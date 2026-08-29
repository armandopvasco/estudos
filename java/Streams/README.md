# estudos_java_streams
Repositórios para guardar conteúdos dos meus estudos relacionados a linguagem de programação JAVA (STREAMS).

Esse é um projeto onde foram realizadas algumas questões relacionadas a STREAMS.

STREAMS:

As streams em Java (introduzidas no Java 8 via Java 8 Streams API) são uma abstração para processar sequências de elementos de forma declarativa e funcional.

Elas não são estruturas de dados que armazenam valores, mas sim um fluxo de dados que permite aplicar operações de alta performance (como filtrar, mapear e reduzir) em coleções de forma limpa e concisa.

Principais Características:
Não armazenam dados: Operam sobre uma fonte de dados (como listas ou arrays) e realizam cálculos no próprio fluxo.

Abordagem declarativa: Você diz o que quer fazer (ex: filtrar itens maiores que 10), e não como fazer (evitando loops for tradicionais).

Avaliação preguiçosa (Lazy Evaluation): As operações intermediárias não são executadas na hora; elas só rodam quando uma operação final é acionada.

Processamento Paralelo: Permite rodar operações usando múltiplos núcleos do processador com pouquíssimo código.

Como Funciona o Pipeline:

Um uso de stream divide-se em três partes:

Fonte: De onde vêm os dados (ex: lista.stream()).

Operações Intermediárias: Transformam o fluxo e retornam outra stream (ex: .filter(), .map()).

Operação fINAL/Terminal: Encerra o fluxo e gera um resultado ou efeito colateral (ex: .collect(), .forEach(), .count()).

Exemplo prático simples para filtrar nomes que começam com a letra "A":

javaList<String> nomes = Arrays.asList("Ana", "Bruno", "Amanda", "Carlos");
List<String> resultado = nomes.stream()
    .filter(n -> n.startsWith("A"))
    .collect(Collectors.toList());