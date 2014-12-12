package com.struts.action;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.model.Usuario;
import com.struts.repository.Usuarios;

public class AutenticacaoAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	private String mensagem;
	
	public String login(){
		EntityManager manager = this.getEntityManager();
		Usuarios usuarios = new Usuarios(manager);
		
		if(usuarios.existeUsernameEPassword(this.usuario.getUsername(), this.usuario.getPassword())){
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("usuario", this.usuario);
			
			this.mensagem = "Autenticação realizada com sucesso.";
			
			return AutenticacaoAction.SUCCESS;
		}else{
			
			this.mensagem = "Usuário e/ou senha incorretos.";
			return AutenticacaoAction.INPUT;
		}
	}
	
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.removeAttribute("usuario");
		
		this.mensagem = "Até logo!";
		
		return AutenticacaoAction.SUCCESS;
	
	}
	
	
	private EntityManager getEntityManager() {
		HttpServletRequest request = ServletActionContext.getRequest();
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		return manager;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
