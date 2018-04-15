package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNAccionesModulo;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNPermisosUsuarios;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuarios;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.AccionesModulo;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.PermisosUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBPermisoUsuario")
@SessionScoped
public class MBPermisoUsuario implements Serializable {

	MBMensajes mensajes;

	private PermisosUsuario crearPermisoUsu;
	private PermisosUsuario modificarPermisoUsu;
	private PermisosUsuario selectionPermiso;
	private AccionesModulo selectionAccion;
	private Usuario selectionUsuario;

	private List<AccionesModulo> listAccionesModulo;
	private List<PermisosUsuario> listPermisoUsuario;
	private List<Usuario> listUsuarios;

	DNAccionesModulo dNAccionesModulo;
	DNUsuarios dNUsuarios;
	DNPermisosUsuarios dNPermisosUsuarios;

	public MBPermisoUsuario() throws Exception {

		crearPermisoUsu = new PermisosUsuario();
		modificarPermisoUsu = new PermisosUsuario();
		selectionPermiso = new PermisosUsuario();
		selectionAccion = new AccionesModulo();
		selectionUsuario = new Usuario();

		listAccionesModulo = new ArrayList<AccionesModulo>();
		listPermisoUsuario = new ArrayList<PermisosUsuario>();
		listUsuarios = new ArrayList<Usuario>();

		mensajes = new MBMensajes();
		consultarDatos();
	}

	public void consultarDatos() throws Exception {
		inicializarDelegados();
		listAccionesModulo = dNAccionesModulo.consultarAllAccionesModulo();
		listPermisoUsuario = dNPermisosUsuarios.consultarTodo();

		listUsuarios = dNUsuarios.consultarUsuarios();

		modificarPermisoUsu = selectionPermiso;
	}

	public void guardarPermiso(Usuario usuario) throws Exception {

		inicializarDelegados();

		if (selectionUsuario != null && selectionAccion != null) {

			Date fecha = new Date();

			Usuario temp = dNUsuarios.consultarUsuarioByUsuario(usuario);

			crearPermisoUsu.setPeuUsuAsignacion(temp.getIdUsuario());
			crearPermisoUsu.setPeuFechaAsignacion(fecha);
			crearPermisoUsu.setUsuario(selectionUsuario);
			crearPermisoUsu.setAccionesModulo(selectionAccion);

			if (dNPermisosUsuarios.crearPermisoUsuario(crearPermisoUsu) != null) {
				selectionAccion = null;
				selectionUsuario = null;
				selectionAccion = new AccionesModulo();
				selectionUsuario = new Usuario();
				listPermisoUsuario = dNPermisosUsuarios.consultarTodo();
				mensajes.mostrarMensaje("Registro Exitoso", 1);
			} else {
				mensajes.mostrarMensaje("Registro no exitoso, comunicarse con el administrador", 3);
			}
		} else {
			mensajes.mostrarMensaje("Debe seleccionar un usuario y accion", 1);
		}

	}

	public void guardarModificar() throws Exception {

		inicializarDelegados();

		if (dNPermisosUsuarios.actualizarModulo(modificarPermisoUsu) != null) {
			listPermisoUsuario.remove(selectionPermiso);
			listPermisoUsuario.add(modificarPermisoUsu);
			selectionPermiso = null;
			selectionPermiso = new PermisosUsuario();

			mensajes.mostrarMensaje("Modificacion Exitosa", 1);
		}

	}

	private void inicializarDelegados() throws Exception {

		if (dNAccionesModulo == null) {
			dNAccionesModulo = new DNAccionesModulo();
		}

		if (dNUsuarios == null) {
			dNUsuarios = new DNUsuarios();
		}

		if (dNPermisosUsuarios == null) {
			dNPermisosUsuarios = new DNPermisosUsuarios();
		}

	}

	public MBMensajes getMensajes() {
		return mensajes;
	}

	public void setMensajes(MBMensajes mensajes) {
		this.mensajes = mensajes;
	}

	public Usuario getSelectionUsuario() {
		return selectionUsuario;
	}

	public void setSelectionUsuario(Usuario selectionUsuario) {
		this.selectionUsuario = selectionUsuario;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public PermisosUsuario getCrearPermisoUsu() {
		return crearPermisoUsu;
	}

	public void setCrearPermisoUsu(PermisosUsuario crearPermisoUsu) {
		this.crearPermisoUsu = crearPermisoUsu;
	}

	public PermisosUsuario getModificarPermisoUsu() {
		return modificarPermisoUsu;
	}

	public void setModificarPermisoUsu(PermisosUsuario modificarPermisoUsu) {
		this.modificarPermisoUsu = modificarPermisoUsu;
	}

	public PermisosUsuario getSelectionPermiso() {
		return selectionPermiso;
	}

	public void setSelectionPermiso(PermisosUsuario selectionPermiso) {
		this.selectionPermiso = selectionPermiso;
	}

	public AccionesModulo getSelectionAccion() {
		return selectionAccion;
	}

	public void setSelectionAccion(AccionesModulo selectionAccion) {
		this.selectionAccion = selectionAccion;
	}

	public List<AccionesModulo> getListAccionesModulo() {
		return listAccionesModulo;
	}

	public void setListAccionesModulo(List<AccionesModulo> listAccionesModulo) {
		this.listAccionesModulo = listAccionesModulo;
	}

	public List<PermisosUsuario> getListPermisoUsuario() {
		return listPermisoUsuario;
	}

	public void setListPermisoUsuario(List<PermisosUsuario> listPermisoUsuario) {
		this.listPermisoUsuario = listPermisoUsuario;
	}

}
