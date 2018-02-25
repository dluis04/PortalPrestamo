package com.portalPrestamos.estandar.vista.utilidades;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.portalPrestamos.estandar.modelo.utilidades.Parametros;
import com.portalPrestamos.estandar.modelo.utilidades.UtilidadesModel;
import com.portalPrestamos.estandar.vista.utilidades.UtilidadesWeb;


public class GenerarReportes {
//	private static final int DEFAULT_BUFFER_SIZE = 10240;
//
//	/*
//	 * Ejemplo Llamado ParametrosWeb param = (ParametrosWeb)
//	 * UtilidadesWeb.getManagedBean("Parametros"); HashMap parametros = new
//	 * HashMap(); // Asignar codigos de generacion reporte
//	 * GenerarReportes.generarReporte( FacesContext.getCurrentInstance(), "1",
//	 * ParametrosWeb.FORMATO_EXCEL, parametros, param.getCONTEXTO_APP(),
//	 * ParametrosWeb.RUTA_JASPER, ParametrosWeb.RUTA_PDF,
//	 * ParametrosWeb.RUTA_IMG);
//	 */
//	public static void generarReporteSeguimientoCobranzas(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		// Consulta solicitudes basico.
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "seguimientoPorDiaContactoCobranzas", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//
//		}
//
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//
//	}
//	
//	
//	public static void generarReporteSeguimientoFenalCobranzas(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		// Consulta solicitudes basico.
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "seguimientoPorDiaContactoFenalCobranzas", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//
//		}
//
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//
//	}
//	
//	
//	
//	public static void generarReporteSeguimientoCarteraAfiliados(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		// Consulta solicitudes basico.
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "seguimientoPorDiaContactoAfiliados", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//
//		}
//
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//
//	}
//	
//	
//	public static void generarReporteHistoricoDataCredito(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		// Consulta solicitudes basico.
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "reporte_datacredito", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//
//		}
//
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//
//	}
//	
//	
//	public static void generarReporteMemosActivosSinSaldo(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "reporteMemosActivosSinSaldoUnoEE", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//		}
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//	}
//	
//	public static void generarReporteMemosInactivosConSaldo(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "reporteMemosInactivosConSaldoUnoEE", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//		}
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//	}
//	
//	
//	
//	
//
//	
//	
//	
//	
//	
//	
//	
//	public static void generarReportePagosVsSeguimiento(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		// Consulta solicitudes basico.
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "reporte_PagosVsSeguimiento", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//
//		}
//
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//
//	}
//	
//	
//	
//	public static void generarReporteSeguimientoUsuarios(FacesContext facesContext, String idReporte, String formato, HashMap parametrosM,
//			String rutaApp, String rutaJasper, String rutaReportes, String rutaImg) throws Exception {
//		String nombreArchivo = "";
//		// Consulta solicitudes basico.
//		if (idReporte.equals("1")) {
//			nombreArchivo = generarReporte(parametrosM, "reporte_SeguimientoUsuarios", null,
//					String.valueOf(Parametros.JNDI_CONEXION), formato, null, rutaApp, rutaJasper, rutaReportes,
//					rutaImg);
//
//		}
//
//		generarRespuesta(facesContext, rutaApp + rutaReportes, nombreArchivo, formato);
//
//	}
//	
//	
//	
//	
//	
//	
//
//	private static void generarRespuesta(FacesContext facesContext, String rutaReporte, String nombreArchivo,
//			String formato) throws Exception {
//
//		File file = null;
//
//		BufferedInputStream input = null;
//		BufferedOutputStream output = null;
//		ExternalContext externalContext = facesContext.getExternalContext();
//
//		try {
//
//			file = new File(rutaReporte, nombreArchivo);
//			// Open file.
//			input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
//
//			// Init servlet response.
//			externalContext.responseReset();
//			externalContext.setResponseContentType("application/" + formato);
//			externalContext.setResponseContentLength((int) file.length());
//			externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivo + "\"");
//			output = new BufferedOutputStream(externalContext.getResponseOutputStream(), DEFAULT_BUFFER_SIZE);
//
//			// Write file contents to response.
//			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
//			int length;
//			while ((length = input.read(buffer)) > 0) {
//				output.write(buffer, 0, length);
//			}
//		} finally {
//			// Gently close streams.
//			try {
//				if (output != null) {
//					output.close();
//				}
//				if (input != null) {
//					input.close();
//				}
//				if (file != null) {
//					file.delete();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		facesContext.responseComplete();
//	}

	// TODO IMPLEMENTAR FUNCIONALIDAD CUANDO SE REQUIERA
	/*
	 * public void abrirArchivo(String nFile, String ruta, String formato) {
	 * File destFile = null; FileInputStream archivo = null; BufferedInputStream
	 * buf = null;
	 * 
	 * try { destFile = new File(ruta + "" + nFile + "." + formato);
	 * 
	 * HttpServletResponse Response =
	 * (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext
	 * ().getResponse(); ServletOutputStream ouputStream =
	 * Response.getOutputStream();
	 * 
	 * 
	 * Response.setContentType("application/" + formato);
	 * Response.setHeader("Content-Disposition", "attachment;filename = " +
	 * nFile + "." + formato); //Response.setContentLength((int)
	 * destFile.length()); //Response.setBufferSize(1024);
	 * 
	 * archivo = new FileInputStream(destFile); buf = new
	 * BufferedInputStream(archivo); int readBytes = 0;
	 * 
	 * while ((readBytes = buf.read()) != -1) { ouputStream.write(readBytes); }
	 * 
	 * ouputStream.flush(); ouputStream.close(); buf.close(); } catch
	 * (FileNotFoundException e) { // TODO e.printStackTrace(); } catch
	 * (IOException e) { // TODO e.printStackTrace(); } }
	 */
//
//	private static String generarReporte(HashMap param, String report, String[] subReport, String strcon,
//			String formato, String otraConexion, String rutaApp, String rutaJasper, String rutaReport, String rutaImg)
//			throws Exception {
//		Connection con = null;
//		Connection connection = null;
//		String nombreArchivo = null;
//		String descargarReporte = null;
//		HttpSession session = null;
//		String rutaReportes = null;
//		String rutaPdf = null;
//		String rutaImages = null;
//		String imagenEnc = null;
//		String imagenPie = null;
//		String imagenlogo = null;
//		HashMap parametrosM;
//		Iterator it = null;
//		JasperReport reporteMaestro = null;
//		JasperPrint jasperPrint = null;
//		String archivoPdf = null;
//		String archivoXls = null;
//		OutputStream ouputStream = null;
//		ByteArrayOutputStream byteArrayOutputStream = null;
//		JRXlsExporter exporterXLS = null;
//		JRPdfExporter jrPdfExporter = null;
//		JasperReport subReportes[] = null;
//
//		try {
//			rutaReportes = rutaApp + rutaJasper;
//			rutaPdf = rutaApp + rutaReport;
//			rutaImages = rutaApp + rutaImg;
//
//			parametrosM = new HashMap();
//			parametrosM.put("SUBREPORT_DIR", rutaReportes);
//
//			// Parametros de Imagenes Usadas Por los Reportes
//			parametrosM.put("IMAGEN_DIR", rutaImages);
//
//			// Parametros Especificos de cada Reporte
//			it = param.entrySet().iterator();
//			while (it.hasNext()) {
//				Map.Entry e = (Map.Entry) it.next();
//				parametrosM.put(e.getKey(), e.getValue());
//			}
//
//			// se obtiene la conexion a la DB
//			con = UtilidadesModel.DatabaseUtils.getConnection(strcon);
//
//			// Se valida si biene un segundo jndi para otra conexion.
//			if (otraConexion != null && otraConexion != null && !otraConexion.equals(null)
//					&& otraConexion.length() > 0) {
//				connection = UtilidadesModel.DatabaseUtils.getConnection(otraConexion);
//				parametrosM.put("OTRACONEXION", connection);
//			}
//
//			// Referencia al reporte a cargar
//			reporteMaestro = null;
//
//			// Se carga el reporte
//			reporteMaestro = (JasperReport) JRLoader.loadObject(rutaReportes + report + ".jasper");
//
//			// Se cargan los subreportes si existen.
//			if (subReport != null && subReport.length > 0) {
//				subReportes = new JasperReport[subReport.length];
//
//				for (int indice = 0; indice < subReportes.length; indice++) {
//					subReportes[indice] = (JasperReport) JRLoader
//							.loadObject(rutaReportes + subReport[indice] + ".jasper");
//				}
//			}
//
//			// se ejecuta el reporte
//			jasperPrint = JasperFillManager.fillReport(reporteMaestro, parametrosM, con);
//			nombreArchivo = report + "_" + new Date().getTime();
//			archivoPdf = nombreArchivo + ".pdf";
//			archivoXls = nombreArchivo + ".xls";
//			descargarReporte = rutaPdf + archivoPdf;
//
//			// se exporta el reporte
//			if (formato.equals(ParametrosWeb.FORMATO_PDF)) {
//				ouputStream = new FileOutputStream(new File(rutaPdf + archivoPdf));
//				byteArrayOutputStream = new ByteArrayOutputStream();
//
//				jrPdfExporter = new JRPdfExporter();
//				jrPdfExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//				jrPdfExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
//
//				// Quita los bordes que se hayan creado con el jasper
//
//				jrPdfExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
//						Boolean.valueOf(true));
//				jrPdfExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
//						Boolean.valueOf(true));
//				jrPdfExporter.exportReport();
//				ouputStream.write(byteArrayOutputStream.toByteArray());
//				ouputStream.flush();
//				ouputStream.close();
//
//				// JasperExportManager.exportReportToPdfFile(jasperPrint,
//				// descargarReporte);
//			} else if (formato.equals(ParametrosWeb.FORMATO_EXCEL)) {
//				ouputStream = new FileOutputStream(new File(rutaPdf + archivoXls));
//				byteArrayOutputStream = new ByteArrayOutputStream();
//
//				exporterXLS = new JRXlsExporter();
//				exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//				exporterXLS.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
//				exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.valueOf(true));
//
//				// Quita los bordes que se hayan creado con el jasper
//				exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.valueOf(true));
//
//				exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
//						Boolean.valueOf(true));
//				exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
//						Boolean.valueOf(true));
//				exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
//				exporterXLS.exportReport();
//				ouputStream.write(byteArrayOutputStream.toByteArray());
//				ouputStream.flush();
//				ouputStream.close();
//			}
//
//			// Liberando espacio de memoria en reportes
//			nombreArchivo = null;
//			descargarReporte = null;
//			session = null;
//			rutaReportes = null;
//			rutaPdf = null;
//			rutaImages = null;
//			imagenEnc = null;
//			imagenPie = null;
//			imagenlogo = null;
//			parametrosM = null;
//			it = null;
//			reporteMaestro = null;
//			jasperPrint = null;
//			// archivoPdf = null;
//			// archivoXls = null;
//			ouputStream = null;
//			byteArrayOutputStream = null;
//			exporterXLS = null;
//			subReportes = null;
//			subReport = null;
//
//			if (formato.equals(ParametrosWeb.FORMATO_PDF)) {
//				return archivoPdf;
//			} else if (formato.equals(ParametrosWeb.FORMATO_EXCEL)) {
//				return archivoXls;
//			}
//
//		} finally {
//			// se cierra la conexion a la DB
//			try {
//				if (con != null) {
//					con.close();
//				}
//
//				if (connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				System.out.println("***ERROR CERRANDO CONEXION GenerarReporte");
//				e.printStackTrace();
//			}
//		}
//
//		return null;
//	}
}
