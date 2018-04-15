package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBUsuarioLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(value = "DNDeudores")
@ApplicationScoped
public class DNDeudores {

	SBUsuarioLocal sBUsuarioLocal;

	public DNDeudores() throws Exception {
		sBUsuarioLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBUsuario" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBUsuarioLocal",
				SBUsuarioLocal.class);
	}

	public Usuario crearUsuario(Usuario usuario) throws Exception {
		return sBUsuarioLocal.crearUsuario(usuario);
	}

	public Usuario actualizarUsuario(Usuario usuario) throws Exception {
		return sBUsuarioLocal.actualizarUsuario(usuario);
	}

	public List<Usuario> consultarDeudoresActivos() throws Exception {
		return sBUsuarioLocal.consultarDeudoresActivos();
	}

	public Usuario consultarUsuarioByUsuario(Usuario user) throws Exception {
		return sBUsuarioLocal.consultarDetalleByUsuario(user);
	}

	public boolean consultarCedulaDeudor(Usuario deudor) throws Exception {
		return sBUsuarioLocal.consultarCedulaExiste(deudor);
	}

	public Usuario eliminarUsuario(Usuario usuario) throws Exception {
		return sBUsuarioLocal.eliminarUsuario(usuario);
	}

}
