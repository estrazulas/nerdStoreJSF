package br.edu.ifsc.nerdstore.modelo;

import java.math.BigDecimal;

import br.edu.ifsc.nerdstore.dao.ProdutoDAO;
import br.edu.ifsc.nerdstore.util.Util;

public class ItemComercializado {

	private String id;
	private String  idProduto;
	private Integer quantidade;
	private BigDecimal totalDoItem;
	
	public ItemComercializado(){
		this(new Produto(), 0);
	}
	
	public ItemComercializado(Produto produto, Integer quantidade){
		this.id = Util.geraUID();
		this.idProduto = produto.getId();
		this.quantidade = quantidade;
		this.totalDoItem = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public Produto getProduto(){
		return ProdutoDAO.getInstance().buscaPorId(this.idProduto);
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getTotalDoItem() {
		return totalDoItem;
	}
	public void setTotalDoItem(BigDecimal totalDoItem) {
		this.totalDoItem = totalDoItem;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	
}
