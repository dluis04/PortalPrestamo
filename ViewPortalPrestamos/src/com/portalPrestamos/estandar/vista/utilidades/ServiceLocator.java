package com.portalPrestamos.estandar.vista.utilidades;

import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;


public class ServiceLocator {
    static ServiceLocator serviceLocator = null;
    Context context = null;

    /**
     * Cache where the objects can be stored for later retrieval.
     * This enhances the performance.
     */
    static HashMap serviceCache = null;

    public static ServiceLocator getInstance() throws NamingException {
        if (serviceLocator == null) {
            serviceLocator = new ServiceLocator();
            serviceCache = new HashMap();
        }
        return serviceLocator;
    }


    /**
     * This is the method that returns the service
     *
     * @param jndiName JNDI Lookup needed for invoking the service
     * @exception NamingException In case an exception is generated
     * @return Service Object
     */
    public <T> T obtenerServicio(String jndiName, 
                                 Class<T> clazz) throws Exception {
        Object bean = null;

        if (serviceCache.containsKey(jndiName)) {
            bean = serviceCache.get(jndiName);
            return (T)bean;
        }
        try {
            context = new InitialContext();
            //printJNDITree("");
            bean = context.lookup(jndiName);
            if (!serviceCache.containsKey(jndiName)) {
                // If the object is not saved in the cache, then do a lookup and save it
                serviceCache.put(jndiName, bean);
            }
        } catch (NamingException ex) {
            throw new Exception("No se puede conectar con el Session Bean: " + 
                                jndiName + ". Causa: " + ex, ex);
        }
        // Return the required object
        return (T)bean;
    }

    public void printJNDITree(String ct) {
        try {
            printNE(context.list(ct), ct);
        } catch (NamingException e) {
            //ignore leaf node exception
        }
    }

    private void printNE(NamingEnumeration ne, 
                         String parentctx) throws NamingException {
        while (ne.hasMoreElements()) {
            NameClassPair next = (NameClassPair)ne.nextElement();
            printEntry(next);
            increaseIndent();
            printJNDITree((parentctx.length() == 0) ? next.getName() : 
                          parentctx + "/" + next.getName());
            decreaseIndent();
        }
    }

    private void printEntry(NameClassPair next) {
        System.out.println(printIndent() + "-->" + next);
    }


    private int indentLevel = 0;

    private void increaseIndent() {
        indentLevel += 4;
    }

    private void decreaseIndent() {
        indentLevel -= 4;
    }

    private String printIndent() {
        StringBuffer buf = new StringBuffer(indentLevel);
        for (int i = 0; i < indentLevel; i++) {
            buf.append(" ");
        }
        return buf.toString();
    }
}
