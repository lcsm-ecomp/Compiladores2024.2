import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.Trees;
import java.util.*;
import java.io.*;

class Main {

    public static int avalie(ParseTree t) {
        String nomeClasse = t.getClass().getName();
        switch (nomeClasse) {
        case "ExprParser$ElemContext":
           return Integer.parseInt(t.getChild(0).getText());
        case "ExprParser$SomaContext":
           return avalie(t.getChild(0)) + avalie(t.getChild(2));
        case "ExprParser$ProdutoContext":
           return avalie(t.getChild(0)) * avalie(t.getChild(2));
        case "ExprParser$GrupoContext":
           return avalie(t.getChild(1));
        }
        throw new RuntimeException("Nao ser compilar " + nomeClasse + " no codigo : " + t.getText());
    }
    public static void main(String args[]) throws Exception {
        CharStream input = CharStreams.fromFileName("input.exp");
        //CharStream input = CharStreams.fromString("10 + 4");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        ExprParser parser = new ExprParser( tokens ); 
        ParserRuleContext tree = parser.expr();
        System.out.printf("Tree = %s\n", tree.toStringTree(parser));
        System.out.printf("Nome da classe: %s\n", tree.getClass().getName());
        System.out.printf("Valor da expressão: %d\n",avalie(tree));
        
    }

}