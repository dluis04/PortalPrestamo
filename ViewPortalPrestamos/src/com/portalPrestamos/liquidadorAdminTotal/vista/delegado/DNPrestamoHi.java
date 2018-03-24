
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBPrestamoHiLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PrestamosHi;

@ManagedBean(value = "DNPrestamoHi")
@ApplicationScoped
public class DNPrestamoHi {

	SBPrestamoHiLocal sBPrestamoHiLocal;

	public DNPrestamoHi() throws Exception {
		sBPrestamoHiLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBPrestamoHi" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPrestamoHiLocal",
				SBPrestamoHiLocal.class);
	}

	public PrestamosHi registrarPrestamoHistorial(PrestamosHi prestamo) throws Exception {
		return sBPrestamoHiLocal.registrarPrestamoHistorial(prestamo);
	}

	public List<PrestamosHi> consultarPrestamoHistorialByPrestamo(Prestamo prestamo) throws Exception {
		return sBPrestamoHiLocal.consultarPrestamoHistorialByPrestamo(prestamo);
	}

}
