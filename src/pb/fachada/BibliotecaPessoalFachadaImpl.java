package pb.fachada;

@Stateless
public class BancoEletronicoFachadaImpl implements BancoEletronicoFachada {
	@EJB
	private UsuarioDAO usuarioDAO;

	@Override
	public pb.fachada.Usuario autenticarUsuario(String login, String senha)
			throws pb.fachada.UsuarioInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cadastrarUsuario(pb.fachada.Usuario novo)
			throws pb.fachada.UsuarioInvalidoException {
		// TODO Auto-generated method stub
		return false;
	}

}
