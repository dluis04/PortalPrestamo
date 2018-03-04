package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TiposBloqueo;


@Local
public interface SBTiposBloqueoLocal {
	
	public TiposBloqueo consultarDetalleTipoBloqueoById(int idBloqueo) throws Exception;

}
