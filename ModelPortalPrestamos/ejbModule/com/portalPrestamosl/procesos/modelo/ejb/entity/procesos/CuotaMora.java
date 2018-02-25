package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CUOTA_MORA database table.
 * 
 */
@Entity
@Table(name="CUOTA_MORA")
@NamedQuery(name="CuotaMora.findAll", query="SELECT c FROM CuotaMora c")
public class CuotaMora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CUOTA_MORA")
	private int idCuotaMora;

	@Column(name="CTM_ABONO_MORA")
	private int ctmAbonoMora;

	@Column(name="CTM_ESTADO")
	private String ctmEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="CTM_FECHA_PAGO")
	private Date ctmFechaPago;

	@Column(name="CTM_FECHA_REGISTRO")
	private String ctmFechaRegistro;

	@Column(name="CTM_SEC_PAGO")
	private int ctmSecPago;

	@Column(name="CTM_USU_REGISTRO")
	private int ctmUsuRegistro;

	//bi-directional many-to-one association to DetalleCuota
	@ManyToOne
	@JoinColumn(name="ID_DETALLE_CUOTA")
	private DetalleCuota detalleCuota;

	public CuotaMora() {
	}

	public int getIdCuotaMora() {
		return this.idCuotaMora;
	}

	public void setIdCuotaMora(int idCuotaMora) {
		this.idCuotaMora = idCuotaMora;
	}

	public int getCtmAbonoMora() {
		return this.ctmAbonoMora;
	}

	public void setCtmAbonoMora(int ctmAbonoMora) {
		this.ctmAbonoMora = ctmAbonoMora;
	}

	public String getCtmEstado() {
		return this.ctmEstado;
	}

	public void setCtmEstado(String ctmEstado) {
		this.ctmEstado = ctmEstado;
	}

	public Date getCtmFechaPago() {
		return this.ctmFechaPago;
	}

	public void setCtmFechaPago(Date ctmFechaPago) {
		this.ctmFechaPago = ctmFechaPago;
	}

	public String getCtmFechaRegistro() {
		return this.ctmFechaRegistro;
	}

	public void setCtmFechaRegistro(String ctmFechaRegistro) {
		this.ctmFechaRegistro = ctmFechaRegistro;
	}

	public int getCtmSecPago() {
		return this.ctmSecPago;
	}

	public void setCtmSecPago(int ctmSecPago) {
		this.ctmSecPago = ctmSecPago;
	}

	public int getCtmUsuRegistro() {
		return this.ctmUsuRegistro;
	}

	public void setCtmUsuRegistro(int ctmUsuRegistro) {
		this.ctmUsuRegistro = ctmUsuRegistro;
	}

	public DetalleCuota getDetalleCuota() {
		return this.detalleCuota;
	}

	public void setDetalleCuota(DetalleCuota detalleCuota) {
		this.detalleCuota = detalleCuota;
	}

}