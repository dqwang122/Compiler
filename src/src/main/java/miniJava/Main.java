package miniJava;
import java.io.IOException;
import java.util.Arrays;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.atn.PredictionMode;

import miniJava.antlr.*;
import miniJava.antlr.gen.MyminiJavaLexer;
import miniJava.antlr.gen.MyminiJavaParser;

import javax.swing.JFrame;
import javax.swing.JPanel;




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


        // print concrete syntax tree
//        System.out.println(tree.toStringTree(parser));
        JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);



        // print LISP-style AST
        MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
        ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
        System.out.println(root.printNode());

        //show AST in GUI
        LISPtoTreeView.ShowLISPTree(root.printNode());

//        root.createSymTab(null);


    }

    private static void runTemplate(String filename) throws IOException{
        ParseTree tree = null;

        try {
            // create a lexer that feeds off of input CharStream
            MyminiJavaLexer lexer = new MyminiJavaLexer(CharStreams.fromFileName(filename));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MyErrorListener.UnderlineLexerListener());

            // create a buffer of tokens pulled from the lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // create a parser that feeds off the tokens buffer
            MyminiJavaParser parser = new MyminiJavaParser(tokens);
            parser.removeErrorListeners(); // remove ConsoleErrorListener
            parser.addErrorListener(new MyErrorListener.UnderlineParserListener());
            parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            tree = parser.goal();
        }
        catch (Exception e){
            System.err.println("Syntax Wrong!");
        }
        finally {
            MyErrorListener.CheckSyntax();
        }

        // begin parsing at goal rule
       if(tree != null && !MyErrorListener.IsError()) {
           MyminiJavaASTVisitor ASTvisitor = new MyminiJavaASTVisitor();
           ASTtree.ASTtreeNode root = ASTvisitor.visit(tree);
           System.out.println(root.printNode());
           root.createSymTab(null);
//           ASTtree.PrintSymTabScope();
//           ASTtree.PrintClassScope();
       }
       else{
            System.err.println("There are syntax errors and the AST tree can't be created!");
       }



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
            tree = parser.goal();
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
//        String filename = "examples/error/errorsemantic.java";
       String filename = "examples/factorial.java";
        runTemplate(filename);
//       run("class Factorial{\n" +
//               "    public static void main(String[] a){\n" +
//               "\ta = 1;\n" +
//               "\tb% = ;\n" +
//               "    }\n" +
//               "}");
   }
}
