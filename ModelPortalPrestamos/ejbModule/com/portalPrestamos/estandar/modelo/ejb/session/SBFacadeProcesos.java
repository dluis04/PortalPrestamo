package com.portalPrestamos.estandar.modelo.ejb.session;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.jpa.JpaEntityManager;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;


@Stateless(name = "SBFacadeProcesos")
public class SBFacadeProcesos implements  SBFacadeProcesosLocal {
    @PersistenceContext(unitName = "portalPrestamos")
    private EntityManager emSBFacade;

    public SBFacadeProcesos() {
    }

    /**
     * Este método sirve para sincronizar la entidad contra la tabla en la base de datos
     * @since 5.0
     * @author jaloaiza
     * @param pEntity Entidad a sincronizar
     * @return Object con la entidad actualizada
     * @FechaCreacion 2006-09-19
     */
    public Object updateEntity(Object pEntity) throws BaseException {
        try {
            return emSBFacade.merge(pEntity);
        } catch (Exception vExcepcion) {
            throw new BaseException("error004", null, vExcepcion, pEntity, "notificacion001");
        }
    }

    public Object persistEntity(Object entity) throws BaseException {
        emSBFacade.persist(entity);
        return entity;
    }


    //Metodos agregados del SBFacade del proyecto Alicuotas

    public List executeNamedQuery(String queryName, HashMap parameters, int maxElem) throws BaseException {
        try {
            Query query = emSBFacade.createNamedQuery(queryName);

            // limitamos la cantidad de elementos a retornar en la consulta
            query.setMaxResults(maxElem);
            Iterator vIterator = parameters.keySet().iterator();
            Object vKey = null;

            while (vIterator.hasNext()) {
                vKey = vIterator.next();
                query.setParameter(vKey.toString(), parameters.get(vKey));
            }

            // refrescamos el contenido de la lista de resultados.
            return query.getResultList();
        } catch (Exception e) {
            throw new BaseException("error006", null, e, queryName, "notificacion002");
        }
    }

    /**
     * Este método sirve para llamar y ejecutar un namedQuery registrado en un entity bean
     * @since 5.0
     * @author jaloaiza
     * @param queryName Nombre del NamedQuery
     * @param parameters Parametros que se le envian al NamedQury
     * @return List Con los resultados de la consulta
     * @FechaCreacion 2006-09-19
     */
    public List executeNamedQuery(String queryName, HashMap parameters) throws BaseException {
        try {
            Query query = emSBFacade.createNamedQuery(queryName);

            //Para que no haga control de los objetos ya insertados dentro de la transaccion, esto reduce memoria
            //permite que no se generen mas consumo para consultar los objetos ya ingresados dentro de una transaccion, solo consultaria objetos ya existentes en la bd
            query.setFlushMode(FlushModeType.COMMIT);
            if (parameters != null) {
                Iterator vIterator = parameters.keySet().iterator();
                Object vKey = null;

                while (vIterator.hasNext()) {
                    vKey = vIterator.next();
                    query.setParameter(vKey.toString(), parameters.get(vKey));
                }
            }

            // refrescamos el contenido de la lista de resultados.
            List vList = query.getResultList();

            query = null;

            return vList;
        } catch (Exception e) {
            throw new BaseException("error006", null, e, queryName, "notificacion003");
        }
    }

    /**
     * Este método sirve para insertar un registro en la tabla de la base de datos
     * @since 5.0
     * @author jaloaiza
     * @param pEntity Entidad a insertar
     * @return Object Con el objeto insertado
     * @FechaCreacion 2006-09-19
     */
    public Object insertEntity(Object pEntity) throws BaseException {
        //Se ejecuta la consulta, lanzando SiaException
        return insertEntity(pEntity, true);
    }

    /**
     * Este método sirve para insertar un registro en la tabla de la base de datos
     * @since 5.0
     * @author jaloaiza
     * @param pEntity Entidad a insertar
     * @return Object Con el objeto insertado
     * @FechaCreacion 2006-09-19
     */
    public Object insertEntity(Object pEntity, boolean pbFlush) throws BaseException {
        try {
            emSBFacade.persist(pEntity);
            if (pbFlush) {
                emSBFacade.flush();
            }
            return pEntity;
        } catch (Exception vExcepcion) {
            throw new BaseException("error003", null, vExcepcion, pEntity, "notificacion004");
        }
    }

    /**
     * Este método sirve para consultar una entidad por la llave primaria
     * @since 5.0
     * @author jaloaiza
     * @param pClaseBusqueda Clase EntityBean a buscar
     * @param vPk Objeto con el(los) valor(es) de la(s) llave(s) primaria(s) para la búsqueda
     * @param pTipoTransaccion Tipo de transaccion, UtilidadesModel.TIPO_TRANSACCION.RAISE, UtilidadesModel.TIPO_TRANSACCION.NO_RAISE
     * @return Object con el pEntity bean enacontrado
     * @FechaCreacion 2006-09-19
     */
    public Object findByPrimaryKey(Class pClaseBusqueda, Object vPk) throws BaseException {
        try {
            return emSBFacade.find(pClaseBusqueda, vPk);
        } catch (Exception vException) {
            throw new BaseException("error007", new String[] { vPk.toString() }, vException, vPk, "notificacion005");
        }
    }

    /**
     * Este método sirve para eliminar un registro de la base de datos
     * @since 5.0
     * @author jaloaiza
     * @param pEntity Entidad a eliminar
     * @FechaCreacion 2006-09-19
     */
    public void removeEntity(Object pEntity) throws BaseException {
        try {
            emSBFacade.remove(emSBFacade.merge(pEntity));
        } catch (Exception vExcepcion) {
            throw new BaseException("error005", null, vExcepcion, pEntity, "notificacion006");
        }
    }

    /**
     * Este metodo ejecuta un NativeQuery de los EJB
     * @since 5.0
     * @author siscjmduran
     * @param  psQuery       Nombre de la consulta que se va a ejecutar
     * @param  poParameters  Lista de Parametros para ejecutar la consulta
     * @param  pnQueryType   Para determinar si realiza RAISE o no
     * @return Object        Objeto que retorna la consulta
     * @FechaCreacion 2007/05/05
     */
    public List executeNativeQuery(String psQuery, HashMap poParameters) throws BaseException {
        try {
            //Consulta la informacion
            Query query = emSBFacade.createNativeQuery(psQuery);

            if (poParameters != null) {
                Iterator vIterator = poParameters.keySet().iterator();
                Object vKey = null;
                while (vIterator.hasNext()) {
                    vKey = vIterator.next();
                    query.setParameter(vKey.toString(), poParameters.get(vKey));
                }
            }
            return query.getResultList();

        } catch (Exception vExcepcion) {
            throw new BaseException("error011", null, vExcepcion, psQuery, "notificacion007");
        }
    }

    /**
     * Este metodo ejecuta un NativeQuery para realizar updates o deletes
     * @since 5.0
     * @author jhonandrey@hotmail.com
     * @param  psQuery       SQL del update o delete
     * @param  poParameters  Lista de Parametros para ejecutar el update o el delete
     * @param  pnQueryType   Para determinar si realiza RAISE o no
     * @FechaCreacion 2008/08/05
     */
    public void executeNativeQueryUpdate(String psQuery, HashMap poParameters) throws BaseException {
        try {
            //Consulta la informacion
            Query query = emSBFacade.createNativeQuery(psQuery);
            if (poParameters != null) {
                Iterator vIterator = poParameters.keySet().iterator();
                Object vKey = null;
                while (vIterator.hasNext()) {
                    vKey = vIterator.next();
                    query.setParameter(vKey.toString(), poParameters.get(vKey));
                }
            }
            query.executeUpdate();

        } catch (Exception vExcepcion) {
            throw new BaseException("error011", null, vExcepcion, psQuery, "notificacion008");
        }
    }

    /**
     * Este metodo borra el cache de los ejbs, esto es, los objetos mapeados que estan en memoria
     * se borran para que se vuelvan a consultar de la  BD
     * @since 5.0
     * @author jloaiza
     * @FechaCreacion 2008/02/19
     */
    public void clearCache() {
        try {
            //TODO PARAMETRIZARLO POR TECNOLOGIA PORQUE ESTA ES ESPECIFICA PARA TOPLINK JPA
            //((oracle.toplink.essentials.ejb.cmp3.EntityManager)emSBFacade.getDelegate()).getServerSession().getIdentityMapAccessor().invalidateAll();

            // Usando EclipseLink - jpa
            //((JpaEntityManager)emSBFacade.getDelegate()).getServerSession().getIdentityMapAccessor().invalidateAll();
        } catch (Exception vExcepcion) {
            System.out.println("No se puede limpiar el cache de los EJBs");
            vExcepcion.printStackTrace();
        }
    }

    /**
     * Este método se llama cuando los sesion beans generan excepcion de aplicacion (errores de lógica de negocio)
     * para hacer rollback de toda la transaccion
     * @since 5.0
     * @author jaloaiza
     * @FechaCreacion 2010-03-18
     */
    public void rollback() {
        try {
            //TODO PARAMETRIZARLO POR TECNOLOGIA PORQUE ESTA ES ESPECIFICA PARA TOPLINK JPA
            //Context vCtx = new InitialContext();
            //SessionContext sessionContext=(SessionContext)vCtx.lookup("java:comp/EJBContext");
            emSBFacade.getTransaction().rollback();
            //EJBContext ctxSessionFacade = (EJBContext)vCtx.lookup("java:comp/EJBContext");
            //ctxSessionFacade.setRollbackOnly();
        } catch (Throwable th) {
            System.out.println("No se puede hacer rollback de la transacción ");
            th.printStackTrace();
        }
    }

    /**
     * Este metodo ejecuta un NativeQuery de los EJB
     * @since 5.0
     * @author jaloaiza
     * @param  psQuery       Nombre de la consulta que se va a ejecutar
     * @param  psClass       Clase del Entity a mapear el resultado de la consulta
     * @param  poParameters  Lista de Parametros para ejecutar la consulta
     * @param  pnQueryType   Para determinar si realiza RAISE o no
     * @return Object        Objeto que retorna la consulta
     */
    public List executeNativeQuery(String psQuery, Class psClass, HashMap poParameters) throws BaseException {
        try {
            //Consulta la informacion
            Query query = emSBFacade.createNativeQuery(psQuery, psClass);
            //se le dice que refresque los resultados de la bd
            query.setHint("toplink.refresh", HintValues.TRUE);
            //invalida el objeto en el cache para que se vuelva a buscar en la bd
            ((JpaEntityManager)emSBFacade.getDelegate()).getServerSession().getIdentityMapAccessor().invalidateClass(psClass);

            if (poParameters != null) {
                Iterator vIterator = poParameters.keySet().iterator();
                Object vKey = null;
                while (vIterator.hasNext()) {
                    vKey = vIterator.next();
                    query.setParameter(vKey.toString(), poParameters.get(vKey));
                }
            }
            return query.getResultList();
        } catch (Exception vExcepcion) {

            throw new BaseException("error011", null, vExcepcion, psQuery, "notificacion007");
        }
    }

    /**
     * Clear the persistence context, causing all managed
     * entities to become detached. Changes made to entities that
     * have not been flushed to the database will not be
     * persisted.
     */
    public void clear() {
        try {
            emSBFacade.clear();
        } catch (Exception e) {
            System.out.println("Error limpiando el EntityManager");
            e.printStackTrace();
        }
    }

    /**
     * Refresh the state of the instance from the database,
     * overwriting changes made to the entity, if any.
     * @param entity
     * @throws IllegalArgumentException if not an entity
     * or entity is not managed
     * @throws TransactionRequiredException if invoked on a
     * container-managed entity manager of type
     * PersistenceContextType.TRANSACTION and there is
     * no transaction.
     * @throws EntityNotFoundException if the entity no longer
     * exists in the database
     */
    public void refresh(Object entity) {
        try {
            emSBFacade.refresh(entity);
        } catch (Exception e) {
            System.out.println("Error refrescando la entidad " + entity != null ? entity.toString() : "");
            e.printStackTrace();
        }
    }

    /**
     * Create an instance of Query for executing a
     * Java Persistence query language statement.
     * @param qlString a Java Persistence query string
     * @return the new query instance
     * @throws IllegalArgumentException if query string is not valid
     */
    public List executeQuery(String qlQuery, HashMap parameters) throws BaseException {
        try {
            Query query = emSBFacade.createQuery(qlQuery);
            //Para que no haga control de los objetos ya insertados dentro de la transaccion, esto reduce memoria
            //permite que no se generen mas consumo para consultar los objetos ya ingresados dentro de una transaccion, solo consultaria objetos ya existentes en la bd
            query.setFlushMode(FlushModeType.COMMIT);
            if (parameters != null) {
                Iterator vIterator = parameters.keySet().iterator();
                Object vKey = null;

                while (vIterator.hasNext()) {
                    vKey = vIterator.next();
                    query.setParameter(vKey.toString(), parameters.get(vKey));
                }
            }

            // refrescamos el contenido de la lista de resultados.
            return query.getResultList();
        } catch (Exception e) {
        	System.out.println("errork "+e);
            throw new BaseException("error012", null, e, qlQuery, "notificacion009");
        }
    }
}
