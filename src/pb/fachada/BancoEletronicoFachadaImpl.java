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

	// TODO: saber como abortar a transação
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean transferir(double quanto, int deQualConta, int paraQualConta)
			throws OperacaoInvalidaException, ContaInvalidaException, DinheiroInsuficienteException {

		Conta contaOrigem = service.recuperarConta(deQualConta);
		Conta contaDestino = service.recuperarConta(paraQualConta);

		if (contaOrigem == null) {
			throw new ContaInvalidaException("A conta de origem não existe");
		} else if (contaDestino == null) {
			throw new ContaInvalidaException(
					"A conta de destino não existe");
		}
		service.withdraw(contaOrigem, quanto);
		return service.deposit(contaDestino, quanto) > quanto;
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
