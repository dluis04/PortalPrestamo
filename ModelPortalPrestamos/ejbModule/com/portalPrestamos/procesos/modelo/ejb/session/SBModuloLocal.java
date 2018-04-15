package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

@Local
public interface SBModuloLocal {

	public Modulo crearModulo(Modulo nuevo) throws Exception;

	public List<Modulo> consultarAllModulos() throws Exception;
	
	public List<Modulo> consultarAllModulosActivos() throws Exception;

	public Modulo consultarModulosById(Modulo modulo) throws Exception;

	public Modulo actualizarModulo(Modulo modulo) throws Exception;

}
