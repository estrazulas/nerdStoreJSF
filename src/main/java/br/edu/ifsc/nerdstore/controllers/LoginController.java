package br.edu.ifsc.nerdstore.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsc.nerdstore.dao.CarrinhoDAO;
import br.edu.ifsc.nerdstore.dao.UsuarioDAO;
import br.edu.ifsc.nerdstore.modelo.Usuario;

@WebServlet(urlPatterns = "/home")
public class LoginController extends HttpServlet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		validaUsuarioEDespacha(req, resp, email, senha);
	}

	private void validaUsuarioEDespacha(HttpServletRequest req, HttpServletResponse resp, String email, String senha)
			throws ServletException, IOException {
		Usuario usuario =  UsuarioDAO.getInstance().buscaPorEmailESenha(email, senha);
		
		String destino="";
		
		if (usuario == null) {
			req.setAttribute("mensagem", "usuario.invalido");
			destino = "index.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			session.setAttribute("carrinhoCompras", CarrinhoDAO.getInstance().adicionaCarrinhoSeNaoTem(usuario.getId()));
			req.setAttribute("mensagem", "sistema.bemvindo");
			destino = "/executa?tarefa=loja";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(destino);
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, resp);
	}

	public String logoff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("usuarioLogado");
		req.getSession().removeAttribute("carrinho");
		return "index.jsp";
	}
}