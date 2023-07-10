# Pokedex - Exemplo de Projeto com Clean Architecture e MVVM

Bem-vindo ao repositório da Pokedex, um projeto de exemplo que demonstra a aplicação do Clean Architecture em conjunto com o padrão de arquitetura MVVM (Model-View-ViewModel) em um aplicativo Android. Este repositório foi criado como parte de um [artigo]() sobre Desenvolvimento com Clean Architecture e MVVM, com o objetivo de fornecer um exemplo prático e claro de como essas abordagens podem ser implementadas em um projeto Android.

## Visão Geral

A Pokedex é uma aplicação que permite aos usuários explorar e obter informações sobre diferentes pokemons. Ela utiliza a API [PokéAPI](https://pokeapi.co/) para obter os dados sobre os pokemons, exibindo informações como nome, tipo, habilidades, estatísticas, entre outros.

O projeto foi desenvolvido utilizando o Android Studio e a linguagem Kotlin, seguindo as diretrizes do Clean Architecture e do padrão MVVM. Essas abordagens foram escolhidas para promover uma separação clara de responsabilidades, facilitar a manutenção do código, melhorar a testabilidade e permitir a evolução do aplicativo de forma escalável.

## Estrutura do Projeto

O projeto está organizado em packages, cada um responsável por uma camada específica da arquitetura. A estrutura do projeto é a seguinte:

- **app**: Package do aplicativo Android, responsável pela implementação da camada de apresentação (View) do MVVM. Aqui, os fragments, activities, adapters e view models estão localizados.

- **domain**: Package que contém as entidades e as regras de negócio do aplicativo. Ele representa a camada de domínio da arquitetura.

- **data**: Package que lida com a obtenção e o armazenamento de dados. Ele implementa as interfaces definidas no package de domínio e é responsável pela comunicação com a API e com o banco de dados local.

- **presentation**: Package que contém as classes responsáveis pela lógica de apresentação do aplicativo, incluindo os view models e os observables (LiveData) utilizados para atualizar a interface do usuário.

## Tecnologias Utilizadas

O projeto faz uso de várias tecnologias e bibliotecas, incluindo:

- [Kotlin](https://kotlinlang.org/): Linguagem de programação moderna e concisa, utilizada para desenvolver o aplicativo Android.

- [Android Jetpack](https://developer.android.com/jetpack): Conjunto de bibliotecas e ferramentas recomendadas pelo Google para o desenvolvimento de aplicativos Android. Entre as bibliotecas utilizadas estão: ViewModel, LiveData e Room.

- [Ktor](https://ktor.io/): Biblioteca Kotlin para criar clientes HTTP assíncronos e baseados em coroutines. É utilizada para realizar as chamadas de API e obter os dados dos pokemons.

- [Room](https://developer.android.com/jetpack/androidx/releases/room): Biblioteca de persistência que fornece uma camada de abstração sobre o SQLite para facilitar o acesso aos dados locais e a implementação de um banco de dados.

## Configuração do Projeto

Para executar o projeto localmente, siga estas etapas:

1. Clone este repositório para o seu ambiente de desenvolvimento:
```
git clone https://github.com/seu-usuario/pokedex.git
```
2. Abra o projeto no Android Studio.

3. Aguarde o Android Studio sincronizar o projeto e baixar as dependências necessárias.

4. Execute o projeto no emulador ou dispositivo Android.

## Contribuindo

Contribuições são bem-vindas! Se você encontrar algum problema no projeto, tiver alguma ideia de melhoria ou desejar adicionar novos recursos, sinta-se à vontade para abrir uma nova issue ou enviar um pull request.
