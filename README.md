# Linguagens de Programação
Professor Fernando Luís Dotti


## Analisador Léxico
A atividade consiste um projetar e construir um lexer simples para os tipos de tokens da gramática de aritmética básica. A atividade pode ser feita individualmente ou em duplas. A linguagem de programação é de livre escolha e os arquivos com o código-fonte devem ser enviados através do Moodle.
A linguagem de aritmética tem os seguintes tokens e códigos:  
Token	id	Comentário  
IDENT	1	Nomes de variáveis  
INT_LIT	2	Números inteiros  
LPAREN	3	'('  
RPAREN	4	')'  
ADD_OP	5	'+'  
SUB_OP	6	'-'  
MUL_OP	7	'*'  
DIV_OP	8	'/'  
GT_OP	9	'>'  
LT_OP	10	'<'  
EQ_OP	11	'=='  
ASSIGN_OP	12	':='  
Considerações sobre a linguagem:  
Variáveis não podem começar com dígitos mas podem ter dígitos e caracteres depois do segundo símbolo.
As expressões possuem apenas números inteiros.
Não há números negativos neste nível de análise ainda.
Considere que os lexemas relativos aos números terão tamanho menor 100 dígitos. A mesma restrição de tamanho se aplica aos nomes de variáveis.
A análise léxica consiste em estabelecer triplas do tipo (lexema, token, token_id) a partir de uma palavra de entrada. Por exemplo, supondo a entrada seja:  
a := (aux - 2) * 200 / 19  
O analisador léxico deve produzir as seguintes triplas:  
('a', IDENT, 1)  
(':=', ASSIGN_OP, 12)  
('(', LPAREN, 3)  
('aux', IDENT, 1)  
('-', SUB_OP, 6)  
('2', INT_LIT, 2)  
(')', RPAREN, 4)  
('*', MUL_OP, 7)  
('200', INT_LIT, 2)  
('/', DIV_OP, 13)  
('19', INT_LIT, 2)  
Estratégia para a análise léxica:  
A análise léxica extrai um caractere de cada vez da entrada.
Se este caractere fizer parte de um lexema do tipo variável ou um número, é necessário guardar esta informação ao ler o próximo símbolo.
Esta informação determina se a leitura do próximo símbolo a ser lido deve ser um dígito ou um caractere ou apenas um dígito.
Um novo lexema é iniciado quando o símbolo lido pertence a um token diferente do atual ou então através da leitura de um caractere de espaço em branco, quebra de linha '\n', tabulação '\t', retorno de cursor '\r'  indica que a leitura do lexema atual encerrou. O caractere de final de arquivo EOF também encerra um lexema assim como termina a execução do programa.


## Pre-requisitos
1. Instalar o Gradle 6.6.1 (adicionar nas variaveis de ambiente do sistema);
2. Java 1.8.0 (adicionar o JAVA_HOME nas variaveis de ambiente do sistema);

## Adicionando uma nova variavel de ambiente do sistema
1. Na pesquisa do sistema, procure por "Variaveis de ambiente do sistema" (Edit the system environment variables)
2. Clique em "Variaveis de ambiente..." (Environment variables...)
3. Na aba inferior da nova janela, em variaveis do sistema, clique no botão "nova variavel"
4. Digite o nome da variavel [GRADLE_HOME ou JAVA_HOME]
5. O valor da variável deverá ser a pasta raiz do package, por exemplo, C:\Program Files\opt\gradle. Clique em Ok
6. Procure pela variável "Path" e adicione um novo parametro entre '%' com o nome da variável recem criada e adicione \bin no final. Por exemplo, %GRADLE_HOME%\bin
*Para verificar se funcionou, não utilize terminais abertos antes desse processo. Feche-o e abra um novo terminal.*

## Verificando o ambiente
1. Abra o terminal (cmd)
2. Verificar a versão do Java Compiler 'javac -version'
3. Verificar a versão do Gradle 'gradle --version'
4. Verificar se a variavel de ambiente do sistema está configurada 'echo %JAVA_HOME%'

## Como executar o código groovy
1. Abrir o terminal na pasta raiz do projeto
2. Executar o comando ´gradle run --args"Nome_do_arquivo"´
** O arquivo deve estar na pasta resources do projeto.

## Como executar os testes
1. Abrir o terminal na pasta raiz do projeto
2. Executar o comando ´gradle test´

Observações:
* A primeira execução vai ser mais demorada, dado que o gradle vai baixar as dependencias como o Groovy-all e o JUnit5-Jupiter. As demais execuções serão mais rápidas;
* Não tenho certeza quanto a necessidade de baixar e instalar o package da linguagem Groovy. Eu tenho instalado, mas acredito que apenas faça a função de me permitir compilar e executar o programa pelo cmd (fora do gradle);
* Eu utilizo a versão 6.6.1 do Gradle (<= 4.5.1 não funcionam), não tenho certeza até qual versão anterior as dependencias funcionam. Recomendo utilizar a 6.6.1 (última disponível).

*Comandos gradle*
* gradle build - cria o artefato .jar/.war (executando os testes)
* gradle clean - Exclui todos os arquivos de compilação e artefatos do projeto
* gradle run - Executa o programa
* gradle artifact - Gera o artefato de entrega
* gradle test - Executa os testes unitários do projeto

**Todos os comandos gradle compilam o projeto automagicamente**


### Links úteis
* https://groovyconsole.appspot.com
