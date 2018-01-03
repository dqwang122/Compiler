package miniJava;

import java.io.IOException;

import miniJava.antlr.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.atn.PredictionMode;

import miniJava.antlr.gen.MyminiJavaLexer;
import miniJava.antlr.gen.MyminiJavaParser;


public class Main {
    private static void TestExample(String filename) throws IOException{

        // create a lexer that feeds off of input CharStream
        MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromFileName(filename));

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

//        root.createSymTab(null);


    }

   public static void run(String str) {
        ParseTree tree = null;

        try {
            // create a lexer that feeds off of input CharStream
            MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromString(str));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MyErrorListener.UnderlineLexerListener());

            // create a buffer of tokens pulled from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // create a parser that feeds off the tokens buffer
            MyminiJavaParser parser = new MyminiJavaParser(tokens);
            parser.removeErrorListeners(); // remove ConsoleErrorListener
            parser.addErrorListener(new MyErrorListener.UnderlineParserListener());
            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            tree = parser.statement();
        }
        catch (Exception e){
            System.err.println("Syntax Wrong!");
        }
        finally {
            MyErrorListener.CheckSyntax();
        }

        // begin parsing at goal rule
//        ParseTree tree = parser.expression();
       if(tree != null && !MyErrorListener.IsError()) {
           MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
           ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
           System.out.println(root.printNode());
       }
       else{
            System.err.println("There are syntax errors and the AST tree can't be created!");
       }

    }

   public static void main(String [] args) throws IOException{
        String filename = "examples/factorial.java";
        TestExample(filename);
//       run("{{a=1;}}{b=1;}}");
   }
}
