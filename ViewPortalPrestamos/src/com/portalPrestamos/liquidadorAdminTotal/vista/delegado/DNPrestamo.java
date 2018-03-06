
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBPrestamoLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(value = "DNPrestamo")
@ApplicationScoped
public class DNPrestamo {

	SBPrestamoLocal sBPrestamoLocal;

	public DNPrestamo() throws Exception {
		sBPrestamoLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBPrestamo" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPrestamoLocal",
				SBPrestamoLocal.class);
	}

	public Prestamo crearPrestamo(Prestamo nuevoPrestamo) throws Exception {
		return sBPrestamoLocal.crearPrestamo(nuevoPrestamo);
	}

	public Prestamo consultarPrestamoByDeudor(Usuario deudor) throws Exception {
		return sBPrestamoLocal.consultarPrestamoByDeudor(deudor);
	}

	public Prestamo modificarPrestamo(Prestamo prestamo) throws Exception {
		return sBPrestamoLocal.modificarPrestamo(prestamo);
	}

	public List<Prestamo> consultarAllPrestamosActivos() throws Exception {
		return sBPrestamoLocal.consultarAllPrestamosActivos();
	}

	public List<Prestamo> consultarAllPrestamosTerminados() throws Exception {
		return sBPrestamoLocal.consultarAllPrestamosTerminados();
	}

	public List<Prestamo> consultarAllPrestamosEliminados() throws Exception {
		return sBPrestamoLocal.consultarAllPrestamosEliminados();
	}

}
