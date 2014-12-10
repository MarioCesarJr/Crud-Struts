package com.struts.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.struts.model.Carro;

public class Carros {

	private EntityManager manager;
	
	public Carros(EntityManager manager){
		this.manager = manager;
	}
	
	public void adiciona(Carro carro){
		this.manager.persist(carro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> todos(){
		return this.manager.createQuery("FROM Carro").getResultList();
	}
}
