package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

/**
 * Session Bean implementation class SBDetalleCuota
 */
@Stateless
@LocalBean
public class SBDetalleCuota implements SBDetalleCuotaLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBDetalleCuota() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<DetalleCuota> crearCuota(List<DetalleCuota> nuevasCuotas) throws Exception {

		List<DetalleCuota> listDetalleTemp = new ArrayList();

		for (DetalleCuota list : nuevasCuotas) {
			DetalleCuota entity = (DetalleCuota) sbFacade.insertEntity(list);
			listDetalleTemp.add(entity);
		}

		return listDetalleTemp;
	}

	@Override
	public List<DetalleCuota> consultarDetalleCuotaByPrestamoDeben(Prestamo prestamo) throws Exception {
		String query = "SELECT u FROM DetalleCuota u where u.prestamo.idPrestamos='" + prestamo.getIdPrestamos() + "' and u.dtcEstado='DEBE'";
		List<DetalleCuota> listDetalleCuotas = sbFacade.executeQuery(query, null);
		return listDetalleCuotas;
	}

	@Override
	public List<DetalleCuota> consultarAllDetalleCuotas() throws Exception {
		String query = "SELECT u FROM DetalleCuota u";
		List<DetalleCuota> listDetalleCuotas = sbFacade.executeQuery(query, null);
		return listDetalleCuotas;
	}

	@Override
	public List<DetalleCuota> modificarDetalleCuotas(List<DetalleCuota> listDetalleCuotas) throws Exception {
		List<DetalleCuota> listDetalleTemp = new ArrayList();

		for (DetalleCuota list : listDetalleCuotas) {
			DetalleCuota entity = (DetalleCuota) sbFacade.updateEntity(list);
			listDetalleTemp.add(entity);
		}

		return listDetalleTemp;
	}

}
