package miniJava;

import java.io.IOException;

import miniJava.antlr.MyErrorListener;
import miniJava.antlr.MyminiJavaASTVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.atn.PredictionMode;

import miniJava.antlr.gen.MyminiJavaLexer;
import miniJava.antlr.gen.MyminiJavaParser;
import miniJava.antlr.ASTtree;


public class Main {
    private static void TestExample(String filename) throws IOException{

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
//        System.out.println(tree.toStringTree(parser));

        // print LISP-style AST
        MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
        ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
        System.out.println(root.printNode());

        //show AST in GUI
        LISPtoTreeView.ShowLISPTree(root.printNode());

    }

   public static void run(String str) {

        // create a lexer that feeds off of input CharStream
        MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromString(str));

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println("Lexical analysis successfull");

        // create a parser that feeds off the tokens buffer
        MyminiJavaParser parser = new MyminiJavaParser(tokens);

        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new MyErrorListener.UnderlineListener());
        parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        parser.goal();

        // begin parsing at goal rule
//        ParseTree tree = parser.expression();
//        MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
//        ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
//        System.out.println(root.printNode());



    }

   public static void main(String [] args) throws IOException{
//        String filename = "examples/binarysearch.java";
//        TestExample(filename);
       run("da&s");
   }
}
