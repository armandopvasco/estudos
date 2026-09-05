package br.com.alura.jpahibernate.JPAHibernate.repository;

import br.com.alura.jpahibernate.JPAHibernate.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
