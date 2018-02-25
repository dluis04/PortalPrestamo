package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SESIONES_ACTIVAS database table.
 * 
 */
@Entity
@Table(name="SESIONES_ACTIVAS")
@NamedQuery(name="SesionesActiva.findAll", query="SELECT s FROM SesionesActiva s")
public class SesionesActiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SESION")
	private int idSesion;

	@Temporal(TemporalType.DATE)
	@Column(name="SEA_FECHA_REGISTRO")
	private Date seaFechaRegistro;

	@Column(name="SEA_PASSWORD_SESION")
	private String seaPasswordSesion;

	@Temporal(TemporalType.DATE)
	@Column(name="SEA_ULTIMA_ACTIVIDAD")
	private Date seaUltimaActividad;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public SesionesActiva() {
	}

	public int getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public Date getSeaFechaRegistro() {
		return this.seaFechaRegistro;
	}

	public void setSeaFechaRegistro(Date seaFechaRegistro) {
		this.seaFechaRegistro = seaFechaRegistro;
	}

	public String getSeaPasswordSesion() {
		return this.seaPasswordSesion;
	}

	public void setSeaPasswordSesion(String seaPasswordSesion) {
		this.seaPasswordSesion = seaPasswordSesion;
	}

	public Date getSeaUltimaActividad() {
		return this.seaUltimaActividad;
	}

	public void setSeaUltimaActividad(Date seaUltimaActividad) {
		this.seaUltimaActividad = seaUltimaActividad;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}