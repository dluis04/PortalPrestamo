package com.portalPrestamos.procesos.modelo.ejb.session;

import javax.ejb.Local;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.UsuariosBloqueado;

@Local
public interface SBUsuariosBloqueadoLocal {

	public UsuariosBloqueado registrarUsuarioBloqueado(UsuariosBloqueado usuario) throws BaseException;

}
