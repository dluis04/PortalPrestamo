package com.portalPrestamosl.procesos.modelo.ejb.entity.procesos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_USUARIO")
	private int idUsuario;

	@Column(name="USU_CEDULA")
	private String usuCedula;

	@Column(name="USU_DF_BARRIO")
	private String usuDfBarrio;

	@Column(name="USU_DF_BARRIO_EMP")
	private String usuDfBarrioEmp;

	@Column(name="USU_DF_BARRIO_VEC")
	private String usuDfBarrioVec;

	@Column(name="USU_DF_CEL")
	private String usuDfCel;

	@Column(name="USU_DF_DIRE")
	private String usuDfDire;

	@Column(name="USU_DF_DIRE_EMP")
	private String usuDfDireEmp;

	@Column(name="USU_DF_DIRE_VEC")
	private String usuDfDireVec;

	@Column(name="USU_DF_EMPRESA")
	private String usuDfEmpresa;

	@Column(name="USU_DF_FIJO")
	private String usuDfFijo;

	@Column(name="USU_DF_NOMBVECINO")
	private String usuDfNombvecino;

	@Column(name="USU_DF_OCUPACION")
	private String usuDfOcupacion;

	@Column(name="USU_DF_TELTRABAJO")
	private String usuDfTeltrabajo;

	@Column(name="USU_DF_TELVECINO")
	private String usuDfTelvecino;

	@Column(name="USU_MAIL")
	private String usuMail;

	@Column(name="USU_PASSWORD")
	private String usuPassword;

	@Column(name="USU_PRIMERAPE")
	private String usuPrimerape;

	@Column(name="USU_PRIMERNOMB")
	private String usuPrimernomb;

	@Column(name="USU_SEGUNDOAPE")
	private String usuSegundoape;

	@Column(name="USU_SEGUNDONOMB")
	private String usuSegundonomb;

	@Column(name="USU_USUARIO")
	private String usuUsuario;

	//bi-directional many-to-one association to Nota
	@OneToMany(mappedBy="usuario")
	private List<Nota> notas;

	//bi-directional many-to-one association to PermisosUsuario
	@OneToMany(mappedBy="usuario")
	private List<PermisosUsuario> permisosUsuarios;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="usuario1")
	private List<Prestamo> prestamos1;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="usuario2")
	private List<Prestamo> prestamos2;

	//bi-directional many-to-one association to Prestamo
	@OneToMany(mappedBy="usuario3")
	private List<Prestamo> prestamos3;

	//bi-directional many-to-one association to SesionesActiva
	@OneToMany(mappedBy="usuario")
	private List<SesionesActiva> sesionesActivas;

	//bi-directional many-to-one association to StatusUsuario
	@ManyToOne
	@JoinColumn(name="ID_STATUS_USU2")
	private StatusUsuario statusUsuario2;

	//bi-directional many-to-one association to TipoUsuario
	@ManyToOne
	@JoinColumn(name="ID_TIPO_USU2")
	private TipoUsuario tipoUsuario2;

	//bi-directional many-to-one association to UsuariosBloqueado
	@OneToMany(mappedBy="usuario")
	private List<UsuariosBloqueado> usuariosBloqueados;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuCedula() {
		return this.usuCedula;
	}

	public void setUsuCedula(String usuCedula) {
		this.usuCedula = usuCedula;
	}

	public String getUsuDfBarrio() {
		return this.usuDfBarrio;
	}

	public void setUsuDfBarrio(String usuDfBarrio) {
		this.usuDfBarrio = usuDfBarrio;
	}

	public String getUsuDfBarrioEmp() {
		return this.usuDfBarrioEmp;
	}

	public void setUsuDfBarrioEmp(String usuDfBarrioEmp) {
		this.usuDfBarrioEmp = usuDfBarrioEmp;
	}

	public String getUsuDfBarrioVec() {
		return this.usuDfBarrioVec;
	}

	public void setUsuDfBarrioVec(String usuDfBarrioVec) {
		this.usuDfBarrioVec = usuDfBarrioVec;
	}

	public String getUsuDfCel() {
		return this.usuDfCel;
	}

	public void setUsuDfCel(String usuDfCel) {
		this.usuDfCel = usuDfCel;
	}

	public String getUsuDfDire() {
		return this.usuDfDire;
	}

	public void setUsuDfDire(String usuDfDire) {
		this.usuDfDire = usuDfDire;
	}

	public String getUsuDfDireEmp() {
		return this.usuDfDireEmp;
	}

	public void setUsuDfDireEmp(String usuDfDireEmp) {
		this.usuDfDireEmp = usuDfDireEmp;
	}

	public String getUsuDfDireVec() {
		return this.usuDfDireVec;
	}

	public void setUsuDfDireVec(String usuDfDireVec) {
		this.usuDfDireVec = usuDfDireVec;
	}

	public String getUsuDfEmpresa() {
		return this.usuDfEmpresa;
	}

	public void setUsuDfEmpresa(String usuDfEmpresa) {
		this.usuDfEmpresa = usuDfEmpresa;
	}

	public String getUsuDfFijo() {
		return this.usuDfFijo;
	}

	public void setUsuDfFijo(String usuDfFijo) {
		this.usuDfFijo = usuDfFijo;
	}

	public String getUsuDfNombvecino() {
		return this.usuDfNombvecino;
	}

	public void setUsuDfNombvecino(String usuDfNombvecino) {
		this.usuDfNombvecino = usuDfNombvecino;
	}

	public String getUsuDfOcupacion() {
		return this.usuDfOcupacion;
	}

	public void setUsuDfOcupacion(String usuDfOcupacion) {
		this.usuDfOcupacion = usuDfOcupacion;
	}

	public String getUsuDfTeltrabajo() {
		return this.usuDfTeltrabajo;
	}

	public void setUsuDfTeltrabajo(String usuDfTeltrabajo) {
		this.usuDfTeltrabajo = usuDfTeltrabajo;
	}

	public String getUsuDfTelvecino() {
		return this.usuDfTelvecino;
	}

	public void setUsuDfTelvecino(String usuDfTelvecino) {
		this.usuDfTelvecino = usuDfTelvecino;
	}

	public String getUsuMail() {
		return this.usuMail;
	}

	public void setUsuMail(String usuMail) {
		this.usuMail = usuMail;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public String getUsuPrimerape() {
		return this.usuPrimerape;
	}

	public void setUsuPrimerape(String usuPrimerape) {
		this.usuPrimerape = usuPrimerape;
	}

	public String getUsuPrimernomb() {
		return this.usuPrimernomb;
	}

	public void setUsuPrimernomb(String usuPrimernomb) {
		this.usuPrimernomb = usuPrimernomb;
	}

	public String getUsuSegundoape() {
		return this.usuSegundoape;
	}

	public void setUsuSegundoape(String usuSegundoape) {
		this.usuSegundoape = usuSegundoape;
	}

	public String getUsuSegundonomb() {
		return this.usuSegundonomb;
	}

	public void setUsuSegundonomb(String usuSegundonomb) {
		this.usuSegundonomb = usuSegundonomb;
	}

	public String getUsuUsuario() {
		return this.usuUsuario;
	}

	public void setUsuUsuario(String usuUsuario) {
		this.usuUsuario = usuUsuario;
	}

	public List<Nota> getNotas() {
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public Nota addNota(Nota nota) {
		getNotas().add(nota);
		nota.setUsuario(this);

		return nota;
	}

	public Nota removeNota(Nota nota) {
		getNotas().remove(nota);
		nota.setUsuario(null);

		return nota;
	}

	public List<PermisosUsuario> getPermisosUsuarios() {
		return this.permisosUsuarios;
	}

	public void setPermisosUsuarios(List<PermisosUsuario> permisosUsuarios) {
		this.permisosUsuarios = permisosUsuarios;
	}

	public PermisosUsuario addPermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().add(permisosUsuario);
		permisosUsuario.setUsuario(this);

		return permisosUsuario;
	}

	public PermisosUsuario removePermisosUsuario(PermisosUsuario permisosUsuario) {
		getPermisosUsuarios().remove(permisosUsuario);
		permisosUsuario.setUsuario(null);

		return permisosUsuario;
	}

	public List<Prestamo> getPrestamos1() {
		return this.prestamos1;
	}

	public void setPrestamos1(List<Prestamo> prestamos1) {
		this.prestamos1 = prestamos1;
	}

	public Prestamo addPrestamos1(Prestamo prestamos1) {
		getPrestamos1().add(prestamos1);
		prestamos1.setUsuario1(this);

		return prestamos1;
	}

	public Prestamo removePrestamos1(Prestamo prestamos1) {
		getPrestamos1().remove(prestamos1);
		prestamos1.setUsuario1(null);

		return prestamos1;
	}

	public List<Prestamo> getPrestamos2() {
		return this.prestamos2;
	}

	public void setPrestamos2(List<Prestamo> prestamos2) {
		this.prestamos2 = prestamos2;
	}

	public Prestamo addPrestamos2(Prestamo prestamos2) {
		getPrestamos2().add(prestamos2);
		prestamos2.setUsuario2(this);

		return prestamos2;
	}

	public Prestamo removePrestamos2(Prestamo prestamos2) {
		getPrestamos2().remove(prestamos2);
		prestamos2.setUsuario2(null);

		return prestamos2;
	}

	public List<Prestamo> getPrestamos3() {
		return this.prestamos3;
	}

	public void setPrestamos3(List<Prestamo> prestamos3) {
		this.prestamos3 = prestamos3;
	}

	public Prestamo addPrestamos3(Prestamo prestamos3) {
		getPrestamos3().add(prestamos3);
		prestamos3.setUsuario3(this);

		return prestamos3;
	}

	public Prestamo removePrestamos3(Prestamo prestamos3) {
		getPrestamos3().remove(prestamos3);
		prestamos3.setUsuario3(null);

		return prestamos3;
	}

	public List<SesionesActiva> getSesionesActivas() {
		return this.sesionesActivas;
	}

	public void setSesionesActivas(List<SesionesActiva> sesionesActivas) {
		this.sesionesActivas = sesionesActivas;
	}

	public SesionesActiva addSesionesActiva(SesionesActiva sesionesActiva) {
		getSesionesActivas().add(sesionesActiva);
		sesionesActiva.setUsuario(this);

		return sesionesActiva;
	}

	public SesionesActiva removeSesionesActiva(SesionesActiva sesionesActiva) {
		getSesionesActivas().remove(sesionesActiva);
		sesionesActiva.setUsuario(null);

		return sesionesActiva;
	}

	public StatusUsuario getStatusUsuario2() {
		return this.statusUsuario2;
	}

	public void setStatusUsuario2(StatusUsuario statusUsuario2) {
		this.statusUsuario2 = statusUsuario2;
	}

	public TipoUsuario getTipoUsuario2() {
		return this.tipoUsuario2;
	}

	public void setTipoUsuario2(TipoUsuario tipoUsuario2) {
		this.tipoUsuario2 = tipoUsuario2;
	}

	public List<UsuariosBloqueado> getUsuariosBloqueados() {
		return this.usuariosBloqueados;
	}

	public void setUsuariosBloqueados(List<UsuariosBloqueado> usuariosBloqueados) {
		this.usuariosBloqueados = usuariosBloqueados;
	}

	public UsuariosBloqueado addUsuariosBloqueado(UsuariosBloqueado usuariosBloqueado) {
		getUsuariosBloqueados().add(usuariosBloqueado);
		usuariosBloqueado.setUsuario(this);

		return usuariosBloqueado;
	}

	public UsuariosBloqueado removeUsuariosBloqueado(UsuariosBloqueado usuariosBloqueado) {
		getUsuariosBloqueados().remove(usuariosBloqueado);
		usuariosBloqueado.setUsuario(null);

		return usuariosBloqueado;
	}

}