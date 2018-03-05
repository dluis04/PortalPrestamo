package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TipoUsuario;

/**
 * Session Bean implementation class SBTipoUsuario
 */
@Stateless
@LocalBean
public class SBTipoUsuario implements SBTipoUsuarioLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBTipoUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TipoUsuario> consultarTodo() throws Exception {
		String query = "SELECT u FROM TipoUsuario u";
		List<TipoUsuario> listTipoUsuario = sbFacade.executeQuery(query, null);
		return listTipoUsuario;
	}

	@Override
	public TipoUsuario consultarDetalleTipoUsuarioById(int idTipo) throws Exception {

		String query = "SELECT u FROM TipoUsuario u where u.idTipoUsu='" + idTipo + "' ";
		TipoUsuario temp = null;
		List<TipoUsuario> listTipoUsuario = sbFacade.executeQuery(query, null);

		for (TipoUsuario list : listTipoUsuario) {
			temp = list;
		}

		return temp;
	}

	@Override
	public TipoUsuario crearTipoUsuario(TipoUsuario tipoUsuario) throws Exception {
		TipoUsuario entity = (TipoUsuario) sbFacade.insertEntity(tipoUsuario);
		return entity;
	}

	@Override
	public TipoUsuario modificarTipoUsuario(TipoUsuario TipoUsuario) throws Exception {
		TipoUsuario x = (TipoUsuario) sbFacade.updateEntity(TipoUsuario);
		return x;
	}

}
