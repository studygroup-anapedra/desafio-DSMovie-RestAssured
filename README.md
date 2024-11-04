
# Desafio: Testes de API com RestAssured




<h2>Requisitos que satisfazem o desafio proposto:</h2>

<p>
Projeto de filmes com avaliações, onde as visualizações dos dados dos filmes devem ser públicas e não requerem login. No entanto, as alterações de filmes, como inserir, atualizar e deletar, serão permitidas apenas para usuários com perfil ADMIN. As avaliações de filmes podem ser registradas por qualquer usuário logado, seja CLIENT ou ADMIN.

A entidade Score deverá armazenar uma nota de 0 a 5, que será a média das notas que os usuários atribuem a cada filme. Sempre que um usuário registra uma nota, o sistema recalcula a média das notas de todos os usuários e atualiza a nota média na entidade Movie, juntamente com a contagem de votos.

O projeto (Spring Boot com Java) e os testes com RestAssured deverão ser desenvolvidos a partir das especificações desses testes, fornecidas pelo avaliador. O avaliado pode optar por desenvolver primeiro os testes ou o projeto, contanto que entregue o projeto com todos os testes passando.
 </p>
<p>
 <h2>Competências avaliadas:</h2>
<p>
  - Implementação de testes de APIs com RestAssured.

  - Modelagem em camadas bem definidas.

  - Definição de cardinalidade entre classes.

  - Aplicação de filtros por parâmetros nas requisições.

  - Implementação de segurança na aplicação.

  - Controle de permissões.

  - Autenticação de usuários.

  - Uso do padrão DTO (Data Transfer Object).
</p>


  </p>

  <h2>Especificações de testes que satisfazem o desafio: </h2>
  <p>


- MovieController.findAll() deve retornar 200 (OK) quando nenhum argumento for fornecido.

- MovieController.findAll() deve retornar 200 e filmes paginados quando o parâmetro de título do -   filme não estiver vazio.

- MovieController.findById(id) deve retornar 200 e um filme quando o id existir.

- MovieController.findById(id) deve retornar 404 e lançar ResourceNotFoundException(personalizada) quando o id não existir.

- MovieController.insert(dto) deve retornar 422 e UnprocessableEntity quando o administrador estiver logado e o título estiver em branco.

- MovieController.insert(dto) deve retornar 403 (Forbidden) quando o cliente estiver logado.

- MovieController.insert(dto) deve retornar 401 (Unauthorized) quando o token for inválido.

- ScoreController.saveScore(dto) deve retornar 404 e lançar ResourceNotFoundException(personalizada) quando o id do filme não existir.

- ScoreController.saveScore(dto) deve retornar 422 e UnprocessableEntity quando o id do filme estiver ausente.

- ScoreController.saveScore(dto) deve retornar 422 e UnprocessableEntity quando a pontuação for menor que zero.


   <p>

 </p>
 <h2>Ferramentas utilizadas: </h2>
  <p>

<p>🚀 1 - Java 21</p>

<p>🚀 2 - Spring Boot 3.2.5</p>

<p>🚀 3 - Spring Data</p>

<p>🚀 4 - PostgreSQL(perfil/dev)</p>

<p>🚀 5 - RestAssured</p>

<p>🚀 6 - Spring Validation</p>

<p>🚀 7 - Jacoco</p>

<p>🚀 8 - Postman</p>

<p>🚀 9 - Estilo Arquitetural REST</p>

<p>🚀 10 - Maven</p>

<p>🚀 11 - JPA</p>

<p>🚀 12 - Linux</p>

<p>🚀 13 - IntelliJ</p>

<p>🚀 14 - VS Code</p>

<p>🚀 15 - H2 (perfil/test)</p>

<p>🚀 16 - Spring Security</p>

<p>🚀 17 - JUnit 5</p>

<p>🚀 18 - OAuth2</p>

<p>🚀 19 - Git/GitHub</p>

<p>🚀 20 - Commits com Assinaturas</p>

<p>🚀 21 - Code Review</p>

<p>🚀 23 - Proteção de Branches</p>

<p>🚀 24 - Pull Request</p>

  <p >

 </p>

 </p>
 <h2>Sobre a implementação: </h2>
  <p>

  <p >

 </p>


<h3>Maior Desafio Superado: </h3>
 <p></p>

 <h3>Maior Apredizado: </h3>
 <p></p>

 <h3>Algum dos requisitos que não foi desenvolvido? Se sim, explique o motivo. </h3>
 <p></p>

 <h3>Pesquisas, projetos ou cursos de Referência: </h3>
 <p></p>


<p >
<a href="">🔗  </a>
 </p>

<p >
<a href="">🔗 </a>
 </p>


<p >
<a href="">🔗 </a>
 </p>

<p >
<a href="">🔗 </a>
 </p>


<h3>Autora:</h3>

<p>Ana Santana</P>

<h3>Email: </h>
<p>anapedra.mil@gmail.com</P>


<h3>Phone: </h3>
<p>55619993347731</P>


<h3>Lnkedin:</h3>
<p>https://www.linkedin.com/in/anasantana/</P>



<h3>Próximo desafio:</h3>

<p></p>
<p >
<a href="">🔗
</a>
 </p>




