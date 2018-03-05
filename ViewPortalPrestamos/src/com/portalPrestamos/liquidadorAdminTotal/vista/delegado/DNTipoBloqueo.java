
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBTiposBloqueo;
import com.portalPrestamos.procesos.modelo.ejb.session.SBTiposBloqueoLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TiposBloqueo;

@ManagedBean(value = "DNTipoBloqueo")
@ApplicationScoped
public class DNTipoBloqueo {

	SBTiposBloqueoLocal sBTiposBloqueo;

	public DNTipoBloqueo() throws Exception {
		sBTiposBloqueo = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBTiposBloqueo" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBTiposBloqueoLocal",
				SBTiposBloqueo.class);
	}

	public TiposBloqueo consultarDetalleTipoBloqueoById(int idBloqueo) throws Exception {
		return sBTiposBloqueo.consultarDetalleTipoBloqueoById(idBloqueo);
	}

	public List<TiposBloqueo> consultarAllTiposBloqueos() throws Exception {
		return sBTiposBloqueo.consultarAllTiposBloqueos();
	}

}
