package pb.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pb.service.ContaService;

@ManagedBean(name="contaMB")
@ViewScoped
public class ContaMB extends AppMB {
	private static final long serialVersionUID = 5916320095618212562L;

	@EJB
	private ContaService service;

	public ContaMB(){
		super();
	}
	
	private String OpDeposito(){
		return "formDeposito.xhml";
	}
	private String OpSaque(){
		return "formSaque.xhml";
	}
}
