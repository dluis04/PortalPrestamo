package com.portalPrestamos.estandar.vista.utilidades;


import javax.faces.context.FacesContext;


public class ParametrosWeb {
    
    //PARAMETRIZAR SOLO DATOS QUE NECESITEN SER ACCEDIDOS POR UN COMPONENTE WEB, POR UN EJEMPLO
    //SERVLETS, PAGINAS JSF, BACKENDBEANS. LOS OTROS PARAMETROS DEFINIRLOS EN LA CLASE PARAMETROS DEL MODELO
    
    public String CONTEXTO_APP;
    public static final String LLAVE_FORMATO = "formato";
    
    public static final String FORMATO_EXCEL = "xls";
    public static final String FORMATO_PDF = "pdf";
    public static final String FORMATAPPDATE = "dd/MM/yyyy";

    //Variables para la definicion de estilos
    public String ESTILO_ICONOS = "height:25px; border:0px";
    public String ESTILO_ICONOS_MENSAJES = "height:17px; border:0px";
    public String ESTILO_ICONOS_TABLA = "height:15px; border:0px";
    
    //Parametros Generador
    public static final String ACTIVO_SI="S";
    public static final String ACTIVO_NO="N";

    //Propiedades tablelayout de los formularios
    private String cellPadding = "5";
    private String cellSpacing = "5";
    private String anchoUnaColumna = "500";
    private String alineacion = "center";
    private int TABLE_ROWS = 35;
    private int DEFAULT_COLUMNS_INPUTTEXT = 15;
    private String TABLE_WIDTH_CONSOLE = "690";
    private String TABLE_WIDTH_LOV = "400";
    private int columnasTextArea = 60;
    private int filasTextArea = 3;
    private String altoIconosReportes = "20";
    private String altoTablaSubtitulo = "10";
    private String patternNumericoDecimal = "###.##";

    //Parametro que se envia para identificar el reporte que se quiere generar
    public static final String ID_REPORT = "idreport";

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

    public void setESTILO_ICONOS(String ESTILO_ICONOS) {
        this.ESTILO_ICONOS = ESTILO_ICONOS;
    }

    public String getESTILO_ICONOS() {
        return ESTILO_ICONOS;
    }

    public void setESTILO_ICONOS_MENSAJES(String ESTILO_ICONOS_MENSAJES) {
        this.ESTILO_ICONOS_MENSAJES = ESTILO_ICONOS_MENSAJES;
    }

    public String getESTILO_ICONOS_MENSAJES() {
        return ESTILO_ICONOS_MENSAJES;
    }

    public void setESTILO_ICONOS_TABLA(String ESTILO_ICONOS_TABLA) {
        this.ESTILO_ICONOS_TABLA = ESTILO_ICONOS_TABLA;
    }

    public String getESTILO_ICONOS_TABLA() {
        return ESTILO_ICONOS_TABLA;
    }

    public void setCellPadding(String cellPadding) {
        this.cellPadding = cellPadding;
    }

    public String getCellPadding() {
        return cellPadding;
    }

    public void setCellSpacing(String cellSpacing) {
        this.cellSpacing = cellSpacing;
    }

    public String getCellSpacing() {
        return cellSpacing;
    }

    public void setAnchoUnaColumna(String anchoUnaColumna) {
        this.anchoUnaColumna = anchoUnaColumna;
    }

    public String getAnchoUnaColumna() {
        return anchoUnaColumna;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setTABLE_ROWS(int TABLE_ROWS) {
        this.TABLE_ROWS = TABLE_ROWS;
    }

    public int getTABLE_ROWS() {
        return TABLE_ROWS;
    }

    public void setDEFAULT_COLUMNS_INPUTTEXT(int DEFAULT_COLUMNS_INPUTTEXT) {
        this.DEFAULT_COLUMNS_INPUTTEXT = DEFAULT_COLUMNS_INPUTTEXT;
    }

    public int getDEFAULT_COLUMNS_INPUTTEXT() {
        return DEFAULT_COLUMNS_INPUTTEXT;
    }

    public void setTABLE_WIDTH_CONSOLE(String TABLE_WIDTH_CONSOLE) {
        this.TABLE_WIDTH_CONSOLE = TABLE_WIDTH_CONSOLE;
    }

    public String getTABLE_WIDTH_CONSOLE() {
        return TABLE_WIDTH_CONSOLE;
    }

    public void setTABLE_WIDTH_LOV(String TABLE_WIDTH_LOV) {
        this.TABLE_WIDTH_LOV = TABLE_WIDTH_LOV;
    }

    public String getTABLE_WIDTH_LOV() {
        return TABLE_WIDTH_LOV;
    }

    public void setColumnasTextArea(int columnasTextArea) {
        this.columnasTextArea = columnasTextArea;
    }

    public int getColumnasTextArea() {
        return columnasTextArea;
    }

    public void setFilasTextArea(int filasTextArea) {
        this.filasTextArea = filasTextArea;
    }

    public int getFilasTextArea() {
        return filasTextArea;
    }

    public void setAltoIconosReportes(String altoIconosReportes) {
        this.altoIconosReportes = altoIconosReportes;
    }

    public String getAltoIconosReportes() {
        return altoIconosReportes;
    }

    public void setAltoTablaSubtitulo(String altoTablaSubtitulo) {
        this.altoTablaSubtitulo = altoTablaSubtitulo;
    }

    public String getAltoTablaSubtitulo() {
        return altoTablaSubtitulo;
    }

    public void setPatternNumericoDecimal(String patternNumericoDecimal) {
        this.patternNumericoDecimal = patternNumericoDecimal;
    }

    public String getPatternNumericoDecimal() {
        return patternNumericoDecimal;
    }

	public String getActivoSi() {
		return ACTIVO_SI;
	}

	public String getActivoNo() {
		return ACTIVO_NO;
	}
}
