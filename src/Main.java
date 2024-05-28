import org.antlr.v4.runtime.*;
import java.io.*;

public class Main {
   public static void main(String args[]) {
         CharStream input = CharStreams.fromString("x=x+1+;");
         SimpleCLexer lexer = new SimpleCLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         SimpleCParser parser = new SimpleCParser(tokens);
         parser.start();
   }
}