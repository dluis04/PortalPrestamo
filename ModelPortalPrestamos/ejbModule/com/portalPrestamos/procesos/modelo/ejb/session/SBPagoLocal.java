package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Pago;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBPagoLocal {

	public Pago registrarPago(Pago pago) throws Exception;

	public List<Pago> consultarPagoByCuota(DetalleCuota cuota) throws Exception;

	public Pago modificarPago(Pago pago) throws Exception;

	public List<Pago> consultarPagosByDeudorPago(Usuario deudor) throws Exception;

	public List<Pago> consultarAbonosByDeudorPago(Usuario deudor) throws Exception;

}
