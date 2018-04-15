package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PermisosUsuario;

/**
 * Session Bean implementation class SBPermisosUsuarios
 */
@Stateless
public class SBPermisosUsuarios implements SBPermisosUsuariosLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPermisosUsuarios() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PermisosUsuario crearPermisoUsuario(PermisosUsuario permiso) throws Exception {
		PermisosUsuario entity = (PermisosUsuario) sbFacade.insertEntity(permiso);
		return entity;
	}

	@Override
	public List<PermisosUsuario> consultarTodo() throws Exception {
		String query = "SELECT u FROM PermisosUsuario u";
		List<PermisosUsuario> listPermisosUsuario = sbFacade.executeQuery(query, null);
		return listPermisosUsuario;
	}

	@Override
	public List<PermisosUsuario> consultarPermisosActivos() throws Exception {
		String query = "SELECT u FROM PermisosUsuario u where u.peuActiva='1'";
		List<PermisosUsuario> listPermisosUsuario = sbFacade.executeQuery(query, null);
		return listPermisosUsuario;
	}

	@Override
	public PermisosUsuario actualizarModulo(PermisosUsuario permiso) throws Exception {
		PermisosUsuario entity = (PermisosUsuario) sbFacade.updateEntity(permiso);
		return entity;
	}

}
