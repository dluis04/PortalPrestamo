package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

@Local
public interface SBDetalleCuotaLocal {

	public List<DetalleCuota> crearCuota(List<DetalleCuota> nuevasCuotas) throws Exception;

	public List<DetalleCuota> consultarDetalleCuotaByPrestamoDeben(Prestamo prestamo) throws Exception;

	public List<DetalleCuota> consultarAllDetalleCuotas() throws Exception;

	public List<DetalleCuota> modificarDetalleCuotas(List<DetalleCuota> listDetalleCuotas) throws Exception;
}
