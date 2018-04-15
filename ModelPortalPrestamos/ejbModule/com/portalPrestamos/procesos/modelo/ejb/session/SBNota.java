package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Nota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBNota
 */
@Stateless
@LocalBean
public class SBNota implements SBNotaLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBNota() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Nota crearNota(Nota nuevaNota) throws Exception {
		Nota entity = (Nota) sbFacade.insertEntity(nuevaNota);
		return entity;
	}

	@Override
	public List<Nota> consultarNotaByUsuario(Usuario usuario) throws Exception {
		String query = "SELECT u FROM Nota u where u.usuario='" + usuario + "' ";
		List<Nota> listNota = sbFacade.executeQuery(query, null);
		return listNota;
	}

	@Override
	public Nota modificarNota(Nota nota) throws Exception {
		Nota entity = (Nota) sbFacade.updateEntity(nota);
		return entity;
	}

	@Override
	public void eleminarNota(Nota nota) throws Exception {
		sbFacade.removeEntity(nota);
	}

}
