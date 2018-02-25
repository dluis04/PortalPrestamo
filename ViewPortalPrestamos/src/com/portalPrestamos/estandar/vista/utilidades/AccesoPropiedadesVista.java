
package com.portalPrestamos.estandar.vista.utilidades;

import java.io.IOException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;




public class AccesoPropiedadesVista {
    public AccesoPropiedadesVista() {
    }
    
    public String getParametro(String nombreParametro) throws Exception{
        return getProperty("parametros.properties",nombreParametro);
    }
    
    public List getParametroLista(String nombreParametro, String separador) throws Exception{
        return getListProperty("parametros.properties",nombreParametro, separador);
    }
    
    public String getMensaje(String codigoMensaje) throws Exception{
        return getProperty("mensajes.properties",codigoMensaje);
    }
    
    public String getError(String codigoMensaje) throws Exception{
        return getProperty("errores.properties",codigoMensaje);
    }
    
    public String getLabel(String codigoMensaje) throws Exception{
        return getProperty("label.properties",codigoMensaje);
    }

    private String getProperty(String fileName, String propertyName) throws Exception {
        Properties pro = null;
        String valor;
        try {
            //Si el archivo es el de parametros y estamos en ambiente local cambiamos el nombre al archivo
            if (fileName.equals("parametros.properties") && 
                !Parametros.AMBIENTE_SERVIDOR) {
                fileName = "parametros_local.properties";
            }

            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/portalPrestamos/estandar/vista/properties/" + fileName);
            pro.load(input);
            valor = pro.getProperty(propertyName);
            pro.clear();
            input.close();

            return valor;
            //return pro.getProperty(propertyName);
        } catch (IOException ex) {
            System.out.println("Error leyendo propiedad por: " + ex.getMessage());
            throw new Exception("Error leyendo propiedad por: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error leyendo propiedad por: " + ex.getMessage());
            throw new Exception("Error leyendo propiedad por: " + ex.getMessage());
        }
    }

    public List getListProperty(String fileName, String propertyName, 
                                String propertySeparator) throws Exception {
        Properties pro = null;
        List list;
        String[] d;

        try {
            //Si el archivo es el de parametros y estamos en ambiente local cambiamos el nombre al archivo
            if (fileName.equals("parametros.properties") && 
                !Parametros.AMBIENTE_SERVIDOR) {
                fileName = "parametros_local.properties";
            }

            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/portalPrestamos/estandar/vista/properties/" + 
                                                                                   fileName);
            pro.load(input);

            list = new ArrayList();
            d = pro.getProperty(propertyName).split(propertySeparator);

            for (int i = 0; i < d.length; i++)
                list.add(d[i]);

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
