package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPOS_BLOQUEO database table.
 * 
 */
@Entity
@Table(name="TIPOS_BLOQUEO")
@NamedQuery(name="TiposBloqueo.findAll", query="SELECT t FROM TiposBloqueo t")
public class TiposBloqueo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TIPO_BLOQUEO")
	private int idTipoBloqueo;

	@Column(name="TPB_DESC_TIPO")
	private String tpbDescTipo;

	//bi-directional many-to-one association to UsuariosBloqueado
	@OneToMany(mappedBy="tiposBloqueo")
	private List<UsuariosBloqueado> usuariosBloqueados;

	public TiposBloqueo() {
	}

	public int getIdTipoBloqueo() {
		return this.idTipoBloqueo;
	}

	public void setIdTipoBloqueo(int idTipoBloqueo) {
		this.idTipoBloqueo = idTipoBloqueo;
	}

	public String getTpbDescTipo() {
		return this.tpbDescTipo;
	}

	public void setTpbDescTipo(String tpbDescTipo) {
		this.tpbDescTipo = tpbDescTipo;
	}

	public List<UsuariosBloqueado> getUsuariosBloqueados() {
		return this.usuariosBloqueados;
	}

	public void setUsuariosBloqueados(List<UsuariosBloqueado> usuariosBloqueados) {
		this.usuariosBloqueados = usuariosBloqueados;
	}

	public UsuariosBloqueado addUsuariosBloqueado(UsuariosBloqueado usuariosBloqueado) {
		getUsuariosBloqueados().add(usuariosBloqueado);
		usuariosBloqueado.setTiposBloqueo(this);

		return usuariosBloqueado;
	}

	public UsuariosBloqueado removeUsuariosBloqueado(UsuariosBloqueado usuariosBloqueado) {
		getUsuariosBloqueados().remove(usuariosBloqueado);
		usuariosBloqueado.setTiposBloqueo(null);

		return usuariosBloqueado;
	}

}