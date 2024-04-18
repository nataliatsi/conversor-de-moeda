# Conversor de Moeda

## Descrição
O projeto Conversor de Moeda consiste em um sistema de conversão de moeda que utiliza a API ExchangeRate-API para obter taxas de câmbio dinâmicas e atualizadas em tempo real. Este projeto foi desenvolvido como parte do desafio "Conversor de Moedas" da formação Backend com Java da Oracle Next Education.

## Funcionalidades
O Conversor de Moeda oferece as seguintes funcionalidades:
- Conversão de moeda entre diversas opções.
- Interação textual via console com os usuários.
- Taxas de conversão dinâmicas obtidas através da API ExchangeRate-API.
- Registro das conversões realizadas em arquivos JSON.
- Registro de logs das conversões realizadas, incluindo informações sobre as moedas convertidas e o momento da conversão.


## Exemplo de Interação do Usuário
Aqui está um exemplo de interação do usuário ao executar o programa:

```plaintext
Digite a moeda de origem (3 caracteres): usd
Digite a moeda de destino (3 caracteres): brl
Digite a quantidade: 100
Moeda de origem : USD
Moeda de destino : BRL
Quantidade : 100,00
Taxa de câmbio : 5,2647
Valor convertido : 526,47
Deseja fazer outra conversão? (1 - Sim, 0 - Não): 0
Encerrando programa...
Conversões salvas em arquivo JSON com sucesso!
```

Neste exemplo, o usuário converte 100 dólares para reais (BRL) e encerra o programa após uma única conversão, com o histórico de conversões sendo salvo em um arquivo JSON.

## Utilização
Para utilizar o conversor, basta seguir estes passos:
1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter o Java instalado em seu sistema.
3. Configure sua chave de API da ExchangeRate-API no arquivo `config.properties`. Siga as instruções na seção de Configuração abaixo para mais detalhes.
4. Compile e execute o projeto.
5. Siga as instruções apresentadas no console para realizar as conversões desejadas.

## API Utilizada
O conversor utiliza a API ExchangeRate-API para obter taxas de câmbio atualizadas. Para mais informações, visite [ExchangeRate-API](https://www.exchangerate-api.com/).

## Configuração
Para utilizar o Exchange System, siga estas etapas para configurar sua chave de API da ExchangeRate-API:

1. Acesse [ExchangeRate-API](https://www.exchangerate-api.com/) e crie uma conta gratuita.
2. Após criar sua conta e fazer login, você receberá sua chave de API.
3. Abra o arquivo `config.properties` localizado na pasta raiz do projeto.
4. Substitua o valor da propriedade `api.key` pela sua chave de API.

Exemplo do arquivo `config.properties`:
```
api.key=sua_chave_api_aqui
```

Certifique-se de manter sua chave de API confidencial e não compartilhá-la publicamente.

## Requisitos
- Java 8 ou superior.
- Conexão com a internet para acessar a API ExchangeRate-API.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs ou novas funcionalidades ✨
