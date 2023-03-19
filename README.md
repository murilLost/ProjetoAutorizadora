# FIAP - SPRING
## 1SCJR - ProjetoAutorizadora
Prof: FABIO TADASHI MIYASATO

-Desenvolvido por:
<ul>
  <li>Murillo Lopes Fernandes</li>
  <li>Eduardo Freire Cotrim</li>
  <li>Ana Carolina Alves Cola</li>
  <li>Marco Antonio da Paz Couzin</li>
</ul>

Protótipo de autorizadora de cartão de uma universidade.

## Executando o projeto


### 1 - Download do projeto no github:

```
Producer
git clone https://github.com/murilLost/ProjetoAutorizadora.git
```

##  Pré-requisitos para execução do projeto

- Tecnologias necessárias.

  1- Para executar o projeto é necessário ter instalado Java SE Development Kit versão 17.

  2- Utilizar Intellij IDE para execução.

  3- Gradle

  4- Postman

### 2 - Subindo o projeto

<ol>
  <li>Baixar o projeto aqui do GIT, pode clonar ou baixar zipado.</li>
  <li>Possuir o Intellij IDE para configurar o projeto e roda-lo.</li>
  <li>Abrir o projeto no Intellij IDE, e builda-lo com Gradle.</li>
  <li>Utilizei o JDK 17 no projeto, sugiro utilizar o mesmo.</li>
  <li>Ir no arquivo application.yml, presente no caminho: src/main/resources</li>
  <li>Alterar o email e a senha, estará escrito email@hotmail.com e senha. Observação, deve ser um email da Microsoft, como Hotmail e Outlook, se for usar outro email, deve-se alterar o host(SMTP).</li>
  <li>Pronto, o projeto está pronto para ser executado; execute-o.</li>
  <li>Baixar e instalar qualquer programa que faça chamadas Rest, uma opção é o Postman, link: https://www.postman.com/</li>
  <li>Fazer as chamadas Rest para as 3 apis do projeto, uma para criar cartão, uma para autorizar pagamento e a última para enviar um email com o extrato de transações delimitado por data-hora.</li>
  <li>Para executa-las, será necessário passar o JWT, que é uma autenticação do tipo Bearer. A geração do JWT é feita no projeto hw-spring-acquirer.</li>
</ol>
  
### 3 - Testes das APIs e descrição:
<ol>
  <li>(POST) http://localhost:8085/cartao           - Cria o cartão para o aluno, com limite de R$5000,00.</li>
  ![api-criacao-cartao](https://user-images.githubusercontent.com/63795081/226216320-cfcd68eb-807f-449b-b4c3-53a045cdf9a5.png)

  <li>(POST) http://localhost:8085/autorizadora     - Faz a autorização do pagamento e sensibiliza o limite do aluno.</li>
  ![api-pagamento](https://user-images.githubusercontent.com/63795081/226216323-5b34cdd8-01a1-4edb-b027-762601e8a6f8.png)

  <li>(GET) http://localhost:8085/autorizadora      - Faz o envio do extrato por email</li>
  ![api-envio-email](https://user-images.githubusercontent.com/63795081/226216333-97542fa8-9db4-4328-aae5-b1ae1ad3960e.png)
  ![resultado-email](https://user-images.githubusercontent.com/63795081/226216368-105f937f-c318-4e8a-b7af-b128dff53f31.png)

</ol>


## NOTAS:
###### Em função das limitações de utilização do banco de dados H2, os projetos devem ser executados individualmente.
