import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Main {
   public static int avalie(ExprParser.ExprContext t) {
      
      if (t instanceof ExprParser.ConstContext) {
            return Integer.parseInt(t.getText());
      } else if (t instanceof ExprParser.SomaContext) {
            var esq = (ExprParser.ExprContext) t.getChild(0);
            var dir = (ExprParser.ExprContext) t.getChild(2);
            return avalie(esq) + avalie(dir);
      } else if (t instanceof ExprParser.ProdutoContext) {
            var esq = (ExprParser.ExprContext) t.getChild(0);
            var dir = (ExprParser.ExprContext) t.getChild(2);
            return avalie(esq) * avalie(dir);
      } else if (t instanceof ExprParser.GrupoContext) {
            var interna = (ExprParser.ExprContext) t.getChild(1);
            return avalie(interna);
      }
      throw new RuntimeException("Tipo de no inválido");
   }
   public static void passear(ExprParser.ExprContext t) {
      ExprListener lis = new ExprBaseListener() {
            @Override public void enterConst(ExprParser.ConstContext ctx) { 
                  System.out.printf("Visitando a constante %s\n", ctx.getText());
            }
            @Override public void enterSoma(ExprParser.SomaContext ctx) { 
                  System.out.printf("Visitando a soma %s\n", ctx.getText());
            }
            @Override public void enterProduto(ExprParser.ProdutoContext ctx) { 
                  System.out.printf("Visitando a multiplicacao %s\n", ctx.getText());
            }
            @Override public void exitConst(ExprParser.ConstContext ctx) { 
                  System.out.printf("deixando a constante %s\n", ctx.getText());
            }
            @Override public void exitSoma(ExprParser.SomaContext ctx) { 
                  System.out.printf("Deixando a soma %s\n", ctx.getText());
            }
            @Override public void exitProduto(ExprParser.ProdutoContext ctx) { 
                  System.out.printf("Deixando a multiplicacao %s\n", ctx.getText());
            }
      };
      ParseTreeWalker.DEFAULT.walk(lis,t);
   }
   public static void main(String args[]) {
         CharStream input = CharStreams.fromString(args[0]);
         ExprLexer lexer = new ExprLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         ExprParser parser = new ExprParser(tokens);
         ExprParser.ExprContext t = parser.expr();
         System.out.printf("Valor = %d\n", avalie(t));
         passear(t);
   }
}