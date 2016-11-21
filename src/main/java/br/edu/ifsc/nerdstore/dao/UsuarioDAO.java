package br.edu.ifsc.nerdstore.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifsc.nerdstore.modelo.Usuario;


public class UsuarioDAO {
	
	public static synchronized UsuarioDAO getInstance() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}
	
	private UsuarioDAO() {}
	
	private static UsuarioDAO instancia;

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("daniel.estrazulas@gmail.com", new Usuario("daniel.estrazulas@gmail.com","teste"));
		USUARIOS.put("diretor@sematecsolucoes.com.br", new Usuario("diretor@sematecsolucoes.com.br","diretor"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

	public void adiciona(Usuario novoUsuario) {
		USUARIOS.put(novoUsuario.getEmail(), novoUsuario);
	}

	public boolean usuarioExiste(String email) {
		return USUARIOS.containsKey(email);
	}

	public List<Usuario> listarTodos() {
		return new ArrayList<>(USUARIOS.values());
	}


}
