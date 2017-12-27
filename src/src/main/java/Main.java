import miniJava.antlr.gen.MyminiJavaBaseListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;



import miniJava.antlr.gen.MyminiJavaLexer;
import miniJava.antlr.gen.MyminiJavaParser;

import java.io.IOException;


public class Main {
    public static void run(String filename) throws IOException{
        MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromFileName(filename));
        System.out.println("Lexical analysis successfull");

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        MyminiJavaParser parser = new MyminiJavaParser(tokens);

        ParseTree tree = parser.expression();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyminiJavaBaseListener(), tree);
        System.out.println();

    }

   public static void main(String [] args) throws IOException{
        String filename = "examples/Factorial.java";
        run(filename);
   }
}
