
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBTipoUsuarioLocal;
import com.portalPrestamos.procesos.modelo.ejb.session.SBTiposBloqueo;
import com.portalPrestamos.procesos.modelo.ejb.session.SBTiposBloqueoLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TipoUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TiposBloqueo;

@ManagedBean(value = "DNTipoUsuario")
@ApplicationScoped
public class DNTipoUsuario {

	SBTipoUsuarioLocal sBTipoUsuarioLocal;

	public DNTipoUsuario() throws Exception {
		sBTipoUsuarioLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBTipoUsuario" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBTipoUsuarioLocal",
				SBTipoUsuarioLocal.class);
	}

	public List<TipoUsuario> consultarTodosTipoUsuario() throws Exception {
		return sBTipoUsuarioLocal.consultarTodo();
	}

	public TipoUsuario consultarDetalleTipoUsuarioById(int idTipo) throws Exception {
		return sBTipoUsuarioLocal.consultarDetalleTipoUsuarioById(idTipo);
	}

}