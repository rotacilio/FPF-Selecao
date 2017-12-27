FPF-Seleção - CRUD de Produtos
========================

O aplicativo consiste de dois módulos, um back-end desenvolvido em Java com a utilização do Framework Spring Boot e o outro front-end desenvolvido em HTML5 com AngularJS 1.6.

O módulo back-end foi desenvolvido utilizando a IDE eclipse, utilizando o Maven para facilitar a instalação e configuração do Spring Boot. A API Rest se comunica com o banco de dados MySQL, o mesmo foi usado para salvar as informações sobre os produtos. Para executar o servidor REST, temos duas alternativas:
* Importar o projeto para o eclipse JEE e executá-lo utilizando a IDE;
* Executar o arquivo .jar disponilizado na raiz deste repositório.

O módulo front-end foi desenvolvido utilizando HTML5 e AngularJS 1.6. O servidor utilizado para teste foi o Apache HTTP. Para executar-mos o módulo front-end devemos instalar e configurar o servidor Apache. Logo abaixo na seção de configuração tem um link que redireciona para uma página onde ensina fazer a configuração do servidor Apache no Linux e no Windows.

No diretório data deste repositório, tem um script para criação do banco de dados e preenchimento das tabelas com valores, para teste.

Dependências
=======
* Maven
* Apache HTTP 2.4
* MySQL 5.6
* JDK 1.7/1.8/9

Configuração
=======
* Para instalar e configurar o Servidor Apache, juntamente com o MySQL no Linux: https://matheuslima.com.br/instalando-o-apache-24-mysql-57-php-71-lamp
* Para instalar o Apache 2.4 no Windows: https://codepepper.wordpress.com/2014/08/12/instalando-apache-2-4-10-php-5-4-9-no-windows-7/
* Para baixar e instalar o Mysql no Windows: https://dev.mysql.com/downloads/mysql/
* Após instalar e configurar todas as dependências, só resta copiar a aplicação front-end para o servidor e executar no browser de sua preferência.
