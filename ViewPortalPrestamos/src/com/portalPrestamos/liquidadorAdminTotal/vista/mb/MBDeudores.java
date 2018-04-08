package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNDeudores;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNStatusUsuario;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNTipoUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TipoUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBDeudores")
@SessionScoped
public class MBDeudores implements Serializable {

	MBMensajes mensajes = new MBMensajes();

	private Usuario usuarioCrear;
	private Usuario usuarioModificar;
	DNDeudores dnDeudores;
	DNTipoUsuario dNTipoUsuario;
	DNStatusUsuario dNStatusUsuario;
	List<Usuario> listUsuarios;
	List<Usuario> filterUsuarios;

	public MBDeudores() {
		usuarioCrear = new Usuario();
		usuarioModificar = new Usuario();
		consultarTodo();
	}

	public void consultarTodo() {
		try {
			inicializarDelegados();
			consultarTodosDeudores();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void consultarTodosDeudores() throws Exception {
		listUsuarios = dnDeudores.consultarDeudoresActivos();
	}

	public void guardarUsuario(int tipoUsuario) throws Exception {

		inicializarDelegados();

		if (!dnDeudores.consultarCedulaDeudor(usuarioCrear)) {

			StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(1);
			TipoUsuario tipoUsu = dNTipoUsuario.consultarDetalleTipoUsuarioById(tipoUsuario);

			usuarioCrear.setStatusUsuario2(status);
			usuarioCrear.setTipoUsuario2(tipoUsu);

			if (dnDeudores.crearUsuario(usuarioCrear) != null) {
				usuarioCrear = null;
				usuarioCrear = new Usuario();
				mensajes.mostrarMensaje("Registro Exitoso", 1);
			}

		} else {
			mensajes.mostrarMensaje("La cedula ya existe, favor validar", 3);
		}

	}

	public void modificarUsuario() throws Exception {

		inicializarDelegados();

		if (dnDeudores.actualizarUsuario(usuarioModificar) != null) {
			usuarioModificar = null;
			usuarioModificar = new Usuario();
			mensajes.mostrarMensaje("Modificacion Exitosa", 1);
		}
	}

	public void actualizarDatosDeudor(Usuario deudor) throws Exception {

		usuarioModificar = deudor;

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		String url2 = externalContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,
				"/view/deudores/modificarDeudor.xhtml"));
		externalContext.redirect(url2);

	}

	public void eliminarUsuario(Usuario usuario) throws Exception {

		inicializarDelegados();
		StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(3);
		usuario.setStatusUsuario2(status);

		if (dnDeudores.eliminarUsuario(usuario) != null) {
			mensajes.mostrarMensaje("Cliente eliminado", 1);
			consultarTodosDeudores();
		}

	}

	public void redireccionarRegistrarfiador() throws Exception {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		String url2 = externalContext.encodeActionURL(
				context.getApplication().getViewHandler().getActionURL(context, "/view/deudores/crearFiador.xhtml"));
		externalContext.redirect(url2);

	}

	private void inicializarDelegados() throws Exception {

		if (dnDeudores == null) {
			dnDeudores = new DNDeudores();
		}

		if (dNTipoUsuario == null) {
			dNTipoUsuario = new DNTipoUsuario();
		}

		if (dNStatusUsuario == null) {
			dNStatusUsuario = new DNStatusUsuario();
		}

	}

	public Usuario getUsuarioModificar() {
		return usuarioModificar;
	}

	public void setUsuarioModificar(Usuario usuarioModificar) {
		this.usuarioModificar = usuarioModificar;
	}

	public Usuario getUsuarioCrear() {
		return usuarioCrear;
	}

	public void setUsuarioCrear(Usuario usuarioCrear) {
		this.usuarioCrear = usuarioCrear;
	}

	public List<Usuario> getListUsuarios() {
		return listUsuarios;
	}

	public List<Usuario> getFilterUsuarios() {
		return filterUsuarios;
	}

	public void setFilterUsuarios(List<Usuario> filterUsuarios) {
		this.filterUsuarios = filterUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

}
