package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.HashMap;
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

		String query = "SELECT ID_LOG_SESION,LGS_INTENTO_FALLIDO FROM LOG_SESIONES WHERE LGS_USUARIO=?1 order by ID_LOG_SESION desc LIMIT 1";

		HashMap parametros = new HashMap();
		
		parametros.put("1", user.getUsuUsuario());
		List<Object[]> registrosList = sbFacade.executeNativeQuery(query, parametros);

		for (int i = 0; i < registrosList.size(); i++) {
			retorna = Integer.parseInt(registrosList.get(i)[1] + "");
		}
		return retorna;

	}

	@Override
	public LogSesione registrarLogSesion(LogSesione log) throws BaseException {
		LogSesione x = (LogSesione) sbFacade.updateEntity(log);
		return x;
	}

}
