package miniJava.antlr;

import miniJava.antlr.gen.MyminiJavaLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;

public class MyminiJavaErrorLexer extends MyminiJavaLexer {
    public MyminiJavaErrorLexer(CharStream input) {
		super(input);
	}
	public void recover(LexerNoViableAltException e) {
        throw new RuntimeException(e); // Bail out
    }

}
