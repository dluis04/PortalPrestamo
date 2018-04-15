
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBModuloLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

@ManagedBean(value = "DNModulo")
@ApplicationScoped
public class DNModulo {

	SBModuloLocal sBModuloLocal;

	public DNModulo() throws Exception {
		sBModuloLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBModulo" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBModuloLocal",
				SBModuloLocal.class);
	}

	public Modulo crearModulo(Modulo nuevo) throws Exception {
		return sBModuloLocal.crearModulo(nuevo);
	}

	public List<Modulo> consultarAllModulos() throws Exception {
		return sBModuloLocal.consultarAllModulos();
	}

	public List<Modulo> consultarAllModulosActivos() throws Exception {
		return sBModuloLocal.consultarAllModulosActivos();
	}

	public Modulo consultarModulosById(Modulo modulo) throws Exception {
		return sBModuloLocal.consultarModulosById(modulo);
	}

	public Modulo actualizarModulo(Modulo modulo) throws Exception {
		return sBModuloLocal.actualizarModulo(modulo);
	}

}
