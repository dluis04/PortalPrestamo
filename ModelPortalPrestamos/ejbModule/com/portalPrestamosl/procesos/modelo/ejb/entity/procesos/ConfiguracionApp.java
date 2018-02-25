package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CONFIGURACION_APP database table.
 * 
 */
@Entity
@Table(name="CONFIGURACION_APP")
@NamedQuery(name="ConfiguracionApp.findAll", query="SELECT c FROM ConfiguracionApp c")
public class ConfiguracionApp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CONFIGURACION")
	private int idConfiguracion;

	@Column(name="CONF_DESCRIPCION")
	private String confDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="CONF_FECHA_REGIS")
	private Date confFechaRegis;

	@Column(name="CONF_NOMBRE")
	private String confNombre;

	@Column(name="CONF_TIPO_VALOR")
	private String confTipoValor;

	@Column(name="CONF_VALOR")
	private int confValor;

	public ConfiguracionApp() {
	}

	public int getIdConfiguracion() {
		return this.idConfiguracion;
	}

	public void setIdConfiguracion(int idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public String getConfDescripcion() {
		return this.confDescripcion;
	}

	public void setConfDescripcion(String confDescripcion) {
		this.confDescripcion = confDescripcion;
	}

	public Date getConfFechaRegis() {
		return this.confFechaRegis;
	}

	public void setConfFechaRegis(Date confFechaRegis) {
		this.confFechaRegis = confFechaRegis;
	}

	public String getConfNombre() {
		return this.confNombre;
	}

	public void setConfNombre(String confNombre) {
		this.confNombre = confNombre;
	}

	public String getConfTipoValor() {
		return this.confTipoValor;
	}

	public void setConfTipoValor(String confTipoValor) {
		this.confTipoValor = confTipoValor;
	}

	public int getConfValor() {
		return this.confValor;
	}

	public void setConfValor(int confValor) {
		this.confValor = confValor;
	}

}