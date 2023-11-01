## Lab3_1 alinea c)

### Pergunta 1
A instância de "userRepository" é criada automaticamente pelo Spring Framework por meio da anotação @Repository na interface "UserRepository". O Spring gerencia a criação e o ciclo de vida desses componentes, permitindo que a classe "UserController" acesse e utilize o repositório por meio da injeção de dependência realizada com a anotação @Autowired no construtor da classe. Isso simplifica o gerenciamento de dependências e torna o código mais flexível e desacoplado.

### Pergunta 2

No objeto "userRepository" invocado pela "UserController," são chamados os seguintes métodos:

- **save(user)** para salvar um usuário.
- **findAll()** para buscar todos os usuários.
- **findById(id)** para buscar um usuário pelo ID.
- **delete(user)** para excluir um usuário.

Esses métodos são definidos na interface "UserRepository" que estende a interface "CrudRepository" do Spring Data. A implementação concreta desses métodos é fornecida pelo Spring Data JPA, que gera automaticamente consultas SQL com base nos nomes dos métodos definidos na interface, simplificando a interação com o banco de dados.

### Pergunta 3
Os dados estão sendo salvos em um banco de dados H2 em memória, que é incorporado e usado para desenvolvimento e testes.

### Pergunta 4
A regra de "not empty" para o endereço de email é definida acima do campo "email" na classe "User" por meio da anotação @NotBlank do Jakarta Validation. Ela indica que o campo de email não pode estar em branco (vazio).