# DomusNet (MarketPlace)

> Desenvolvida em Java aplicando Programação Orientada a Objetos (POO), arquitetura MVC, padrão DAO e operações CRUD integradas a um banco de dados relacional MySQL.

---

## Autor: Samuel Rodrigues Boryça

## Screenshots

<img width="916" height="422" alt="{CE53EB42-D164-4876-9208-117C329FA8D7}" src="https://github.com/user-attachments/assets/b47be37c-bc85-4f2d-80d4-ec8e5cddd263" />
<img width="922" height="417" alt="{8EA80470-4598-48CA-8710-CCBAFE01EBA1}" src="https://github.com/user-attachments/assets/163055d4-d594-4626-8b03-f5fcfaf0a774" />
<img width="916" height="419" alt="{AD6512A6-523D-458D-8F39-A0556EB022AC}" src="https://github.com/user-attachments/assets/d7163a04-8c23-47e6-9b0d-bf32491f05f0" />

<img width="920" height="416" alt="{6610D98B-40D7-4724-B40D-27363110E158}" src="https://github.com/user-attachments/assets/baaf9f03-5ed9-4124-9d84-351e6e4310c8" />
<img width="929" height="420" alt="{DB3F9BC9-B111-45A6-ACA6-03777758A8A0}" src="https://github.com/user-attachments/assets/39b7b116-cb59-4fa5-a480-f6adbc06cd38" />

---

## Funcionalidades

* **Gerenciamento de Vendedores (CRUD Completo):** Cadastro, listagem, atualização e exclusão de vendedores com validação de notas de avaliação (0 a 5).
* **Gerenciamento de Produtos:** Cadastro, edição e remoção de produtos vinculados diretamente a um vendedor existente por meio de chave estrangeira (`id_vendedor`).
* **Consulta Relacional:** Visualização filtrada de todos os produtos pertencentes a um vendedor específico.
* **Múltiplas Interfaces:** Suporte para execução via Console estilizado e visualização em Web.

---

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 11+)
* **Banco de Dados:** MySQL
* **Conectividade:** JDBC (MySQL Connector/J)
* **Interface Gráfica:** Console ANSI / HTML5 & CSS3
* **Arquitetura e Padrões:** POO, MVC (Model-View-Controller) e DAO (Data Access Object)

---

Markdown
## ⚙️ Instruções de Instalação e Execução

### 1. Pré-requisitos
* **Java JDK** (versão 8 ou superior) instalado.
* **MySQL Server** instalado e em execução.
* Uma IDE Java de sua preferência (IntelliJ IDEA, Eclipse ou NetBeans).

---

### 2. Configuração do Banco de Dados
Abra o seu gerenciador MySQL (MySQL Workbench, DBeaver ou terminal) e execute o script SQL abaixo para criar o banco de dados e as tabelas:

```sql
CREATE DATABASE MarketPlace;
USE MarketPlace;

CREATE TABLE vendedor (
    id_vendedor INT PRIMARY KEY,
    nome_vendedor VARCHAR(50),
    avaliacao INT
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY,
    nome_produto VARCHAR(50),
    quantidade INT,
    preco DECIMAL(10,2),
    id_vendedor INT,
    CONSTRAINT fk_produto_vendedor FOREIGN KEY (id_vendedor) REFERENCES vendedor(id_vendedor)
);
```

### 3. Configuração do Projeto Java & DAO
Baixe ou clone este repositório em sua máquina.

Abra o projeto na sua IDE.

Adicione o driver MySQL Connector/J (.jar) às bibliotecas (Libraries / Build Path) do seu projeto.

Abra o arquivo src/dao/ConexaoDB.java e atualize o usuário e a senha para corresponderem às credenciais do seu MySQL local:

Java
private static final String USUARIO = "seu_usuario"; // ex: root
private static final String SENHA = "sua_senha";     // ex: sua senha
4. Executando a Interface Web
Como o projeto utiliza uma interface web interativa em HTML para testar o fluxo do sistema sem complicações visuais:

Navegue até a pasta view do projeto onde o arquivo MenuPrincipal.html está localizado.

Dê um duplo clique no arquivo MenuPrincipal.html (ou clique com o botão direito e escolha Abrir com o seu navegador web favorito, como Google Chrome, Edge ou Firefox).

O painel visual em formato de console web será aberto, permitindo que você gerencie vendedores, cadastre produtos vinculados e consulte relacionamentos instantaneamente.
