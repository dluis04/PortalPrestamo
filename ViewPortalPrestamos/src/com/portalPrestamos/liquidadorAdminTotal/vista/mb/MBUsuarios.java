package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNStatusUsuario;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNTipoUsuario;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuarios;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.StatusUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.TipoUsuario;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBUsuarios")
@SessionScoped
public class MBUsuarios implements Serializable {

	MBMensajes mensajes = new MBMensajes();
	private Usuario vUsuario;
	private Usuario usuarioCrear;
	private Usuario usuarioModificar;
	private String confirmacionPassword;
	private int tipoUsuario1;
	private int tipoUsuario;
	DNUsuarios dnUsuarios;
	DNTipoUsuario dNTipoUsuario;
	DNStatusUsuario dNStatusUsuario;
	List<TipoUsuario> listTipoUsuario;
	List<SelectItem> listTiposUsuario;
	List<Usuario> listUsuarios;
	List<Usuario> filterUsuarios;
	boolean isTipoUsuarioHabilitado;

	public MBUsuarios() {
		vUsuario = new Usuario();
		usuarioCrear = new Usuario();
		usuarioModificar = new Usuario();
		consultarTodo();
		isTipoUsuarioHabilitado=false;
	}

	public void consultarTodo() {
		try {
			inicializarDelegados();

			listTiposUsuario = new ArrayList<>();
			listTipoUsuario = dNTipoUsuario.consultarTodosTipoUsuario();

			int cont = 1;
			for (TipoUsuario list : listTipoUsuario) {

				if (cont != 1) {
					listTiposUsuario.add(new SelectItem(list.getIdTipoUsu(), list.getTpuTipoUsu()));
				}
				cont++;
			}

			consultarTodosUsuarios();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void consultarTodosUsuarios() throws Exception {
		listUsuarios = dnUsuarios.consultarUsuarios();
	}

	public void guardarUsuario() throws Exception {

		inicializarDelegados();

		if (usuarioCrear.getUsuPassword().equals(confirmacionPassword)) {
			StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(1);
			TipoUsuario tipoUsu = dNTipoUsuario.consultarDetalleTipoUsuarioById(tipoUsuario);

			usuarioCrear.setStatusUsuario2(status);
			usuarioCrear.setTipoUsuario2(tipoUsu);

			if (dnUsuarios.crearUsuario(usuarioCrear) != null) {
				usuarioCrear = null;
				usuarioCrear = new Usuario();
				mensajes.mostrarMensaje("Registro Exitoso", 1);
				tipoUsuario1 = 0;
				consultarTodo();
			}
		} else {
			mensajes.mostrarMensaje("Las contraseñas no coinciden", 3);
		}

	}

	public void consultarUsuarioByUsuario(Usuario usuario) throws Exception {

		inicializarDelegados();
		usuarioModificar = dnUsuarios.consultarUsuarioByUsuario(usuario);

		tipoUsuario = usuarioModificar.getTipoUsuario2().getIdTipoUsu();
		
		if(tipoUsuario!=1 || tipoUsuario!=2) {
			isTipoUsuarioHabilitado = false;
		}else {
			isTipoUsuarioHabilitado=true;
		}

	}

	public void modificarUsuario() throws Exception {

		inicializarDelegados();

		StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(1);
		TipoUsuario tipoUsu = dNTipoUsuario.consultarDetalleTipoUsuarioById(tipoUsuario);

		usuarioModificar.setStatusUsuario2(status);
		usuarioModificar.setTipoUsuario2(tipoUsu);

		if (dnUsuarios.actualizarUsuario(usuarioModificar) != null) {
			mensajes.mostrarMensaje("Modificacion Exitosa", 1);
		}
	}

	public void actualizarDatosUsuarioTabla(Usuario usuario) throws Exception {

		usuarioModificar = usuario;
		
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		String url2 = externalContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,
				"/view/usuarios/modificarUsuario.xhtml"));
		externalContext.redirect(url2);

	}

	public void eliminarUsuario(Usuario usuario) throws Exception {

		inicializarDelegados();
		StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(3);
		usuario.setStatusUsuario2(status);

		if (dnUsuarios.eliminarUsuario(usuario) != null) {
			mensajes.mostrarMensaje("Usuario eliminado", 1);
			consultarTodosUsuarios();
		}

	}

	private void inicializarDelegados() throws Exception {

		if (dnUsuarios == null) {
			dnUsuarios = new DNUsuarios();
		}

		if (dNTipoUsuario == null) {
			dNTipoUsuario = new DNTipoUsuario();
		}

		if (dNStatusUsuario == null) {
			dNStatusUsuario = new DNStatusUsuario();
		}

	}

	public boolean isTipoUsuarioHabilitado() {
		return isTipoUsuarioHabilitado;
	}

	public void setTipoUsuarioHabilitado(boolean isTipoUsuarioHabilitado) {
		this.isTipoUsuarioHabilitado = isTipoUsuarioHabilitado;
	}

	public Usuario getUsuarioModificar() {
		return usuarioModificar;
	}

	public void setUsuarioModificar(Usuario usuarioModificar) {
		this.usuarioModificar = usuarioModificar;
	}

	public int getTipoUsuario1() {
		return tipoUsuario1;
	}

	public void setTipoUsuario1(int tipoUsuario1) {
		this.tipoUsuario1 = tipoUsuario1;
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

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<TipoUsuario> getListTipoUsuario() {
		return listTipoUsuario;
	}

	public void setListTipoUsuario(List<TipoUsuario> listTipoUsuario) {
		this.listTipoUsuario = listTipoUsuario;
	}

	public List<SelectItem> getListTiposUsuario() {
		return listTiposUsuario;
	}

	public void setListTiposUsuario(List<SelectItem> listTiposUsuario) {
		this.listTiposUsuario = listTiposUsuario;
	}

	public Usuario getvUsuario() {
		return vUsuario;
	}

	public void setvUsuario(Usuario vUsuario) {
		this.vUsuario = vUsuario;
	}

	public String getConfirmacionPassword() {
		return confirmacionPassword;
	}

	public void setConfirmacionPassword(String confirmacionPassword) {
		this.confirmacionPassword = confirmacionPassword;
	}

}
