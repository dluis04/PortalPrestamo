package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNAccionesModulo;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.AccionesModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Modulo;

@ManagedBean(name = "MBAccionesModu")
@SessionScoped
public class MBAccionesModu implements Serializable {

	MBMensajes mensajes;
	private AccionesModulo accionesModulo;
	private AccionesModulo vModuloModificar;
	private AccionesModulo vSeletionModulo;
	private Modulo vSelectionMod;
	private List<AccionesModulo> listModulo;
	private List<Modulo> listAllModulos;
	DNModulo dNModulo;

	DNAccionesModulo dNAccionesModulo;

	public MBAccionesModu() throws Exception {
		accionesModulo = new AccionesModulo();
		vSeletionModulo = new AccionesModulo();
		vModuloModificar = new AccionesModulo();
		listModulo = new ArrayList<AccionesModulo>();
		listAllModulos = new ArrayList<Modulo>();
		mensajes = new MBMensajes();
		datosModulos();
	}

	public void datosModulos() throws Exception {
		inicializarDelegados();
		listModulo = dNAccionesModulo.consultarAllAccionesModulo();
		listAllModulos = dNModulo.consultarAllModulosActivos();
		vModuloModificar = vSeletionModulo;
	}

	public void guardarModulo() throws Exception {

		inicializarDelegados();

		accionesModulo.setAcmActiva(1);

		if (vSelectionMod != null) {

			accionesModulo.setModulo(vSelectionMod);

			if (dNAccionesModulo.crearAccionesModulo(accionesModulo) != null) {
				accionesModulo = null;
				vSelectionMod = null;
				vSelectionMod = new Modulo();
				accionesModulo = new AccionesModulo();
				mensajes.mostrarMensaje("Registro Exitoso", 1);
				datosModulos();
			}
		} else {
			mensajes.mostrarMensaje("Debe seleccionar un modulo", 1);
		}

	}

	public void guardarModificar() throws Exception {

		inicializarDelegados();

		if (dNAccionesModulo.actualizarModulo(vModuloModificar) != null) {
			mensajes.mostrarMensaje("Modificacion Exitosa", 1);
			listModulo.remove(vSeletionModulo);
			listModulo.add(vModuloModificar);
			vModuloModificar = null;
			vModuloModificar = new AccionesModulo();
			vSeletionModulo = null;
			vSeletionModulo = new AccionesModulo();
		}

	}

	private void inicializarDelegados() throws Exception {
		if (dNAccionesModulo == null) {
			dNAccionesModulo = new DNAccionesModulo();
		}

		if (dNModulo == null) {
			dNModulo = new DNModulo();
		}
	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public AccionesModulo getAccionesModulo() {
		return accionesModulo;
	}

	public void setAccionesModulo(AccionesModulo accionesModulo) {
		this.accionesModulo = accionesModulo;
	}

	public AccionesModulo getvModuloModificar() {
		return vModuloModificar;
	}

	public void setvModuloModificar(AccionesModulo vModuloModificar) {
		this.vModuloModificar = vModuloModificar;
	}

	public AccionesModulo getvSeletionModulo() {
		return vSeletionModulo;
	}

	public void setvSeletionModulo(AccionesModulo vSeletionModulo) {
		this.vSeletionModulo = vSeletionModulo;
	}

	public List<AccionesModulo> getListModulo() {
		return listModulo;
	}

	public void setListModulo(List<AccionesModulo> listModulo) {
		this.listModulo = listModulo;
	}

	public List<Modulo> getListAllModulos() {
		return listAllModulos;
	}

	public void setListAllModulos(List<Modulo> listAllModulos) {
		this.listAllModulos = listAllModulos;
	}

	public Modulo getvSelectionMod() {
		return vSelectionMod;
	}

	public void setvSelectionMod(Modulo vSelectionMod) {
		this.vSelectionMod = vSelectionMod;
	}

}
