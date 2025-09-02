# 📽️ Projeto Filmes com Gson

Este é um mini projeto em **Java com Maven**, que demonstra como usar a
biblioteca **Gson** para converter objetos em JSON.\
O programa cria objetos da classe `Filme`, transforma em JSON formatado
e salva em um arquivo `filmes.json`.

> Obs: o arquivo `filmes.json` gerado está no `.gitignore`, pois é
> apenas saída do programa e pode ser recriado a qualquer momento.

------------------------------------------------------------------------

## 🚀 Tecnologias

-   **Java 17+** (ou superior)\
-   **Maven**\
-   **Gson (Google)**\
-   **maven-assembly-plugin** (para gerar `.jar` executável com
    dependências)

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

-   **`Filme`** → representa um filme com título, ano, gênero e
    diretor.\
-   **`ListaFilmes`** → gerencia a lista de filmes em memória
    (adicionar, limpar e recuperar filmes).\
-   **`FilmesJson`** → classe responsável pela persistência em JSON, ou
    seja, salvar e carregar filmes em arquivos `.json`.

------------------------------------------------------------------------

## ❓ Por que criar a classe `FilmesJson`?

Inicialmente, a ideia era salvar os filmes direto dentro da classe
`ListaFilmes`.\
No entanto, isso faria a classe ter **duas responsabilidades
diferentes**:\
Além disso, quando testei a parte de gerar arquivo estava dando erro, como o GSON estava instanciado dentro da propria classe filme,quando
o GSON tentava criar um arquivo ele tentava passar ele mesmo para JSON e retornava uma exceção.
1. Gerenciar a lista de filmes em memória.\
2. Lidar com a persistência (arquivos JSON).

Isso iria contra o **princípio da responsabilidade única (SRP - Single
Responsibility Principle)** da programação orientada a objetos.

👉 Por isso, foi criada a classe **`FilmesJson`**, que tem como única
função salvar e ler arquivos JSON usando Gson.\
Assim:\
- `ListaFilmes` → cuida apenas da lista em memória.\
- `FilmesJson` → cuida apenas do arquivo JSON.

Essa separação melhora a **organização**, facilita os **testes
unitários** e torna o código **mais reutilizável e limpo**.

------------------------------------------------------------------------

## 🧪 Testes Implementados

Os testes (JUnit 5) garantem o funcionamento correto do sistema:\
- Verificar se `criarFilme()` realmente adiciona um filme.\
- Garantir que a lista inicia vazia.\
- `getFilmes()` nunca retorna `null`.\
- Ordem de inserção dos filmes é mantida.\
- Após `limparListaFilmes()`, o tamanho da lista volta a `0`.\
- Arquivos JSON são corretamente sobrescritos quando uma nova lista é
salva.
- Testa a veracidade das informações passadas quando um filme é criado
- Garante que a lista de filmes funcione conforme o esperado
------------------------------------------------------------------------

## 📉 Regressão e Correção

Durante o desenvolvimento, foi introduzida uma **regressão** quando o código foi modificado em dupla.  
Essa alteração quebrou parte da funcionalidade do sistema, resultando em falhas nos testes automatizados.  

A correção foi feita revertendo o código ao estado funcional anterior e garantindo que todos os testes voltassem a passar. 
