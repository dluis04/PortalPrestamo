
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBPermisosUsuariosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PermisosUsuario;

@ManagedBean(value = "DNPermisosUsuarios")
@ApplicationScoped
public class DNPermisosUsuarios {

	SBPermisosUsuariosLocal sBPermisosUsuariosLocal;

	public DNPermisosUsuarios() throws Exception {
		sBPermisosUsuariosLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBPermisosUsuarios" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPermisosUsuariosLocal",
				SBPermisosUsuariosLocal.class);
	}

	public PermisosUsuario crearPermisoUsuario(PermisosUsuario permiso) throws Exception {
		return sBPermisosUsuariosLocal.crearPermisoUsuario(permiso);
	}

	public List<PermisosUsuario> consultarTodo() throws Exception {
		return sBPermisosUsuariosLocal.consultarTodo();
	}

	public List<PermisosUsuario> consultarPermisosActivos() throws Exception {
		return sBPermisosUsuariosLocal.consultarPermisosActivos();
	}

	public PermisosUsuario actualizarModulo(PermisosUsuario permiso) throws Exception {
		return sBPermisosUsuariosLocal.actualizarModulo(permiso);
	}

}
