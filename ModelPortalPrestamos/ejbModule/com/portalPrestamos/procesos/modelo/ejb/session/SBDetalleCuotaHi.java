package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuotasHi;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

/**
 * Session Bean implementation class SBDetalleCuotaHi
 */
@Stateless
@LocalBean
public class SBDetalleCuotaHi implements SBDetalleCuotaHiLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBDetalleCuotaHi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DetalleCuotasHi> registrarHistoriaDetalleCuota(List<DetalleCuotasHi> nuevasCuotas) throws Exception {
		List<DetalleCuotasHi> listDetalleTemp = new ArrayList();

		for (DetalleCuotasHi list : nuevasCuotas) {
			DetalleCuotasHi entity = (DetalleCuotasHi) sbFacade.insertEntity(list);
			listDetalleTemp.add(entity);
		}

		return listDetalleTemp;
	}

	@Override
	public List<DetalleCuotasHi> consultarDetalleCuotaHistorialByPrestamo(Prestamo prestamo) throws Exception {
		String query = "SELECT u FROM DetalleCuotasHi u where u.idPrestamosHis='" + prestamo.getIdPrestamos() + "' order by u.dtchFecUltMod asc ";
		List<DetalleCuotasHi> listDetalleCuotas = sbFacade.executeQuery(query, null);
		return listDetalleCuotas;
	}

}
