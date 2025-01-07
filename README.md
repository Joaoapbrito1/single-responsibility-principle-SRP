## Exercício 1: Single Responsibility Principle (SRP)

### Enunciado:
Você foi contratado por um banco para criar um sistema que gere relatórios financeiros. Atualmente, a classe RelatorioFinanceiro faz duas coisas: gera o relatório e envia por e-mail. Refatore o código para que ele siga o Princípio da Responsabilidade Única (SRP).

Código inicial (errado):
```java
public class RelatorioFinanceiro {
    public void gerarRelatorio() {
        System.out.println("Gerando relatório financeiro...");
    }

    public void enviarPorEmail() {
        System.out.println("Enviando relatório por e-mail...");
    }
}
```

### Tarefa:


- Separe as responsabilidades em classes diferentes.
- Crie uma classe para gerar o relatório e outra para enviar o e-mail.

## Resolução

Seguindo o Princípio da Responsabilidade Única (SRP), fiz um novo código separando as responsabilidades e mantendo cada 
classe com resposibilidades únicas. Modularizei o código para que seja possível implementar futuramente outras formas de
envio do relatorio sem precisar alterar o código da classe principal EnviarRelatotio.

### Códigos

- Classe GeradorRelatorio.

```java
package service;

public class GeradorRelatorio {
    public String gerarRelatorio() {
        System.out.println("Gerando relatório financeiro...");
        return null;
    }
}
```
Contém apenas a lógica para gerar relatórios financeiros.

- Classe EnviaRelatorio

```java
package model;

public class EnviaRelatorio {
    private MeioEnvio meioEnvio;
    
    public EnviaRelatorio(MeioEnvio meioEnvio) {
        this.meioEnvio = meioEnvio;
    }

    public void enviarRelatorio(String conteudo) {
        meioEnvio.enviar(conteudo);
    }
}
```
Centraliza o envio do relatório, utiliza a interface MeioEnvio, permitindo flexibilidade na escolha do meio de envio por meio da injeção de dependência.

- Interface MeioEnvio

```java
package model;

public interface MeioEnvio {
    void enviar(String conteudo);
}
```
Define um contrato para todos os meios de envio, facilita a adição de novos meios de envio sem modificar as classes existentes.

- Classe EnvioEmail

```java
package service;

import model.MeioEnvio;

public class EnvioEmail implements MeioEnvio {
    @Override
    public void enviar(String conteudo) {
        System.out.println("Enviando por e-mail: " + conteudo);
    }
}
```
Implementam o comportamento específico.


- Classe EnvioChat - Novo meio de envio
```java
package service;

import model.MeioEnvio;

public class EnvioChat implements MeioEnvio {
    @Override
    public void enviar(String conteudo) {
        System.out.println("Enviando por chat: " + conteudo);
    }
}
```
Na resolução dessa questão consegui abordar 4 pilares do SOLID de forma automatica.

- SRP: Cada classe tem uma responsabilidade única.
- OCP: O sistema é facilmente extensível sem modificar o código existente.
- LSP: As implementações da interface MeioEnvio podem ser usadas de forma intercambiável.
- DIP: A dependência está na abstração (MeioEnvio), e não nas implementações concretas.