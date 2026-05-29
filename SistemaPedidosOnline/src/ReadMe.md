#  Sistema de Pedidos Online

##  Sobre o Projeto

Este projeto foi desenvolvido como trabalho final da disciplina de **Padrões de Projetos de Software**, com o objetivo de aplicar conceitos de **Programação Orientada a Objetos (POO)** e implementar padrões de projeto em uma aplicação Java funcional.

A aplicação simula um sistema de pedidos online com interface gráfica, permitindo ao usuário:
- selecionar o tipo de pedido;
- escolher a forma de pagamento;
- inserir o valor da compra;
- finalizar o pedido.

O sistema foi desenvolvido utilizando arquitetura orientada a objetos e aplicando padrões de projeto para garantir:
- baixo acoplamento;
- reutilização de código;
- organização;
- flexibilidade;
- facilidade de manutenção.

---

#  Interface do Sistema

A aplicação possui uma interface gráfica desenvolvida com **Java Swing**, proporcionando uma interação simples e intuitiva para o usuário.

### Funcionalidades disponíveis:
✅ Seleção de tipo de pedido  
✅ Escolha de forma de pagamento  
✅ Inserção de valor do pedido  
✅ Finalização do pedido  
✅ Exibição das informações processadas  
✅ Simulação de conexão com banco de dados  

---

#  Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java | Linguagem principal |
| Java Swing | Interface gráfica |
| Programação Orientada a Objetos | Estrutura do sistema |
| Design Patterns | Organização e arquitetura |

---

#  Padrões de Projeto Aplicados

O sistema utiliza três padrões de projeto distintos:

---

# 1️ Singleton

##  Classe:
```java
DatabaseConnection
```

##  Objetivo

O padrão Singleton foi utilizado para garantir que exista apenas uma única instância da conexão com o banco de dados durante toda a execução do sistema.

##  Vantagens

- evita múltiplas conexões desnecessárias;
- centraliza o gerenciamento da conexão;
- reduz consumo de recursos;
- facilita manutenção.

## Aplicação no sistema

A classe `DatabaseConnection` possui:
- construtor privado;
- instância estática;
- método público `getInstance()`.

Dessa forma, qualquer parte do sistema reutiliza a mesma conexão.

---

# 2️ Factory Method

##  Classe:
```java
PedidoFactory
```

##  Objetivo

O padrão Factory Method foi utilizado para centralizar e abstrair a criação dos diferentes tipos de pedidos.

##  Vantagens

- desacoplamento;
- facilidade para adicionar novos tipos de pedido;
- maior organização;
- reutilização de código.

##  Aplicação no sistema

A fábrica identifica o tipo escolhido pelo usuário e cria automaticamente:
- `PedidoNormal`
- `PedidoExpresso`

Sem que a interface precise conhecer os detalhes da implementação.

---

# 3️ Strategy

##  Classes:
```java
PagamentoPix
PagamentoCartao
PagamentoBoleto
```

##  Objetivo

O padrão Strategy foi utilizado para permitir diferentes formas de pagamento de maneira flexível.

## Vantagens

- troca dinâmica de comportamento;
- baixo acoplamento;
- facilidade de expansão;
- reutilização.

##  Aplicação no sistema

Cada forma de pagamento possui sua própria estratégia:
- PIX
- Cartão
- Boleto

Todas implementam a interface:

```java
PagamentoStrategy
```

O sistema consegue trocar a forma de pagamento sem alterar o restante do código.

---

#  Arquitetura Geral

O sistema foi desenvolvido utilizando Programação Orientada a Objetos, separando responsabilidades entre:
- interface gráfica;
- lógica de negócio;
- criação de objetos;
- estratégias de pagamento;
- gerenciamento de conexão.

Essa divisão torna o projeto:
- mais organizado;
- mais escalável;
- mais fácil de manter.

---

#  Estrutura do Projeto

```text
SistemaPedidosOnline
│
├── src
│   ├── TelaPedidos.java
│   ├── DatabaseConnection.java
│   ├── Pedido.java
│   ├── PedidoNormal.java
│   ├── PedidoExpresso.java
│   ├── PedidoFactory.java
│   ├── PagamentoStrategy.java
│   ├── PagamentoPix.java
│   ├── PagamentoCartao.java
│   ├── PagamentoBoleto.java
│   └── PedidoService.java
│
└── README.md
```

---

#  Fluxo do Sistema

1. O usuário seleciona o tipo de pedido;
2. O sistema cria o pedido utilizando Factory Method;
3. O usuário escolhe a forma de pagamento;
4. O sistema aplica a estratégia correspondente;
5. O pedido é finalizado;
6. As informações são exibidas na interface.

---


#  Conceitos de POO Aplicados

Durante o desenvolvimento foram aplicados conceitos fundamentais de Programação Orientada a Objetos:

- encapsulamento;
- abstração;
- herança;
- polimorfismo;
- interfaces;
- separação de responsabilidades.

---

#  Objetivos Alcançados

✅ Aplicação funcional em Java  
✅ Interface gráfica funcional  
✅ Implementação correta de padrões de projeto  
✅ Organização orientada a objetos  
✅ Estrutura escalável e reutilizável  
✅ Separação adequada das responsabilidades  

---

# Considerações Finais

O desenvolvimento deste projeto possibilitou a aplicação prática de conceitos importantes da engenharia de software, principalmente relacionados aos padrões de projeto e à Programação Orientada a Objetos.

Os padrões utilizados contribuíram significativamente para:
- modularização do sistema;
- reutilização de componentes;
- flexibilidade da aplicação;
- facilidade de manutenção e expansão.

Além disso, a utilização de interface gráfica tornou a aplicação mais intuitiva e próxima de um sistema real, proporcionando melhor experiência de utilização e demonstração prática do funcionamento do software.

