package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LOG_SESIONES database table.
 * 
 */
@Entity
@Table(name="LOG_SESIONES")
@NamedQuery(name="LogSesione.findAll", query="SELECT l FROM LogSesione l")
public class LogSesione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LOG_SESION")
	private int idLogSesion;

	@Temporal(TemporalType.DATE)
	@Column(name="LGS_FECHA_REGISTRO")
	private Date lgsFechaRegistro;

	@Column(name="LGS_INTENTO_FALLIDO")
	private int lgsIntentoFallido;

	@Column(name="LGS_PASSWORD")
	private String lgsPassword;

	@Column(name="LGS_STATUS_INTENTO")
	private String lgsStatusIntento;

	@Column(name="LGS_USUARIO")
	private String lgsUsuario;

	public LogSesione() {
	}

	public int getIdLogSesion() {
		return this.idLogSesion;
	}

	public void setIdLogSesion(int idLogSesion) {
		this.idLogSesion = idLogSesion;
	}

	public Date getLgsFechaRegistro() {
		return this.lgsFechaRegistro;
	}

	public void setLgsFechaRegistro(Date lgsFechaRegistro) {
		this.lgsFechaRegistro = lgsFechaRegistro;
	}

	public int getLgsIntentoFallido() {
		return this.lgsIntentoFallido;
	}

	public void setLgsIntentoFallido(int lgsIntentoFallido) {
		this.lgsIntentoFallido = lgsIntentoFallido;
	}

	public String getLgsPassword() {
		return this.lgsPassword;
	}

	public void setLgsPassword(String lgsPassword) {
		this.lgsPassword = lgsPassword;
	}

	public String getLgsStatusIntento() {
		return this.lgsStatusIntento;
	}

	public void setLgsStatusIntento(String lgsStatusIntento) {
		this.lgsStatusIntento = lgsStatusIntento;
	}

	public String getLgsUsuario() {
		return this.lgsUsuario;
	}

	public void setLgsUsuario(String lgsUsuario) {
		this.lgsUsuario = lgsUsuario;
	}

}