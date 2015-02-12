package pb.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pb.entity.Conta;

@Stateless
public class ContaService extends AbstractPersistence<Conta, Long> {
	/**
	 * O container injeta a referência para o EntityManager.
	 */
	@PersistenceContext(unitName="personalBiblio")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ContaService() {
		super(Conta.class);
	}
}
