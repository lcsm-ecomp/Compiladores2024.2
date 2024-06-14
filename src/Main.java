import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

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

   public static int avalie_walking(ExprParser.ExprContext t) {
      Stack<Integer> pilha = new Stack<Integer>();
      ExprListener lis = new ExprBaseListener() {
            
            @Override public void exitConst(ExprParser.ConstContext ctx) { 
                  int valor = Integer.parseInt(ctx.n.getText());
                  pilha.push(valor);
            }
            @Override public void exitSoma(ExprParser.SomaContext ctx) { 
                  int b = pilha.pop();
                  int a = pilha.pop();
                  pilha.push(a+b);
            }
            @Override public void exitProduto(ExprParser.ProdutoContext ctx) { 
                  int b = pilha.pop();
                  int a = pilha.pop();
                  pilha.push(a*b);

            }
      };
      ParseTreeWalker.DEFAULT.walk(lis,t);
      return pilha.pop();

   }
   public static String geracodigo_walking(ExprParser.ExprContext t) {
      Stack<String> pilha = new Stack<String>();
      ExprListener lis = new ExprBaseListener() {
            
            @Override public void exitConst(ExprParser.ConstContext ctx) { 
                  String valor = "parseInt('"+ctx.n.getText()+"')";
                  pilha.push(valor);
            }
            @Override public void exitSoma(ExprParser.SomaContext ctx) { 
                  String b = pilha.pop();
                  String a = pilha.pop();
                  pilha.push(" soma("+a+" , "+b+") ");
            }
            @Override public void exitProduto(ExprParser.ProdutoContext ctx) { 
                  String b = pilha.pop();
                  String a = pilha.pop();
                  pilha.push(" produto("+a+" , "+b+") ");

            }
      };
      ParseTreeWalker.DEFAULT.walk(lis,t);
      return pilha.pop();

   }
   public static void main(String args[]) {
         CharStream input = CharStreams.fromString(args[0]);
         ExprLexer lexer = new ExprLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         ExprParser parser = new ExprParser(tokens);
         ExprParser.ExprContext t = parser.expr();
         System.out.printf("Valor = %d\n", avalie(t));
         passear(t);
         System.out.printf("valor usando listener = %d\n",avalie_walking(t));
         System.out.printf("codigo gerado:\n   %s\n",geracodigo_walking(t));
   }
}