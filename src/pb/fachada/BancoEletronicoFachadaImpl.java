package pb.fachada;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pb.entity.Conta;
import pb.exception.OperacaoInvalidaException;

@Stateless
public class BancoEletronicoFachadaImpl implements BancoEletronicoFachada {
	@EJB
	private Conta contaService;

	@Override
	public boolean transferir(double quanto, Conta deQualConta,
			Conta paraQualConta) throws OperacaoInvalidaException {
		// TODO Auto-generated method stub
		return false;
	}
}
