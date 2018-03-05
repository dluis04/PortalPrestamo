package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.portalPrestamos.estandar.modelo.ejb.session.SBFacadeProcesosLocal;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.AccionesModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

/**
 * Session Bean implementation class SBAccionesModulo
 */
@Stateless
@LocalBean
public class SBAccionesModulo implements SBAccionesModuloLocal {
	
	@EJB
	SBFacadeProcesosLocal sbFacade;
	
    /**
     * Default constructor. 
     */
    public SBAccionesModulo() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public AccionesModulo crearAccionesModulo(AccionesModulo nuevo) throws Exception {
		AccionesModulo entity = (AccionesModulo) sbFacade.insertEntity(nuevo);
		return entity;
	}

	@Override
	public List<AccionesModulo> consultarAllAccionesModuloByModulo(Modulo modulo) throws Exception {

		String query = "SELECT u FROM AccionesModulo u where u.modulo='" + modulo+ "' ";
		List<AccionesModulo> listAccionesModulos = sbFacade.executeQuery(query, null);
		return listAccionesModulos;
	}

	@Override
	public List<AccionesModulo> consultarAllAccionesModulo() throws Exception {
		String query = "SELECT u FROM AccionesModulo u";
		List<AccionesModulo> listAccionesModulos = sbFacade.executeQuery(query, null);
		return listAccionesModulos;
	}

	@Override
	public AccionesModulo actualizarModulo(AccionesModulo modulo) throws Exception {
		AccionesModulo entity = (AccionesModulo) sbFacade.updateEntity(modulo);
		return entity;
	}
    
    

}
