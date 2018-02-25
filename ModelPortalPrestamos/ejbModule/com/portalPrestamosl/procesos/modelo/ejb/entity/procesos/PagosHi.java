package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PAGOS_HIS database table.
 * 
 */
@Entity
@Table(name="PAGOS_HIS")
@NamedQuery(name="PagosHi.findAll", query="SELECT p FROM PagosHi p")
public class PagosHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PAGO_HIS")
	private int idPagoHis;

	@Column(name="ID_DETALLE_CUOTA_HIS")
	private int idDetalleCuotaHis;

	@Column(name="ID_PAGO")
	private int idPago;

	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="PGSH_ABONO")
	private int pgshAbono;

	@Column(name="PGSH_ESTADO")
	private String pgshEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="PGSH_FEC_ULT_MOD")
	private Date pgshFecUltMod;

	@Temporal(TemporalType.DATE)
	@Column(name="PGSH_FECHA_PAGO")
	private Date pgshFechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="PGSH_FECHA_REGISTRO")
	private Date pgshFechaRegistro;

	@Column(name="PGSH_SEC_PAGO")
	private int pgshSecPago;

	@Column(name="PGSH_USU_ASIG")
	private int pgshUsuAsig;

	public PagosHi() {
	}

	public int getIdPagoHis() {
		return this.idPagoHis;
	}

	public void setIdPagoHis(int idPagoHis) {
		this.idPagoHis = idPagoHis;
	}

	public int getIdDetalleCuotaHis() {
		return this.idDetalleCuotaHis;
	}

	public void setIdDetalleCuotaHis(int idDetalleCuotaHis) {
		this.idDetalleCuotaHis = idDetalleCuotaHis;
	}

	public int getIdPago() {
		return this.idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPgshAbono() {
		return this.pgshAbono;
	}

	public void setPgshAbono(int pgshAbono) {
		this.pgshAbono = pgshAbono;
	}

	public String getPgshEstado() {
		return this.pgshEstado;
	}

	public void setPgshEstado(String pgshEstado) {
		this.pgshEstado = pgshEstado;
	}

	public Date getPgshFecUltMod() {
		return this.pgshFecUltMod;
	}

	public void setPgshFecUltMod(Date pgshFecUltMod) {
		this.pgshFecUltMod = pgshFecUltMod;
	}

	public Date getPgshFechaPago() {
		return this.pgshFechaPago;
	}

	public void setPgshFechaPago(Date pgshFechaPago) {
		this.pgshFechaPago = pgshFechaPago;
	}

	public Date getPgshFechaRegistro() {
		return this.pgshFechaRegistro;
	}

	public void setPgshFechaRegistro(Date pgshFechaRegistro) {
		this.pgshFechaRegistro = pgshFechaRegistro;
	}

	public int getPgshSecPago() {
		return this.pgshSecPago;
	}

	public void setPgshSecPago(int pgshSecPago) {
		this.pgshSecPago = pgshSecPago;
	}

	public int getPgshUsuAsig() {
		return this.pgshUsuAsig;
	}

	public void setPgshUsuAsig(int pgshUsuAsig) {
		this.pgshUsuAsig = pgshUsuAsig;
	}

}