package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.AccionesModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

@Local
public interface SBAccionesModuloLocal {

	
	public AccionesModulo crearAccionesModulo(AccionesModulo nuevo) throws Exception;
	public List<AccionesModulo> consultarAllAccionesModuloByModulo(Modulo modulo) throws Exception;
	public List<AccionesModulo> consultarAllAccionesModulo() throws Exception;
	public AccionesModulo actualizarModulo(AccionesModulo modulo) throws Exception;
	
}
