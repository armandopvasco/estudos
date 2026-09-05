package br.com.alura.jpahibernate.JPAHibernate;

import br.com.alura.jpahibernate.JPAHibernate.model.Categoria;
import br.com.alura.jpahibernate.JPAHibernate.model.Pedido;
import br.com.alura.jpahibernate.JPAHibernate.model.Produto;
import br.com.alura.jpahibernate.JPAHibernate.repository.CategoriaRepository;
import br.com.alura.jpahibernate.JPAHibernate.repository.PedidoRepository;
import br.com.alura.jpahibernate.JPAHibernate.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

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

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CAPÍTULO 1: Exercícios - Criar as classes Produto, Pedido e Categoria e inserir um registro de cada utilizando JPA");
		Produto produto1 = new Produto("Produto 1", 10.50);
		repositorioProduto.save(produto1);
		System.out.println("Produto 1 salvo com sucesso");

		Pedido pedido1 = new Pedido(1L, LocalDate.now());
		repositorioPedido.save(pedido1);
		System.out.println("Pedido 1 salvo com sucesso");

		Categoria categoria1 = new Categoria(1L, "Categoria 1");
		repositorioCategoria.save(categoria1);
		System.out.println("Categoria 1 salva com sucesso");
	}
}
