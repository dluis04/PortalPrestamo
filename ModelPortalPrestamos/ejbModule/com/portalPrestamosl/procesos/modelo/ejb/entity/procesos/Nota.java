package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the NOTAS database table.
 * 
 */
@Entity
@Table(name="NOTAS")
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NOTA")
	private int idNota;

	@Lob
	@Column(name="NTS_DESCRIPCION")
	private byte[] ntsDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="NTS_FECHA")
	private Date ntsFecha;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="ID_PRESTAMOS")
	private Prestamo prestamo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Nota() {
	}

	public int getIdNota() {
		return this.idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public byte[] getNtsDescripcion() {
		return this.ntsDescripcion;
	}

	public void setNtsDescripcion(byte[] ntsDescripcion) {
		this.ntsDescripcion = ntsDescripcion;
	}

	public Date getNtsFecha() {
		return this.ntsFecha;
	}

	public void setNtsFecha(Date ntsFecha) {
		this.ntsFecha = ntsFecha;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}