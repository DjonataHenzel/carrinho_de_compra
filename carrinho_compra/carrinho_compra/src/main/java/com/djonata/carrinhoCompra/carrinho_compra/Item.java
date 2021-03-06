package com.djonata.carrinhoCompra.carrinho_compra;

import java.math.BigDecimal;

public class Item {

	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;
	private Integer index;

	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		super();
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorTotal() {
		return this.valorUnitario.multiply(BigDecimal.valueOf(this.quantidade));
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
