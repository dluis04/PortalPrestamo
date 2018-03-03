package com.portalPrestamos.procesos.modelo.ejb.session;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.UsuariosBloqueado;

/**
 * Session Bean implementation class SBUsuariosBloqueado
 */
@Stateless
@LocalBean
public class SBUsuariosBloqueado implements SBUsuariosBloqueadoLocal {

	@EJB
	SBFacadeProcesosLocal sbFacade;
	
    /**
     * Default constructor. 
     */
    public SBUsuariosBloqueado() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public UsuariosBloqueado registrarUsuarioBloqueado(UsuariosBloqueado usuario) throws BaseException {
		UsuariosBloqueado entity = (UsuariosBloqueado) sbFacade.insertEntity(usuario);
		return entity;
	}

}
