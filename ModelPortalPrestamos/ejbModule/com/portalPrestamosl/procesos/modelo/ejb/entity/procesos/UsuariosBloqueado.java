package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the USUARIOS_BLOQUEADOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS_BLOQUEADOS")
@NamedQuery(name="UsuariosBloqueado.findAll", query="SELECT u FROM UsuariosBloqueado u")
public class UsuariosBloqueado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO_BLOQ")
	private int idUsuarioBloq;

	@Temporal(TemporalType.DATE)
	@Column(name="USB_FECHA_REGISTRO")
	private Date usbFechaRegistro;

	@Column(name="USB_TIEMPO")
	private int usbTiempo;

	@Column(name="USB_TIPO_TIEMPO")
	private int usbTipoTiempo;

	//bi-directional many-to-one association to TiposBloqueo
	@ManyToOne
	@JoinColumn(name="ID_TIPO_BLOQUEO")
	private TiposBloqueo tiposBloqueo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public UsuariosBloqueado() {
	}

	public int getIdUsuarioBloq() {
		return this.idUsuarioBloq;
	}

	public void setIdUsuarioBloq(int idUsuarioBloq) {
		this.idUsuarioBloq = idUsuarioBloq;
	}

	public Date getUsbFechaRegistro() {
		return this.usbFechaRegistro;
	}

	public void setUsbFechaRegistro(Date usbFechaRegistro) {
		this.usbFechaRegistro = usbFechaRegistro;
	}

	public int getUsbTiempo() {
		return this.usbTiempo;
	}

	public void setUsbTiempo(int usbTiempo) {
		this.usbTiempo = usbTiempo;
	}

	public int getUsbTipoTiempo() {
		return this.usbTipoTiempo;
	}

	public void setUsbTipoTiempo(int usbTipoTiempo) {
		this.usbTipoTiempo = usbTipoTiempo;
	}

	public TiposBloqueo getTiposBloqueo() {
		return this.tiposBloqueo;
	}

	public void setTiposBloqueo(TiposBloqueo tiposBloqueo) {
		this.tiposBloqueo = tiposBloqueo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}