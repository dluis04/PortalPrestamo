package com.portalPrestamos.procesos.modelo.ejb.session;

import java.util.List;

import javax.ejb.Local;

import com.portalPrestamos.estandar.modelo.excepciones.BaseException;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.ConfiguracionApp;

@Local
public interface SBConfiguracionAppLocal {

	public int consultaConfiguracionIntentosInicioSesion(int idConfiguracion) throws BaseException;

	public List<ConfiguracionApp> consultarAllConfiguracionApp() throws BaseException;

	public ConfiguracionApp modificarParametrizacion(ConfiguracionApp configuracion) throws BaseException;

}
