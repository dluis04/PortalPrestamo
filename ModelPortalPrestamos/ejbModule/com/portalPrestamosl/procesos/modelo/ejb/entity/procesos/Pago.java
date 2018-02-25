package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PAGOS database table.
 * 
 */
@Entity
@Table(name="PAGOS")
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PAGO")
	private int idPago;

	@Column(name="PGS_ABONO")
	private int pgsAbono;

	@Column(name="PGS_ESTADO")
	private String pgsEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="PGS_FECHA_PAGO")
	private Date pgsFechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="PGS_FECHA_REGISTRO")
	private Date pgsFechaRegistro;

	@Column(name="PGS_SEC_PAGO")
	private int pgsSecPago;

	@Column(name="PGS_USU_REGISTRO")
	private int pgsUsuRegistro;

	//bi-directional many-to-one association to DetalleCuota
	@ManyToOne
	@JoinColumn(name="ID_DETALLE_CUOTA")
	private DetalleCuota detalleCuota;

	public Pago() {
	}

	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public int getPgsAbono() {
		return this.pgsAbono;
	}

	public void setPgsAbono(int pgsAbono) {
		this.pgsAbono = pgsAbono;
	}

	public String getPgsEstado() {
		return this.pgsEstado;
	}

	public void setPgsEstado(String pgsEstado) {
		this.pgsEstado = pgsEstado;
	}

	public Date getPgsFechaPago() {
		return this.pgsFechaPago;
	}

	public void setPgsFechaPago(Date pgsFechaPago) {
		this.pgsFechaPago = pgsFechaPago;
	}

	public Date getPgsFechaRegistro() {
		return this.pgsFechaRegistro;
	}

	public void setPgsFechaRegistro(Date pgsFechaRegistro) {
		this.pgsFechaRegistro = pgsFechaRegistro;
	}

	public int getPgsSecPago() {
		return this.pgsSecPago;
	}

	public void setPgsSecPago(int pgsSecPago) {
		this.pgsSecPago = pgsSecPago;
	}

	public int getPgsUsuRegistro() {
		return this.pgsUsuRegistro;
	}

	public void setPgsUsuRegistro(int pgsUsuRegistro) {
		this.pgsUsuRegistro = pgsUsuRegistro;
	}

	public DetalleCuota getDetalleCuota() {
		return this.detalleCuota;
	}

	public void setDetalleCuota(DetalleCuota detalleCuota) {
		this.detalleCuota = detalleCuota;
	}

}