package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DETALLE_CUOTAS_HIS database table.
 * 
 */
@Entity
@Table(name="DETALLE_CUOTAS_HIS")
@NamedQuery(name="DetalleCuotasHi.findAll", query="SELECT d FROM DetalleCuotasHi d")
public class DetalleCuotasHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DETALLE_CUOTA_HIS")
	private int idDetalleCuotaHis;

	@Column(name="DTCH_ESTADO")
	private String dtchEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="DTCH_FEC_ULT_MOD")
	private Date dtchFecUltMod;

	@Temporal(TemporalType.DATE)
	@Column(name="DTCH_FECHA_COBRO")
	private Date dtchFechaCobro;

	@Column(name="DTCH_NUM_CUOTA")
	private int dtchNumCuota;

	@Column(name="DTCH_USU_ASIG")
	private int dtchUsuAsig;

	@Column(name="DTCH_VALOR_CUOTA")
	private int dtchValorCuota;

	@Column(name="ID_PRESTAMOS_HIS")
	private int idPrestamosHis;

	public DetalleCuotasHi() {
	}

	public int getIdDetalleCuotaHis() {
		return this.idDetalleCuotaHis;
	}

	public void setIdDetalleCuotaHis(int idDetalleCuotaHis) {
		this.idDetalleCuotaHis = idDetalleCuotaHis;
	}

	public String getDtchEstado() {
		return this.dtchEstado;
	}

	public void setDtchEstado(String dtchEstado) {
		this.dtchEstado = dtchEstado;
	}

	public Date getDtchFecUltMod() {
		return this.dtchFecUltMod;
	}

	public void setDtchFecUltMod(Date dtchFecUltMod) {
		this.dtchFecUltMod = dtchFecUltMod;
	}

	public Date getDtchFechaCobro() {
		return this.dtchFechaCobro;
	}

	public void setDtchFechaCobro(Date dtchFechaCobro) {
		this.dtchFechaCobro = dtchFechaCobro;
	}

	public int getDtchNumCuota() {
		return this.dtchNumCuota;
	}

	public void setDtchNumCuota(int dtchNumCuota) {
		this.dtchNumCuota = dtchNumCuota;
	}

	public int getDtchUsuAsig() {
		return this.dtchUsuAsig;
	}

	public void setDtchUsuAsig(int dtchUsuAsig) {
		this.dtchUsuAsig = dtchUsuAsig;
	}

	public int getDtchValorCuota() {
		return this.dtchValorCuota;
	}

	public void setDtchValorCuota(int dtchValorCuota) {
		this.dtchValorCuota = dtchValorCuota;
	}

	public int getIdPrestamosHis() {
		return this.idPrestamosHis;
	}

	public void setIdPrestamosHis(int idPrestamosHis) {
		this.idPrestamosHis = idPrestamosHis;
	}

}