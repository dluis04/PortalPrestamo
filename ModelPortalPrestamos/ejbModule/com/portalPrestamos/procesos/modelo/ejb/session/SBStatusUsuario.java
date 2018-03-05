package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;

/**
 * Session Bean implementation class SBStatusUsuario
 */
@Stateless
@LocalBean
public class SBStatusUsuario implements SBStatusUsuarioLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBStatusUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StatusUsuario consultarDetalleStatusById(int idStatus) throws Exception {
		String query = "SELECT u FROM StatusUsuario u where u.idStatusUsu='" + idStatus + "' ";

		List<StatusUsuario> listStatus = sbFacade.executeQuery(query, null);
		StatusUsuario temp = new StatusUsuario();

		for (int i = 0; i < listStatus.size(); i++) {
			temp = listStatus.get(i);
		}
		return temp;
	}

	@Override
	public List<StatusUsuario> consultarAllStatusUsuario() throws Exception {
		String query = "SELECT u FROM StatusUsuario u";

		List<StatusUsuario> listStatus = sbFacade.executeQuery(query, null);
		return listStatus;
	}

}
