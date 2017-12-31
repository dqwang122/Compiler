package miniJava.antlr;

import org.antlr.v4.runtime.*;
import java.util.*;


public class MyErrorListener {
    public static class UnderlineListener extends BaseErrorListener {
        private static int errornum = 0;

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                    Object offendingSymbol,
                    int line, int charPositionInLine,
                    String msg,
                    RecognitionException e) {
            errornum ++;
            List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
            Collections.reverse(stack);
            System.err.println("[" + Integer.toString(errornum) + "]Syntax Error: " + "Line "+line+":"+charPositionInLine+" "+msg);
            System.err.println("rule stack: "+stack);
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
            System.err.println(errorLine);
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
}
