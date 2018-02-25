package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the CUOTA_MORA_HIS database table.
 * 
 */
@Entity
@Table(name="CUOTA_MORA_HIS")
@NamedQuery(name="CuotaMoraHi.findAll", query="SELECT c FROM CuotaMoraHi c")
public class CuotaMoraHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CUOTA_MORA_HIS")
	private int idCuotaMoraHis;

	@Column(name="CTMH_ABONO_MORA")
	private int ctmhAbonoMora;

	@Column(name="CTMH_ESTADO")
	private String ctmhEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="CTMH_FEC_ULT_MOD")
	private Date ctmhFecUltMod;

	@Temporal(TemporalType.DATE)
	@Column(name="CTMH_FECHA_PAGO")
	private Date ctmhFechaPago;

	@Column(name="CTMH_SEC_PAGO")
	private int ctmhSecPago;

	@Column(name="CTMH_USU_ASIG")
	private int ctmhUsuAsig;

	@Column(name="ID_CUOTA_MORA")
	private int idCuotaMora;

	@Column(name="ID_DETALLE_CUOTA_HIS")
	private int idDetalleCuotaHis;

	@Column(name="ID_USUARIO")
	private int idUsuario;

	public CuotaMoraHi() {
	}

	public int getIdCuotaMoraHis() {
		return this.idCuotaMoraHis;
	}

	public void setIdCuotaMoraHis(int idCuotaMoraHis) {
		this.idCuotaMoraHis = idCuotaMoraHis;
	}

	public int getCtmhAbonoMora() {
		return this.ctmhAbonoMora;
	}

	public void setCtmhAbonoMora(int ctmhAbonoMora) {
		this.ctmhAbonoMora = ctmhAbonoMora;
	}

	public String getCtmhEstado() {
		return this.ctmhEstado;
	}

	public void setCtmhEstado(String ctmhEstado) {
		this.ctmhEstado = ctmhEstado;
	}

	public Date getCtmhFecUltMod() {
		return this.ctmhFecUltMod;
	}

	public void setCtmhFecUltMod(Date ctmhFecUltMod) {
		this.ctmhFecUltMod = ctmhFecUltMod;
	}

	public Date getCtmhFechaPago() {
		return this.ctmhFechaPago;
	}

	public void setCtmhFechaPago(Date ctmhFechaPago) {
		this.ctmhFechaPago = ctmhFechaPago;
	}

	public int getCtmhSecPago() {
		return this.ctmhSecPago;
	}

	public void setCtmhSecPago(int ctmhSecPago) {
		this.ctmhSecPago = ctmhSecPago;
	}

	public int getCtmhUsuAsig() {
		return this.ctmhUsuAsig;
	}

	public void setCtmhUsuAsig(int ctmhUsuAsig) {
		this.ctmhUsuAsig = ctmhUsuAsig;
	}

	public int getIdCuotaMora() {
		return this.idCuotaMora;
	}

	public void setIdCuotaMora(int idCuotaMora) {
		this.idCuotaMora = idCuotaMora;
	}

	public int getIdDetalleCuotaHis() {
		return this.idDetalleCuotaHis;
	}

	public void setIdDetalleCuotaHis(int idDetalleCuotaHis) {
		this.idDetalleCuotaHis = idDetalleCuotaHis;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}