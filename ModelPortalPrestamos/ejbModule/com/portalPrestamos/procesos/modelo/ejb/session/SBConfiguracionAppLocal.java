package com.portalPrestamos.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;

@Local
public interface SBConfiguracionAppLocal {
	
	public int consultaConfiguracionIntentosInicioSesion(int idConfiguracion) throws BaseException;

}
