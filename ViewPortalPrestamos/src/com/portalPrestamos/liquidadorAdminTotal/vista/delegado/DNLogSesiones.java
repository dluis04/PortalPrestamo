package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;



import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBLogSesionesLocal;
import com.portalPrestamos.procesos.modelo.ejb.session.SBUsuarioLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.LogSesione;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;



@ManagedBean(value = "DNLogSesiones")
@ApplicationScoped
public class DNLogSesiones {

	SBLogSesionesLocal sBLogSesiones;

	public DNLogSesiones() throws Exception {
		sBLogSesiones = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBLogSesiones" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBLogSesionesLocal",
				SBLogSesionesLocal.class);
	}
	

	public int consultarIntentosFallidos(Usuario user) throws BaseException {
		return sBLogSesiones.consultarIntentosFallidos(user);
	}
	
	public LogSesione registrarLogSesion(LogSesione log) throws BaseException {
		return sBLogSesiones.registrarLogSesion(log);
	}	


}
