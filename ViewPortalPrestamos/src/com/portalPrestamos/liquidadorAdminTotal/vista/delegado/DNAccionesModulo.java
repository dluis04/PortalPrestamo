
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBAccionesModuloLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.AccionesModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

@ManagedBean(value = "DNAccionesModulo")
@ApplicationScoped
public class DNAccionesModulo {

	SBAccionesModuloLocal sBAccionesModuloLocal;

	public DNAccionesModulo() throws Exception {
		sBAccionesModuloLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBAccionesModulo" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBAccionesModuloLocal",
				SBAccionesModuloLocal.class);
	}

	public AccionesModulo crearAccionesModulo(AccionesModulo nuevo) throws Exception {
		return sBAccionesModuloLocal.crearAccionesModulo(nuevo);
	}

	public List<AccionesModulo> consultarAllAccionesModuloByModulo(Modulo modulo) throws Exception {
		return sBAccionesModuloLocal.consultarAllAccionesModuloByModulo(modulo);
	}

	public List<AccionesModulo> consultarAllAccionesModulo() throws Exception {
		return sBAccionesModuloLocal.consultarAllAccionesModulo();
	}

	public AccionesModulo actualizarModulo(AccionesModulo modulo) throws Exception {
		return sBAccionesModuloLocal.actualizarModulo(modulo);
	}

}
