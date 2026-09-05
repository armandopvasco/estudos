package br.com.alura.jpahibernate.JPAHibernate.repository;

import br.com.alura.jpahibernate.JPAHibernate.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
