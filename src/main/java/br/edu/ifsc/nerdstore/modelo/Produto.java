package br.edu.ifsc.nerdstore.modelo;

import java.math.BigDecimal;

public class Produto {

	private String id;
	private String nome;
	private String urlImagem;
	private BigDecimal preco;
	

	public Produto() {
		this("","","",new BigDecimal(0));
	}
	
	public Produto(String id, String nome, String urlImagem, BigDecimal preco) {
		this.id = id;
		this.nome = nome;
		this.urlImagem = urlImagem;
		this.preco = preco;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	
	
	
}
