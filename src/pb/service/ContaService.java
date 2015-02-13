package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Conta;

@Stateless
public class ContaService extends AbstractPersistence<Conta, Long> {
	@PersistenceContext(unitName="bancoEletronico")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ContaService() {
		super(Conta.class);
	}

	public Conta recuperarConta(int numero){
		return em.find(Conta.class,numero);
	}
	public Conta atualizarConta(Conta conta){
		return em.merge(conta);
	}
}
