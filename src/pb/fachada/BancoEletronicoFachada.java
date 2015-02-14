package pb.fachada;

import java.util.List;

import javax.ejb.Remote;

import pb.entity.Conta;
import pb.exception.ContaInvalidaException;
import pb.exception.DinheiroInsuficienteException;
import pb.exception.OperacaoInvalidaException;

@Remote
public interface BancoEletronicoFachada {
	public boolean transferir(double quanto, int deQualConta, int paraQualConta)
			throws OperacaoInvalidaException, ContaInvalidaException,
			DinheiroInsuficienteException;

	public Conta save(Conta conta);

	public List<Conta> findAll();
}
