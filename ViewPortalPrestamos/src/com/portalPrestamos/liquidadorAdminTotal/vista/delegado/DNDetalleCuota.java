
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBDetalleCuotaLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Prestamo;

@ManagedBean(value = "DNDetalleCuota")
@ApplicationScoped
public class DNDetalleCuota {

	SBDetalleCuotaLocal sBDetalleCuotaLocal;

	public DNDetalleCuota() throws Exception {
		sBDetalleCuotaLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBDetalleCuota" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBDetalleCuotaLocal",
				SBDetalleCuotaLocal.class);
	}

	public List<DetalleCuota> crearCuota(List<DetalleCuota> nuevasCuotas) throws Exception {
		return sBDetalleCuotaLocal.crearCuota(nuevasCuotas);
	}

	public List<DetalleCuota> consultarDetalleCuotaByPrestamoDeben(Prestamo prestamo) throws Exception {
		return sBDetalleCuotaLocal.consultarDetalleCuotaByPrestamoDeben(prestamo);
	}

	public List<DetalleCuota> consultarAllDetalleCuotas() throws Exception {
		return sBDetalleCuotaLocal.consultarAllDetalleCuotas();
	}

	public List<DetalleCuota> modificarDetalleCuotas(List<DetalleCuota> listDetalleCuotas) throws Exception {
		return sBDetalleCuotaLocal.modificarDetalleCuotas(listDetalleCuotas);
	}

}
