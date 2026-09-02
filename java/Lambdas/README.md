# LAMBDAS
Repositórios para guardar conteúdos dos meus estudos relacionados a linguagem de programação JAVA (LAMBDAS).

Esse é um projeto onde foram realizadas algumas questões relacionadas as funções LAMBDA.

## CONCEITO (Algumas informações obtidas em pesquisa numa IA):

Funções lambda em Java (também conhecidas como Expressões Lambda) são blocos de código curtos e sem nome próprio que podem receber argumentos e retornar um valor. Elas foram introduzidas no Java 8 para deixar a escrita de programas mais limpa, rápida e próxima da programação funcional.

- Como funciona a sintaxe:
A estrutura básica de uma expressão lambda usa o operador de seta ->:
(argumentos) -> { corpo da função }

	- Argumentos: Os dados que a função recebe (podem ser vazios (), um único valor ou vários separados por vírgula).
	- Seta (->): Separa os argumentos do que o código vai fazer.
	- Corpo: A tarefa ou o cálculo que será executado.

- Principais características:

	- Funções anônimas: Não precisam de um nome fixo nem de modificadores de acesso.
	- Interfaces funcionais: Só funcionam em conjunto com uma interface que possui apenas um método abstrato (como Runnable ou Consumer).
	- Economia de código: Substituem as antigas classes anônimas, que exigiam muitas linhas repetitivas para tarefas simples.

### EXERCÍCIOS:

- 1 - Crie uma expressão lambda que multiplique dois números inteiros. A expressão deve ser implementada dentro de uma interface funcional com o método multiplicacao(int a, int b).

- 2 - Implemente uma expressão lambda que verifique se um número é primo.

- 3 - Crie uma função lambda que receba uma string e a converta para letras maiúsculas.

- 4 - Crie uma expressão lambda que verifique se uma string é um palíndromo. A expressão deve ser implementada dentro de uma interface funcional com o método boolean verificarPalindromo(String str). Dica: utilize o método reverse da classe StringBuilder.

- 5 - Implemente uma expressão lambda que recebe uma lista de inteiros e retorna uma nova lista onde cada número foi multiplicado por 3. Dica: a função replaceAll, das Collections, recebe uma interface funcional como parâmetro, assim como vimos na função forEach.

- 6 - Crie uma expressão lambda que ordene uma lista de strings em ordem alfabética. Dica: a função sort, das Collections, recebe uma interface funcional como parâmetro, assim como vimos na função forEach.

- 7 - Crie uma função lambda que recebe dois números e divide o primeiro pelo segundo. A função deve lançar uma exceção de tipo ArithmeticException se o divisor for zero.