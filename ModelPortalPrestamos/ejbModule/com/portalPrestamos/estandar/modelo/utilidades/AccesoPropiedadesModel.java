package com.portalPrestamos.estandar.modelo.utilidades;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class AccesoPropiedadesModel {
    public AccesoPropiedadesModel() {
    }

    public String getProperty(String fileName, 
                              String propertyName) throws Exception {
        Properties pro = null;
        String valor=null;
        try {
            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/portalPrestamos/estandar/modelo/properties/" + 
                                                                                   fileName);
            pro.load(input);

            valor = pro.getProperty(propertyName);

            pro.clear();

            input.close();

            return valor;
        } catch (IOException ex) {
            System.out.println("Error leyendo propiedad por: " + 
                               ex.getMessage());
            throw ex;
        }
    }
    
    public String getParametro(String nombreParametro) throws Exception{
        return getProperty("parametros.properties",nombreParametro);
    }
    
    public List getParametroLista(String nombreParametro, String separador) throws Exception{
        return getListProperty("parametros.properties",nombreParametro, separador);
    }
    
    public String getError(String codigoError) throws Exception{
        return getProperty("errores.properties",codigoError);
   }
   
    public String getNotificacion(String codigoNotificacion) throws Exception{
         return getProperty("notificaciones.properties",codigoNotificacion);
    }

    public List getListProperty(String fileName, String propertyName, 
                                      String propertySeparator) throws Exception {
        Properties pro = null;
        List list;
        String[] d;

        try {
            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/portalPrestamos/estandar/modelo/properties/" + 
                                                                                   fileName);
            pro.load(input);

            list = new ArrayList();
            d = pro.getProperty(propertyName).split(propertySeparator);

            for (int i = 0; i < d.length; i++){
                list.add( d[i] );
            }

            pro.clear();

            input.close();

            return list;

        } catch (IOException ex) {
            System.out.println("Error leyendo propiedad por: " + 
                               ex.getMessage());
            throw ex;
        }
    }

}