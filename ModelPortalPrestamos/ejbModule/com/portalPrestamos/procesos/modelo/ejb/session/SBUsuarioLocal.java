package com.portalPrestamos.procesos.modelo.ejb.session;

import javax.ejb.Local;


import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBUsuarioLocal {

	public Usuario crearUsuario(Usuario nuevo) throws Exception;
	public Usuario actualizarUsuario(Usuario update) throws Exception;
	public Usuario consultarDetalleUsuario(int id) throws Exception;
	public int consultarUsuarioInicio(Usuario user) throws Exception;
	public int consultarUsuarioRepetido(Usuario user) throws Exception;
	public Usuario consultarDetalleByUsuario(Usuario usuario) throws Exception;
	public int recuperarPassword(Usuario usario) throws Exception;
	public Usuario bloquearUsuarioStatus(Usuario usuario) throws Exception;
	
	
}
