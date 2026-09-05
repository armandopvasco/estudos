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
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JPAHibernateApplication implements CommandLineRunner {

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
		System.out.println("CAPÍTULO 1: Exercícios - Criar as classes Produto, Pedido e Categoria e inserir um registro de cada utilizando JPA");
		Categoria categoria1 = new Categoria(4L, "Categoria 3");
		repositorioCategoria.save(categoria1);
		System.out.println("Categoria salva com sucesso");

		Fornecedor fornecedor1 = new Fornecedor("Fornecedor 1");
		repositorioFornecedor.save(fornecedor1);
		System.out.println("Fornecedor salvo com sucesso");

		Produto produto1 = new Produto("Produto 10", 10.50, categoria1);
		Produto produto2 = new Produto("Produto 11", 10.0, categoria1);
		Produto produto3 = new Produto("Produto 13", 20.0, categoria1);
		produto1.setFornecedore(fornecedor1);
		produto2.setFornecedore(fornecedor1);
		produto3.setFornecedore(fornecedor1);
		List<Produto> produtos = new ArrayList<>();
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		repositorioProduto.saveAll(produtos);
		System.out.println("Produto salvo com sucesso");

		Pedido pedido1 = new Pedido(1L, LocalDate.now());
		pedido1.setProdutos(produtos);
		repositorioPedido.save(pedido1);
		System.out.println("Pedido e seus produtos salvos com sucesso");
	}
}
