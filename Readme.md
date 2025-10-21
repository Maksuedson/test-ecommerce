# 📦 API de Produtos - E-commerce

Este projeto é um exemplo de API RESTful desenvolvida em **Spring Boot** para gerenciamento de produtos em um sistema de e-commerce.

A API permite o cadastro, listagem, atualização, exclusão e consulta de produtos por diversos parâmetros, como nome, código de barras ou ID.

---

## 🔧 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Java JWT
- Spring Data JPA
- Banco de Dados (Mysql, H2)
- Lombok
- Maven

---

## 🚀 Endpoints Disponíveis

### 🔹 POST `/api/produtos`
**Cadastrar um novo produto**

**Request Body:**
```json

  {
    "nome": "Notebook Dell Inspiron",
    "descricao": "Notebook com processador Intel i7, 16GB RAM, SSD 512GB",
    "codigoBarras": "7891234567890",
    "preco": 5000,
    "categoria": {
      "id": 1
    },
    "estoque": 15
  }

```
Response:

```json

  {
    "id": "0a7b64e7-bc81-4059-be38-fac791fc5304",
    "nome": "Notebook Dell Inspiron",
    "descricao": "Notebook com processador Intel i7, 16GB RAM, SSD 512GB",
    "codigoBarras": "7891234567890",
    "preco": 5000,
    "categoria": {
      "id": 1,
      "nome": "Eletrônicos",
      "dataCadastro": "2025-10-20T19:21:59"
    },
    "estoque": 15,
    "dataCadastro": "2025-10-20T19:23:01",
    "dataUltimaModificacao": "2025-10-20T19:26:35"
  }
```

🔹 POST /api/produtos/lista
Cadastrar uma lista de produtos


🔹 PUT /api/produtos
Atualizar um produto existente

🔹 GET /api/produtos/{id}
Buscar produto por ID

🔹 GET /api/produtos/nome/{nome}
Buscar produtos por nome (parcial ou completo)

🔹 GET /api/produtos/nome-ou-codigo-barras/{nomeOuCodigoBarras}
Buscar produtos por nome ou código de barras

🔹 GET /api/produtos/codigo-barra/{codigoBarra}
Buscar produto por código de barras

🔹 GET /api/produtos
Listar todos os produtos

🔹 DELETE /api/produtos/{id}
Excluir produto por ID

<br>
🧩 Estrutura de Pacotes graphql
<br>

com.ecommerce.ecommerce
```
├── 📁 controller
│   ├── 📁 request
│   │   ├── ☕ CategoriaRequest.java
│   │   ├── ☕ ClienteRequest.java
│   │   ├── ☕ ItemPedidoRequest.java
│   │   ├── ☕ LoginRequest.java
│   │   ├── ☕ PedidoRequest.java
│   │   └── ☕ ProdutoRequest.java
│   ├── 📁 response
│   │   ├── ☕ CategoriaResponse.java
│   │   ├── ☕ ClienteResponse.java
│   │   ├── ☕ ItemPedidoResponse.java
│   │   ├── ☕ PedidoResponse.java
│   │   ├── ☕ ProdutoResponse.java
│   │   ├── ☕ TokenResponse.java
│   │   └── ☕ UsuarioResponse.java
│   ├── ☕ CategoriaController.java
│   ├── ☕ ClienteController.java
│   ├── ☕ PedidoController.java
│   ├── ☕ ProdutoController.java
│   ├── ☕ RelatorioVendaController.java
│   └── ☕ UsuarioController.java
├── 📁 dto
│   ├── ☕ CategoriaDto.java
│   ├── ☕ ClienteDto.java
│   ├── ☕ ItemPedidoDto.java
│   ├── ☕ Login.java
│   ├── ☕ PedidoDto.java
│   ├── ☕ ProdutoDto.java
│   ├── ☕ TicketMedioUsuarioDto.java
│   ├── ☕ UsuarioDto.java
│   └── ☕ UsuarioRankingDto.java
├── 📁 entity
│   ├── ☕ Categoria.java
│   ├── ☕ Cliente.java
│   ├── ☕ ItemPedido.java
│   ├── ☕ Pedido.java
│   ├── ☕ Produto.java
│   └── ☕ Usuario.java
├── 📁 enums
│   ├── ☕ Pagamento.java
│   ├── ☕ PedidoSituacao.java
│   └── 📄 enums.iml
├── 📁 exception
│   ├── ☕ BadCredentialException.java
│   ├── ☕ GlobalExceptionHandler.java
│   ├── ☕ IntegridadeException.java
│   ├── ☕ NaoAlteradoException.java
│   ├── ☕ NaoEncontradoException.java
│   └── ☕ SqlInterityContraintViolationException.java
├── 📁 infra
│   └── 📁 security
│       ├── ☕ SecurityConfig.java
│       ├── ☕ SecurityFilter.java
│       └── ☕ TokenService.java
├── 📁 mapper
│   ├── ☕ CategoriaMapper.java
│   ├── ☕ ClienteMapper.java
│   ├── ☕ ItemPedidoMapper.java
│   ├── ☕ PedidoMapper.java
│   ├── ☕ ProdutoMapper.java
│   └── ☕ UsuarioMapper.java
├── 📁 report
│   ├── ☕ ItemRelatorioDTO.java
│   └── ☕ VendaRelatorioDTO.java
├── 📁 repository
│   ├── ☕ CategoriaRepository.java
│   ├── ☕ ClienteRepository.java
│   ├── ☕ ItemPedidoRepository.java
│   ├── ☕ PedidoRepository.java
│   ├── ☕ ProdutoRepository.java
│   └── ☕ UsuarioRepository.java
├── 📁 service
│   ├── 📁 impl
│   │   ├── ☕ CategoriaServiceImpl.java
│   │   ├── ☕ ClienteServiceImpl.java
│   │   ├── ☕ PedidoServiceImpl.java
│   │   ├── ☕ ProdutoServiceImpl.java
│   │   └── ☕ UsuarioServiceImpl.java
│   ├── 📁 interfaces
│   │   ├── ☕ CategoriaService.java
│   │   ├── ☕ ClienteService.java
│   │   ├── ☕ PedidoService.java
│   │   ├── ☕ ProdutoService.java
│   │   └── ☕ UsuarioService.java
│   ├── ☕ AuthUserDetailsService.java
│   └── ☕ RelatorioVendaService.java
└── ☕ EcommerceApplication.java
```
<br>
📅 Datas e Campos Importantes
dataCadastro: Data de criação do produto

dataUltimaModificacao: Última data em que o produto foi modificado

codigoBarras: Deve ser único

categoria.id: ID da categoria à qual o produto pertence
<br>
📌 Observações
A categoria deve existir antes de cadastrar um produto.

IDs dos produtos são do tipo UUID.

É possível cadastrar uma lista de produtos via endpoint /lista.
<br>
🧪 Testando a API
Você pode testar os endpoints usando ferramentas como:
<br>
Postman

Insomnia

Bruno

Curl no terminal



## 🔗 Relações entre as Entidades (Tabelas)

### Produto ⇄ Categoria
- **Relação**: Muitos para Um (`@ManyToOne`)
- **Descrição**: Muitos produtos pertencem a uma única categoria.
- **Tabela associada**: A tabela `produto` tem uma `categoria_id` como chave estrangeira para `categoria`.

---

### Pedido ⇄ Cliente
- **Relação**: Muitos para Um (`@ManyToOne`)
- **Descrição**: Muitos pedidos podem ser feitos por um único cliente.

---

### Pedido ⇄ Usuario
- **Relação**: Muitos para Um (`@ManyToOne`)
- **Descrição**: Muitos pedidos podem estar associados a um único usuário (vendedor ou responsável pelo pedido).
- **Detalhe**: O atributo `vendedor` também existe como `String`, mas provavelmente deveria ser substituído pela relação com `Usuario`.

---

### Pedido ⇄ ItemPedido
- **Relação**: Um para Muitos (`@OneToMany`)
- **Descrição**: Um pedido possui muitos itens (`items`).
- **Observação**: Os itens são persistidos e removidos junto com o pedido (`Cascade + OrphanRemoval`).

---

### ItemPedido ⇄ Produto
- **Relação**: Muitos para Um (`@ManyToOne`)
- **Descrição**: Um item de pedido refere-se a um único produto.

---

### Usuario ⇄ Pedido
- **Relação**: Um para Muitos (`@OneToMany`)
- **Descrição**: Um usuário pode ter vários pedidos relacionados.

---

### Categoria ⇄ Produto
- **Relação**: Um para Muitos (`@OneToMany`)
- **Descrição**: Uma categoria possui vários produtos.

---

## 🔒 Atributos com Restrição de Unicidade (`unique`)

Apenas um atributo está explicitamente com a anotação `@Column(unique = true)`:

### Entidade: `Usuario`
```java
@Column(unique = true, nullable = false)
private String login;
```


# 📦 Regras de Negócio Implementadas

## 🔹 1. Efetuar Pedido (`efetuarPedido`)

Este é o principal método da classe. Ele executa as seguintes regras de negócio:

### ✔ Validação de Cliente e Usuário:
- O cliente e o usuário (vendedor) são buscados pelo ID.
- Se não encontrados, são lançadas exceções (`NaoEncontradoException`).

### ✔ Criação do Pedido:
- Um objeto `Pedido` é criado com os dados recebidos.
- Cada item do pedido é processado individualmente:

### ✔ Processamento de Itens:
Para cada item:
- O produto é buscado pelo ID.
- A quantidade é verificada e padronizada para `0` caso seja `null`.
- O sistema tenta **subtrair o estoque** usando `produtoService.subtrairEstoque(...)`.

#### ⚠ Regra de Estoque:
- Se a subtração de estoque **falhar**, o pedido é **cancelado** (`PedidoSituacao.CANCELADO`).
- Caso contrário, o pedido é marcado como **pendente** (`PedidoSituacao.PENDENTE`).

### ✔ Cálculo de Valores:
- Cada item tem seu `valorTotal` calculado: `preço * quantidade`.
- O valor total do pedido é a soma dos valores dos itens.

### ✔ Salvamento:
- O pedido é salvo no banco de dados e transformado em DTO para retorno.

---

## 🔹 2. Alterar Pedido (`alterarPedido`)

Esse método permite **editar um pedido existente**:

### ✔ Busca o pedido por ID:
- Se o pedido não existe, é lançada uma exceção.

### ✔ Atualização de cliente e usuário:
- Os dados são reatribuídos com base nos novos dados recebidos.

### ✔ Atualização dos Itens:
- Os itens antigos são **removidos**.
- Novos itens são **mapeados** e adicionados.
- Preço, quantidade e valor total são recalculados.
- A data de modificação é atualizada.

#### ⚠ Observação:
- Não há nova verificação de **estoque** nesta parte (diferente do `efetuarPedido`).
- Pode ser necessário verificar estoque novamente ao alterar itens de um pedido.

---

## 🔹 3. Listar Pedidos (`listaPedidos`)

- Retorna todos os pedidos cadastrados.
- Se nenhum pedido for encontrado, lança uma exceção.

---

## 🔹 4. Buscar Pedido por ID (`buscaPedidoPorId`)

- Retorna os dados de um pedido específico.
- Lança exceção se o pedido não existir.

# 🔐 1. Cadastro de Usuário (/api/usuarios)

Endpoint:
```java
@PostMapping("/usuarios")
public ResponseEntity<UsuarioResponse> cadastra(@RequestBody UsuarioDto usuarioDto)
```
## O que faz?

Esse endpoint permite que um novo usuário se registre (seja criado) na aplicação.

## Fluxo:

O cliente envia os dados de cadastro (por exemplo: nome, login, senha) no corpo da requisição (@RequestBody UsuarioDto).

O controller chama o usuarioService.cadastrar(...) para processar o cadastro.

O serviço cria o usuário, salva no banco (provavelmente com senha criptografada) e retorna os dados.

O mapper (UsuarioMapper) transforma o DTO de volta para um objeto de resposta (UsuarioResponse) — ou seja, o que será enviado de volta ao cliente.

Exemplo de payload enviado:
```
{
  "login": "joao123",
  "password": "minhasenha123"
}
```

# 🔐 2. Login de Usuário (/api/login)

Endpoint:
```java
@PostMapping("/login")
public ResponseEntity login(@RequestBody LoginRequest data)
```
## O que faz?

Esse endpoint permite que um usuário já cadastrado faça login. Ao fazer isso, ele recebe um JWT (JSON Web Token) que será usado para autenticação em requisições futuras.

## Fluxo:

O cliente envia login e senha no corpo da requisição (LoginRequest).

É criado um objeto UsernamePasswordAuthenticationToken com essas credenciais.

O authenticationManager.authenticate(...) tenta autenticar o usuário usando:

O UserDetailsService (no caso, sua classe AuthUserDetailsService).

O PasswordEncoder (BCrypt).

Se a autenticação for bem-sucedida, o TokenService gera um JWT.

O token é retornado no corpo da resposta.

Exemplo de payload enviado:
```
{
  "login": "joao123",
  "password": "minhasenha123"
}
```

## Exemplo de resposta:
```java
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvMTIzIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3MD..."
}
```

# 🛠 3. Autenticação com JWT (Segurança)


Após o login, o JWT deve ser enviado pelo cliente em todas as requisições protegidas (com exceção de /login e /usuarios) no cabeçalho HTTP:

Authorization: Bearer <token>


Esse token será:

Verificado pelo SecurityFilter

Extrai o token do cabeçalho.

Usa o TokenService.validateToken(...) para validar.

Recupera o usuário e coloca no SecurityContextHolder.

A partir disso, o Spring Security sabe quem está autenticado e quais permissões (roles) o usuário tem.


# 📦 4. Repositório de Usuários (UsuarioRepository)


Sua classe UsuarioRepository é usada em vários pontos:

Pelo AuthUserDetailsService (para autenticação).

Pelo SecurityFilter (para carregar o usuário pelo login no token).

Pelo controller de cadastro.

Esse repositório provavelmente é algo como:
```java
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
```

# 👤 5. UserDetails / Roles


Seu Usuario implementa UserDetails, o que é exigido pelo Spring Security. Isso permite que o Spring use a entidade diretamente para autenticação e autorização. Ele deve implementar métodos como:
```java
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority("ROLE_USER")); // ou ROLE_ADMIN
}
```


<br>
Collections

```
{
  "info": {
    "name": "ecommerce",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "3 salvar usuario ADMIN",
      "event": [],
      "request": {
        "method": "POST",
        "header": [],
        "auth": {
          "type": "noauth"
        },
        "description": "",
        "url": {
          "raw": "http://localhost:8080/api/usuarios",
          "protocol": "http",
          "host": [
            "localhost:8080"
          ],
          "path": [
            "api",
            "usuarios"
          ],
          "query": [],
          "variable": []
        },
        "body": {
          "mode": "raw",
          "raw": "{\n  \"username\": \"joao.admin\",\n  \"password\": \"123\",\n  \"roles\": [\"ADMIN\", \"USER\"]\n}\n",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        }
      }
    },
    {
      "name": "3 salvar usuario USUARIO",
      "event": [],
      "request": {
        "method": "POST",
        "header": [],
        "auth": {
          "type": "noauth"
        },
        "description": "",
        "url": {
          "raw": "http://localhost:8080/api/usuarios",
          "protocol": "http",
          "host": [
            "localhost:8080"
          ],
          "path": [
            "api",
            "usuarios"
          ],
          "query": [],
          "variable": []
        },
        "body": {
          "mode": "raw",
          "raw": "{\n  \"username\": \"joao.usuario\",\n  \"password\": \"123\",\n  \"roles\": [\"USER\"]\n}\n",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        }
      }
    },
    {
      "name": "busca usuario por id",
      "event": [],
      "request": {
        "method": "GET",
        "header": [],
        "auth": {
          "type": "noauth"
        },
        "description": "",
        "url": {
          "raw": "http://localhost:8080/api/usuarios/1",
          "protocol": "http",
          "host": [
            "localhost:8080"
          ],
          "path": [
            "api",
            "usuarios",
            "1"
          ],
          "query": [],
          "variable": []
        },
        "body": {
          "mode": "raw",
          "raw": "",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        }
      }
    },
    {
      "name": "salvar usuario",
      "event": [],
      "request": {
        "method": "POST",
        "header": [],
        "auth": {
          "type": "noauth"
        },
        "description": "",
        "url": {
          "raw": "http://localhost:8080/api/usuarios",
          "protocol": "http",
          "host": [
            "localhost:8080"
          ],
          "path": [
            "api",
            "usuarios"
          ],
          "query": [],
          "variable": []
        },
        "body": {
          "mode": "raw",
          "raw": "{\n  \"username\": \"joao.silva\",\n  \"password\": \"123\"\n}\n",
          "options": {
            "raw": {
              "language": "json"
            }
          }
        }
      }
    },
    {
      "name": "categoria",
      "item": [
        {
          "name": "alterar categoria",
          "event": [],
          "request": {
            "method": "PUT",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"id\": 1,\n  \"nome\": \"Celulares\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "buscar categoria por codigo",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias/2",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias",
                "2"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "excluir categoria por id",
          "event": [],
          "request": {
            "method": "DELETE",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias/1",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias",
                "1"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "listar categorias por nome",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias/nome/eletrônicos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias",
                "nome",
                "eletrônicos"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "listar categorias",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "salvar categoria",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n   \"nome\": \"Eletrônicos\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar lista categoria",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias/lista",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias",
                "lista"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "[\n  {\n    \"nome\": \"Eletrônicos\"\n  },\n  {\n    \"nome\": \"Roupas\"\n  },\n  {\n    \"nome\": \"Livros\"\n  },\n  {\n    \"nome\": \"Móveis\"\n  },\n  {\n    \"nome\": \"Esportes\"\n  }\n]",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        }
      ]
    },
    {
      "name": "cliente",
      "item": [
        {
          "name": "alterar cliente",
          "event": [],
          "request": {
            "method": "PUT",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"id\": 1,\n  \"nome\": \"Empresa Modelo\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "buscar cliente por codigo",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes/1",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes",
                "1"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "buscar cliente por nome",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes/nome/Empresa",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes",
                "nome",
                "Empresa"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "excluir cliente",
          "event": [],
          "request": {
            "method": "DELETE",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes/1",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes",
                "1"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "listar clientes",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLmFkbWluIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3NjEwMDYwMzd9.nZBjf2KCL9v9fx5_6B_vPKxmOYhmrvoK-NcqyzGjDSQ",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar cliente",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"Empresa Exemplo\",\n  \"endereco\": \"Rua das Flores\",\n  \"numero\": \"100\",\n  \"bairro\": \"Centro\",\n  \"cep\": \"12345-678\",\n  \"cidade\": \"São Paulo\",\n  \"estado\": \"SP\",\n  \"telefone\": \"(11) 1234-5678\",\n  \"celular\": \"(11) 91234-5678\",\n  \"email\": \"contato@empresaexemplo.com\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar lista de clientes",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes/lista",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes",
                "lista"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "[\n  {\n    \"nome\": \"João Silva\",\n    \"endereco\": \"Avenida Paulista\",\n    \"numero\": \"1578\",\n    \"bairro\": \"Bela Vista\",\n    \"cep\": \"01310-200\",\n    \"cidade\": \"São Paulo\",\n    \"estado\": \"SP\",\n    \"telefone\": \"(11) 3344-7788\",\n    \"celular\": \"(11) 99876-5432\",\n    \"email\": \"joao.silva@email.com\"\n  },\n  {\n    \"nome\": \"Maria Oliveira\",\n    \"endereco\": \"Rua XV de Novembro\",\n    \"numero\": \"45\",\n    \"bairro\": \"Centro\",\n    \"cep\": \"80020-310\",\n    \"cidade\": \"Curitiba\",\n    \"estado\": \"PR\",\n    \"telefone\": \"(41) 3322-1100\",\n    \"celular\": \"(41) 98765-4321\",\n    \"email\": \"maria.oliveira@email.com\"\n  },\n  {\n    \"nome\": \"Carlos Souza\",\n    \"endereco\": \"Rua das Acácias\",\n    \"numero\": \"210\",\n    \"bairro\": \"Jardim das Flores\",\n    \"cep\": \"64000-200\",\n    \"cidade\": \"Teresina\",\n    \"estado\": \"PI\",\n    \"telefone\": \"(86) 3232-4455\",\n    \"celular\": \"(86) 99888-7766\",\n    \"email\": \"carlos.souza@email.com\"\n  },\n  {\n    \"nome\": \"Fernanda Lima\",\n    \"endereco\": \"Rua do Comércio\",\n    \"numero\": \"1200\",\n    \"bairro\": \"Centro Histórico\",\n    \"cep\": \"90010-320\",\n    \"cidade\": \"Porto Alegre\",\n    \"estado\": \"RS\",\n    \"telefone\": \"(51) 3010-2020\",\n    \"celular\": \"(51) 99666-5544\",\n    \"email\": \"fernanda.lima@email.com\"\n  },\n  {\n    \"nome\": \"Ricardo Mendes\",\n    \"endereco\": \"Avenida Brasil\",\n    \"numero\": \"999\",\n    \"bairro\": \"Copacabana\",\n    \"cep\": \"22040-002\",\n    \"cidade\": \"Rio de Janeiro\",\n    \"estado\": \"RJ\",\n    \"telefone\": \"(21) 2222-3333\",\n    \"celular\": \"(21) 99999-0000\",\n    \"email\": \"ricardo.mendes@email.com\"\n  }\n]\n",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        }
      ]
    },
    {
      "name": "login",
      "item": [
        {
          "name": "login auth admin",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/login",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "login"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"login\": \"joao.admin\",\n  \"password\": \"123\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "login auth usuario",
          "event": [
            {
              "listen": "test",
              "script": {
                "exec": [
                  "pm.environment.set(\"token\", pm.response.text())"
                ]
              }
            }
          ],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/login",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "login"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"login\": \"joao.usuario\",\n  \"password\": \"123\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        }
      ]
    },
    {
      "name": "pedidos",
      "item": [
        {
          "name": "alterar pedido",
          "event": [],
          "request": {
            "method": "PUT",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/pedidos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "pedidos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"id\": 1,\n  \"cliente\": {\n    \"id\": 1\n  },\n  \"usuario\": {\n    \"id\": 1\n  },\n  \"pedidoSituacao\": \"PENDENTE\",\n  \"pagamento\": \"PIX\",\n  \"vendedor\": \"vendedor\",\n  \"items\": [\n    {\n      \"produto\": {\n        \"id\": \"20888d2e-b003-40c6-acf9-31d7abf5b502\"\n      },\n      \"quantidade\": 5\n    }\n  ]\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "buscar pedido por id",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/pedidos/1",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "pedidos",
                "1"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "excluir produto",
          "event": [],
          "request": {
            "method": "DELETE",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produto/a2bbf6bb-8dac-422e-bae6-8e216a5ea202",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produto",
                "a2bbf6bb-8dac-422e-bae6-8e216a5ea202"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "listar pedidos",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLmFkbWluIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3NjEwMDYwMzd9.nZBjf2KCL9v9fx5_6B_vPKxmOYhmrvoK-NcqyzGjDSQ",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/pedidos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "pedidos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "listar vendas",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/relatorios/vendas",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "relatorios",
                "vendas"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar pedido  2 produtos",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/pedidos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "pedidos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"cliente\": {\n    \"id\": 1\n  },\n  \"pedidoSituacao\": \"PENDENTE\",\n  \"usuario\": \"usuario\",\n  \"vendedor\": \"vendedor\",\n  \"items\": [\n    {\n      \"produto\": {\n        \"id\": 1\n      },\n      \"quantidade\": 2,\n    },\n    {\n      \"produto\": {\n        \"id\": 2\n      },\n      \"quantidade\": 1,\n    }\n  ]\n}\n",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar pedido",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/pedidos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "pedidos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"cliente\": {\n    \"id\": 1\n  },\n  \"usuario\": {\n    \"id\": 1\n  },\n  \"pedidoSituacao\": \"PENDENTE\",\n  \"pagamento\": \"PIX\",\n  \"vendedor\": \"vendedor\",\n  \"items\": [\n    {\n      \"produto\": {\n        \"id\": \"a2bbf6bb-8dac-422e-bae6-8e216a5ea202\"\n      },\n      \"quantidade\": 10\n    }\n  ]\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        }
      ]
    },
    {
      "name": "produto",
      "item": [
        {
          "name": "alterar produto com categoria",
          "event": [],
          "request": {
            "method": "PUT",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"id\": \"11bd554a-0fff-453f-9790-363ff3c75d5e\",\n  \"nome\": \"Luva de goleiro\",\n    \"categoria\":{\n    \"id\": 2\n  }\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "alterar produto",
          "event": [],
          "request": {
            "method": "PUT",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"id\": \"6b44d79c-d2a9-4b6d-8b4d-a38ecca9d05d\",\n  \"nome\": \"Luva de goleiro\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "buscar produto por codigoBarras",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos/codigo-barra/7891234567890",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos",
                "codigo-barra",
                "7891234567890"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "buscar produto por id",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos/fd12e8c6-1e33-4b81-8c4e-2c1256cd4eb8",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos",
                "fd12e8c6-1e33-4b81-8c4e-2c1256cd4eb8"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "buscar produto por nome-ou-codigo-barras",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos/nome-ou-codigo-barras/caf",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos",
                "nome-ou-codigo-barras",
                "caf"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "buscar produto por nome",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos/nome/chuteiras",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos",
                "nome",
                "chuteiras"
              ],
              "query": [],
              "variable": []
            }
          }
        },
        {
          "name": "listar produtos",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "{{token}}",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar lista produto",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos/lista",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos",
                "lista"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "[\n  {\n    \"nome\": \"Notebook Dell Inspiron\",\n    \"descricao\": \"Notebook com processador Intel i7, 16GB RAM, SSD 512GB\",\n    \"codigoBarras\": \"7891234567890\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 25.00,\n    \"preco\": 5000.0\n  },\n  {\n    \"nome\": \"Smartphone Samsung Galaxy S21\",\n    \"descricao\": \"Smartphone Android com 128GB de armazenamento\",\n    \"codigoBarras\": \"7896543219870\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 50.00,\n    \"preco\": 3499.00\n  },\n  {\n    \"nome\": \"Cadeira Gamer\",\n    \"descricao\": \"Cadeira ergonômica para jogos e escritório\",\n    \"codigoBarras\": \"7893216549870\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 10.00,\n    \"preco\": 999.90\n  },\n  {\n    \"nome\": \"Mouse Logitech MX Master 3\",\n    \"descricao\": \"Mouse sem fio com alta precisão e bateria de longa duração\",\n    \"codigoBarras\": \"7894561237890\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 100.00,\n    \"preco\": 459.99\n  },\n  {\n    \"nome\": \"TV 55\\\" 4K Samsung\",\n    \"descricao\": \"Smart TV com resolução 4K e HDR\",\n    \"codigoBarras\": \"7899876543210\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 15.00,\n    \"preco\": 2799.00\n  }\n]\n",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "salvar produto",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"Chuteira\",\n  \"codigoBarras\": \"7891234567890\",\n  \"preco\": 199.90,\n  \"estoque\": 50.00,\n  \"categoria\":{\n    \"id\": 1\n  }\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        }
      ]
    },
    {
      "name": "roteiro",
      "item": [
        {
          "name": "1 salvar cliente",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLmFkbWluIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3NjEwMDYwMzd9.nZBjf2KCL9v9fx5_6B_vPKxmOYhmrvoK-NcqyzGjDSQ",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/clientes",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "clientes"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"nome\": \"Empresa Exemplo\",\n  \"endereco\": \"Rua das Flores\",\n  \"numero\": \"100\",\n  \"bairro\": \"Centro\",\n  \"cep\": \"12345-678\",\n  \"cidade\": \"São Paulo\",\n  \"estado\": \"SP\",\n  \"telefone\": \"(11) 1234-5678\",\n  \"celular\": \"(11) 91234-5678\",\n  \"email\": \"contato@empresaexemplo.com\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "2 salvar categoria",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLmFkbWluIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3NjEwMDYwMzd9.nZBjf2KCL9v9fx5_6B_vPKxmOYhmrvoK-NcqyzGjDSQ",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/categorias",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "categorias"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n   \"nome\": \"Eletrônicos\"\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "3 salvar usuario",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/usuarios",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "usuarios"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"username\": \"joao.silva\",\n  \"password\": \"123\",\n  \"roles\": [\"ADMIN\", \"USER\"]\n}\n",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "4 salvar lista produto",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLmFkbWluIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3NjEwMDYwMzd9.nZBjf2KCL9v9fx5_6B_vPKxmOYhmrvoK-NcqyzGjDSQ",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/produtos/lista",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "produtos",
                "lista"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "[\n  {\n    \"nome\": \"Notebook Dell Inspiron\",\n    \"descricao\": \"Notebook com processador Intel i7, 16GB RAM, SSD 512GB\",\n    \"codigoBarras\": \"7891234567890\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 25.00,\n    \"preco\": 5000.0\n  },\n  {\n    \"nome\": \"Smartphone Samsung Galaxy S21\",\n    \"descricao\": \"Smartphone Android com 128GB de armazenamento\",\n    \"codigoBarras\": \"7896543219870\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 50.00,\n    \"preco\": 3499.00\n  },\n  {\n    \"nome\": \"Cadeira Gamer\",\n    \"descricao\": \"Cadeira ergonômica para jogos e escritório\",\n    \"codigoBarras\": \"7893216549870\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 10.00,\n    \"preco\": 999.90\n  },\n  {\n    \"nome\": \"Mouse Logitech MX Master 3\",\n    \"descricao\": \"Mouse sem fio com alta precisão e bateria de longa duração\",\n    \"codigoBarras\": \"7894561237890\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 100.00,\n    \"preco\": 459.99\n  },\n  {\n    \"nome\": \"TV 55\\\" 4K Samsung\",\n    \"descricao\": \"Smart TV com resolução 4K e HDR\",\n    \"codigoBarras\": \"7899876543210\",\n    \"categoria\": {\n      \"id\": 1\n    },\n    \"estoque\": 15.00,\n    \"preco\": 2799.00\n  }\n]\n",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        },
        {
          "name": "5 salvar pedido",
          "event": [],
          "request": {
            "method": "POST",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLnVzdWFyaW8iLCJpc3MiOiJhdXRoLWFwaSIsImV4cCI6MTc2MTAwNjM3NX0.Crt4rKD0BiZSlQxi4BLlhjMF4flCRTta9SoXEQh3iBo",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/pedidos",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "pedidos"
              ],
              "query": [],
              "variable": []
            },
            "body": {
              "mode": "raw",
              "raw": "{\n  \"cliente\": {\n    \"id\": 1\n  },\n  \"usuario\": {\n    \"id\": 1\n  },\n  \"pedidoSituacao\": \"PENDENTE\",\n  \"pagamento\": \"PIX\",\n  \"vendedor\": \"vendedor\",\n  \"items\": [\n    {\n      \"produto\": {\n        \"id\":  \"0a7b64e7-bc81-4059-be38-fac791fc5304\"\n      },\n      \"quantidade\": 10\n    }\n  ]\n}",
              "options": {
                "raw": {
                  "language": "json"
                }
              }
            }
          }
        }
      ]
    },
    {
      "name": "relatorios",
      "item": [
        {
          "name": "relatoriio vendas",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "bearer",
              "bearer": {
                "key": "token",
                "value": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2FvLmFkbWluIiwiaXNzIjoiYXV0aC1hcGkiLCJleHAiOjE3NjEwMDYwMzd9.nZBjf2KCL9v9fx5_6B_vPKxmOYhmrvoK-NcqyzGjDSQ",
                "type": "string"
              }
            },
            "description": "",
            "url": {
              "raw": "http://localhost:8080/api/relatorios/vendas",
              "protocol": "http",
              "host": [
                "localhost:8080"
              ],
              "path": [
                "api",
                "relatorios",
                "vendas"
              ],
              "query": [],
              "variable": []
            }
          }
        }
      ]
    },
    {
      "name": "usuario",
      "item": [
        {
          "name": "busca usuario",
          "event": [],
          "request": {
            "method": "GET",
            "header": [],
            "auth": {
              "type": "noauth"
            },
            "description": "",
            "url": {
              "raw": "",
              "protocol": "",
              "host": [],
              "path": [],
              "query": [],
              "variable": []
            }
          }
        }
      ]
    }
  ],
  "variable": [
    {
      "key": "token",
      "value": "",
      "type": "default"
    }
  ]
}

```