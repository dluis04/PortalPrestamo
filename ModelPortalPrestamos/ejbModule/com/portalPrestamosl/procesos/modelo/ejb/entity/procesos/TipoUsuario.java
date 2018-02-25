package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TIPO_USUARIO database table.
 * 
 */
@Entity
@Table(name="TIPO_USUARIO")
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_USU")
	private int idTipoUsu;

	@Column(name="TPU_TIPO_USU")
	private String tpuTipoUsu;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public TipoUsuario() {
	}

	public int getIdTipoUsu() {
		return this.idTipoUsu;
	}

	public void setIdTipoUsu(int idTipoUsu) {
		this.idTipoUsu = idTipoUsu;
	}

	public String getTpuTipoUsu() {
		return this.tpuTipoUsu;
	}

	public void setTpuTipoUsu(String tpuTipoUsu) {
		this.tpuTipoUsu = tpuTipoUsu;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}