// Generated from E:/GitHub/Java/Compiler/src/src/main/java\MyminiJava.g4 by ANTLR 4.7
package miniJava.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyminiJavaParser}.
 */
public interface MyminiJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(MyminiJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(MyminiJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(MyminiJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(MyminiJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MyminiJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MyminiJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MyminiJavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MyminiJavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MyminiJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MyminiJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#formalList}.
	 * @param ctx the parse tree
	 */
	void enterFormalList(MyminiJavaParser.FormalListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#formalList}.
	 * @param ctx the parse tree
	 */
	void exitFormalList(MyminiJavaParser.FormalListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#formalRest}.
	 * @param ctx the parse tree
	 */
	void enterFormalRest(MyminiJavaParser.FormalRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#formalRest}.
	 * @param ctx the parse tree
	 */
	void exitFormalRest(MyminiJavaParser.FormalRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MyminiJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MyminiJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MyminiJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MyminiJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MyminiJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MyminiJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MyminiJavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MyminiJavaParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#expList}.
	 * @param ctx the parse tree
	 */
	void enterExpList(MyminiJavaParser.ExpListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#expList}.
	 * @param ctx the parse tree
	 */
	void exitExpList(MyminiJavaParser.ExpListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyminiJavaParser#expRest}.
	 * @param ctx the parse tree
	 */
	void enterExpRest(MyminiJavaParser.ExpRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyminiJavaParser#expRest}.
	 * @param ctx the parse tree
	 */
	void exitExpRest(MyminiJavaParser.ExpRestContext ctx);
}