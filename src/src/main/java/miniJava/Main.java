package miniJava;

import java.io.IOException;
import java.util.Arrays;
import javax.swing.*;

import miniJava.antlr.MyminiJavaASTVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;

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
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);


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
        ParseTree tree = parser.statement();
        MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
        ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
        System.out.println(root.printNode());



    }

   public static void main(String [] args) throws IOException{
        String filename = "examples/binarysearch.java";
        TestExample(filename);
//       run("{a = 1; b = 3; System.out.println(a+b); if(a+b) a = 3; else b = 3; while(a<3) b = b+1; a[3]=5;}");
   }
}
