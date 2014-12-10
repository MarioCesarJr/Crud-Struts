package com.struts.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.model.Usuario;
import com.struts.repository.Usuarios;

public class UsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	private List<Usuario> usuariosList;

	public String adicionaOuAltera() {
		EntityManager manager = this.getEntityManager();
		Usuarios usuarios = new Usuarios(manager);
		
		if (this.usuario.getId() == null) {
			usuarios.adiciona(this.usuario);
		} else {
			usuarios.altera(usuario);
		}

		this.usuario = new Usuario();
		return UsuarioAction.SUCCESS;
	}

	public String remove() {
		EntityManager manager = this.getEntityManager();
		Usuarios usuarios = new Usuarios(manager);
		
		usuarios.remove(this.usuario.getId());
		this.usuario = new Usuario();
		return UsuarioAction.SUCCESS;
	}

	public String preparaAlteracao() {
		EntityManager manager = this.getEntityManager();
		Usuarios usuarios = new Usuarios(manager);
	
		this.usuario = usuarios.busca(this.usuario.getId());
		return UsuarioAction.SUCCESS;
	}

	public String lista() {
		EntityManager manager = this.getEntityManager();
		Usuarios usuarios = new Usuarios(manager);
		
		this.usuariosList = usuarios.lista();
		return UsuarioAction.SUCCESS;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Usuario> getUsuariosList() {
		return usuariosList;
	}
	
	private EntityManager getEntityManager() {
		HttpServletRequest request = ServletActionContext.getRequest();
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		return manager;
	}
}
