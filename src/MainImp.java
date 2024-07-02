import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class MainImp {
   public static int avalieVisitor(ImpParser.ComContext exp) {
      HashMap<String, Integer> memoria = new HashMap<String,Integer>();

      ImpBaseVisitor<Integer> visitor = new ImpBaseVisitor<Integer>() {
            public Integer visitConst(ImpParser.ConstContext ctx) { 
                  return Integer.parseInt(ctx.getText());
            }
            public Integer visitOp(ImpParser.OpContext ctx) { 
                  Integer esq = ctx.e.accept(this);
                  Integer dir = ctx.d.accept(this);
                  if (ctx.o.getText().equals("+")) return esq+dir;
                  if (ctx.o.getText().equals("-")) return esq-dir;
                  if (ctx.o.getText().equals("*")) return esq*dir;
                  if (ctx.o.getText().equals("/")) return esq/dir;
                  return 0;
            }
            public Integer visitGroup(ImpParser.GroupContext ctx) { 
                  return ctx.e.accept(this);
            }
            public Integer visitVar(ImpParser.VarContext var) {
                  String name = var.n.getText();
                  if (memoria.containsKey(name))
                      return memoria.get(name);
                  throw new RuntimeException("Variável " + name + " não encontrada");
            }
            public Integer visitPrint(ImpParser.PrintContext prt) {
                  Integer v = prt.e.accept(this);
                  System.out.println("Print("+v+")");
                  return 0;
            }
            public Integer visitAtrib(ImpParser.AtribContext atr) {
                  Integer valor = atr.e.accept(this);
                  String name = atr.v.getText();
                  memoria.put(name,valor);
                  return 0;
            }
            public Integer visitBlock(ImpParser.BlockContext blk) {
                  for (int c=1;c<blk.getChildCount()-1;c++)
                      blk.getChild(c).accept(this);
                  return 0;
            }
            

      };
      return exp.accept(visitor);
   }   
   public static void main(String args[]) throws Exception {
         CharStream input = CharStreams.fromFileName(args[0]);
         ImpLexer lexer = new ImpLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         ImpParser parser = new ImpParser(tokens);
         ImpParser.ComContext t = parser.com();
         if (t==null) System.out.println("T é nulo!!!!!");
         System.out.printf("Valor usando visitor= %d\n", avalieVisitor(t));
   }
}