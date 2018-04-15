package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PrestamosHi;

/**
 * Session Bean implementation class SBPrestamoHi
 */
@Stateless
@LocalBean
public class SBPrestamoHi implements SBPrestamoHiLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPrestamoHi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PrestamosHi registrarPrestamoHistorial(PrestamosHi prestamo) throws Exception {
		PrestamosHi entity = (PrestamosHi) sbFacade.insertEntity(prestamo);
		return entity;
	}

	@Override
	public List<PrestamosHi> consultarPrestamoHistorialByPrestamo(Prestamo prestamo) throws Exception {
		String query = "SELECT u FROM PrestamosHi u where u.idPrestamo='" + prestamo.getIdPrestamos() + "' order by preFecUltMod asc ";
		List<PrestamosHi> listPrestamo = sbFacade.executeQuery(query, null);
		return listPrestamo;
	}

}
