import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.Trees;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Main {

   
    static Pattern classNamePatern = Pattern.compile("[a-zA-Z]+[$]([A-Za-z]+)Context");
    static String getType(ParseTree t) {
       String className = t.getClass().getName();
       Matcher m = classNamePatern.matcher(className);
       if (m.find()) {
         return m.group(1);
       }
       return null;

    }

    public static Map<String,Integer> memoria = new HashMap<>();
    public static int avalie(ParseTree t) {
        String ruleName = getType(t);
        switch (ruleName) {
        case "Elem":
           return Integer.parseInt(t.getChild(0).getText());
        case "Soma":
           return avalie(t.getChild(0)) + avalie(t.getChild(2));
        case "Produto":
           return avalie(t.getChild(0)) * avalie(t.getChild(2));
        case "Grupo":
           return avalie(t.getChild(1));
        case "Variavel":
           String varName = t.getText();
           Integer valor = memoria.get(varName);
           if (valor==null) throw new RuntimeException("Variaval " + varName + " não definida");
           return valor;
        default:
            throw new RuntimeException("Nao ser compilar " + ruleName + " no codigo : " + t.getText());
        }

    }

    public static void main(String args[]) throws Exception {
        CharStream input = CharStreams.fromFileName("input.exp");
        //CharStream input = CharStreams.fromString("10 + 4");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        ExprParser parser = new ExprParser( tokens ); 
        ParserRuleContext tree = parser.expr();
        System.out.printf("Tree = %s\n", tree.toStringTree(parser));
        System.out.printf("Nome da classe: %s\n", getType(tree));
        memoria.put("x",8);
        System.out.printf("Valor da expressão: %d\n",avalie(tree));
        
    }

}