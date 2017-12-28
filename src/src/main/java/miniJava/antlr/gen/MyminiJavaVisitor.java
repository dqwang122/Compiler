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
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MyminiJavaParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(MyminiJavaParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(MyminiJavaParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdType(MyminiJavaParser.IdTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(MyminiJavaParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MyminiJavaParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(MyminiJavaParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(MyminiJavaParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(MyminiJavaParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayStat(MyminiJavaParser.ArrayStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(MyminiJavaParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpr(MyminiJavaParser.ThisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(MyminiJavaParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getmember}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetmember(MyminiJavaParser.GetmemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(MyminiJavaParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(MyminiJavaParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MyminiJavaParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code innerExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInnerExpr(MyminiJavaParser.InnerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newarrayExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewarrayExpr(MyminiJavaParser.NewarrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MyminiJavaParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprlen}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlen(MyminiJavaParser.ExprlenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(MyminiJavaParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(MyminiJavaParser.IdExprContext ctx);
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
}