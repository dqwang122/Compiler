package miniJava.antlr;

import org.antlr.v4.runtime.*;
import java.util.*;


public class MyErrorListener {
    private static int errornum = 0;
    private static int lexererror = 0;
    private static int parsererror = 0;
    public static class UnderlineLexerListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                    Object offendingSymbol,
                    int line, int charPositionInLine,
                    String msg,
                    RecognitionException e) {
            errornum ++;
            lexererror ++;
            System.err.println("[" + Integer.toString(errornum) + "]Lexical Error: " + "Line "+line+":"+charPositionInLine+" "+msg);
        }

    }

    public static class UnderlineParserListener extends BaseErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                    Object offendingSymbol,
                    int line, int charPositionInLine,
                    String msg,
                    RecognitionException e) {
            errornum ++;
            parsererror ++;
            List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
            Collections.reverse(stack);
            System.err.println("[" + Integer.toString(errornum) + "]Syntax Error: " + "Line "+line+":"+charPositionInLine+" "+msg);
            System.err.println("\trule stack: "+stack);
            underlineError(recognizer,(Token)offendingSymbol,
                           line, charPositionInLine);
        }

        private void underlineError(Recognizer recognizer,
                                      Token offendingToken, int line,
                                      int charPositionInLine) {
            CommonTokenStream tokens =
                (CommonTokenStream)recognizer.getInputStream();
            String input = tokens.getTokenSource().getInputStream().toString();
            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];
            System.err.println("\t" + errorLine);
            System.err.print("\t");
            for (int i=0; i<charPositionInLine; i++)
                System.err.print(" ");
            int start = offendingToken.getStartIndex();
            int stop = offendingToken.getStopIndex();
            if ( start>=0 && stop>=0 ) {
                for (int i=start; i<=stop; i++) System.err.print("^");
            }
            System.err.println();
        }
    }

    public static boolean IsError(){
        return errornum != 0;
    }

    public static void CheckSyntax(){
        if(lexererror != 0 && parsererror != 0){
            System.err.println("There are "+ Integer.toString(lexererror)+" lexer error and "+Integer.toString(parsererror)+" parser error.");
        }
        else if(lexererror != 0){
            System.err.println("There are "+ Integer.toString(lexererror)+" lexer error");
        }
        else if(parsererror != 0){
            System.err.println("There are "+ Integer.toString(parsererror)+" parser error");
        }
    }
}
