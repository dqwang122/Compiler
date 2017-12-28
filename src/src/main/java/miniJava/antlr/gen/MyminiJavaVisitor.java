// Generated from E:/GitHub/Java/Compiler/src/src/main/java\MyminiJava.g4 by ANTLR 4.7
package miniJava.antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyminiJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyminiJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(MyminiJavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(MyminiJavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MyminiJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MyminiJavaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MyminiJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#formalList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalList(MyminiJavaParser.FormalListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#formalRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalRest(MyminiJavaParser.FormalRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MyminiJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MyminiJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MyminiJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MyminiJavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#expList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpList(MyminiJavaParser.ExpListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyminiJavaParser#expRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpRest(MyminiJavaParser.ExpRestContext ctx);
}