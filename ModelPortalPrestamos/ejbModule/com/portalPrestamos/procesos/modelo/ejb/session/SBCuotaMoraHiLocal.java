package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.CuotaMoraHi;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;

@Local
public interface SBCuotaMoraHiLocal {

	public CuotaMoraHi registrarHistorialCuotaMora(CuotaMoraHi pago) throws Exception;

	public List<CuotaMoraHi> consultarCuotaMoraHistorialByDetalleCuota(DetalleCuota cuota) throws Exception;

}
