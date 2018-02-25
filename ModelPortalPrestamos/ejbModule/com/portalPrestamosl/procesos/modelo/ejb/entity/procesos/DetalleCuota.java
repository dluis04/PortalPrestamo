package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DETALLE_CUOTAS database table.
 * 
 */
@Entity
@Table(name="DETALLE_CUOTAS")
@NamedQuery(name="DetalleCuota.findAll", query="SELECT d FROM DetalleCuota d")
public class DetalleCuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DETALLE_CUOTA")
	private int idDetalleCuota;

	@Column(name="DTC_ESTADO")
	private String dtcEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="DTC_FECHA_COBRO")
	private Date dtcFechaCobro;

	@Column(name="DTC_NUM_CUOTA")
	private int dtcNumCuota;

	@Column(name="DTC_VALOR_CUOTA")
	private int dtcValorCuota;

	//bi-directional many-to-one association to CuotaMora
	@OneToMany(mappedBy="detalleCuota")
	private List<CuotaMora> cuotaMoras;

	//bi-directional many-to-one association to Prestamo
	@ManyToOne
	@JoinColumn(name="ID_PRESTAMOS")
	private Prestamo prestamo;

	//bi-directional many-to-one association to Pago
	@OneToMany(mappedBy="detalleCuota")
	private List<Pago> pagos;

	public DetalleCuota() {
	}

	public int getIdDetalleCuota() {
		return this.idDetalleCuota;
	}

	public void setIdDetalleCuota(int idDetalleCuota) {
		this.idDetalleCuota = idDetalleCuota;
	}

	public String getDtcEstado() {
		return this.dtcEstado;
	}

	public void setDtcEstado(String dtcEstado) {
		this.dtcEstado = dtcEstado;
	}

	public Date getDtcFechaCobro() {
		return this.dtcFechaCobro;
	}

	public void setDtcFechaCobro(Date dtcFechaCobro) {
		this.dtcFechaCobro = dtcFechaCobro;
	}

	public int getDtcNumCuota() {
		return this.dtcNumCuota;
	}

	public void setDtcNumCuota(int dtcNumCuota) {
		this.dtcNumCuota = dtcNumCuota;
	}

	public int getDtcValorCuota() {
		return this.dtcValorCuota;
	}

	public void setDtcValorCuota(int dtcValorCuota) {
		this.dtcValorCuota = dtcValorCuota;
	}

	public List<CuotaMora> getCuotaMoras() {
		return this.cuotaMoras;
	}

	public void setCuotaMoras(List<CuotaMora> cuotaMoras) {
		this.cuotaMoras = cuotaMoras;
	}

	public CuotaMora addCuotaMora(CuotaMora cuotaMora) {
		getCuotaMoras().add(cuotaMora);
		cuotaMora.setDetalleCuota(this);

		return cuotaMora;
	}

	public CuotaMora removeCuotaMora(CuotaMora cuotaMora) {
		getCuotaMoras().remove(cuotaMora);
		cuotaMora.setDetalleCuota(null);

		return cuotaMora;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public List<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Pago addPago(Pago pago) {
		getPagos().add(pago);
		pago.setDetalleCuota(this);

		return pago;
	}

	public Pago removePago(Pago pago) {
		getPagos().remove(pago);
		pago.setDetalleCuota(null);

		return pago;
	}

}