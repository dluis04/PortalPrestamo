package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.LogSesione;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

/**
 * Session Bean implementation class SBLogSesiones
 */
@Stateless
public class SBLogSesiones implements SBLogSesionesLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;

	/**
	 * Default constructor.
	 */
	public SBLogSesiones() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int consultarIntentosFallidos(Usuario user) throws BaseException {
		int retorna = 0;

		String query = "SELECT max(l.lgsIntentoFallido) FROM LogSesione l where l.lgsUsuario='" + user.getUsuUsuario()
				+ "' ";
		
		List listUsuario = sbFacade.executeQuery(query, null);

		for (int i = 0; i < listUsuario.size(); i++) {
			retorna = Integer.parseInt(listUsuario.get(i) + "");
		}

		return retorna;
	}

	@Override
	public LogSesione registrarLogSesion(LogSesione log) throws BaseException {
		LogSesione x = (LogSesione) sbFacade.updateEntity(log);
		return x;
	}

}
