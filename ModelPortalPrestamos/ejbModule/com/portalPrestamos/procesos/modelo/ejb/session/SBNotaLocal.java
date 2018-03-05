package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Nota;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@Local
public interface SBNotaLocal {

	public Nota crearNota(Nota nuevaNota) throws Exception;
	public List<Nota> consultarNotaByUsuario(Usuario usuario) throws Exception;
	public Nota modificarNota(Nota nota) throws Exception;
	public void eleminarNota(Nota nota) throws Exception;
	
	
}
