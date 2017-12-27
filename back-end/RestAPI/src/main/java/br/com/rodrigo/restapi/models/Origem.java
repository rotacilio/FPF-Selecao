package br.com.rodrigo.restapi.models;

public class Origem {
	
	private Integer id;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Origem() {}

	public Origem(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Origem(String descricao) {
		super();
		this.descricao = descricao;
	}
}
