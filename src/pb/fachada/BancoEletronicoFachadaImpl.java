package pb.fachada;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import pb.entity.Conta;
import pb.exception.OperacaoInvalidaException;
import pb.service.ContaService;

@Stateless
@TransactionManagement(value=TransactionManagementType.BEAN)
public class BancoEletronicoFachadaImpl implements BancoEletronicoFachada {
	@EJB
	private ContaService contaService;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean transferir(double quanto, Conta deQualConta,
			Conta paraQualConta) throws OperacaoInvalidaException {
		// TODO Auto-generated method stub

		return false;
	}
}
