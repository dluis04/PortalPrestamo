
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBConfiguracionAppLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.ConfiguracionApp;

@ManagedBean(value = "DNConfiguracionApp")
@ApplicationScoped
public class DNConfiguracionApp {

	SBConfiguracionAppLocal sBConfiguracionApp;

	public DNConfiguracionApp() throws Exception {
		sBConfiguracionApp = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI + "SBConfiguracionApp"
				+ Parametros.PREFIJO_ADICIONAL_JNDI + "SBConfiguracionAppLocal", SBConfiguracionAppLocal.class);
	}

	public int consultaConfiguracionIntentosInicioSesion(int idConfiguracion) throws BaseException {
		return sBConfiguracionApp.consultaConfiguracionIntentosInicioSesion(idConfiguracion);
	}

	public List<ConfiguracionApp> consultarAllConfiguracionApp() throws BaseException {
		return sBConfiguracionApp.consultarAllConfiguracionApp();
	}

	public ConfiguracionApp modificarParametrizacion(ConfiguracionApp configuracion) throws BaseException {
		return sBConfiguracionApp.modificarParametrizacion(configuracion);
	}

}
