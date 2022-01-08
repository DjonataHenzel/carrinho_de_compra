package com.djonata.carrinhoCompra.carrinho_compra;

import java.util.Objects;

public class Produto {

	private Long codigo;
	private String descricao;

	public Produto(Long codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Produto produto = (Produto) o;
		return Objects.equals(codigo, produto.codigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

}