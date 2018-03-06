
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBPagoLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Pago;

@ManagedBean(value = "DNPago")
@ApplicationScoped
public class DNPago {

	SBPagoLocal sBPagoLocal;

	public DNPago() throws Exception {
		sBPagoLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBPago" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBPagoLocal",
				SBPagoLocal.class);
	}

	public Pago registrarPago(Pago pago) throws Exception {
		return sBPagoLocal.registrarPago(pago);
	}

	public List<Pago> consultarPagoByCuota(DetalleCuota cuota) throws Exception {
		return sBPagoLocal.consultarPagoByCuota(cuota);
	}

	public Pago modificarPago(Pago pago) throws Exception {
		return sBPagoLocal.modificarPago(pago);
	}

}
