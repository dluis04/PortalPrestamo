package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNLogSesiones;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuarios;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.LogSesione;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBLogin")
@SessionScoped
public class MBLogin {
	MBMensajes mensajes = new MBMensajes();
	private Usuario vUsuario;
	DNUsuarios dnUsuarios;
	DNLogSesiones dnLogSesiones;
	private LogSesione vLogSesiones;

	public MBLogin() {
		vUsuario = new Usuario();
		vLogSesiones = new LogSesione();
	}

	public void iniciarSesion() throws Exception {

		inicializarDelegados();

		if (dnUsuarios.consultarUsuarioInicio(vUsuario) == 1) {
			logSesionUsuario(vUsuario, "CORRECTO");

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			String url2 = externalContext.encodeActionURL(context.getApplication().getViewHandler()
					.getActionURL(context, "/view/usuarios/CrearCuentaUsuario.xhtml"));
			externalContext.redirect(url2);
		} else {
			logSesionUsuario(vUsuario, "INCORRECTO");
		}

	}

	private void inicializarDelegados() throws Exception {

		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuarios();
		}

		if (dnLogSesiones == null) {
			dnLogSesiones = new DNLogSesiones();
		}

	}

	private void logSesionUsuario(Usuario user, String status) throws Exception {

		inicializarDelegados();

		int intentosSesion = 0;
		intentosSesion = dnLogSesiones.consultarIntentosFallidos(user);
		

		vLogSesiones.setLgsUsuario(user.getUsuUsuario());
		vLogSesiones.setLgsPassword(user.getUsuPassword());
		vLogSesiones.setLgsStatusIntento(status);
		vLogSesiones.setLgsIntentoFallido(intentosSesion + 1);
		Date fecha = new Date();
		vLogSesiones.setLgsFechaRegistro(fecha);

		if (dnLogSesiones.registrarLogSesion(vLogSesiones) != null) {
			System.out.println("Registro log de sesion");
		} else {
			System.out.println("No registro log de sesion");
		}
	}

	public void cerrarSesion() {

		try {

			FacesContext context = FacesContext.getCurrentInstance();

			ExternalContext externalContext = context.getExternalContext();

			Object session = externalContext.getSession(false);

			HttpSession httpSession = (HttpSession) session;

			httpSession.invalidate();

			String url2 = externalContext.encodeActionURL(
					context.getApplication().getViewHandler().getActionURL(context, "/view/login.xhtml"));
			externalContext.redirect(url2);

		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
			System.out.println("***ERROR INVALIDANDO LA SESSION ACTIVA");
		}

	}

	public Usuario getvUsuario() {
		return vUsuario;
	}

	public void setvUsuario(Usuario vUsuario) {
		this.vUsuario = vUsuario;
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public DNUsuarios getDnUsuarios() {
		return dnUsuarios;
	}

	public void setDnUsuarios(DNUsuarios dnUsuarios) {
		this.dnUsuarios = dnUsuarios;
	}

}
