package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TiposBloqueo;

/**
 * Session Bean implementation class SBTiposBloqueo
 */
@Stateless
@LocalBean
public class SBTiposBloqueo implements SBTiposBloqueoLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBTiposBloqueo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TiposBloqueo consultarDetalleTipoBloqueoById(int idBloqueo) throws Exception {
		String query = "SELECT u FROM TiposBloqueo u where u.idTipoBloqueo='" + idBloqueo + "' ";

		List<TiposBloqueo> listTipoBloqueo = sbFacade.executeQuery(query, null);
		TiposBloqueo temp = new TiposBloqueo();

		for (int i = 0; i < listTipoBloqueo.size(); i++) {
			temp = listTipoBloqueo.get(i);
		}
		return temp;
	}

	@Override
	public List<TiposBloqueo> consultarAllTiposBloqueos() throws Exception {
		String query = "SELECT u FROM TiposBloqueo u";
		List<TiposBloqueo> listTiposBloqueo = sbFacade.executeQuery(query, null);
		return listTiposBloqueo;
	}

}
