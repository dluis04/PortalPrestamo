package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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




}