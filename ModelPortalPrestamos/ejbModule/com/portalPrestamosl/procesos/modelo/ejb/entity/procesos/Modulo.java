package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MODULOS database table.
 * 
 */
@Entity
@Table(name="MODULOS")
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MODULO")
	private int idModulo;

	@Column(name="MOD_ACTIVA")
	private int modActiva;

	@Column(name="MOD_NOMBRE")
	private String modNombre;

	//bi-directional many-to-one association to AccionesModulo
	@OneToMany(mappedBy="modulo")
	private List<AccionesModulo> accionesModulos;

	public Modulo() {
	}

	public int getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public int getModActiva() {
		return this.modActiva;
	}

	public void setModActiva(int modActiva) {
		this.modActiva = modActiva;
	}

	public String getModNombre() {
		return this.modNombre;
	}

	public void setModNombre(String modNombre) {
		this.modNombre = modNombre;
	}

	public List<AccionesModulo> getAccionesModulos() {
		return this.accionesModulos;
	}

	public void setAccionesModulos(List<AccionesModulo> accionesModulos) {
		this.accionesModulos = accionesModulos;
	}

	public AccionesModulo addAccionesModulo(AccionesModulo accionesModulo) {
		getAccionesModulos().add(accionesModulo);
		accionesModulo.setModulo(this);

		return accionesModulo;
	}

	public AccionesModulo removeAccionesModulo(AccionesModulo accionesModulo) {
		getAccionesModulos().remove(accionesModulo);
		accionesModulo.setModulo(null);

		return accionesModulo;
	}

}