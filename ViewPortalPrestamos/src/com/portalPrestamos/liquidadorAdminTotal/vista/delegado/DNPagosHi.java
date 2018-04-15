
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBPagosHiLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Pago;

@ManagedBean(value = "DNPagosHi")
@ApplicationScoped
public class DNPagosHi {

	SBPagosHiLocal sBPagosHiLocal;

	public DNPagosHi() throws Exception {
		sBPagosHiLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBPagosHi" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPagosHiLocal",
				SBPagosHiLocal.class);
	}

	public Pago registrarPagoHistorial(Pago pago) throws Exception {
		return sBPagosHiLocal.registrarPagoHistorial(pago);
	}

	public List<Pago> consultarPagoByDetalleCuotaHis(DetalleCuota cuota) throws Exception {
		return sBPagosHiLocal.consultarPagoByDetalleCuotaHis(cuota);
	}

}
