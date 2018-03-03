
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBUsuariosBloqueadoLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.UsuariosBloqueado;

@ManagedBean(value = "DNUsuariosBloqueados")
@ApplicationScoped
public class DNUsuariosBloqueados {

	SBUsuariosBloqueadoLocal sBUsuariosBloqueadoLocal;

	public DNUsuariosBloqueados() throws Exception {
		sBUsuariosBloqueadoLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBUsuariosBloqueado" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBUsuariosBloqueadoLocal",
				SBUsuariosBloqueadoLocal.class);
	}

	public UsuariosBloqueado registrarUsuarioBloqueado(UsuariosBloqueado usuario) throws BaseException {
		return sBUsuariosBloqueadoLocal.registrarUsuarioBloqueado(usuario);
	}

}
