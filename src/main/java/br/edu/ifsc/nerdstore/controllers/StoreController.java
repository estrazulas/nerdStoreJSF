package br.edu.ifsc.nerdstore.controllers;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsc.nerdstore.dao.ProdutoDAO;
import br.edu.ifsc.nerdstore.modelo.CarrinhoCompras;
import br.edu.ifsc.nerdstore.modelo.Produto;

public class StoreController {

	public String listaProdutos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection<Produto> produtos = ProdutoDAO.getInstance().buscaPorSimilaridade(null);
		req.setAttribute("produtos", produtos);
		
		return "/WEB-INF/paginas/loja.jsp";
	}

	public String verCarrinho(HttpServletRequest req, HttpServletResponse resp) {
		
		return "/WEB-INF/paginas/carrinho.jsp";
	}

	public String comprar(HttpServletRequest req, HttpServletResponse resp) {
		String idProduto = req.getParameter("idProduto");
		Integer quantidade = Integer.valueOf(req.getParameter("quantidade"));
		CarrinhoCompras carrinho = (CarrinhoCompras) req.getSession().getAttribute("carrinhoCompras");
		Produto produtoNovo= ProdutoDAO.getInstance().buscaPorId(idProduto);
		carrinho.adicionaProduto(produtoNovo, quantidade);
		return "/executa?tarefa=carrinho";
	}

	public String removerItem(HttpServletRequest req, HttpServletResponse resp) {
		CarrinhoCompras carrinho = (CarrinhoCompras) req.getSession().getAttribute("carrinhoCompras");
		String idItem = req.getParameter("idItem");
		carrinho.removeProduto(idItem);
		return "/executa?tarefa=carrinho";
	}

}
