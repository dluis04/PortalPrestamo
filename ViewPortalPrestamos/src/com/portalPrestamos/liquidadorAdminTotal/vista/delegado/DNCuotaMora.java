
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBCuotaMoraLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.CuotaMora;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;

@ManagedBean(value = "DNCuotaMora")
@ApplicationScoped
public class DNCuotaMora {

	SBCuotaMoraLocal sBCuotaMoraLocal;

	public DNCuotaMora() throws Exception {
		sBCuotaMoraLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBCuotaMora" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBCuotaMoraLocal",
				SBCuotaMoraLocal.class);
	}

	public CuotaMora registrarPago(CuotaMora pago) throws Exception {
		return sBCuotaMoraLocal.registrarPago(pago);
	}

	public List<CuotaMora> consultarCuotaMoraByCuota(DetalleCuota cuota) throws Exception {
		return sBCuotaMoraLocal.consultarCuotaMoraByCuota(cuota);
	}

	public CuotaMora modificarPagoCuotaMora(CuotaMora pago) throws Exception {
		return sBCuotaMoraLocal.modificarPagoCuotaMora(pago);
	}

}
