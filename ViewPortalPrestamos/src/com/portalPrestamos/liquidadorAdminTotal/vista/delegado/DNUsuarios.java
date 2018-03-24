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

	public Usuario crearUsuario(Usuario usuario) throws Exception {
		return sBUsuarioLocal.crearUsuario(usuario);
	}

	public int consultarUsuarioInicio(Usuario user) throws Exception {
		return sBUsuarioLocal.consultarUsuarioInicio(user);
	}

	public int consultarUsuarioExistente(Usuario user) throws Exception {
		return sBUsuarioLocal.consultarUsuarioRepetido(user);
	}

	public Usuario consultarUsuarioByUsuario(Usuario user) throws Exception {
		return sBUsuarioLocal.consultarDetalleByUsuario(user);
	}

	public int recuperarPassword(Usuario usuario) throws Exception {
		return sBUsuarioLocal.recuperarPassword(usuario);
	}

	public Usuario bloquearUsuarioStatus(Usuario usuario) throws Exception {
		return sBUsuarioLocal.bloquearUsuarioStatus(usuario);
	}

	public Usuario eliminarUsuario(Usuario usuario) throws Exception {
		return sBUsuarioLocal.eliminarUsuario(usuario);
	}

	public Usuario modificarPassword(Usuario usuario) throws Exception {
		return sBUsuarioLocal.modificarPassword(usuario);
	}

}
