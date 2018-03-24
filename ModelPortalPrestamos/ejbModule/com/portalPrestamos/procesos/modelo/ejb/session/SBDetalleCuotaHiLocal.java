package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuotasHi;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

@Local
public interface SBDetalleCuotaHiLocal {

	public List<DetalleCuotasHi> registrarHistoriaDetalleCuota(List<DetalleCuotasHi> nuevasCuotas) throws Exception;

	public List<DetalleCuotasHi> consultarDetalleCuotaHistorialByPrestamo(Prestamo prestamo) throws Exception;
	
}
