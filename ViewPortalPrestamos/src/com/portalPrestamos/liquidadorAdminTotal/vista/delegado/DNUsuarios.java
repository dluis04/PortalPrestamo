package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;


import javax.enterprise.context.ApplicationScoped;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBUsuarioLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;


@ManagedBean(value = "DNUsuarios")
@ApplicationScoped
public class DNUsuarios {

	SBUsuarioLocal sBUsuarioLocal;

	public DNUsuarios() throws Exception {
		sBUsuarioLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBUsuario" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBUsuarioLocal",
				SBUsuarioLocal.class);
	}

//	public Usuario crearUsuario(Usuario nuevo) throws Exception {
//		return sBUsuariosLocal.crearUsuario(nuevo);
//	}
//
//	public Usuario actualizarUsuario(Usuario update) throws Exception {
//		return sBUsuariosLocal.actualizarUsuario(update);
//	}
//
//	public int validarInicioSesion(Usuario user) throws Exception {
//		return sBUsuariosLocal.consultarUsuarioInicio(user);
//	}
//
//	public Usuario consultarDetalleUsuario(int id) throws Exception {
//		return sBUsuariosLocal.consultarDetalleUsuario(id);
//	}
//
//	public Usuario consultarDetalleUsuarioByUsuario(String usuario) throws Exception {
//		return sBUsuariosLocal.consultarDetalleUsuarioByUsuario(usuario);
//	}

	public int consultarUsuarioInicio(Usuario user) throws Exception {
		return sBUsuarioLocal.consultarUsuarioInicio(user);
	}

//	public int consultarUsuarioRepetido(Usuario user) throws Exception {
//		return sBUsuariosLocal.consultarUsuarioRepetido(user);
//	}

}
