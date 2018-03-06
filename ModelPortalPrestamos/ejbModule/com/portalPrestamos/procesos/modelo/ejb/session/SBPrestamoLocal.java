package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBPrestamoLocal {

	public Prestamo crearPrestamo(Prestamo nuevoPrestamo) throws Exception;

	public Prestamo consultarPrestamoByDeudor(Usuario deudor) throws Exception;

	public List<Prestamo> consultarAllPrestamosActivos() throws Exception;

	public List<Prestamo> consultarAllPrestamosTerminados() throws Exception;
	
	public List<Prestamo> consultarAllPrestamosEliminados() throws Exception;

	public Prestamo modificarPrestamo(Prestamo prestamo) throws Exception;

}
