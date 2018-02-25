package com.portalPrestamos.estandar.vista.utilidades;


import javax.faces.context.FacesContext;


import javax.servlet.http.HttpServletRequest;


public class UtilidadesWeb {
    public UtilidadesWeb() {
    }

    //PUBLICAR SOLO METODOS RELACIONADOS CON OBJETOS WEB
    
    /**
     * Metodos utilitarios para obtener un ManagedBean.
     * @param beanName
     * @return
     */
    public static Object getManagedBean(String theBeanName) {
        final Object returnObject =
            FacesContext.getCurrentInstance().getELContext().getELResolver().getValue(FacesContext.getCurrentInstance().getELContext(),
                                                                                      null, theBeanName);
        return returnObject;
    }

    /**
     * Remove the managed bean based on the bean name.
     *
     * @param beanName the bean name of the managed bean to be removed
     */
    public static void resetManagedBean(String beanName) {
        FacesContext.getCurrentInstance().getELContext().getELResolver().setValue(FacesContext.getCurrentInstance().getELContext(),
                                                                                  null, beanName, null);
    }

    /**
     * Get parameter value from request scope.
     *
     * @param name the name of the parameter
     * @return the parameter value
     */
    public static String getRequestParameter(String name) {
        return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    /**
     * Metodo encargado de registrar un objeto en la sesion.
     * @param attribute
     * @param object
     */
    public static void setSessionValue(String attribute, Object object) {
        getServletRequest().getSession(true).setAttribute(attribute, object);
    }

    /**
     * Metodo encargado de obtener un objeto de la sesion.
     * @param attribute
     * @return
     */
    public static Object getSessionValue(String attribute) {
        Object object = getServletRequest().getSession(true).getAttribute(attribute);
        return object;
    }

    private static HttpServletRequest getServletRequest() {
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
