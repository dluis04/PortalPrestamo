package com.portalPrestamos.estandar.vista.utilidades;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CargarArchivosPropiedadesUtil {
    public CargarArchivosPropiedadesUtil() {
    }

    public String getProperty(String fileName, String propertyName) throws Exception {
        Properties pro = null;
        String valor;
        try {
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
            throw ex;
        }
    }

    
    public List getListProperty(String fileName, String propertyName, 
                                      String propertySeparator) throws Exception {
        Properties pro = null;
        List<Long> list;
        String[] d;
        List<String> list2;
        try {
            pro = new Properties();
            InputStream input = 
                Thread.currentThread().getContextClassLoader().getResourceAsStream("com/portalPrestamos/estandar/vista/properties/" + 
                                                                                   fileName);
            pro.load(input);

            list = new ArrayList<Long>();
            list2 = new ArrayList<String>();
            if(propertyName.equals("users.id"))
            {
                d= pro.getProperty(propertyName).split(propertySeparator);

                           for (int i = 0; i < d.length; i++)
                               list2.add(d[i]);

                           pro.clear();

                           input.close();

                           return list2;
            }else
            {
            d = pro.getProperty(propertyName).split(propertySeparator);

            for (int i = 0; i < d.length; i++)
                list.add(Long.parseLong(d[i]));

            pro.clear();

            input.close();

            return list;
            }
            
        } catch (IOException ex) {
            System.out.println("Error leyendo propiedad por: " + 
                               ex.getMessage());
            throw ex;
        }


    }

}
