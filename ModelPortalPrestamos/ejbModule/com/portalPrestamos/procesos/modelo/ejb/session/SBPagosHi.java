package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Pago;

/**
 * Session Bean implementation class SBPagosHi
 */
@Stateless
@LocalBean
public class SBPagosHi implements SBPagosHiLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPagosHi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Pago registrarPagoHistorial(Pago pago) throws Exception {
		Pago entity = (Pago) sbFacade.insertEntity(pago);
		return entity;
	}

	@Override
	public List<Pago> consultarPagoByDetalleCuotaHis(DetalleCuota cuota) throws Exception {
		String query = "SELECT u FROM Pago u where u.idDetalleCuotaHis='" + cuota.getIdDetalleCuota() + "' order by pgshFecUltMod asc ";
		List<Pago> listPago = sbFacade.executeQuery(query, null);
		return listPago;
	}

}
