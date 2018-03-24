
package com.portalPrestamos.liquidadorAdminTotal.vista.delegado;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.vista.utilidades.ServiceLocator;
import com.portalPrestamos.procesos.modelo.ejb.session.SBCuotaMoraHiLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.CuotaMoraHi;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.DetalleCuota;

@ManagedBean(value = "DNCuotaMoraHi")
@ApplicationScoped
public class DNCuotaMoraHi {

	SBCuotaMoraHiLocal sBCuotaMoraHiLocal;

	public DNCuotaMoraHi() throws Exception {
		sBCuotaMoraHiLocal = ServiceLocator.getInstance().obtenerServicio(
				Parametros.PREFIJO_JNDI + "SBCuotaMoraHi" + Parametros.PREFIJO_ADICIONAL_JNDI + "SBCuotaMoraHiLocal",
				SBCuotaMoraHiLocal.class);
	}

	public CuotaMoraHi registrarHistorialCuotaMora(CuotaMoraHi pago) throws Exception {
		return sBCuotaMoraHiLocal.registrarHistorialCuotaMora(pago);
	}

	public List<CuotaMoraHi> consultarCuotaMoraHistorialByDetalleCuota(DetalleCuota cuota) throws Exception {
		return sBCuotaMoraHiLocal.consultarCuotaMoraHistorialByDetalleCuota(cuota);
	}

}
