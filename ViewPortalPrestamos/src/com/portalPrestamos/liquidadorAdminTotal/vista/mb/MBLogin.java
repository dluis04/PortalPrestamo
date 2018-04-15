package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNConfiguracionApp;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNLogSesiones;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNStatusUsuario;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNTipoBloqueo;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuarios;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuariosBloqueados;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.LogSesione;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TiposBloqueo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.UsuariosBloqueado;

@ManagedBean(name = "MBLogin")
@SessionScoped
public class MBLogin implements Serializable {

	MBMensajes mensajes;
	private Usuario vUsuario;
	DNUsuarios dnUsuarios;
	DNLogSesiones dnLogSesiones;
	DNConfiguracionApp dnConfigApp;
	DNStatusUsuario dNStatusUsuario;
	DNTipoBloqueo dNTipoBloqueo;
	DNUsuariosBloqueados dNUsuariosBloqueados;
	private LogSesione vLogSesiones;
	private int intentosSesion = 0;
	boolean isBloqueado = false;

	public MBLogin() {
		vUsuario = new Usuario();
		vLogSesiones = new LogSesione();
		mensajes = new MBMensajes();
	}

	public void iniciarSesion() throws Exception {
		vUsuario.setUsuUsuario("dluis");
		vUsuario.setUsuPassword("123");

		inicializarDelegados();
		intentosSesion = dnLogSesiones.consultarIntentosFallidos(vUsuario);
		int valorConfigIntentos = dnConfigApp.consultaConfiguracionIntentosInicioSesion(1);
		int usuarioExiste = dnUsuarios.consultarUsuarioExistente(vUsuario);

		if (usuarioExiste == 1) {

			if (intentosSesion < valorConfigIntentos) {
				if (dnUsuarios.consultarUsuarioInicio(vUsuario) == 1) {

					logSesionUsuario(vUsuario, "CORRECTO");

					isBloqueado = false;

					FacesContext context = FacesContext.getCurrentInstance();
					ExternalContext externalContext = context.getExternalContext();
					String url2 = externalContext.encodeActionURL(context.getApplication().getViewHandler()
							.getActionURL(context, "/view/gestion/bienvenido.xhtml"));
					externalContext.redirect(url2);
				} else {
					mensajes.mostrarMensaje("Usuario o contraseña incorrectos", 2);
					logSesionUsuario(vUsuario, "INCORRECTO");
				}
			} else {
				mensajes.mostrarMensaje("Usuario Bloqueado por maximo intentos permitidos", 2);
				logSesionUsuario(vUsuario, "BLOQUEADO");
				if (!isBloqueado) {
					bloquearUsuario();
				}
			}

		} else {
			mensajes.mostrarMensaje("Usuario o contraseña incorrectos", 2);
		}
	}

	private void bloquearUsuario() throws Exception {

		StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(2);
		vUsuario.setStatusUsuario2(status);

		vUsuario = dnUsuarios.bloquearUsuarioStatus(vUsuario);

		if (vUsuario.getIdUsuario() != 0) {

			TiposBloqueo tipoBloqueo = dNTipoBloqueo.consultarDetalleTipoBloqueoById(1);
			UsuariosBloqueado usuarioBloqueado = new UsuariosBloqueado();
			Date fecha = new Date();
			usuarioBloqueado.setUsuario(vUsuario);
			usuarioBloqueado.setTiposBloqueo(tipoBloqueo);
			usuarioBloqueado.setUsbFechaRegistro(fecha);
			usuarioBloqueado.setUsbTipoTiempo(0);
			usuarioBloqueado.setUsbTiempo(0);

			if (dNUsuariosBloqueados.registrarUsuarioBloqueado(usuarioBloqueado).getIdUsuarioBloq() != 0) {
				System.out.println("Registro en la tabla usuarios bloqueados");
			}

			isBloqueado = true;
		}

	}

	public void recuperarPass() throws Exception {

		inicializarDelegados();
		vUsuario.setUsuMail(vUsuario.getUsuMail());
		if (dnUsuarios.recuperarPassword(vUsuario) != 0) {
			mensajes.mostrarMensaje("Se envío su contraseña al correo", 1);
			vUsuario = null;
			vUsuario = new Usuario();
		} else {
			mensajes.mostrarMensaje("El correo electrónico no coincide", 1);
			vUsuario = null;
			vUsuario = new Usuario();
		}
	}

	private void logSesionUsuario(Usuario user, String status) throws Exception {

		inicializarDelegados();

		vLogSesiones.setLgsUsuario(user.getUsuUsuario());
		vLogSesiones.setLgsPassword(user.getUsuPassword());
		vLogSesiones.setLgsStatusIntento(status);
		if (status.equals("CORRECTO")) {
			vLogSesiones.setLgsIntentoFallido(0);
		} else {
			vLogSesiones.setLgsIntentoFallido(intentosSesion + 1);
		}
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

	private void inicializarDelegados() throws Exception {

		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuarios();
		}

		if (dnLogSesiones == null) {
			dnLogSesiones = new DNLogSesiones();
		}

		if (dnConfigApp == null) {
			dnConfigApp = new DNConfiguracionApp();
		}

		if (dNStatusUsuario == null) {
			dNStatusUsuario = new DNStatusUsuario();
		}

		if (dNTipoBloqueo == null) {
			dNTipoBloqueo = new DNTipoBloqueo();
		}

		if (dNUsuariosBloqueados == null) {
			dNUsuariosBloqueados = new DNUsuariosBloqueados();
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
