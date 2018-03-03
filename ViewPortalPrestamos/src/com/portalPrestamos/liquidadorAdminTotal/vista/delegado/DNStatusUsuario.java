
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBStatusUsuarioLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;

@ManagedBean(value = "DNStatusUsuario")
@ApplicationScoped
public class DNStatusUsuario {

	SBStatusUsuarioLocal sBStatusUsuarioLocal;

	public DNStatusUsuario() throws Exception {
		sBStatusUsuarioLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI + "SBStatusUsuario"
				+ Parametros.PREFIJO_ADICIONAL_JNDI + "SBStatusUsuarioLocal", SBStatusUsuarioLocal.class);
	}

	public StatusUsuario consultarDetalleStatusById(int idStatus) throws Exception {
		return sBStatusUsuarioLocal.consultarDetalleStatusById(idStatus);
	}

}
