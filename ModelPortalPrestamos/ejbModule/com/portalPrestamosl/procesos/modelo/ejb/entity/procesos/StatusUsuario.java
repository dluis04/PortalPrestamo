package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STATUS_USUARIO database table.
 * 
 */
@Entity
@Table(name="STATUS_USUARIO")
@NamedQuery(name="StatusUsuario.findAll", query="SELECT s FROM StatusUsuario s")
public class StatusUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_STATUS_USU")
	private int idStatusUsu;

	@Column(name="STU_DESC_STATUS")
	private String stuDescStatus;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public StatusUsuario() {
	}

	public int getIdStatusUsu() {
		return this.idStatusUsu;
	}

	public void setIdStatusUsu(int idStatusUsu) {
		this.idStatusUsu = idStatusUsu;
	}

	public String getStuDescStatus() {
		return this.stuDescStatus;
	}

	public void setStuDescStatus(String stuDescStatus) {
		this.stuDescStatus = stuDescStatus;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}