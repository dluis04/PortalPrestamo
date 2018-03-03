package com.portalPrestamos.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;

@Local
public interface SBStatusUsuarioLocal {

	public StatusUsuario consultarDetalleStatusById(int idStatus) throws Exception;
}
