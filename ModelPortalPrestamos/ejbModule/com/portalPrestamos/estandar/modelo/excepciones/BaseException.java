package com.portalPrestamos.estandar.modelo.excepciones;

import com.portalPrestamos.estandar.modelo.utilidades.AccesoPropiedadesModel;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;


;

public class BaseException extends Exception {

    private String descripcion = null;
    private String correccion = null;
    private Object datoError = null;
    private Exception excepcionOriginal = null;

    public BaseException() {
    }

    /**
     * Constructor para el manejo de excepciones no controladas.
     * @param e
     * @param datoError
     * @param codigoNotificacion
     */
    public BaseException(Exception e, Object datoError, String codigoNotificacion) {
        e.printStackTrace();

        descripcion = "Ha ocurrido un error procesando su solicitud.";
        correccion = "Por favor informe al administrador del sistema";

        if (codigoNotificacion != null) {
            envioNotificacion(codigoNotificacion, datoError);
        }

        this.datoError = datoError;
        this.excepcionOriginal = e;
    }

    /**
     * Constructor para el manejo de excepciones no controladas en el login.
     * @param e
     */
    public BaseException(Exception e) {
        e.printStackTrace();

        descripcion = e.getMessage();

        this.datoError = null;
        this.excepcionOriginal = e;
    }

    /**
     * Constructor para el manejo de excepciones controladas.
     * @param codigoError
     * @param dato
     */
    public BaseException(String codigoError, String[] dato) {
        AccesoPropiedadesModel cargarArchivoPropiedades = null;
        String mensaje = null;
        String[] datosMensaje = null;
        try {
            cargarArchivoPropiedades = new AccesoPropiedadesModel();
            mensaje = cargarArchivoPropiedades.getError(codigoError);
        } catch (Exception e) {
            System.out.println("ERROR CARGANDO ARCHIVO DE PROPIEDADES EN BMBaseException: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        if (mensaje == null || mensaje.equals("")) {
            descripcion = "Codigo de error " + codigoError + " no existe en la aplicación.";
            correccion = "Informe el error al administrador del sistema detallando el código del error que no existe.";
            return;
        }

        // Partimos el mensaje
        datosMensaje = mensaje.split(";");
        if (datosMensaje.length != 2) {
            descripcion = "El codigo de error " + codigoError + " no tiene la estructura adecuada.";
            correccion = "Informe el error al administrador del sistema detallando el código del error.";
            return;
        }

        descripcion = datosMensaje[0] + ".";
        //Buscamos si hay datos para asignarle al mensaje
        if (dato != null) {
            for (int i = 0; i < dato.length; i++) {
                if (descripcion.indexOf("$" + (i + 1)) != -1) {
                    descripcion = descripcion.replaceAll("\\$" + (i + 1), dato[i]);
                }
            }
        }

        if (!datosMensaje[1].equals("")) {
            correccion = datosMensaje[1] + ".";
        }
    }

    /**
     * Constructor para las excepciones controladas.
     * @param codigoError
     * @param dato
     * @param ex
     * @param datoError
     * @param codigoNotificacion
     */
    public BaseException(String codigoError, String[] dato, Exception ex, Object datoError,
                           String codigoNotificacion) {
        AccesoPropiedadesModel cargarArchivoPropiedades = null;
        String mensaje = null;
        String[] datosMensaje = null;

        try {
            ex.printStackTrace();

            if (codigoNotificacion != null)
                envioNotificacion(codigoNotificacion, datoError);

            cargarArchivoPropiedades = new AccesoPropiedadesModel();
            mensaje = cargarArchivoPropiedades.getError(codigoError);
        } catch (Exception e) {
            System.out.println("ERROR CARGANDO ARCHIVO DE PROPIEDADES EN BMBaseException: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        if (mensaje == null || mensaje.equals("")) {
            descripcion = "Codigo de error " + codigoError + " no existe en la aplicación.";
            correccion = "Informe el error al administrador del sistema detallando el código del error que no existe.";
            return;
        }

        //Partimos el mensaje
        datosMensaje = mensaje.split(";");
        if (datosMensaje.length != 2) {
            descripcion = "El codigo de error " + codigoError + " no tiene la estructura adecuada.";
            correccion = "Informe el error al administrador del sistema detallando el código del error.";
            return;
        }

        descripcion = datosMensaje[0] + ".";
        //Buscamos si hay datos para asignarle al mensaje
        if (dato != null) {
            for (int i = 0; i < dato.length; i++) {
                if (descripcion.indexOf("$" + (i + 1)) != -1) {
                    descripcion = descripcion.replaceAll("\\$" + (i + 1), dato[i]);
                }
            }
        }

        if (!datosMensaje[1].equals("")) {
            correccion = datosMensaje[1] + ".";
        }

        this.datoError = datoError;
        this.excepcionOriginal = ex;
    }

    /**
     * Metodo encargado de obtener el mensaje notificacion a partir del codigo.
     * @param codigoNotificacion
     * @return
     */
    private String obtenerMensajeNotificacion(String codigoNotificacion) {
        AccesoPropiedadesModel prop = null;

        try {
            prop = new AccesoPropiedadesModel();
            return prop.getNotificacion(codigoNotificacion);
        } catch (Exception e) {
            System.out.println("ERROR LEYENDO MENSAJE NOTIFICACION POR: " + e.getMessage() + ", en BMBaseException");
            return "";
        }
    }

    /**
     * Metodo encargado de enviar notificaciones, dependiendo del valor de la variable en utilidades.
     * @param codigoNotificacion
     */
    private void envioNotificacion(String codigoNotificacion, Object datoError) {
        try {
            // Se valida si esta configurado el envio de notificaciones.
            if (Parametros.ENVIAR_NOTIFICACIONES) {
                // Se invoca el metodo encargado de obtener el mensaje de la notificacion.
                String mensajeNotificacion = obtenerMensajeNotificacion(codigoNotificacion);

                // Sobreescribir el metodo toString de todos las entidades, ya que al momento de enviar una notificacion,
                // se envia el estado del objeto que causo la excepcion.

                if (datoError != null) {
                    datoError.toString();
                }

                // TODO: LLAMADO AL METODO QUE ENVIA LA NOTIFICACION.
            }
        } catch (Exception e) {
            System.out.println("ERROR TRATANDO DE ENVIAR NOTIFICACION POR: " + e.getMessage());
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCorreccion() {
        return correccion;
    }

    public Object getDatoError() {
        return datoError;
    }

    public Exception getExcepcionOriginal() {
        return excepcionOriginal;
    }
}
