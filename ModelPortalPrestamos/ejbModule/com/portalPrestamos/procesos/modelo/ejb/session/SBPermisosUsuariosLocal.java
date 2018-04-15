package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PermisosUsuario;

@Local
public interface SBPermisosUsuariosLocal {

	public PermisosUsuario crearPermisoUsuario(PermisosUsuario permiso) throws Exception;

	public List<PermisosUsuario> consultarTodo() throws Exception;

	public List<PermisosUsuario> consultarPermisosActivos() throws Exception;

	public PermisosUsuario actualizarModulo(PermisosUsuario permiso) throws Exception;

}
