package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import pb.entity.Conta;
import pb.service.ContaService;

@ManagedBean(name = "contaMB")
@ApplicationScoped
public class ContaMB extends AppMB {

	private static final long serialVersionUID = 3925545192631139952L;

	@EJB
	private ContaService service;

	private List<Conta> contas;
	private Conta conta;

	public ContaMB() {
		super();
		contas = new ArrayList<Conta>();
		conta = new Conta();
	}

	private String OpDeposito() {
		return "formDeposito.xhml";
	}

	private String OpSaque() {
		return "formSaque.xhml";
	}

	public void add() {
		if (service.save(conta) != null) {
			System.err.println(" salvou ");
			this.redirect("contas/index");
		} else {
			this.redirect("contas/add");
		}
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContas() {
		contas = service.findAll();
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public boolean isVazio() {
		return this.getContas().isEmpty();
	}

	public boolean isNotVazio() {
		return !this.isVazio();
	}
}
