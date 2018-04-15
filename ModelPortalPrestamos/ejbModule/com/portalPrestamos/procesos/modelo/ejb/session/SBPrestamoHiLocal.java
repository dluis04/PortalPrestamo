package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PrestamosHi;

@Local
public interface SBPrestamoHiLocal {

	public PrestamosHi registrarPrestamoHistorial(PrestamosHi prestamo) throws Exception;

	public List<PrestamosHi> consultarPrestamoHistorialByPrestamo(Prestamo prestamo) throws Exception;

}
