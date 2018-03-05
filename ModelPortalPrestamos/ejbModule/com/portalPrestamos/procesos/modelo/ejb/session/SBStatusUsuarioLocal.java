package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;

@Local
public interface SBStatusUsuarioLocal {

	public StatusUsuario consultarDetalleStatusById(int idStatus) throws Exception;
	public List<StatusUsuario> consultarAllStatusUsuario() throws Exception;
	
}
