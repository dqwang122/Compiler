package miniJava.antlr;

import miniJava.antlr.gen.MyminiJavaBaseVisitor;
import miniJava.antlr.gen.MyminiJavaParser;
import miniJava.antlr.ASTtree;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;




public class MyminiJavaASTVisitor extends MyminiJavaBaseVisitor<ASTtree.ASTtreeNode> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitGoal(MyminiJavaParser.GoalContext ctx) {
	    return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitMainClass(MyminiJavaParser.MainClassContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitClassDeclaration(MyminiJavaParser.ClassDeclarationContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitVarDeclaration(MyminiJavaParser.VarDeclarationContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitMethodDeclaration(MyminiJavaParser.MethodDeclarationContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitFormalList(MyminiJavaParser.FormalListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitFormalRest(MyminiJavaParser.FormalRestContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitType(MyminiJavaParser.TypeContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitStatement(MyminiJavaParser.StatementContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitExpression(MyminiJavaParser.ExpressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitIdentifier(MyminiJavaParser.IdentifierContext ctx) {
	    return new ASTtree.IdentifierNode(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitExpList(MyminiJavaParser.ExpListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	public ASTtree.ASTtreeNode visitExpRest(MyminiJavaParser.ExpRestContext ctx) { return visitChildren(ctx); }
}