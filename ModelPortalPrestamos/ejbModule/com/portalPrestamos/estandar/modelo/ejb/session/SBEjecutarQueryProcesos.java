package com.portalPrestamos.estandar.modelo.ejb.session;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless

public class SBEjecutarQueryProcesos implements SBEjecutarQueryProcesosLocal {

    @EJB
    SBFacadeProcesosLocal sbFacadeLocal;

    public SBEjecutarQueryProcesos() {
    }

    public List ejecutarQuery(String sql) {
             
          try{
              
              List lista = sbFacadeLocal.executeNativeQuery(sql,null);              
              if(lista!=null && lista.size()>0) {
                  return lista;    
              }
              
          }catch(Exception e) {
              
              e.printStackTrace();
          } 
          
          return null;
    }
}
