
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBConfiguracionAppLocal;



@ManagedBean(value = "DNConfiguracionApp")
@ApplicationScoped
public class DNConfiguracionApp {

	SBConfiguracionAppLocal sBConfiguracionApp;

	public DNConfiguracionApp() throws Exception {
		sBConfiguracionApp = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBConfiguracionApp" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBConfiguracionAppLocal",
				SBConfiguracionAppLocal.class);
	}

	public int consultaIntentosInicioSesion(int idConfiguracion) throws BaseException{
		return sBConfiguracionApp.consultaIntentosInicioSesion(idConfiguracion);
	}

}
