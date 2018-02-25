package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;


/**
 * Session Bean implementation class SBUsuario
 */
@Stateless
public class SBUsuario implements SBUsuarioLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBUsuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario crearUsuario(Usuario nuevo) throws Exception {
		Usuario entity = (Usuario) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public int consultarUsuarioInicio(Usuario user) throws Exception {

		int retorna = 0;

		String query = "SELECT u.idUsuario FROM Usuario u where u.usuUsuario='" + user.getUsuUsuario() + "' "
				+ "and u.usuPassword='" + user.getUsuPassword() + "' ";

		List listUsuario = sbFacade.executeQuery(query, null);
		retorna = listUsuario.size();

		if (retorna > 0) {
			return retorna;
		}
		return retorna;
	}

	@Override
	public int consultarUsuarioRepetido(Usuario user) throws Exception {

		String query = "SELECT COUNT(idUsuario) FROM Usuario WHERE usuUsuario ='" + user.getUsuUsuario() + "' ";

		List registrosList = sbFacade.executeNativeQuery(query, null);
		String vo = "0";
		int cont = 0;
		for (int i = 0; i < registrosList.size(); i++) {

			if (vo.equalsIgnoreCase("null")) {
				cont = 0;
			} else {
				cont = Integer.parseInt(registrosList.get(i) + "");
			}
		}
		return cont;

	}

	@Override
	public Usuario actualizarUsuario(Usuario update) throws Exception {
		Usuario x = (Usuario) sbFacade.updateEntity(update);
		return x;
	}

	@Override
	public Usuario consultarDetalleUsuario(int id) throws Exception {
		String query = "SELECT u FROM Usuario u where u.idUsuario='" + id + "' ";

		List<Usuario> listUsuario = sbFacade.executeQuery(query, null);
		Usuario temp = new Usuario();

		for (int i = 0; i < listUsuario.size(); i++) {
			temp = listUsuario.get(i);
		}
		return temp;
	}

	@Override
	public Usuario consultarDetalleUsuarioByUsuario(String usuario) throws Exception {
		String query = "SELECT u FROM Usuario u where u.usuario='" + usuario + "' ";

		List<Usuario> listUsuario = sbFacade.executeQuery(query, null);
		Usuario temp = new Usuario();

		for (int i = 0; i < listUsuario.size(); i++) {
			temp = listUsuario.get(i);
		}
		return temp;
	}

}
