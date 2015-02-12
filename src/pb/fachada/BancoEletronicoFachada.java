package pb.fachada;

import javax.ejb.Remote;

import pb.entity.Conta;
import pb.exception.OperacaoInvalidaException;

@Remote
public interface BancoEletronicoFachada {
	public boolean transferir(double quanto, Conta deQualConta, Conta paraQualConta) throws OperacaoInvalidaException;
}
