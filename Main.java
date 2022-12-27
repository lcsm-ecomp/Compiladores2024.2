import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.Trees;
import java.util.*;
import java.io.*;

class Main {

    public static void main(String args[]) throws Exception {
        CharStream input = CharStreams.fromString("10 + 4");
        ExprLexer lexer = new ExprLexer( input);
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        ExprParser parser = new ExprParser( tokens ); 
        ParserRuleContext tree = parser.expr();
        System.out.printf("Tree = %s\n", tree.toStringTree(parser));
        System.out.printf("class = %s\n", tree.getClass().getName().replace("Context","").replace("ExprParser$",""));
        //System.out.printf("%d\n", tree.getRuleIndex());
        Trees.save(tree,parser,"Tree.ps");
        //ParseTreeWalker walker = new ParseTreeWalker();
        //walker.walk( new HelloWalker(), tree );
    }

}