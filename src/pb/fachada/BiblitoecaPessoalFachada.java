package pb.fachada;

import java.util.List;

import javax.ejb.Remote;

import org.bibpessoal.entidades.Livro;
import org.bibpessoal.entidades.Usuario;
import org.bibpessoal.exceptions.LivroInvalidoException;
import org.bibpessoal.exceptions.UsuarioInvalidoException;

import pb.entity.Conta;
import pb.exception.ContaInvalidaException;

@Remote
public interface BancoEletronicoFachada {
	public Conta recuperarConta(int numero) throws ContaInvalidaException;
	public boolean AtualizarConta(Conta conta) throws ContaInvalidaException;
}
