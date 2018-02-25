package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCIONES_MODULOS database table.
 * 
 */
@Entity
@Table(name="ACCIONES_MODULOS")
@NamedQuery(name="AccionesModulo.findAll", query="SELECT a FROM AccionesModulo a")
public class AccionesModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ACCIONES")
	private int idAcciones;

	@Column(name="ACM_ACTIVA")
	private int acmActiva;

	@Column(name="ACM_NOMBRE")
	private String acmNombre;

	//bi-directional many-to-one association to Modulo
	@ManyToOne
	@JoinColumn(name="ID_MODULO")
	private Modulo modulo;

	//bi-directional many-to-one association to PermisosUsuario
	@OneToMany(mappedBy="accionesModulo")
	private List<PermisosUsuario> permisosUsuarios;

	public AccionesModulo() {
	}

	public int getIdAcciones() {
		return this.idAcciones;
	}

	public void setIdAcciones(int idAcciones) {
		this.idAcciones = idAcciones;
	}

	public int getAcmActiva() {
		return this.acmActiva;
	}

	public void setAcmActiva(int acmActiva) {
		this.acmActiva = acmActiva;
	}

	public String getAcmNombre() {
		return this.acmNombre;
	}

	public void setAcmNombre(String acmNombre) {
		this.acmNombre = acmNombre;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<PermisosUsuario> getPermisosUsuarios() {
		return this.permisosUsuarios;
	}

	public void setPermisosUsuarios(List<PermisosUsuario> permisosUsuarios) {
		this.permisosUsuarios = permisosUsuarios;
	}

	public PermisosUsuario addPermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().add(permisosUsuario);
		permisosUsuario.setAccionesModulo(this);

		return permisosUsuario;
	}

	public PermisosUsuario removePermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().remove(permisosUsuario);
		permisosUsuario.setAccionesModulo(null);

		return permisosUsuario;
	}

}