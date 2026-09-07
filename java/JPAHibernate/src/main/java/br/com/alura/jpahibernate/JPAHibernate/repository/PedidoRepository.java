package br.com.alura.jpahibernate.JPAHibernate.repository;

import br.com.alura.jpahibernate.JPAHibernate.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByDataNull();

    List<Pedido> findByDataNotNull();

    List<Pedido> findByDataGreaterThanEqual(LocalDate data123);

    List<Pedido> findByDataLessThanEqual(LocalDate data123);

    List<Pedido> findByDataBetween(LocalDate dataAfter, LocalDate dataBefore);

    @Query("select p from Pedido p where p.data >= :dtIni45 and p.data <= :dtFin45 ")
    List<Pedido> buscaPedidoEntreDatas(LocalDate dtIni45, LocalDate dtFin45);
}
