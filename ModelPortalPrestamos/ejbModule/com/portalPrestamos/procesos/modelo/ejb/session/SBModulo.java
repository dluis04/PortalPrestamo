package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

/**
 * Session Bean implementation class SBModulo
 */
@Stateless
@LocalBean
public class SBModulo implements SBModuloLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBModulo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Modulo crearModulo(Modulo nuevo) throws Exception {
		Modulo entity = (Modulo) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public List<Modulo> consultarAllModulos() throws Exception {
		String query = "SELECT u FROM Modulo u";
		List<Modulo> listModulo = sbFacade.executeQuery(query, null);
		return listModulo;
	}

	@Override
	public Modulo consultarModulosById(Modulo modulo) throws Exception {

		String query = "SELECT u FROM Modulo u where u.idModulo='" + modulo.getIdModulo() + "' ";
		List<Modulo> listModulo = sbFacade.executeQuery(query, null);
		Modulo temp = new Modulo();

		for (Modulo listModu : listModulo) {
			temp = listModu;
		}

		return temp;
	}

	@Override
	public Modulo actualizarModulo(Modulo modulo) throws Exception {
		Modulo entity = (Modulo) sbFacade.updateEntity(modulo);
		return entity;
	}

}
