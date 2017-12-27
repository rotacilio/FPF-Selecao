package br.com.rodrigo.restapi.models;

import java.sql.Date;

import br.com.rodrigo.restapi.models.dao.CategoriaDao;
import br.com.rodrigo.restapi.models.dao.OrigemDao;

public class Produto {
	
	private Integer id;
	private String descricao;
	private Date dataCompra;
	private String imagem;
	private Double preco;
	private Origem origem;
	private Categoria categoria;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public Produto(String descricao, Date dataCompra, String imagem, Double preco, Integer origem, Integer categoria) {
		super();
		this.descricao = descricao;
		this.dataCompra = dataCompra;
		this.imagem = imagem;
		this.preco = preco;
		this.origem = new OrigemDao().findByPk(origem);
		this.categoria = new CategoriaDao().findByPk(categoria);
	}

	public Produto(Integer id, String descricao, Date dataCompra, String imagem, Double preco, Integer origem,
			Integer categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCompra = dataCompra;
		this.imagem = imagem;
		this.preco = preco;
		this.origem = new OrigemDao().findByPk(origem);
		this.categoria = new CategoriaDao().findByPk(categoria);
	}

	public Produto() {}
	
	public String toString() {
		return "Produto [id: "+this.id+", descricao: "+this.descricao+"]";
	}
}
