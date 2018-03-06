package com.portalPrestamos.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.LogSesione;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBLogSesionesLocal {

	public int consultarIntentosFallidos(Usuario user)  throws BaseException;
	public LogSesione registrarLogSesion(LogSesione log) throws BaseException;
		
}
