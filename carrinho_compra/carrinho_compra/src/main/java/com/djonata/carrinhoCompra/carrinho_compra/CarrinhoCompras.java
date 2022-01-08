package com.djonata.carrinhoCompra.carrinho_compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarrinhoCompras {

	private List<Item> itens = new ArrayList<>();

	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade)
			throws ItemInvalidoCarrinhoException {
		try {
			Optional<Item> produtoItem = itens.stream().filter(item -> item.getProduto().equals(produto)).findFirst();

			if (produtoItem.isPresent()) {
				produtoItem.get().setValorUnitario(valorUnitario);
				produtoItem.get().setQuantidade(quantidade);
			} else {
				Item newItem = new Item(produto, valorUnitario, quantidade);
				newItem.setIndex(itens.size() + 1);
				this.itens.add(newItem);
			}
		} catch (RuntimeException e) {
			throw new ItemInvalidoCarrinhoException("Erro ao adicionar item!!");
		}
	}

	public boolean removerItem(Produto produto) {
		Optional<Item> itemToRemove = this.itens.stream().filter(item -> item.getProduto().equals(produto)).findFirst();
		return itemToRemove.isPresent() && itens.remove(itemToRemove.get());
	}

	public boolean removerItem(int posicaoItem) {
		Optional<Item> removerItem = this.itens.stream().filter(item -> item.getIndex() == posicaoItem).findFirst();
		return removerItem.isPresent() && itens.remove(removerItem.get());
	}

	public BigDecimal getValorTotal() {
		List<BigDecimal> vlrTotal = itens.stream().map(item -> item.getValorTotal()).collect(Collectors.toList());
		return vlrTotal.stream().reduce(BigDecimal.ZERO, (subtotal, element) -> subtotal.add(element));
	}

	public Collection<Item> getItens() {
		return this.itens;

	}

	@Override
	public String toString() {
		List<String> list = itens.stream()
				.map(item -> String.format("{ Index: %d, Produto: %s, Quantidade: %d, ValorUnitário: %.2f }",
						item.getIndex(), item.getProduto().getDescricao(), item.getQuantidade(),
						item.getValorUnitario()))
				.collect(Collectors.toList());

		return list.toString();
	}
}