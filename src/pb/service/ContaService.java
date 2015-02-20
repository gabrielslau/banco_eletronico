package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Conta;
import pb.exception.ContaInvalidaException;
import pb.exception.DinheiroInsuficienteException;
import pb.exception.OperacaoInvalidaException;

@Stateless
public class ContaService extends AbstractPersistence<Conta, Long> {
	@PersistenceContext(unitName = "bancoEletronico")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ContaService() {
		super(Conta.class);
	}

	public Conta recuperarConta(int numero) {
		return em.find(Conta.class, numero);
	}

	public Conta atualizarConta(Conta conta) {
		return em.merge(conta);
	}

	public void withdraw(int deQualConta, double dinheiroParaRetirar)
			throws DinheiroInsuficienteException, ContaInvalidaException, OperacaoInvalidaException {
		Conta conta = this.recuperarConta(deQualConta);

		if (conta == null)
			throw new ContaInvalidaException("A conta de origem não existe");
		
		if(dinheiroParaRetirar == 0)
			throw new OperacaoInvalidaException("Informe a quantia para transferir");
		
		Double saldoAtual = conta.getSaldo();
		
		conta.setSaldo(saldoAtual - dinheiroParaRetirar);
		
		em.merge(conta); // precisa realmente disso?? (já está funcionando sem)
		
		if (saldoAtual < dinheiroParaRetirar)
			throw new DinheiroInsuficienteException(
					"Não há saldo suficiente para completar esta operação");
	}

	public void deposit(int paraQualConta, double dinheiroParaDepositar) throws ContaInvalidaException {
		Conta conta = this.recuperarConta(paraQualConta);
		
		if (conta == null)
			throw new ContaInvalidaException("A conta de destino não existe");
		
		conta.setSaldo(conta.getSaldo() + dinheiroParaDepositar);
	}
	
	public double getSaldo(int deQualConta){
		return this.recuperarConta(deQualConta).getSaldo();
	}
}
