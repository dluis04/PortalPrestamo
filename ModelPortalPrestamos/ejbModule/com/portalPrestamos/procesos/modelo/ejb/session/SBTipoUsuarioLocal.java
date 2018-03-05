package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TipoUsuario;

@Local
public interface SBTipoUsuarioLocal {
	
	public List<TipoUsuario> consultarTodo() throws Exception;
	public TipoUsuario consultarDetalleTipoUsuarioById(int idTipo) throws Exception;
	public TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario) throws Exception;
	public TipoUsuario modificarTipoUsuario(TipoUsuario tipoUsuario) throws Exception;
	
}
