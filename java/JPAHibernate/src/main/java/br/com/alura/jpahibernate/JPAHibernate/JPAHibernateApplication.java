package br.com.alura.jpahibernate.JPAHibernate;

import br.com.alura.jpahibernate.JPAHibernate.model.Categoria;
import br.com.alura.jpahibernate.JPAHibernate.model.Fornecedor;
import br.com.alura.jpahibernate.JPAHibernate.model.Pedido;
import br.com.alura.jpahibernate.JPAHibernate.model.Produto;
import br.com.alura.jpahibernate.JPAHibernate.repository.CategoriaRepository;
import br.com.alura.jpahibernate.JPAHibernate.repository.FornecedorRepository;
import br.com.alura.jpahibernate.JPAHibernate.repository.PedidoRepository;
import br.com.alura.jpahibernate.JPAHibernate.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootApplication
public class JPAHibernateApplication implements CommandLineRunner {

	private Scanner leitura = new Scanner(System.in);
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(JPAHibernateApplication.class, args);
	}
	@Autowired
	public ProdutoRepository repositorioProduto;
	@Autowired
	public PedidoRepository repositorioPedido;
	@Autowired
	public CategoriaRepository repositorioCategoria;
	@Autowired
	public FornecedorRepository repositorioFornecedor;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CAPÍTULO 1, 2:Utilizando JPA");
		//Comentado códigos das INCLUSÕES, pois nosso banco de dados já está alimentado
		//e no CAPÍTULO 3 precisamos exercitar as pesquisas
//		Categoria categoria1 = new Categoria(4L, "Categoria 3");
//		repositorioCategoria.save(categoria1);
//		System.out.println("Categoria salva com sucesso");
//
//		Fornecedor fornecedor1 = new Fornecedor("Fornecedor 1");
//		repositorioFornecedor.save(fornecedor1);
//		System.out.println("Fornecedor salvo com sucesso");
//
//		Produto produto1 = new Produto("Produto 10", 10.50, categoria1);
//		Produto produto2 = new Produto("Produto 11", 10.0, categoria1);
//		Produto produto3 = new Produto("Produto 13", 20.0, categoria1);
//		produto1.setFornecedore(fornecedor1);
//		produto2.setFornecedore(fornecedor1);
//		produto3.setFornecedore(fornecedor1);
//		List<Produto> produtos = new ArrayList<>();
//		produtos.add(produto1);
//		produtos.add(produto2);
//		produtos.add(produto3);
//		repositorioProduto.saveAll(produtos);
//		System.out.println("Produto salvo com sucesso");
//
//		Pedido pedido1 = new Pedido(1L, LocalDate.now());
//		pedido1.setProdutos(produtos);
//		repositorioPedido.save(pedido1);
//		System.out.println("Pedido e seus produtos salvos com sucesso");

		System.out.println("\nCAPÍTULO 3: Utilizando pesquisas com DERIVED QUERIES");
		System.out.println("\n1 - Retorne todos os produtos com o nome exato fornecido.");
		System.out.println("Informe o nome do produto para uma busca exata:");
		var nomeProd = leitura.nextLine();
		Optional<Produto> p1 = repositorioProduto.findByNome(nomeProd);

		if (p1.isPresent()) {
			System.out.println(p1.get());
		} else {
			System.out.println("Produto não encontrado!");
		}

		System.out.println("\n2 - Retorne todos os produtos associados a uma categoria específica.");
		System.out.println("Lista de categorias:");
		repositorioCategoria.findAll().stream().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
		System.out.println("Informe o ID da categoria para buscar os produtos associados a ela:");
		var idCategoria = leitura.nextLong();
		List<Produto> listaP2 = repositorioProduto.findByCategoria_IdEquals(idCategoria);
		System.out.println("Produtos associados a categoria:");
		listaP2.forEach(System.out::println);

		System.out.println("\n3 - Retorne produtos com preço maior que o valor fornecido.");
		System.out.println("Informe o preço para buscar os produtos:");
		var preco3 = leitura.nextDouble();
		List<Produto> listaP3 = repositorioProduto.findByPrecoGreaterThan(preco3);
		System.out.println("Produtos com preço maior que " + preco3 + ": ");
		listaP3.forEach(System.out::println);

		System.out.println("\n4 - Retorne produtos com preço menor que o valor fornecido.");
		System.out.println("Informe o preço para buscar os produtos:");
		var preco4 = leitura.nextDouble();
		List<Produto> listaP4 = repositorioProduto.findByPrecoLessThan(preco4);
		System.out.println("Produtos com preço menor que " + preco4 + ": ");
		listaP3.forEach(System.out::println);

		System.out.println("\n5 - Retorne produtos cujo nome contenha o termo especificado.");
		System.out.println("Informe parte do nome do produto para buscar os produtos:");
		var nome5 = leitura.nextLine();
		List<Produto> listaP5 = repositorioProduto.findByNomeContainingIgnoreCase(nome5);
		System.out.println("Produtos que contém o texto \"" + nome5 + "\" em seu nome: ");
		listaP5.forEach(System.out::println);

		System.out.println("\n6 - Retorne pedidos que ainda não possuem uma data de entrega.");
		System.out.println("Pedidos sem data de entrega:");
		List<Pedido> listaP6 = repositorioPedido.findByDataNull();
		listaP6.forEach(p -> System.out.println("Pedido: " + p.getId()));

		System.out.println("\n7 - Retorne pedidos com data de entrega preenchida.");
		System.out.println("Pedidos com data de entrega preenchida:");
		List<Pedido> listaP7 = repositorioPedido.findByDataNotNull();
		listaP7.forEach(p -> System.out.println("Pedido: " + p.getId() + " - Data: " + p.getData()));

		System.out.println("\n8 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente.");
		System.out.println("Lista de categorias:");
		repositorioCategoria.findAll().stream().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
		System.out.println("Informe o ID da categoria para buscar os produtos:");
		var idCategoria8 = leitura.nextLong();
		List<Produto> listaP8 = repositorioProduto.findByCategoria_IdEqualsOrderByPrecoAsc(idCategoria8);
		System.out.println("Produtos associados a categoria:");
		listaP8.forEach(System.out::println);

		System.out.println("\n9 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.");
		System.out.println("Lista de categorias:");
		repositorioCategoria.findAll().stream().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
		System.out.println("Informe o ID da categoria para buscar os produtos:");
		var idCategoria9 = leitura.nextLong();
		List<Produto> listaP9 = repositorioProduto.findByCategoria_IdEqualsOrderByPrecoDesc(idCategoria9);
		System.out.println("Produtos associados a categoria:");
		listaP9.forEach(System.out::println);

		System.out.println("\n10 - Retorne a contagem de produtos em uma categoria específica.");
		System.out.println("Lista de categorias:");
		repositorioCategoria.findAll().stream().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
		System.out.println("Informe o ID da categoria para buscar a quantidade de produtos:");
		var idCategoria10 = leitura.nextLong();
		Long qtd10 = repositorioProduto.countByCategoria_IdEquals(idCategoria9);
		System.out.println("Existem " + qtd10 + " produtos associados a categoria " + idCategoria10);

		System.out.println("\n11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.");
		System.out.println("Informe o preço:");
		var preco11 = leitura.nextDouble();
		long qtd11 = repositorioProduto.countByPrecoGreaterThan(preco11);
		System.out.println("Quantidade de produtos com preço maior que " + preco11 + " é de " + qtd11);

		System.out.println("\n12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.");
		System.out.println("Informe o preço:");
		var preco12 = leitura.nextDouble();
		System.out.println("Informe parte do nome:");
		var nome12 = leitura.nextLine();
		List<Produto> listaP12 = repositorioProduto.findByPrecoLessThanOrNomeContaining(preco12, nome12);
		listaP12.forEach(System.out::println);

		System.out.println("\n13 - Retorne pedidos feitos após uma data específica.");
		System.out.println("Informa uma data:");
		var data13Str = leitura.nextLine();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		var data123 = LocalDate.parse(data13Str,formato);
		List<Pedido> listaP13 = repositorioPedido.findByDataGreaterThanEqual(data123);
		listaP13.forEach(p -> System.out.println("Pedido: " + p.getId() + " - Data: " + p.getData()));

		System.out.println("\n14 - Retorne pedidos feitos antes de uma data específica.");
		System.out.println("Informa uma data:");
		var data14Str = leitura.nextLine();
		var data14 = LocalDate.parse(data14Str,formato);
		List<Pedido> listaP14 = repositorioPedido.findByDataLessThanEqual(data14);
		listaP14.forEach(p -> System.out.println("Pedido: " + p.getId() + " - Data: " + p.getData()));

		System.out.println("\n15 - Retorne pedidos feitos em um intervalo de datas.");
		System.out.println("Informa a primeira data:");
		var data15Str = leitura.nextLine();
		System.out.println("Informa a segunda data:");
		var data15Str2 = leitura.nextLine();
		var data15 = LocalDate.parse(data15Str,formato);
		var data152 = LocalDate.parse(data15Str2,formato);
		List<Pedido> listaP15 = repositorioPedido.findByDataBetween(data15, data152);
		listaP15.forEach(p -> System.out.println("Pedido: " + p.getId() + " - Data: " + p.getData()));

		System.out.println("\n16 - Retorne os três produtos mais caros.");
		List<Produto> listaP16 = repositorioProduto.findTop3ByOrderByPrecoDesc();
		listaP16.forEach(System.out::println);

		System.out.println("\n17 - Retorne os cinco produtos mais baratos de uma categoria.");
		List<Produto> listaP17 = repositorioProduto.findTop5ByOrderByPrecoAsc();
		listaP17.forEach(System.out::println);

		System.out.println("\nCAPÍTULO 4: Utilizando JPQL");
		System.out.println("\n1 - Crie uma consulta que retorne os produtos com preço maior que um valor");
		System.out.println("Informe um valor: ");
		Double val41 = leitura.nextDouble();
		List<Produto> produtos41 = repositorioProduto.buscaProdutosPrecoMaiorQueValor(val41);
		produtos41.forEach(System.out::println);

		System.out.println("\n2 - Crie uma consulta que retorne os produtos ordenados pelo preço crescente.");
		List<Produto> produtos42 = repositorioProduto.buscaProdutosOrdemValor();
		produtos42.forEach(System.out::println);

		System.out.println("\n3 - Crie uma consulta que retorne os produtos ordenados pelo preço decrescente.");
		List<Produto> produtos43 = repositorioProduto.buscaProdutosOrdemValorDec();
		produtos43.forEach(System.out::println);

		System.out.println("\n4 - Crie uma consulta que retorne os produtos que comecem com uma letra específica.");
		System.out.println("Informe uma letra: ");
		var letra44 = leitura.nextLine();
		//OBS.: Não rodou como esperado
		List<Produto> produtos44 = repositorioProduto.buscaProdutosPrimeiraLetra("G");
		produtos44.forEach(System.out::println);

		System.out.println("\n5 - Crie uma consulta que retorne os pedidos feitos entre duas datas.");
		System.out.println("Digite a data inicial:");
		var dtIni45 = leitura.nextLine();
		LocalDate dtI45 = LocalDate.parse(dtIni45,formato);
		System.out.println("Digite a data final:");
		var dtFin45 = leitura.nextLine();
		LocalDate dtF45 = LocalDate.parse(dtFin45,formato);
		List<Pedido> pedidos45 = repositorioPedido.buscaPedidoEntreDatas(dtI45, dtF45);
		pedidos45.forEach(p -> System.out.println(p.getId() + " - " +p.getData()));

		System.out.println("\n6 - Crie uma consulta que retorne a média de preços dos produtos.");
		var media46 = repositorioProduto.mediaPrecos();
		System.out.println("Média: " + media46);

		System.out.println("\n7 - Crie uma consulta que retorne o preço máximo de um produto em uma categoria");
		System.out.println("Lista de categorias:");
		repositorioCategoria.findAll().stream().forEach(c -> System.out.println(c.getId() + " - " + c.getNome()));
		System.out.println("Informe o ID da categoria para buscar o preço máximo:");
		var idCategoria47 = leitura.nextLong();
		Double prc47 = repositorioProduto.precoMaxCategoria(idCategoria47);
		System.out.println("Preço másximo: " + prc47);

		System.out.println("\n8 - Crie uma consulta para contar o número de produtos por categoria.");
		List<Object[]> result48 = repositorioCategoria.contarProdutosPorCategoria();
		result48.forEach(r -> System.out.println((String) r[0] + " - " +(Number) r[1]));

		System.out.println("\n9 - Crie uma consulta para filtrar categorias com mais de 10 produtos.");
		List<Object[]> cats49 =  repositorioCategoria.categoriasComMaisDeDezProdutos();
		cats49.forEach(c -> System.out.println("Categorias com mais de 6 produtos: " + (String) c[0]));

		System.out.println("\n10 - Crie uma consulta para retornar os produtos filtrados por nome ou por categoria.");
		List<Produto> prods4102 = repositorioProduto.buscarProdutosFiltrados("Produto 8", null);
		List<Produto> prods410 = repositorioProduto.buscarProdutosFiltrados(null, "Categoria 2");
		System.out.println("Por produto de nome 'Produto 8':");
		prods4102.forEach(System.out::println);
		System.out.println("Por categoria de nome 'Categoria 2':");
		prods410.forEach(System.out::println);

		System.out.println("\n11 - Crie uma consulta nativa para buscar os cinco produtos mais caros");
		List<Produto> prod411 = repositorioProduto.top5ProdMaisCaros();
		prod411.forEach(System.out::println);
	}
}
