package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBPrestamo
 */
@Stateless
@LocalBean
public class SBPrestamo implements SBPrestamoLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBPrestamo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Prestamo crearPrestamo(Prestamo nuevoPrestamo) throws Exception {
		Prestamo entity = (Prestamo) sbFacade.insertEntity(nuevoPrestamo);
		return entity;
	}

	@Override
	public Prestamo consultarPrestamoByDeudor(Usuario deudor) throws Exception {
		String query = "SELECT u FROM Prestamo u where u.usuario1.idUsuario='" + deudor.getIdUsuario() + "' ";
		List<Prestamo> listPrestamo = sbFacade.executeQuery(query, null);
		Prestamo temp = null;

		for (Prestamo list : listPrestamo) {
			temp = list;
		}

		return temp;
	}

	@Override
	public List<Prestamo> consultarAllPrestamosActivos() throws Exception {
		String query = "SELECT u FROM Prestamo u where u.preEstado='ACTIVO' ";
		List<Prestamo> listPrestamo = sbFacade.executeQuery(query, null);
		return listPrestamo;
	}

	@Override
	public Prestamo modificarPrestamo(Prestamo prestamo) throws Exception {
		Prestamo entity = (Prestamo) sbFacade.updateEntity(prestamo);
		return entity;
	}

	@Override
	public List<Prestamo> consultarAllPrestamosTerminados() throws Exception {
		String query = "SELECT u FROM Prestamo u where u.preEstado='TERMINADO' ";
		List<Prestamo> listPrestamo = sbFacade.executeQuery(query, null);
		return listPrestamo;
	}

	@Override
	public List<Prestamo> consultarAllPrestamosEliminados() throws Exception {
		String query = "SELECT u FROM Prestamo u where u.preEstado='ELIMINADO' ";
		List<Prestamo> listPrestamo = sbFacade.executeQuery(query, null);
		return listPrestamo;
	}

}
