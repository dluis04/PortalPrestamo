package com.portalPrestamos.estandar.modelo.utilidades;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class UtilidadesModel {
    
	public static class DatabaseUtils {
		public static Connection getConnection(String jndiName)
				throws Exception {
			InitialContext ic = new InitialContext();
			DataSource dataSource;
			dataSource = (DataSource) ic.lookup(jndiName);
			return dataSource.getConnection();
		}
	}
	
	public static String delChar(String cadena){
        int index    = -1;
        char car;
        do{
            index++;
            car = cadena.charAt(index);
        }
        while( index < cadena.length()-1 && car == 48 );
        
        return cadena.substring(index,cadena.length());
    }
    
    //Elimina campos cero de la izquierda de la cadena
    public static String padLeft(String s, int n) {
        return String.format("%1$#" + n + "s", s);
    }
    
    //Elimina campos cero de la izquierda de la cadena        
    public static String padLeftZero(Long d, int n){
        //Formato: %Caracter a remplazar-Numero de digitos-digito
        String f = "%0"+n+"d";
        return  String.format(f, d);
        
    }
    
    //Validación campo es digito
    public static boolean isDigit(String str) throws Exception{
        if (str == null || str.length() == 0)
         return false;
                
        for (int i = 0; i < str.length(); i++) {

            //If we find a non-digit character we return false.
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    //Validación campo es alfabetico
    public static boolean isApha(String str) throws Exception{
        boolean val = true;
        List charsInvalidate = null;
        AccesoPropiedadesModel propiedades = null;
        if(str==null)
        return false;
    
        charsInvalidate = new ArrayList();
        propiedades     = new AccesoPropiedadesModel();
        charsInvalidate = propiedades.getListProperty("parametros.properties","CHAR_UNSOPORT_DB",",");

        for(int i=0; i<charsInvalidate.size(); i++){
            if( str.indexOf(charsInvalidate.get(i).toString())!=-1 ){
                val = false;
                break;
            }
        }
        return val;
    }
    
    public static boolean isDateOrHour(String str) throws Exception {
        String [] hour;
        str = str.trim();
        
        if(str.length()<8)
            return false;
        
        if (str != null && str.indexOf(":")!=-1 ){
            hour = str.split(":");
            
            if(hour.length!=3)
                return false;
            else
            if(hour[0].length()!=2 && hour[1].length()!=2 && hour[2].length()!=2)
                return false;
        }

        return true;
    }
    
    //Definicion: Extrea una etiqueta con parametros del archivo properties del modelo
    public static String getErrorCode(String label, List parametros) throws Exception {
        
        int param = 0;
        AccesoPropiedadesModel msm = new AccesoPropiedadesModel();
        label = msm.getParametro(label);
        label = label.trim();
        
        if(parametros!=null && parametros.size()>0){
            while(label.indexOf("&")!=-1){
                label = label.replaceFirst("&",parametros.get(param).toString());
                param++;
            }
        }

        msm = null;
        return label;
    }
    
    public static Connection getConnection(String jndiName) throws Exception {
        InitialContext ic = new InitialContext();
        DataSource dataSource; 
        dataSource = (DataSource)ic.lookup(jndiName);
        return dataSource.getConnection();
    }
    
    public static Date getFechaActualHoraCero(){
        Calendar hoy= Calendar.getInstance();
        hoy.set(Calendar.HOUR_OF_DAY,0);
        hoy.set(Calendar.MINUTE,0);
        hoy.set(Calendar.SECOND,0);
        hoy.set(Calendar.MILLISECOND,0);
        return hoy.getTime();
    }
    
    public static Date getFechaDiaHoraCero(int dia){
        Calendar hoy= Calendar.getInstance();
        hoy.set(Calendar.HOUR_OF_DAY,0);
        hoy.set(Calendar.MINUTE,0);
        hoy.set(Calendar.SECOND,0);
        hoy.set(Calendar.MILLISECOND,0);
        hoy.set(Calendar.DAY_OF_MONTH,dia);
        return hoy.getTime();
    }
    
    /**
     * Metodo encargado de buscar un archivo en un directorio.
     * @param nombreArchivoBuscar
     * @param rutaDirectorio
     * @return
     * @throws Exception
     */
    public static boolean buscarArchivo(String nombreArchivoBuscar, String rutaDirectorio) throws Exception {
        boolean existe = false;
        if (nombreArchivoBuscar != null && !nombreArchivoBuscar.equals(null) && !nombreArchivoBuscar.equals("") &&
            rutaDirectorio != null && !rutaDirectorio.equals(null) && !rutaDirectorio.equals("")) {
            File directorio = new File(rutaDirectorio);

            // Se valida que se un un directorio.
            if (directorio.isDirectory()) {
                // Se recorren los archivos.
                File listaFile[] = directorio.listFiles();
                if (listaFile != null && listaFile.length > 0) {
                    for (File file : listaFile) {
                        if (file.getName().toLowerCase().trim().equals(nombreArchivoBuscar.toLowerCase())) {
                            existe = true;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("NO ES UN DIRECTORIO VALIDO: " + rutaDirectorio);
            }
        }
        return existe;
    }
    
    /**
     * Metodo encargado de obtner la extension del nombre de un arhcivo.
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String obtenerExtension(String fileName) throws Exception {
        String extension = null;

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        return extension;
    }
    
    /**
     * Metodo encargado de obtner el nombre del archivo sin extension.
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String obtenerNombreSinExtension(String fileName) throws Exception {
        String nombre = null;

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            nombre = fileName.substring(0, i);
        }

        return nombre;
    }
    

    /**
     * Metodo encargado de eliminar un archivo.
     * @param file
     * @throws Exception
     */
    public static boolean eliminarArchivo(String file) throws Exception {
        if (file != null && !file.equals(null) && !file.equals("")) {
            File deleteFile = new File(file);
            if (deleteFile != null && deleteFile.isFile()) {
                return deleteFile.delete();
            }
        }
        return false;
    }
    
    /**
     * Metodo encargado de validar si existe un archivo.
     * @param archivo
     * @return
     * @throws Exception
     */
    public static boolean existeArchivo(String archivo) throws Exception {
        File file = new File(archivo);
        return (file != null && file.isFile());
    }

    /**
     * Metodo encargado de crear un archivo.
     * @param ruta
     * @param contenido
     * @throws Exception
     */
    public static void crearArchivo(String ruta, String contenido) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter(ruta));
        out.write(contenido);
        out.close();
    }


}