package com.struts.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.model.Carro;
import com.struts.repository.Carros;

public class AdicionaCarroAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Carro carro = new Carro();

	@Override
	public String execute() throws Exception {

		EntityManager manager = this.getEntityManager();
        Carros carros = new Carros(manager);
        
        carros.adiciona(carro);
        this.carro = new Carro();
		
        return AdicionaCarroAction.SUCCESS;
	}
	
	public List<Carro> getCarros(){
		EntityManager manager = this.getEntityManager();
		Carros carros = new Carros(manager);
		
		return carros.todos();
	}

	private EntityManager getEntityManager() {
		HttpServletRequest request = ServletActionContext.getRequest();
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		return manager;
	}
	
	public Carro getCarro() {
		return carro;
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
