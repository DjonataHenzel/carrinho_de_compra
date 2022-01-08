package com.djonata.carrinhoCompra.carrinho_compra;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ItemInvalidoCarrinhoException {
		Scanner ler = new Scanner(System.in);
		int identificacaoCliente, tipoOperacao, produtoSelecionado, repetirOperacao, quantidade = 0;
		boolean repetir = true;

		// -----------Cadastro de produtos e clientes--------------
		String cliente1 = "Afonso";
		String cliente2 = "Pedro";
		String cliente3 = "Joaquim";
		Produto foneOuvido = new Produto(1L, "Fone de ouvido JBL");
		Produto impressoraHp = new Produto(2L, "Impressora HP 1200");
		Produto penDriveSanDisk = new Produto(3L, "Pen Drive Sandisk 32GB");

		CarrinhoComprasFactory carrinhoComprasFactory = new CarrinhoComprasFactory();
		CarrinhoCompras carrinhoCliente1 = carrinhoComprasFactory.criar(cliente1);
		CarrinhoCompras carrinhoCliente2 = carrinhoComprasFactory.criar(cliente2);
		CarrinhoCompras carrinhoCliente3 = carrinhoComprasFactory.criar(cliente3);
		CarrinhoCompras carrinhoCliente4 = carrinhoComprasFactory.criar(cliente3);

		System.out.println("Informe selecione seu nome para identificação do carrinho:");
		System.out.println("Digite o numero de acordo com seu nome: \n1 = Afonso \n2 = Pedro \n3 = Joaquim");
		identificacaoCliente = ler.nextInt();
		switch (identificacaoCliente) {
		case 1:
			System.out.println("Seja bem vindo! " + cliente1 + " vamos iniciar nossas compras!!");
			System.out.println("Digite 1 - Adicionar produto / 2 - Remover produto");
			tipoOperacao = ler.nextInt();
			do {
				// Opção para adicionar produtos
				if (tipoOperacao == 1) {
					System.out.println("Seleciona o produto que deseja adicionar no carrinho: ");

					System.out.println("1 - Fone de ouvido JBL \n2 - Impressora HP 1200 \n3 - Pen Drive Sandisk 32GB");

					produtoSelecionado = ler.nextInt();
					if (produtoSelecionado == 1) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente1.adicionarItem(foneOuvido, BigDecimal.valueOf(120), quantidade);
					}

					if (produtoSelecionado == 2) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente1.adicionarItem(impressoraHp, BigDecimal.valueOf(1855), quantidade);
					}

					if (produtoSelecionado == 3) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente1.adicionarItem(penDriveSanDisk, BigDecimal.valueOf(49.90), quantidade);
					}

					System.out.println("Valor total: R$ " + carrinhoCliente1.getValorTotal());
					System.out.println("Realizar mais uma operação? 1 = Sim / 2 = Não");
					repetirOperacao = ler.nextInt();

					if (repetirOperacao == 2) {
						repetir = false;
						System.out.println("-------------Situação atual do carrinho---------------------");
						System.out.println("Quantidade de itens: 1: " + carrinhoCliente1.getItens().size());
						System.out.println("Valor total: R$ " + carrinhoCliente1.getValorTotal());
						System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

					} else {
						repetir = true;
						System.out.println("Digite 1 - Adicionar produto / 2 - Remover produto");
						tipoOperacao = ler.nextInt();
					}

				}

				// Opção para remover produtos
				if (tipoOperacao == 2) {
					System.out.println("Seleciona o produto que deseja remover no carrinho: ");
					System.out.println("1 - Fone de ouvido JBL \n2 - Impressora HP 1200 \n3 - Pen Drive Sandisk 32GB");
					produtoSelecionado = ler.nextInt();

					if (produtoSelecionado == 1) {
						if (carrinhoCliente1.removerItem(foneOuvido)) {
							System.out.println("Removido o produto - " + foneOuvido.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + foneOuvido.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					if (produtoSelecionado == 2) {
						if (carrinhoCliente1.removerItem(impressoraHp)) {
							System.out
									.println("Removido o produto - " + impressoraHp.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + impressoraHp.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					if (produtoSelecionado == 3) {
						if (carrinhoCliente1.removerItem(penDriveSanDisk)) {
							System.out.println(
									"Removido o produto - " + penDriveSanDisk.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + penDriveSanDisk.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					System.out.println("-------------Situação atual do carrinho---------------------");
					System.out.println("Quantidade de itens: " + carrinhoCliente1.getItens().size());
					System.out.println("Valor total: R$ " + carrinhoCliente1.getValorTotal());
					System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

					System.out.println("Realizar mais uma operação? 1 = Sim / 2 = Não");
					repetirOperacao = ler.nextInt();
					if (repetirOperacao == 2) {
						repetir = false;

					} else {
						repetir = true;
					}
				}
			} while (repetir);

			break;

		case 2:
			System.out.println("Seja bem vindo! " + cliente2 + " vamos iniciar nossas compras!!");
			System.out.println("Digite 1 - Adicionar produto / 2 - Remover produto");
			tipoOperacao = ler.nextInt();
			do {
				// Opção para adicionar produtos
				if (tipoOperacao == 1) {
					System.out.println("Seleciona o produto que deseja adicionar no carrinho: ");

					System.out.println("1 - Fone de ouvido JBL \n2 - Impressora HP 1200 \n3 - Pen Drive Sandisk 32GB");

					produtoSelecionado = ler.nextInt();
					if (produtoSelecionado == 1) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente2.adicionarItem(foneOuvido, BigDecimal.valueOf(120), quantidade);
					}

					if (produtoSelecionado == 2) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente2.adicionarItem(impressoraHp, BigDecimal.valueOf(1855), quantidade);
					}

					if (produtoSelecionado == 3) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente2.adicionarItem(penDriveSanDisk, BigDecimal.valueOf(49.90), quantidade);
					}

					System.out.println("Valor total: R$ " + carrinhoCliente2.getValorTotal());
					System.out.println("Realizar mais uma operação? 1 = Sim / 2 = Não");
					repetirOperacao = ler.nextInt();

					if (repetirOperacao == 2) {
						repetir = false;
						System.out.println("-------------Situação atual do carrinho---------------------");
						System.out.println("Quantidade de itens: 1: " + carrinhoCliente2.getItens().size());
						System.out.println("Valor total: R$ " + carrinhoCliente2.getValorTotal());
						System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

					} else {
						repetir = true;
						System.out.println("Digite 1 - Adicionar produto / 2 - Remover produto");
						tipoOperacao = ler.nextInt();
					}

				}

				// Opção para remover produtos
				if (tipoOperacao == 2) {
					System.out.println("Seleciona o produto que deseja remover no carrinho: ");
					System.out.println("1 - Fone de ouvido JBL \n2 - Impressora HP 1200 \n3 - Pen Drive Sandisk 32GB");
					produtoSelecionado = ler.nextInt();

					if (produtoSelecionado == 1) {
						if (carrinhoCliente2.removerItem(foneOuvido)) {
							System.out.println("Removido o produto - " + foneOuvido.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + foneOuvido.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					if (produtoSelecionado == 2) {
						if (carrinhoCliente2.removerItem(impressoraHp)) {
							System.out
									.println("Removido o produto - " + impressoraHp.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + impressoraHp.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					if (produtoSelecionado == 3) {
						if (carrinhoCliente2.removerItem(penDriveSanDisk)) {
							System.out.println(
									"Removido o produto - " + penDriveSanDisk.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + penDriveSanDisk.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					System.out.println("-------------Situação atual do carrinho---------------------");
					System.out.println("Quantidade de itens: " + carrinhoCliente2.getItens().size());
					System.out.println("Valor total: R$ " + carrinhoCliente2.getValorTotal());
					System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

					System.out.println("Realizar mais uma operação? 1 = Sim / 2 = Não");
					repetirOperacao = ler.nextInt();
					if (repetirOperacao == 2) {
						repetir = false;

					} else {
						repetir = true;
					}
				}
			} while (repetir);

			break;
		case 3:
			System.out.println("Seja bem vindo! " + cliente3 + " vamos iniciar nossas compras!!");
			System.out.println("Digite 1 - Adicionar produto / 2 - Remover produto");
			tipoOperacao = ler.nextInt();
			do {
				// Opção para adicionar produtos
				if (tipoOperacao == 1) {
					System.out.println("Seleciona o produto que deseja adicionar no carrinho: ");

					System.out.println("1 - Fone de ouvido JBL \n2 - Impressora HP 1200 \n3 - Pen Drive Sandisk 32GB");

					produtoSelecionado = ler.nextInt();
					if (produtoSelecionado == 1) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente3.adicionarItem(foneOuvido, BigDecimal.valueOf(120), quantidade);
					}

					if (produtoSelecionado == 2) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente3.adicionarItem(impressoraHp, BigDecimal.valueOf(1855), quantidade);
					}

					if (produtoSelecionado == 3) {
						System.out.println("Informe a quantidade desse produto:");
						quantidade = ler.nextInt();
						carrinhoCliente3.adicionarItem(penDriveSanDisk, BigDecimal.valueOf(49.90), quantidade);
					}

					System.out.println("Valor total: R$ " + carrinhoCliente3.getValorTotal());
					System.out.println("Realizar mais uma operação? 1 = Sim / 2 = Não");
					repetirOperacao = ler.nextInt();

					if (repetirOperacao == 2) {
						repetir = false;
						System.out.println("-------------Situação atual do carrinho---------------------");
						System.out.println("Quantidade de itens: 1: " + carrinhoCliente3.getItens().size());
						System.out.println("Valor total: R$ " + carrinhoCliente3.getValorTotal());
						System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

					} else {
						repetir = true;
						System.out.println("Digite 1 - Adicionar produto / 2 - Remover produto");
						tipoOperacao = ler.nextInt();
					}

				}

				// Opção para remover produtos
				if (tipoOperacao == 2) {
					System.out.println("Seleciona o produto que deseja remover no carrinho: ");
					System.out.println("1 - Fone de ouvido JBL \n2 - Impressora HP 1200 \n3 - Pen Drive Sandisk 32GB");
					produtoSelecionado = ler.nextInt();

					if (produtoSelecionado == 1) {
						if (carrinhoCliente3.removerItem(foneOuvido)) {
							System.out.println("Removido o produto - " + foneOuvido.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + foneOuvido.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					if (produtoSelecionado == 2) {
						if (carrinhoCliente3.removerItem(impressoraHp)) {
							System.out
									.println("Removido o produto - " + impressoraHp.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + impressoraHp.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					if (produtoSelecionado == 3) {
						if (carrinhoCliente3.removerItem(penDriveSanDisk)) {
							System.out.println(
									"Removido o produto - " + penDriveSanDisk.getDescricao() + " - do carrinho.");
						} else {
							System.out.println("Produto " + penDriveSanDisk.getDescricao()
									+ " não encontrado no carrinho. Não é possivel remover.");
						}
					}

					System.out.println("-------------Situação atual do carrinho---------------------");
					System.out.println("Quantidade de itens: " + carrinhoCliente3.getItens().size());
					System.out.println("Valor total: R$ " + carrinhoCliente3.getValorTotal());
					System.out.println("TicketMedio: " + carrinhoComprasFactory.getValorTicketMedio());

					System.out.println("Realizar mais uma operação? 1 = Sim / 2 = Não");
					repetirOperacao = ler.nextInt();
					if (repetirOperacao == 2) {
						repetir = false;

					} else {
						repetir = true;
					}
				}
			} while (repetir);

			break;

		default:
			System.out.println("Opção invalida, verifique o numero correspondente e tente novamente!! ");

			break;

		}

		System.out.println("----------------------Demais funções----------------------------");
		// Verifica se o carrinhoCliente3 e carrinhoCliente4 são iguais - pertecem ao
		// mesmo dono
		System.out.println(
				"O carrinho 3 e 4 pertence ao mesmo proprietario? : " + carrinhoCliente3.equals(carrinhoCliente4));

		// Invalidando o carrinho do cliente1
		carrinhoComprasFactory.invalidar(cliente1);
	}

}
