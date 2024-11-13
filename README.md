
# Desafio: Testes de API com RestAssured




<h2>Requisitos que satisfazem o desafio proposto:</h2>

<p>
Projeto de filmes com avaliações, onde a visualização dos dados dos filmes deve ser pública e não requer login. No entanto, interações como inserção, atualização e deleção serão permitidas apenas para usuários com perfil ADMIN. As avaliações de filmes podem ser registradas por qualquer usuário logado, seja CLIENT ou ADMIN. Obs.: Apenas as interações de listar e inserir filmes serão avaliadas.

As notas atribuídas devem variar de 0 a 5 por usuário logado. Sempre que um usuário registra uma nota, o sistema recalcula a média das notas de todos os usuários e atualiza a média na entidade Movie, juntamente com a contagem das notas. Apenas o usuário que registrou a nota poderá atualizá-la posteriormente.

O projeto (Spring Boot com Java) e os testes com RestAssured devem ser desenvolvidos de acordo com as especificações dos testes fornecidas pelo avaliador. O avaliado pode optar por desenvolver os testes ou o projeto primeiro, desde que entregue o projeto com todos os testes aprovados.
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
Objetivo: Garantir que a API funcione corretamente e retorne uma lista de filmes completa sem filtros.

- MovieController.findAll() deve retornar 200 e filmes paginados quando o parâmetro de título do filme não estiver vazio.
Objetivo: Verificar se a busca por título retorna resultados paginados corretamente, mostrando que a funcionalidade de filtragem está operando como esperado.

- MovieController.findById(id) deve retornar 200 e um filme quando o ID existir.
Objetivo: Validar que a busca por um filme específico com um ID existente retorne corretamente o filme solicitado.

- MovieController.findById(id) deve retornar 404 e lançar ResourceNotFoundException (personalizada) quando o ID não existir.
Objetivo: Verificar que a API trata adequadamente casos onde o ID fornecido não corresponde a nenhum filme, retornando a exceção personalizada.

- MovieController.insert(dto) deve retornar 422 e UnprocessableEntity quando o administrador estiver logado e o título estiver em branco.
Objetivo: Assegurar que o título do filme seja um campo obrigatório e que falhas de validação sejam tratadas corretamente.

- MovieController.insert(dto) deve retornar 403 (Forbidden) quando o cliente estiver logado.
Objetivo: Confirmar que apenas administradores possam inserir novos filmes, e que tentativas feitas por clientes resultem em 403 Forbidden.

- MovieController.insert(dto) deve retornar 401 (Unauthorized) quando o token for inválido.
Objetivo: Garantir que a autenticação esteja funcionando corretamente, e que requisições sem token ou com um token inválido sejam bloqueadas.

- ScoreController.saveScore(dto) deve retornar 404 e lançar ResourceNotFoundException (personalizada) quando o ID do filme não existir.
Objetivo: Assegurar que a API responda adequadamente quando um ID de filme inexistente é fornecido ao tentar salvar uma pontuação.

- ScoreController.saveScore(dto) deve retornar 422 e UnprocessableEntity quando o ID do filme estiver ausente.
Objetivo: Verificar que a API valide a presença do ID do filme no dto e retorne 422 caso ele esteja ausente.

- ScoreController.saveScore(dto) deve retornar 422 e UnprocessableEntity quando a pontuação for menor que zero.
Objetivo: Garantir que a API faça a validação de pontuação e retorne um erro de 422 quando uma pontuação inválida é fornecida.

- ScoreController.updateScore(dto) deve retornar 422 e UnprocessableEntity quando o ID do filme estiver ausente.
Objetivo: Validar que a API retorne 422 Unprocessable Entity quando o movieId está ausente no payload ao atualizar a pontuação.

- ScoreController.updateScore(dto) deve retornar 403 (Forbidden) quando o userId não corresponder ao usuário logado.
Objetivo: Verificar que a API retorne 403 Forbidden quando um usuário tentar atualizar uma pontuação que não pertence a ele.

- ScoreController.updateScore(dto) deve retornar 422 e UnprocessableEntity quando a pontuação for menor que zero.
Objetivo: Assegurar que a API valide corretamente a pontuação e retorne 422 quando o valor for inválido.

- ScoreController.updateScore(dto) deve retornar 200 (OK) quando a pontuação for válida e o usuário autenticado for o mesmo que avaliou o filme.
Objetivo: Verificar que a API retorne 200 OK ao atualizar uma pontuação de forma válida, assegurando que apenas o usuário que fez a avaliação original possa atualizá-la.


   <p>

 </p>
 <h2>Ferramentas utilizadas: </h2>
  <p>

<p>🚀 1 - Java 21</p>

<p>🚀 2 - Spring Boot 3.2.5</p>

<p>🚀 3 - Spring Data</p>

<p> 4 - PostgreSQL(perfil/dev)</p>

<p>🚀 5 - RestAssured</p>

<p>🚀 6 - Spring Validation</p>

<p> 7 - Jacoco</p>

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

<h3>Maior Desafio Superado: </h3>
 <p></p>

 <h3>Maior Apredizado: </h3>
 <p>Utilizar a metodologia TDD sem dúvidas foi o maior desafio</p>

 <h3>Algum dos requisitos que não foi desenvolvido? Se sim, explique o motivo. </h3>
 <p>Todos os requisitos foram atendidos.</p>

 <h3>Pesquisas, projetos ou cursos de Referência: </h3>
 <p></p>


<p >
<a href="https://devsuperior.club/c/6-61">🔗 JavaSpringExpert </a>
 </p>

<p >
<a href="https://devsuperior.club/c/5-61">🔗 JavaSpringProfessional</a>
 </p>

 <p >
<a href="https://learn.devsuperior.com/certificados/7165816">🔗 Bootcamp Spring edição 3.0.</a>
 </p>


<p >
<a href="https://github.com/anapedra/commerce.git">🔗 commerce </a>
 </p>

<p >
<a href="https://github.com/anapedra/desafio-jacoco">🔗 desafio-jacoco</a>
 </p>

 <p >
<a href="https://github.com/anapedra/bds-0006.git">🔗 bds-6</a>
 </p>


<h3>Autora:</h3>

<p>Ana Santana</P>

<h3>Email: </h>
<p>anapedra.mil@gmail.com</P>


<h3>WhatsApp.: </h3>
<p>55619993347731</P>


<h3>Lnkedin:</h3>
<p>https://www.linkedin.com/in/anasantana/</P>



<h3>Próximo desafio:</h3>

<p>Estruturas de Dados e Algoritmos Expert</p>
<p >
 Com DevSuperior e Jornada Dev Eficiente
 </p>




