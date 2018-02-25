package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PERMISOS_USUARIOS database table.
 * 
 */
@Entity
@Table(name="PERMISOS_USUARIOS")
@NamedQuery(name="PermisosUsuario.findAll", query="SELECT p FROM PermisosUsuario p")
public class PermisosUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERMISO")
	private int idPermiso;

	@Column(name="PEU_ACTIVA")
	private int peuActiva;

	@Temporal(TemporalType.DATE)
	@Column(name="PEU_FECHA_ASIGNACION")
	private Date peuFechaAsignacion;

	@Column(name="PEU_USU_ASIGNACION")
	private int peuUsuAsignacion;

	//bi-directional many-to-one association to AccionesModulo
	@ManyToOne
	@JoinColumn(name="ID_ACCIONES")
	private AccionesModulo accionesModulo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public PermisosUsuario() {
	}

	public int getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(int idPermiso) {
		this.idPermiso = idPermiso;
	}

	public int getPeuActiva() {
		return this.peuActiva;
	}

	public void setPeuActiva(int peuActiva) {
		this.peuActiva = peuActiva;
	}

	public Date getPeuFechaAsignacion() {
		return this.peuFechaAsignacion;
	}

	public void setPeuFechaAsignacion(Date peuFechaAsignacion) {
		this.peuFechaAsignacion = peuFechaAsignacion;
	}

	public int getPeuUsuAsignacion() {
		return this.peuUsuAsignacion;
	}

	public void setPeuUsuAsignacion(int peuUsuAsignacion) {
		this.peuUsuAsignacion = peuUsuAsignacion;
	}

	public AccionesModulo getAccionesModulo() {
		return this.accionesModulo;
	}

	public void setAccionesModulo(AccionesModulo accionesModulo) {
		this.accionesModulo = accionesModulo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}