package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.CuotaMoraHi;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;

/**
 * Session Bean implementation class SBCuotaMoraHi
 */
@Stateless
@LocalBean
public class SBCuotaMoraHi implements SBCuotaMoraHiLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBCuotaMoraHi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CuotaMoraHi registrarHistorialCuotaMora(CuotaMoraHi pago) throws Exception {
		CuotaMoraHi entity = (CuotaMoraHi) sbFacade.insertEntity(pago);
		return entity;
	}

	@Override
	public List<CuotaMoraHi> consultarCuotaMoraHistorialByDetalleCuota(DetalleCuota cuota) throws Exception {
		String query = "SELECT u FROM CuotaMoraHi u where u.idDetalleCuotaHis='" + cuota.getIdDetalleCuota() + "' order by u.ctmhFecUltMod asc ";
		List<CuotaMoraHi> listPago = sbFacade.executeQuery(query, null);
		return listPago;
	}

}
