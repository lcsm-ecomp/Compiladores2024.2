### Tutorial: Criando um Avaliador de Expressões Aritméticas com ANTLR

ANTLR (Another Tool for Language Recognition) é uma ferramenta poderosa para a construção de analisadores léxicos e sintáticos. Neste tutorial, vamos criar um avaliador de expressões aritméticas simples usando ANTLR.

#### 1. Instalação do ANTLR

Primeiro, precisamos instalar o ANTLR. Você pode fazer o download do jar diretamente do site oficial ou usar o seguinte comando se estiver em um ambiente Unix-based:

```bash
curl -O https://www.antlr.org/download/antlr-4.10.1-complete.jar
alias antlr4='java -jar antlr-4.10.1-complete.jar'
alias grun='java org.antlr.v4.gui.TestRig'
```

Além disso, você precisará do runtime do ANTLR na sua aplicação. Se estiver usando Maven, adicione a dependência no seu `pom.xml`:

```xml
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4-runtime</artifactId>
    <version>4.10.1</version>
</dependency>
```

#### 2. Definindo a Gramática

Vamos começar criando um arquivo com a gramática para expressões aritméticas. Crie um arquivo chamado `Arithmetic.g4` com o seguinte conteúdo:

```antlr
grammar Arithmetic;

// Regras Léxicas
PLUS    : '+' ;
MINUS   : '-' ;
MUL     : '*' ;
DIV     : '/' ;
LPAREN  : '(' ;
RPAREN  : ')' ;
NUMBER  : [0-9]+ ;
WS      : [ \t\r\n]+ -> skip ;

// Regras Sintáticas
prog:   expr EOF ;

expr:   expr op=('*'|'/') expr
    |   expr op=('+'|'-') expr
    |   NUMBER
    |   LPAREN expr RPAREN ;
```

Essa gramática define operações básicas de adição, subtração, multiplicação e divisão, além do uso de parênteses para alterar a precedência.

#### 3. Gerando o Código com ANTLR

Agora, vamos gerar o analisador léxico e sintático usando o ANTLR:

```bash
antlr4 Arithmetic.g4
javac Arithmetic*.java
```

Isso gerará arquivos Java que correspondem às regras da gramática.

#### 4. Implementando o Avaliador

Crie uma classe Java para avaliar as expressões com base na árvore sintática gerada:

```java
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ArithmeticEvaluator extends ArithmeticBaseVisitor<Integer> {

    @Override
    public Integer visitProg(ArithmeticParser.ProgContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitExpr(ArithmeticParser.ExprContext ctx) {
        if (ctx.op != null) {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            switch (ctx.op.getType()) {
                case ArithmeticParser.PLUS:
                    return left + right;
                case ArithmeticParser.MINUS:
                    return left - right;
                case ArithmeticParser.MUL:
                    return left * right;
                case ArithmeticParser.DIV:
                    return left / right;
            }
        }
        if (ctx.NUMBER() != null) {
            return Integer.parseInt(ctx.NUMBER().getText());
        }
        return visit(ctx.expr(0)); // Para expressões entre parênteses
    }

    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromStream(System.in);
        ArithmeticLexer lexer = new ArithmeticLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArithmeticParser parser = new ArithmeticParser(tokens);
        ParseTree tree = parser.prog();

        ArithmeticEvaluator eval = new ArithmeticEvaluator();
        System.out.println(eval.visit(tree));
    }
}
```

Este avaliador visita cada nó da árvore sintática e calcula o resultado da expressão aritmética.

#### 5. Testando o Avaliador

Compile e execute o código:

```bash
javac ArithmeticEvaluator.java
java ArithmeticEvaluator
```

Agora você pode inserir expressões aritméticas no terminal, como `3 + 5 * (10 - 4)`, e o avaliador retornará o resultado.
