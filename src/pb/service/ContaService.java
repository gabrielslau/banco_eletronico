package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Conta;
import pb.exception.DinheiroInsuficienteException;

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

	public double withdraw(Conta conta, double dinheiroParaRetirar) throws DinheiroInsuficienteException {
		if (conta.getSaldo() < dinheiroParaRetirar) {
			throw new DinheiroInsuficienteException(
					"Não há saldo suficiente para completar esta operação");
		}
		double novoSaldo = conta.getSaldo() - dinheiroParaRetirar;
		conta.setSaldo(novoSaldo);
		return novoSaldo;
	}

	public double deposit(Conta conta, double dinheiroParaDepositar) {
		double novoSaldo = conta.getSaldo() + dinheiroParaDepositar;
		conta.setSaldo( conta.getSaldo() + dinheiroParaDepositar );
		return novoSaldo;
	}
}
