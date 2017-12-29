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
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MyminiJavaParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MyminiJavaParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(MyminiJavaParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(MyminiJavaParser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(MyminiJavaParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(MyminiJavaParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIdType(MyminiJavaParser.IdTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idType}
	 * labeled alternative in {@link MyminiJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIdType(MyminiJavaParser.IdTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MyminiJavaParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MyminiJavaParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MyminiJavaParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MyminiJavaParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MyminiJavaParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MyminiJavaParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(MyminiJavaParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(MyminiJavaParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(MyminiJavaParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(MyminiJavaParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayStat(MyminiJavaParser.ArrayStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayStat}
	 * labeled alternative in {@link MyminiJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayStat(MyminiJavaParser.ArrayStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MyminiJavaParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MyminiJavaParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(MyminiJavaParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(MyminiJavaParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MyminiJavaParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MyminiJavaParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(MyminiJavaParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(MyminiJavaParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(MyminiJavaParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(MyminiJavaParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MyminiJavaParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MyminiJavaParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code innerExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterInnerExpr(MyminiJavaParser.InnerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code innerExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitInnerExpr(MyminiJavaParser.InnerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newarrayExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewarrayExpr(MyminiJavaParser.NewarrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newarrayExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewarrayExpr(MyminiJavaParser.NewarrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MyminiJavaParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MyminiJavaParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprlen}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprlen(MyminiJavaParser.ExprlenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprlen}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprlen(MyminiJavaParser.ExprlenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(MyminiJavaParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(MyminiJavaParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(MyminiJavaParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(MyminiJavaParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MyminiJavaParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MyminiJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MyminiJavaParser.IdExprContext ctx);
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
}