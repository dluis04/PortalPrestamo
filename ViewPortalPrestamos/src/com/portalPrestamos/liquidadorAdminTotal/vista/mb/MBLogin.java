package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuarios;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.LogSesione;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBLogin")
@SessionScoped
public class MBLogin {
	MBMensajes mensajes = new MBMensajes();
	private String user;
	private String pass;
	private Usuario vUsuario;
	DNUsuarios dnUsuarios;
	private LogSesione vLogSesiones;

	public MBLogin() {
		vUsuario = new Usuario();
		vLogSesiones = new LogSesione();
	}

	public void iniciarSesion() throws Exception {
		dnUsuarios = new DNUsuarios();

		if (dnUsuarios.consultarUsuarioInicio(vUsuario) == 1) {

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			String url2 = externalContext.encodeActionURL(context.getApplication().getViewHandler()
					.getActionURL(context, "/view/usuarios/CrearCuentaUsuario.xhtml"));
			externalContext.redirect(url2);
		} else {

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public DNUsuarios getDnUsuarios() {
		return dnUsuarios;
	}

	public void setDnUsuarios(DNUsuarios dnUsuarios) {
		this.dnUsuarios = dnUsuarios;
	}

}
