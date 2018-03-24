package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Pago;

@Local
public interface SBPagosHiLocal {

	
	public Pago registrarPagoHistorial(Pago pago) throws Exception;

	public List<Pago> consultarPagoByDetalleCuotaHis(DetalleCuota cuota) throws Exception;

}
