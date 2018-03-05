
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBNotaLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Nota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(value = "DNNota")
@ApplicationScoped
public class DNNota {

	SBNotaLocal sBNotaLocal;

	public DNNota() throws Exception {
		sBNotaLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBNota" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBNotaLocal",
				SBNotaLocal.class);
	}

	public Nota crearNota(Nota nuevaNota) throws Exception {
		return sBNotaLocal.crearNota(nuevaNota);
	}

	public List<Nota> consultarNotaByUsuario(Usuario usuario) throws Exception {
		return sBNotaLocal.consultarNotaByUsuario(usuario);
	}

	public Nota modificarNota(Nota nota) throws Exception {
		return sBNotaLocal.modificarNota(nota);
	}

	public void eleminarNota(Nota nota) throws Exception {
		sBNotaLocal.eleminarNota(nota);
	}

}
