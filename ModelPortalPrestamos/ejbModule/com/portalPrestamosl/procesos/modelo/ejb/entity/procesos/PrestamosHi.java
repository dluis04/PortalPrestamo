package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the PRESTAMOS_HIS database table.
 * 
 */
@Entity
@Table(name="PRESTAMOS_HIS")
@NamedQuery(name="PrestamosHi.findAll", query="SELECT p FROM PrestamosHi p")
public class PrestamosHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRESTAMOS_HIS")
	private int idPrestamosHis;

	@Column(name="ID_DEUDOR")
	private int idDeudor;

	@Column(name="ID_FIADOR")
	private int idFiador;

	@Column(name="ID_PRESTAMO")
	private int idPrestamo;

	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="PRE_CREDITO")
	private int preCredito;

	@Column(name="PRE_ESTADO")
	private String preEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="PRE_FEC_ULT_MOD")
	private Date preFecUltMod;

	@Temporal(TemporalType.DATE)
	@Column(name="PRE_FECHA_DESEMBOLSO")
	private Date preFechaDesembolso;

	@Temporal(TemporalType.DATE)
	@Column(name="PRE_FECHA_REGISTRO")
	private Date preFechaRegistro;

	@Column(name="PRE_FORMA_PAGO")
	private String preFormaPago;

	@Column(name="PRE_INTERES")
	private double preInteres;

	@Column(name="PRE_NUM_CUOTAS")
	private int preNumCuotas;

	@Column(name="PRE_TOTAL_PRESTA")
	private int preTotalPresta;

	@Column(name="PRE_VALOR_CUOTA")
	private int preValorCuota;

	public PrestamosHi() {
	}

	public int getIdPrestamosHis() {
		return this.idPrestamosHis;
	}

	public void setIdPrestamosHis(int idPrestamosHis) {
		this.idPrestamosHis = idPrestamosHis;
	}

	public int getIdDeudor() {
		return this.idDeudor;
	}

	public void setIdDeudor(int idDeudor) {
		this.idDeudor = idDeudor;
	}

	public int getIdFiador() {
		return this.idFiador;
	}

	public void setIdFiador(int idFiador) {
		this.idFiador = idFiador;
	}

	public int getIdPrestamo() {
		return this.idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getPreCredito() {
		return this.preCredito;
	}

	public void setPreCredito(int preCredito) {
		this.preCredito = preCredito;
	}

	public String getPreEstado() {
		return this.preEstado;
	}

	public void setPreEstado(String preEstado) {
		this.preEstado = preEstado;
	}

	public Date getPreFecUltMod() {
		return this.preFecUltMod;
	}

	public void setPreFecUltMod(Date preFecUltMod) {
		this.preFecUltMod = preFecUltMod;
	}

	public Date getPreFechaDesembolso() {
		return this.preFechaDesembolso;
	}

	public void setPreFechaDesembolso(Date preFechaDesembolso) {
		this.preFechaDesembolso = preFechaDesembolso;
	}

	public Date getPreFechaRegistro() {
		return this.preFechaRegistro;
	}

	public void setPreFechaRegistro(Date preFechaRegistro) {
		this.preFechaRegistro = preFechaRegistro;
	}

	public String getPreFormaPago() {
		return this.preFormaPago;
	}

	public void setPreFormaPago(String preFormaPago) {
		this.preFormaPago = preFormaPago;
	}

	public double getPreInteres() {
		return this.preInteres;
	}

	public void setPreInteres(double preInteres) {
		this.preInteres = preInteres;
	}

	public int getPreNumCuotas() {
		return this.preNumCuotas;
	}

	public void setPreNumCuotas(int preNumCuotas) {
		this.preNumCuotas = preNumCuotas;
	}

	public int getPreTotalPresta() {
		return this.preTotalPresta;
	}

	public void setPreTotalPresta(int preTotalPresta) {
		this.preTotalPresta = preTotalPresta;
	}

	public int getPreValorCuota() {
		return this.preValorCuota;
	}

	public void setPreValorCuota(int preValorCuota) {
		this.preValorCuota = preValorCuota;
	}

}