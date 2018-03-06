package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Pago;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

/**
 * Session Bean implementation class SBPago
 */
@Stateless
@LocalBean
public class SBPago implements SBPagoLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPago() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pago registrarPago(Pago pago) throws Exception {
		Pago entity = (Pago) sbFacade.insertEntity(pago);
		return entity;
	}

	@Override
	public List<Pago> consultarPagoByCuota(DetalleCuota cuota) throws Exception {
		String query = "SELECT u FROM Pago u where u.detalleCuota.idDetalleCuota='" + cuota.getIdDetalleCuota() + "' ";
		List<Pago> listPago = sbFacade.executeQuery(query, null);
		return listPago;
	}

	@Override
	public Pago modificarPago(Pago pago) throws Exception {
		Pago entity = (Pago) sbFacade.updateEntity(pago);
		return entity;
	}

}
