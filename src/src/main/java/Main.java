import miniJava.antlr.MyminiJavaASTVisitor;
import miniJava.antlr.gen.MyminiJavaBaseListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;



import miniJava.antlr.gen.MyminiJavaLexer;
import miniJava.antlr.gen.MyminiJavaParser;
import miniJava.antlr.ASTtree;

import java.io.IOException;


public class Main {
    public static void TestExample(String filename) throws IOException{

        // create a lexer that feeds off of input CharStream
        MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromFileName(filename));

        System.out.println("Lexical analysis successfull");

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        MyminiJavaParser parser = new MyminiJavaParser(tokens);
        // begin parsing at goal rule
        ParseTree tree = parser.goal();

        // print LISP-style tree
        System.out.println(tree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyminiJavaBaseListener(), tree);
        System.out.println();

    }

   public static void run(String str) {

        // create a lexer that feeds off of input CharStream
        MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromString(str));

        System.out.println("Lexical analysis successfull");

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        MyminiJavaParser parser = new MyminiJavaParser(tokens);

        // begin parsing at goal rule
        ParseTree tree = parser.expression();
        MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
        ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
        System.out.println(root.printNode());



    }

   public static void main(String [] args) throws IOException{
//        String filename = "examples/Factorial.java";
//        TestExample(filename);
       run("abc+das+dsa");
   }
}
