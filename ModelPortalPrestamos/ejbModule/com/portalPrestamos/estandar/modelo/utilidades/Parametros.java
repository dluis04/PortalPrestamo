package com.portalPrestamos.estandar.modelo.utilidades;

import javax.faces.context.FacesContext;

/*
 * SE DEFINEN IDS DE REGISROS DE BASE DE DATOS
 * HACERLO CON LA SIGUIENTE NOTACION
 * public static final TIPO_DATO NOMBRE_PARAMETRO=VALOR;
 * */
public class Parametros {
	public String CONTEXTO_APP;
	
	//Variable para controlar los ambientes de ejecucion
    public static boolean AMBIENTE_SERVIDOR =false;    
    public static final String ACTIVO="S";
    public static final String INACTIVO="N";
    //DEFINE SI SE ENVIAN O NO NOTIFICACIONES AL MOMENTO DE PRESENTARSE UNA EXCEPCION
    public static final boolean ENVIAR_NOTIFICACIONES=false;
    
    //JNDI SESSION BEANS
    public static final String PREFIJO_JNDI = "java:global/EARPortalPrestamos/ModelPortalPrestamos/";
    public static final String PREFIJO_ADICIONAL_JNDI = "!com.portalPrestamos.procesos.modelo.ejb.session.";
    public static final String PREFIJO_ADICIONAL_JNDI_BM = "!com.portalPrestamos.estandar.modelo.ejb.session.";
    public static final String JNDI_CONEXION = "jdbc/portalPrestamosDS";
   
 
    //PARAMETROS GENERACION REPORTES
    public static final String LLAVE_PARAM_REPORT = "parametrosM";
    public static final String LLAVE_FORMATO = "formato";
    public static final String FORMATO_EXCEL = "xls";
    public static final String FORMATO_PDF = "pdf";
    public static final String RUTA_JASPER="/WEB-INF/reportes/";
    public static final String RUTA_PDF="/WEB-INF/pdf/";
    public static final String RUTA_IMG="/resources/images/";
    public static final String RUTA_FOTOS="/resources/fotos/";
    //ID SECCIONES
    public static final long SECCION_FIRST=1L;
    public static final long SECCION_SECOND=2L;
    public static final long SECCION_THIRD=3L;
    public static final long SECCION_EXITOSA=4L;
    public static final long SECCION_CRITICA=5L;
    public static final long SECCION_RESOLUCION=6L;
	    
    public String getCONTEXTO_APP() {
        if (CONTEXTO_APP == null || CONTEXTO_APP.equals("")) {
            CONTEXTO_APP =
                    FacesContext.getCurrentInstance() != null ? (FacesContext.getCurrentInstance().getExternalContext().getRealPath("/")) :
                    "";
        }
        return CONTEXTO_APP;
    }

    public void setCONTEXTO_APP(String CONTEXTO_APP) {
        this.CONTEXTO_APP = CONTEXTO_APP;
    }
    
}
