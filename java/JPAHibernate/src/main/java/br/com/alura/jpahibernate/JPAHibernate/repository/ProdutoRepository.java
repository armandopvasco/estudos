package br.com.alura.jpahibernate.JPAHibernate.repository;

import br.com.alura.jpahibernate.JPAHibernate.model.Pedido;
import br.com.alura.jpahibernate.JPAHibernate.model.Produto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("select p from Produto p where p.preco >= :val41")
    List<Produto> buscaProdutosPrecoMaiorQueValor(Double val41);

    @Query("select p from Produto p order by p.preco asc ")
    List<Produto> buscaProdutosOrdemValor();

    @Query("select p from Produto p order by p.preco desc ")
    List<Produto> buscaProdutosOrdemValorDec();

    @Query("select p from Produto p where p.nome ILIKE :letra44% ")
    List<Produto> buscaProdutosPrimeiraLetra(@Param("letra44") String letra44);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :letra%")
    List<Produto> buscarProdutosPorLetraInicial(@Param("letra") String letra);

    @Query("SELECT avg(p.preco) FROM Produto p ")
    Object mediaPrecos();

    @Query("SELECT max(p.preco) FROM Produto p where p.categoria.id = :idCategoria47 ")
    Double precoMaxCategoria(long idCategoria47);

    @Query("SELECT p FROM Produto p WHERE (:nome IS NULL OR p.nome = :nome) AND (:categoria IS NULL OR p.categoria.nome = :categoria)")
    List<Produto> buscarProdutosFiltrados(@Param("nome") String nome, @Param("categoria") String categoria);

    @Query(value = "SELECT * FROM produto order by valor desc limit 5 ", nativeQuery = true)
    List<Produto> top5ProdMaisCaros();
}
