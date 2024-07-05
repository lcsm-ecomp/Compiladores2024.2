import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;

public class MainImp {
    static HashSet<String> varsDecl;
    public static boolean verifique(ImpParser.ComContext com) {
      varsDecl = new HashSet<String>();
      ImpBaseVisitor<Boolean> visitor = new ImpBaseVisitor<Boolean>() {
            public Boolean visitConst(ImpParser.ConstContext ctx) { 
                  return true;
            }
            public Boolean visitOp(ImpParser.OpContext ctx) { 
                  Boolean esq = ctx.e.accept(this);
                  Boolean dir = ctx.d.accept(this);
                  return esq && dir;
            }
            public Boolean visitGroup(ImpParser.GroupContext ctx) { 
                  return ctx.e.accept(this);
            }
            public Boolean visitVar(ImpParser.VarContext var) {
                  String name = var.n.getText();
                  if (varsDecl.contains(name))
                      return true;
                  else {
                      System.err.println("Variável " + name + " não encontrada");
                      return false;
                  }
            }
            public Boolean visitPrint(ImpParser.PrintContext prt) {
                  return prt.e.accept(this);
            }
            public Boolean visitAtrib(ImpParser.AtribContext atr) {
                  Boolean correct = atr.e.accept(this);
                  String name = atr.v.getText();
                  if (!varsDecl.contains(name)) {
                        System.err.println("Variável " + name + " não encontrada");
                        return false;  
                  }
                  return correct;
            }
            public Boolean visitWhile(ImpParser.WhileContext tree) {
                  return tree.e.accept(this) && tree.cRep.accept(this);
            }
            public Boolean visitIf(ImpParser.IfContext tree) {
                  return tree.e.accept(this) && tree.cTrue.accept(this) && tree.cFalse.accept(this);    
            }
            public Boolean visitBlock(ImpParser.BlockContext blk) {
                  boolean correct = true;
                  HashSet<String> declsInicio = (HashSet<String>) varsDecl.clone();
                  for (int c=1;c<blk.getChildCount()-1;c++)
                      correct = correct && blk.getChild(c).accept(this);
                  varsDecl = declsInicio;
                  return correct;
            }
            public Boolean visitDec(ImpParser.DecContext dec) {
                  String name = dec.name.getText();
                  Boolean correct = dec.vInic.accept(this);
                  if (varsDecl.contains(name)) {
                        System.err.printf("a variavel %s já foi declarada",name);
                        return false;
                  }
                  varsDecl.add(name);
                  return correct; 
            }
            

      };
      return com.accept(visitor);

   }
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
            public Integer visitWhile(ImpParser.WhileContext tree) {
                  Integer teste = tree.e.accept(this);
                  while (teste!=0) {
                        tree.cRep.accept(this);
                        teste = tree.e.accept(this);
                  }
                  return 0;
            }
            public Integer visitIf(ImpParser.IfContext tree) {
                  Integer teste = tree.e.accept(this);
                  if (teste!=0)
                     return tree.cTrue.accept(this);
                  else
                     return tree.cFalse.accept(this);
                  
            }
            public Integer visitBlock(ImpParser.BlockContext blk) {
                  for (int c=1;c<blk.getChildCount()-1;c++)
                      blk.getChild(c).accept(this);
                  return 0;
            }
            public Integer visitDec(ImpParser.DecContext dec) {
                  Integer valor = dec.vInic.accept(this);
                  String name = dec.name.getText();
                  memoria.put(name,valor);
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
         if (t==null) {
            System.out.println("T é nulo!!!!!");
            System.exit(0);
         }
         if (verifique(t)==false) {
            System.err.println("O programa tem erros de tipos e não pode ser executado");
            System.exit(0);
         }
         
         long start = System.nanoTime();
         System.out.println("Executanto código");
         avalieVisitor(t);
         long end = System.nanoTime();
         System.out.printf("Tempo de Execução: %dms\n", (end-start)/1000000);
         
   }
}