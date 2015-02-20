package pb.fachada;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pb.entity.Conta;
import pb.exception.ContaInvalidaException;
import pb.exception.DinheiroInsuficienteException;
import pb.exception.OperacaoInvalidaException;
import pb.service.ContaService;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class BancoEletronicoFachadaImpl implements BancoEletronicoFachada {
	@EJB
	private ContaService service;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public boolean transferir(double quanto, int deQualConta, int paraQualConta)
			throws ContaInvalidaException, DinheiroInsuficienteException,
			OperacaoInvalidaException {
		
		if(deQualConta == paraQualConta)
			throw new ContaInvalidaException("A conta de destino é igual à conta de origem");

		service.withdraw(deQualConta, quanto);
		service.deposit(paraQualConta, quanto);

		return service.getSaldo(paraQualConta) >= quanto;
	}

	@Override
	public Conta save(Conta conta) {
		return service.save(conta);
	}

	@Override
	public List<Conta> findAll() {
		return service.findAll();
	}
}
