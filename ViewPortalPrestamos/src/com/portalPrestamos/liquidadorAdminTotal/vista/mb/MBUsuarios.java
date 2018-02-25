package com.portalPrestamos.liquidadorAdminTotal.vista.mb;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.portalPrestamos.estandar.vista.mb.MBMensajes;
import com.portalPrestamos.liquidadorAdminTotal.vista.delegado.DNUsuarios;
import com.portalPrestamosl.procesos.modelo.ejb.entity.procesos.Usuario;

@ManagedBean(name = "MBUsuarios")
@SessionScoped
public class MBUsuarios {
	MBMensajes mensajes = new MBMensajes();
	private String user;
	private String pass;
	private Usuario vUsuario;
	DNUsuarios dnUsuarios;

	public MBUsuarios() {
		vUsuario = new Usuario();
	}

	

}
