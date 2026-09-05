package br.com.alura.jpahibernate.JPAHibernate.repository;

import br.com.alura.jpahibernate.JPAHibernate.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
