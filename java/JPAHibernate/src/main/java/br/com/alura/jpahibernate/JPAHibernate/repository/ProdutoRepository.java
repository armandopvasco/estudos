package br.com.alura.jpahibernate.JPAHibernate.repository;

import br.com.alura.jpahibernate.JPAHibernate.model.Pedido;
import br.com.alura.jpahibernate.JPAHibernate.model.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNome(String nomeProd);

    List<Produto> findByCategoria_IdEquals(long idCategoria);

    List<Produto> findByPrecoGreaterThan(double preco);

    List<Produto> findByPrecoLessThan(double preco4);

    List<Produto> findByNomeContainingIgnoreCase(String nome5);

    List<Produto> findByCategoria_IdEqualsOrderByPrecoAsc(long idCategoria8);

    List<Produto> findByCategoria_IdEqualsOrderByPrecoDesc(long idCategoria9);

    Long countByCategoria_IdEquals(long idCategoria9);

    Long countByPrecoGreaterThan (Double preco);

    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String nome);

    List<Produto> findTop3ByOrderByPrecoDesc();

    List<Produto> findTop5ByOrderByPrecoAsc();
}
