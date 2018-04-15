
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBDetalleCuotaHiLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuotasHi;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

@ManagedBean(value = "DNDetalleCuotaHi")
@ApplicationScoped
public class DNDetalleCuotaHi {

	SBDetalleCuotaHiLocal sBDetalleCuotaHiLocal;

	public DNDetalleCuotaHi() throws Exception {
		sBDetalleCuotaHiLocal = ServiceLocator.getInstance().obtenerServicio(Parametros.PREFIJO_JNDI
				+ "SBDetalleCuotaHi" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBDetalleCuotaHiLocal",
				SBDetalleCuotaHiLocal.class);
	}

	public List<DetalleCuotasHi> registrarHistoriaDetalleCuota(List<DetalleCuotasHi> nuevasCuotas) throws Exception {
		return sBDetalleCuotaHiLocal.registrarHistoriaDetalleCuota(nuevasCuotas);
	}

	public List<DetalleCuotasHi> consultarDetalleCuotaHistorialByPrestamo(Prestamo prestamo) throws Exception {
		return sBDetalleCuotaHiLocal.consultarDetalleCuotaHistorialByPrestamo(prestamo);
	}

}
