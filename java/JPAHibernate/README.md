# JPA e Hibernate
Repositórios para guardar conteúdos dos meus estudos relacionados a linguagem de programação JAVA (JPA e Hibernate).

Esse é um projeto onde foram realizadas algumas questões relacionadas a JPA e Hibernate.

## CONCEITOS:

O Spring Data JPA, o JPA e o Hibernate formam a pilha tecnológica padrão para gerenciar dados em bancos relacionais no ecossistema Java. O JPA define o padrão de regras, o Hibernate executa as operações fazendo a ponte com o banco, e o Spring Boot automatiza toda a configuração inicial.

Você pode iniciar um projeto estruturado rapidamente utilizando a ferramenta oficial de geração de projetos no Spring Initializr (https://start.spring.io/).

###Entendendo os Conceitos:

- JPA (Jakarta/Java Persistence API): É apenas uma especificação (um conjunto de regras e interfaces) de como os dados em objetos Java devem ser salvos em tabelas relacionais. Ela não faz nada sozinha.
- Hibernate: É a implementação concreta da JPA. Ele transforma as chamadas orientadas a objetos em comandos SQL reais enviados ao banco de dados.
- Spring Data JPA: É uma camada acima do Hibernate que remove códigos repetitivos (boilerplates), permitindo criar operações de banco escrevendo interfaces simples.

###Exemplo Prático e Conceitual:

- 1. Configuração (application.properties):
O Spring Boot gerencia as conexões automaticamente quando você define as propriedades do seu banco no arquivo de configuração:

```java
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

- 2. A Entidade (Modelo):
A classe anotada representa uma tabela no banco de dados relacional:

```java
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    // Construtores, Getters e Setters
}
```

- 3. O Repositório
A interface que herda do Spring Data JPA traz métodos prontos de CRUD (Salvar, Buscar, Deletar):

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Consultas personalizadas podem ser criadas apenas com o nome do método
    Usuario findByNome(String nome);
}
```

## EXERCÍCIOS (CAPÍTULO 1):

Para isso, você pode criar um novo projeto chamado gerenciador-pedidos, onde iremos trabalhar em classes de Produto e Pedido, por exemplo. Seu projeto deve ser do tipo “spring-sem-web” e deve ter as dependências do Spring JPA e do banco de dados PostgreSQL.

Tendo criado o projeto completo e configurado as configurações do banco no application.properties, você pode criar um banco de dados chamado gerenciador-pedidos também, conforme feito em aula.

Feito isso, estamos preparados para exercitar os conhecimentos. Vamos lá?

- 1 - Crie uma classe chamada Produto com os seguintes atributos: id (Long, chave primária) nome (String) preco (Double) Anote a classe com @Entity e mapeie o atributo id como chave primária com @Id. A classe deve ter um construtor e os getters.

- 2 - Modifique o exercício anterior para usar a anotação @GeneratedValue no campo id, com a estratégia de geração automática de identificadores (GenerationType.IDENTITY).

- 3 - Agora, iremos usar vários parâmetros da anotação @Column. Acrescente os seguintes requisitos à classe Produto: O atributo nome deve ser único e não nulo. O atributo preco deve ser armazenado em uma coluna chamada valor.

- 4 - Crie uma classe Categoria com os atributos: id (Long, chave primária) nome (String) A classe deve ter um construtor e os getters. Transforme a classe em entidade.

- 5 - Crie uma classe Pedido com os seguintes atributos: id (Long, chave primária) data (LocalDate) A classe deve ter um construtor e os getters. Transforme a classe em entidade.

- 6 - Execute a aplicação e veja se todas as tabelas foram criadas corretamente. Quando estiver tudo certo, podemos ir para o próximo passo.

- 7 - Agora, iremos querer salvar dados no banco. Por isso, você deve criar vários repositórios diferentes: um para Pedido, outro para Produto e outro para Categoria.

- 8 - Para finalizar, crie um objeto de cada classe e use os repositórios para salvar os dados. Tudo certo para executar os dados? Provavelmente faltará um passo bem importante. Tente se lembrar do que acontece na aula e fazer este último passo. Você também pode analisar o log de erro

Extra (pra quem quer mergulhar mesmo): uma vez que seu programa tiver executado corretamente, você pode testar os vários tipos de GenerationType do id. Adicione vários registros diferentes, comparando como o id é inserido no banco de dados. Na prática, qual a diferença de cada um dos tipos de geração de id?

Faça a mesma coisa para os vários parâmetros de @Column. Como os parâmetros alteram as colunas? Para te ajudar nessa segunda parte, você pode usar alguma ferramenta de IA, pedindo sugestões de casos para testar. Depois, conte para a gente no fórum sobre sua experiência :)

## EXERCÍCIOS (CAPÍTULO 2):

Utilize a aplicação que você criou na lista de exercícios anterior. Vamos lá?

- 1 - Relacione Categoria e Produto usando @OneToMany, permitindo que uma categoria tenha vários produtos. Assim, estamos definindo um relacionamento 1:n do lado da categoria. Aqui, ao salvarmos uma categoria, queremos salvar seus produtos automaticamente também. Faça a configuração necessária para atender a esse requisito.

- 2 - Repare que o relacionamento criado é unidirecional: somente a classe Categoria o enxerga. Podemos deixá-lo bidirecional, configurando um relacionamento do tipo n:1 do lado do Produto, com a anotação @ManyToOne.

- 3 - Na sua classe Principal, você pode criar várias categorias e produtos diferentes e fazer as associações correspondentes. Extra (pra quem quer mergulhar mesmo): Agora, iremos trabalhar com um novo tipo de relacionamento: o relacionamento muitos para muitos, que usa a anotação @ManyToMany.

Para esse relacionamento, geralmente é criada uma tabela intermediária entre as entidades. Pesquise como isso é feito e mapeie um relacionamento do tipo @ManyToMany entre Produto e Pedido, usando uma tabela intermediária. Dica: use a anotação @JoinTable, em conjunto com @JoinColumn.

Depois, associe produtos a pedidos na sua classe Principal.

- 4 - Crie uma nova classe Fornecedor, com os atributos id e nome. Transforme a classe em entidade.

- 5 - Configure um relacionamento unidirecional entre Fornecedor e Produto. O relacionamento deve ser mapeado na classe Produto. Logo, é nessa classe que deverá ter a anotação de relacionamento. Qual é a melhor anotação para usarmos neste caso?

- 6 - Faça as devidas associações entre Fornecedor e Produto na sua classe Principal.