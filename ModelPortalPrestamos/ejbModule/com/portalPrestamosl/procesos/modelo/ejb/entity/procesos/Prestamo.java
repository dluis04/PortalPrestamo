package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PRESTAMOS database table.
 * 
 */
@Entity
@Table(name="PRESTAMOS")
@NamedQuery(name="Prestamo.findAll", query="SELECT p FROM Prestamo p")
public class Prestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRESTAMOS")
	private int idPrestamos;

	@Column(name="PRE_CREDITO")
	private int preCredito;

	@Column(name="PRE_ESTADO")
	private String preEstado;

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

	//bi-directional many-to-one association to DetalleCuota
	@OneToMany(mappedBy="prestamo")
	private List<DetalleCuota> detalleCuotas;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="prestamo")
	private List<Nota> notas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_DEUDOR")
	private Usuario usuario1;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_FIADOR")
	private Usuario usuario2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario3;

	public Prestamo() {
	}

	public int getIdPrestamos() {
		return this.idPrestamos;
	}

	public void setIdPrestamos(int idPrestamos) {
		this.idPrestamos = idPrestamos;
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

	public List<DetalleCuota> getDetalleCuotas() {
		return this.detalleCuotas;
	}

	public void setDetalleCuotas(List<DetalleCuota> detalleCuotas) {
		this.detalleCuotas = detalleCuotas;
	}

	public DetalleCuota addDetalleCuota(DetalleCuota detalleCuota) {
		getDetalleCuotas().add(detalleCuota);
		detalleCuota.setPrestamo(this);

		return detalleCuota;
	}

	public DetalleCuota removeDetalleCuota(DetalleCuota detalleCuota) {
		getDetalleCuotas().remove(detalleCuota);
		detalleCuota.setPrestamo(null);

		return detalleCuota;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setPrestamo(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setPrestamo(null);

		return nota;
	}

	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

	public Usuario getUsuario3() {
		return this.usuario3;
	}

	public void setUsuario3(Usuario usuario3) {
		this.usuario3 = usuario3;
	}

}