package com.djonata.carrinhoCompra.carrinho_compra;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoComprasFactory {

	private HashMap<String, CarrinhoCompras> carrinhoCompra = new HashMap<>();

	public CarrinhoComprasFactory() {
	}

	public CarrinhoCompras criar(String identificacaoCliente) {
		CarrinhoCompras carrinhoCompras = carrinhoCompra.get(identificacaoCliente);
		if (carrinhoCompras != null)
			return carrinhoCompras;

		carrinhoCompras = new CarrinhoCompras();
		carrinhoCompra.put(identificacaoCliente, carrinhoCompras);
		return carrinhoCompras;
	}

	public BigDecimal getValorTicketMedio() {

		List<BigDecimal> valorCarrinho = carrinhoCompra.values().stream()
				.map(carrinhoCompras -> carrinhoCompras.getValorTotal()).collect(Collectors.toList());
		Integer totalCarrinho = valorCarrinho.size();
		BigDecimal valorTotalCarrinhos = valorCarrinho.stream().reduce(BigDecimal.ZERO,
				(subtotal, element) -> subtotal.add(element));
		return valorTotalCarrinhos.divide(BigDecimal.valueOf(totalCarrinho));

	}

	public boolean invalidar(String identificacaoCliente) {
		CarrinhoCompras removerCarrinho = carrinhoCompra.remove(identificacaoCliente);
		return removerCarrinho != null;

	}
}
