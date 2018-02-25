package com.portalPrestamos.estandar.modelo.ejb.session;


import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;


@Local
public interface SBFacadeProcesosLocal {

    public Object updateEntity(Object pEntity) throws BaseException;

    public Object persistEntity(Object entity) throws BaseException;

    public List executeNamedQuery(String queryName, HashMap parameters, 
                                  int maxElem) throws BaseException;

    public List executeNamedQuery(String queryName, 
                                  HashMap parameters) throws BaseException;

    public Object insertEntity(Object pEntity) throws BaseException;

    public Object insertEntity(Object pEntity, 
                               boolean pbFlush) throws BaseException;

    public Object findByPrimaryKey(Class pClaseBusqueda, 
                                   Object vPk) throws BaseException;

    public void removeEntity(Object pEntity) throws BaseException;

    public List executeNativeQuery(String psQuery, 
                                   HashMap poParameters) throws BaseException;

    public void executeNativeQueryUpdate(String psQuery, 
                                         HashMap poParameters) throws BaseException;

    public void clearCache();

    public void rollback();

    public List executeNativeQuery(String psQuery, Class psClass, HashMap poParameters) throws BaseException;

    public void clear();

    public void refresh(Object entity);

    public List executeQuery(String qlQuery, 
                             HashMap parameters) throws BaseException;
}
