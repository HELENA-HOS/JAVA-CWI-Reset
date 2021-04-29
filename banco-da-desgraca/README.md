# Banco da Desgraça

Criar um sistema para gestão de contas bancárias, possibilitando funções de entrada, saída, transferência e extrato.

*Obs.: você deve criar um projeto novo chamado `banco-da-desgraca` e copiar a mesma estrutura de classes e packages fornecida neste projeto de exemplo.*

### Tipos de contas bancárias

Devem ser criados três tipos de contas bancárias: `ContaPoupanca`, `ContaCorrente` e `ContaDigital`.

*Composição das contas bancárias:*

- Toda conta bancária possui um número de conta corrente;
- Toda conta bancária possui uma instituição bancária;
- As instituições bancárias contempladas até o momento são: Banco do Brasil, Bradesco, Caixa, Itaú e Nubank;
- Toda conta bancária precisa sobrescrever o método `toString` para que fique neste formato de exemplo *(perceba que o nome do banco está "apresentável")*: `Conta Digital Nubank 123`, `Conta Poupança Caixa Econômica Federal 873`, etc.

*Regras específicas dos tipos de contas bancárias:*

- `ContaDigital`: não possui nenhum tipo de taxa, todas as operações são gratuitas. Os saques só são permitidos se o valor solicitado for de pelo menos R$ 10,00;
- `ContaCorrente`: é livre de taxas, exceto para transferências para outras instituições bancárias *(neste caso, a taxa é de 1% do valor a ser transferido)*. O saque só pode ser feito para valores divisíveis por 5 *(ou seja, notas de R$ 5,00, R$ 10,00, R$ 20,00, R$ 50,00, R$ 100,00 e R$ 200,00)*;
- `ContaPoupanca`: possui taxa de 2% para saques, sendo que o valor mínimo para solicitação de saque é de R$ 50,00. Possui taxa de 0,5% para transferências para mesma instituição bancária e 1% para outras instituições bancárias;

*Regras sobre instituições bancárias:*

- Somente Itaú e Nubank permitem contas digitais;
- Somente Nubank não permite conta poupança.

### Regras gerais

- **Não é permitido alterar a interface `ContaBancaria`**;
- Você precisará completar a classe `Transacao` com o tipo da transação, a data da transação e o valor da transação;
- Utilize o método `main` de `BancoDaDesgraca` para criar casos de testes. Crie várias contas bancárias e efetue diversos tipos de transação;
- As classes que representam contas bancárias devem ser criadas no package `br.com.banco.desgraca.domain.conta`;
- Sempre que precisar imprimir um valor monetário, use `DecimalFormat.getCurrencyInstance().format()`;
- Todos as operações da conta bancária devem imprimir uma mensagem indicando a operação que foi feita. Deve ser o mais legível possível. Ex.:
  - `Sacando valor R$ 50,00 da Conta Poupança Bradesco 123`
  - `Depositando valor R$ 25,00 na Conta Corrente Banco do Brasil 555`
  - `Transferindo valor R$ 100,00 da Conta Digital Nubank 123 para conta corrente Itaú 789`
- Toda e qualquer situação que infrinja uma restrição deve lançar uma exceção específica e customizada para indicar o problema. Um exemplo pode ser visto no package `exception`;
- Se achar necessário, crie uma classe abstrata para evitar trabalho repetitivo;
- Você precisará criar algumas classes e completar outras que já existem no projeto inicial;
- Lembre-se de utilizar o Google para pesquisar algumas coisas :)

### Regra da data

Para que o exemplo fique completo, precisamos também trabalhar com datas, que estarão associadas às transações.

Sempre que você precisar de uma data para criar uma transação, utilize a classe utilitária `Data` *(localizada na raiz do projeto)* que já possui um método `getDataTransacao()`. Toda vez que você chamar este método, será acrescido 5 dias à uma data estipulada como início *(01/07/2020)*.

------

### Detalhamento de algumas regras

1. As taxas são valores **somados** ao valor original. *Exemplos:*
   - Se for solicitado um saque de `R$ 100` e a taxa for de `2%`, o saldo da conta deve diminuir em `R$ 102`;
   - Se for solicitada uma transferência de `R$ 100` e a taxa for de `5%`, o débito na conta de origem deve ser de `R$ 105`; na conta de destino, crédito de `R$ 100`.
2. Existem apenas **dois** tipos de transação: `ENTRADA` e `SAIDA`
   - *Uma operação de transferência nada mais é do que uma saída da conta de origem e uma entrada na conta de destino*
3. A transação precisa ter, além do valor original, a discrimininação da taxa. Ou seja: um saque de `R$ 100`, que gerou um débito de `R$ 102` devido à taxa de `2%`, precisa armazenar o valor `R$ 100` e a taxa `R$ 2`.
4. O valor da taxa deve ser exibido no extrato. O formato deve ser semelhante a este:

```
----- EXTRATO CONTA DIGITAL NUBANK 12345
+   R$ 100,00  (-   R$ 2,00)   01/07/2020
+    R$ 50,00  (-   R$ 0,50)   06/07/2020
-    R$ 10,00  (-   R$ 0,10)   11/04/2020
-----
```