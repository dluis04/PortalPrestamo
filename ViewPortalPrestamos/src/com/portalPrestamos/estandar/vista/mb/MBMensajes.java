package com.portalPrestamos.estandar.vista.mb;




import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamos.estandar.vista.utilidades.AccesoPropiedadesVista;


public class MBMensajes {

	
	
    public static int MENSAJE_OK = 1;
    public static int MENSAJE_ERROR = 2;
    public static int MENSAJE_ALERTA = 3;
    private AccesoPropiedadesVista apv;

    public MBMensajes() {
    	apv = new AccesoPropiedadesVista();
    }

    public void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
        try {
            FacesMessage message =
                new FacesMessage((tipoMensaje == MENSAJE_OK ? 
                		FacesMessage.SEVERITY_INFO : (tipoMensaje ==
                                                                                            MENSAJE_ALERTA ?
                                                                                            FacesMessage.SEVERITY_WARN :
                                                                                            FacesMessage.SEVERITY_ERROR)),
                                 mensaje, titulo);

            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
        
    }

    private void mostrarMensaje() {
    }

    public void mostrarMensaje(ActionEvent actionEvent) {
        try {
            mostrarMensaje();
        } catch (Exception exception) {
            System.out.println("EXCEPCION AL MOMENTO DE MOSTRAR MENSAJE: ");
            exception.printStackTrace();
        }
    }

    /**
     * Metodo encargado de mostrar el mensaje de las excepciones no controladas.
     * @param bmBaseException
     */
    public void mostrarMensaje(BaseException bmBaseException) {
        // Se invoca el metodo encargado de mostrar la ventana con el mensaje de la excepcion.
        mostrarMensajeError(bmBaseException.getDescripcion(), bmBaseException.getCorreccion());
    }

    /**
     * Metodo encargado de determinar el mensaje a mostrar.
     * @param mensaje
     * @param codigo
     */
    public void mostrarMensaje(String mensaje, int codigo) {
        if (codigo == MENSAJE_ALERTA) {
            mostrarMensajeAlerta(mensaje);
        } else if (codigo == MENSAJE_ERROR) {
            mostrarMensajeError(mensaje, null);
        } else if (codigo == MENSAJE_OK) {
            mostrarMensajeOk(mensaje);
        }
    }

    /**
     * Metodo encargado de mostrar la ventana de mensajes con el icono de error.
     * @param descripcion
     * @param solucion
     */
    public void mostrarMensajeError(String descripcion, String solucion) {
        String mensaje = "";
        if (solucion != null) {
            mensaje = (descripcion + " " + solucion);
        } else {
            mensaje = (descripcion);
        }
        mostrarMensaje(mensaje, "ERROR", MENSAJE_ERROR);
    }

    /**
     * Metodo encargado de mostrar la ventana de mensajes con el icono de alerta.
     * @param descripcion
     */
    public void mostrarMensajeAlerta(String descripcion) {
        mostrarMensaje(descripcion, "ALERTA", MENSAJE_ALERTA);
    }

    /**
     * Metodo encargado de mostrar la ventana de mensajes con el icono Ok.
     * @param descripcion
     */
    public void mostrarMensajeOk(String descripcion) {
        mostrarMensaje(descripcion, "OK", MENSAJE_OK);
    }
    
    /**
     * Metodo para mostrar un error desde un codigo
     * @param code codigo del error
     */
    public void showError(String code){
		try {
			String message = apv.getError(code);
			mostrarMensaje(message, "ERROR", MENSAJE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Metodo para mostrar un error desde un codigo y una descricion mas amplia del mismo
     * @param code codigo del error
     */
    public void showError(String code, Exception exc){
		try {
			String message = apv.getError(code)+"\n"+exc.toString();
			mostrarMensaje(message, "ERROR", MENSAJE_ERROR);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Metodo para mostrar un error desde un codigo
     * @param code codigo del error
     */
    public void showInfo(String code){
		try {
			String message = apv.getMensaje(code);
			mostrarMensaje(message, "OK", MENSAJE_OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
}
