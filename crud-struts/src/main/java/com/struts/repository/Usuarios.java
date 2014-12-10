package com.struts.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.struts.model.Usuario;

public class Usuarios {

	private EntityManager manager;
	
	public Usuarios(EntityManager manager){
		this.manager = manager;
	}

	public Usuario busca(Long id) {
		return this.manager.find(Usuario.class, id);
	}

	public void adiciona(Usuario usuario) {
		this.manager.persist(usuario);
	}

	public void remove(Long id) {
		Usuario usuario = this.manager.find(Usuario.class, id);
		this.manager.remove(usuario);
	}

	public Usuario altera(Usuario usuario) {
		 return this.manager.merge(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> lista() {
		return this.manager.createQuery("from Usuario").getResultList();
	}
	
	public boolean existeUsernameEPassword(String username, String password){
		Query query = this.manager.createQuery("select u from Usuario u where u.username = :username and u.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		return !query.getResultList().isEmpty();
	}
}
