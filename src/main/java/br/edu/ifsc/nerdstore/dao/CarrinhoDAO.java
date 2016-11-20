package br.edu.ifsc.nerdstore.dao;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifsc.nerdstore.modelo.CarrinhoCompras;

/**
 * Utilizado para guardar o histórico dos carrinhos dos usuários, para que no login não se perca
 * @author estrazulas
 *
 */
public class CarrinhoDAO {
	
	public static synchronized CarrinhoDAO getInstance() {
		if (instancia == null) {
			instancia = new CarrinhoDAO();
		}
		return instancia;
	}
	
	private CarrinhoDAO() {}
	
	private static CarrinhoDAO instancia;
	
	private final static Map<String, CarrinhoCompras> CARRINHOS = new HashMap<>();
	
	private CarrinhoCompras buscaPorIdDoUsuario(String userId){
		CarrinhoCompras carrinho= null;
		carrinho = CARRINHOS.get(userId);
		return carrinho;
	}
	
	private void adicionaCarrinho(CarrinhoCompras carrinho , String userId){
		if(!CARRINHOS.containsKey(userId)){
			CARRINHOS.put(userId, carrinho);
		}
	}
	
	public CarrinhoCompras adicionaCarrinhoSeNaoTem(String userId){
		CarrinhoCompras carrinho = this.buscaPorIdDoUsuario(userId);
		if(carrinho==null)
		{
			carrinho = new CarrinhoCompras();
			adicionaCarrinho(carrinho,userId);
		}
		return carrinho;
	}

}
