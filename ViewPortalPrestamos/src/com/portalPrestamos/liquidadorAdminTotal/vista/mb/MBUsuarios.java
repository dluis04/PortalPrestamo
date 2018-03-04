package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	private String confirmacionPassword;
	private int tipoUsuario;
	DNUsuarios dnUsuarios;
	DNTipoUsuario dNTipoUsuario;
	DNStatusUsuario dNStatusUsuario;
	List<TipoUsuario> listTipoUsuario;
	List<SelectItem> listTiposUsuario;

	public MBUsuarios() {
		vUsuario = new Usuario();

		consultarTodo();
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

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void guardarUsuario() throws Exception {

		inicializarDelegados();

		StatusUsuario status = dNStatusUsuario.consultarDetalleStatusById(1);
		TipoUsuario tipoUsu = dNTipoUsuario.consultarDetalleTipoUsuarioById(tipoUsuario);

		vUsuario.setStatusUsuario2(status);
		vUsuario.setTipoUsuario2(tipoUsu);

		if (dnUsuarios.crearUsuario(vUsuario) != null) {
			vUsuario = null;
			vUsuario = new Usuario();
			mensajes.mostrarMensaje("Registro Exitoso", 1);
			tipoUsuario = 0;
			consultarTodo();
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
