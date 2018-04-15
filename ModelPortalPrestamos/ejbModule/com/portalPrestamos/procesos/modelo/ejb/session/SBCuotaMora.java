package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.CuotaMora;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBCuotaMora
 */
@Stateless
@LocalBean
public class SBCuotaMora implements SBCuotaMoraLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBCuotaMora() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CuotaMora registrarPago(CuotaMora pago) throws Exception {
		CuotaMora entity = (CuotaMora) sbFacade.insertEntity(pago);
		return entity;
	}

	@Override
	public List<CuotaMora> consultarCuotaMoraByCuota(DetalleCuota cuota) throws Exception {
		String query = "SELECT u FROM CuotaMora u where u.detalleCuota.idDetalleCuota='" + cuota.getIdDetalleCuota()
				+ "' ";
		List<CuotaMora> listCuotaMora = sbFacade.executeQuery(query, null);
		return listCuotaMora;
	}

	@Override
	public CuotaMora modificarPagoCuotaMora(CuotaMora pago) throws Exception {
		CuotaMora entity = (CuotaMora) sbFacade.updateEntity(pago);
		return entity;
	}

	@Override
	public List<CuotaMora> consultarCuotaMorasByDeudorDebe(Usuario deudor) throws Exception {
		String query = "SELECT u FROM CuotaMora u where u.detalleCuota.prestamo.usuario1.idUsuario='"
				+ deudor.getIdUsuario() + "' and u.ctmEstado='DEBE' ";
		List<CuotaMora> listCuotaMora = sbFacade.executeQuery(query, null);
		return listCuotaMora;
	}

	@Override
	public List<CuotaMora> consultarCuotaMorasByDeudorPago(Usuario deudor) throws Exception {
		String query = "SELECT u FROM CuotaMora u where u.detalleCuota.prestamo.usuario1.idUsuario='"
				+ deudor.getIdUsuario() + "' and u.ctmEstado='PAGO' order by u.ctmSecPago asc ";
		List<CuotaMora> listCuotaMora = sbFacade.executeQuery(query, null);
		return listCuotaMora;
	}

}
