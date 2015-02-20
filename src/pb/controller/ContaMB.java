package pb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import pb.entity.Conta;
import pb.exception.ContaInvalidaException;
import pb.exception.DinheiroInsuficienteException;
import pb.exception.OperacaoInvalidaException;
import pb.fachada.BancoEletronicoFachada;

@ManagedBean(name = "contaMB")
@RequestScoped
public class ContaMB extends AppMB {

	private static final long serialVersionUID = 1L;

	@EJB
	private BancoEletronicoFachada fachada;

	private List<Conta> contas;
	private Conta conta;
	private int numeroContaOrigem, numeroContaDestino;
	private double quantidade;

	public ContaMB() {
		super();
		contas = new ArrayList<Conta>();
		conta = new Conta();
	}

	@Deprecated
	private String OpDeposito() {
		return "formDeposito.xhml";
	}

	@Deprecated
	private String OpSaque() {
		return "formSaque.xhml";
	}

	public void add() {
		if (fachada.save(conta) != null) {
			this.redirect("contas/index");
		} else {
			this.redirect("contas/add");
		}
	}

	public String transferir() {
		try {
			if (fachada.transferir(quantidade, numeroContaOrigem,
					numeroContaDestino)) {
				this.redirect("contas/index");
			}
		} catch (OperacaoInvalidaException | ContaInvalidaException
				| DinheiroInsuficienteException e) {
			setMensagem(e.getMessage());
		}
		return "contas/index.xhtml";
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getContas() {
		contas = fachada.findAll();
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

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public int getNumeroContaOrigem() {
		return numeroContaOrigem;
	}

	public void setNumeroContaOrigem(int numeroContaOrigem) {
		this.numeroContaOrigem = numeroContaOrigem;
	}

	public int getNumeroContaDestino() {
		return numeroContaDestino;
	}

	public void setNumeroContaDestino(int numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}
}
