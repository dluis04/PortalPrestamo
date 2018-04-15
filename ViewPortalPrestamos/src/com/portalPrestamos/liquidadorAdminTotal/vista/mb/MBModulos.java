package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

@ManagedBean(name = "MBModulos")
@SessionScoped
public class MBModulos implements Serializable {

	MBMensajes mensajes;
	private Modulo vModulo;
	private Modulo vModuloModificar;
	private Modulo vSeletionModulo;
	private List<Modulo> listModulo;

	DNModulo dNModulo;

	public MBModulos() throws Exception {
		vModulo = new Modulo();
		vModuloModificar = new Modulo();
		listModulo = new ArrayList<Modulo>();
		mensajes = new MBMensajes();
		datosModulos();
	}

	public void datosModulos() throws Exception {
		inicializarDelegados();
		listModulo = dNModulo.consultarAllModulos();
		vModuloModificar = vSeletionModulo;
	}

	public void guardarModulo() throws Exception {

		inicializarDelegados();

		vModulo.setModActiva(1);

		if (dNModulo.crearModulo(vModulo) != null) {
			vModulo = null;
			vModulo = new Modulo();
			mensajes.mostrarMensaje("Registro Exitoso", 1);
			datosModulos();
		}

	}

	public void guardarModificar() throws Exception {

		inicializarDelegados();

		if (dNModulo.actualizarModulo(vModuloModificar) != null) {
			mensajes.mostrarMensaje("Modificacion Exitosa", 1);
			listModulo.remove(vSeletionModulo);
			listModulo.add(vModuloModificar);
		}

	}

	private void inicializarDelegados() throws Exception {

		if (dNModulo == null) {
			dNModulo = new DNModulo();
		}

	}

	public Modulo getvModuloModificar() {
		return vModuloModificar;
	}

	public void setvModuloModificar(Modulo vModuloModificar) {
		this.vModuloModificar = vModuloModificar;
	}

	public List<Modulo> getListModulo() {
		return listModulo;
	}

	public void setListModulo(List<Modulo> listModulo) {
		this.listModulo = listModulo;
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public Modulo getvModulo() {
		return vModulo;
	}

	public void setvModulo(Modulo vModulo) {
		this.vModulo = vModulo;
	}

	public Modulo getvSeletionModulo() {
		return vSeletionModulo;
	}

	public void setvSeletionModulo(Modulo vSeletionModulo) {
		this.vSeletionModulo = vSeletionModulo;
	}


}
