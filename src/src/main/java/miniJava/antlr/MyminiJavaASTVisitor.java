// Generated from E:/GitHub/Java/Compiler/src/src/main/java\MyminiJava.g4 by ANTLR 4.7

package miniJava.antlr;
import miniJava.antlr.gen.MyminiJavaBaseVisitor;
import miniJava.antlr.gen.MyminiJavaParser;

import java.util.ArrayList;
import java.util.List;

public class MyminiJavaASTVisitor extends MyminiJavaBaseVisitor<ASTtree.ASTtreeNode> {

	public ASTtree.ASTtreeNode visitGoal(MyminiJavaParser.GoalContext ctx) {
        ASTtree.ProgramNode node = new ASTtree.ProgramNode();
        node.m = (ASTtree.MainClassNode) visit(ctx.mainClass());
        node.cl = new ArrayList<ASTtree.ClassDeclNode>();
        for(int i = 0; i < ctx.classDeclaration().size(); i++){
            node.cl.add((ASTtree.ClassDeclNode)visit(ctx.classDeclaration(i)));
        }
	    return node;
	}

	public ASTtree.ASTtreeNode visitMainClass(MyminiJavaParser.MainClassContext ctx) {
        ASTtree.MainClassNode node = new ASTtree.MainClassNode();
        node.i1 = (ASTtree.IdentifierNode) visit(ctx.identifier(0));
        node.i2 = (ASTtree.IdentifierNode) visit(ctx.identifier(1));
        node.s = (ASTtree.StatementNode) visit(ctx.statement());

	    return node;
	}

	public ASTtree.ASTtreeNode visitClassDeclaration(MyminiJavaParser.ClassDeclarationContext ctx) {
	    if(ctx.identifier().size() == 1){
	        ASTtree.ClassDeclSimpleNode node = new ASTtree.ClassDeclSimpleNode();
	        node.i = (ASTtree.IdentifierNode) visit(ctx.identifier(0));

	        node.vl = new ArrayList<ASTtree.VarDeclNode>();
            for(int i = 0; i < ctx.varDeclaration().size(); i++){
                node.vl.add((ASTtree.VarDeclNode)visit(ctx.varDeclaration(i)));
            }
            node.ml = new ArrayList<ASTtree.MethodDeclNode>();
            for(int i = 0; i < ctx.methodDeclaration().size(); i++){
                node.ml.add((ASTtree.MethodDeclNode)visit(ctx.methodDeclaration(i)));
            }

	        return node;
        }
        else if (ctx.identifier().size() == 2){
	        ASTtree.ClassDeclExtendsNode node = new ASTtree.ClassDeclExtendsNode();
	        node.i = (ASTtree.IdentifierNode) visit(ctx.identifier(0));
	        node.j = (ASTtree.IdentifierNode) visit(ctx.identifier(1));

	        node.vl = new ArrayList<ASTtree.VarDeclNode>();
            for(int i = 0; i < ctx.varDeclaration().size(); i++){
                node.vl.add((ASTtree.VarDeclNode)visit(ctx.varDeclaration(i)));
            }
            node.ml = new ArrayList<ASTtree.MethodDeclNode>();
            for(int i = 0; i < ctx.methodDeclaration().size(); i++){
                node.ml.add((ASTtree.MethodDeclNode)visit(ctx.methodDeclaration(i)));
            }

	        return node;
        }
        else{
            // error
            System.out.println("There is an error!");
            return null;
        }

	}

	public ASTtree.ASTtreeNode visitVarDeclaration(MyminiJavaParser.VarDeclarationContext ctx) {
	    ASTtree.VarDeclNode node = new ASTtree.VarDeclNode();
	    node.t = (ASTtree.TypeNode) visit(ctx.type());
	    node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
	    return node;
	}

	public ASTtree.ASTtreeNode visitMethodDeclaration(MyminiJavaParser.MethodDeclarationContext ctx) {
        ASTtree.MethodDeclNode node = new ASTtree.MethodDeclNode();
        node.t = (ASTtree.TypeNode) visit(ctx.type());
        node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
        node.e = (ASTtree.ExpressionNode) visit(ctx.expression());

        node.fl = new ArrayList<ASTtree.FormalNode>();
        for(int i = 0; i < ctx.formalList().size(); i++){
            node.fl.add((ASTtree.FormalNode)visit(ctx.formalList(i)));
        }

        node.vl = new ArrayList<ASTtree.VarDeclNode>();
        for(int i = 0; i < ctx.varDeclaration().size(); i++){
            node.vl.add((ASTtree.VarDeclNode)visit(ctx.varDeclaration(i)));
        }

        node.sl = new ArrayList<ASTtree.StatementNode>();
        for(int i = 0; i < ctx.statement().size(); i++){
            node.sl.add((ASTtree.StatementNode)visit(ctx.statement(i)));
        }

	    return node;
	}

	public ASTtree.ASTtreeNode visitFormalList(MyminiJavaParser.FormalListContext ctx) {
        ASTtree.FormalNode node = new ASTtree.FormalNode();
        node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
        node.t = (ASTtree.TypeNode) visit(ctx.type());
	    return node;
	}

	public ASTtree.ASTtreeNode visitArrayType(MyminiJavaParser.ArrayTypeContext ctx) {
        return new ASTtree.IntArrayTypeNode();
	}

	public ASTtree.ASTtreeNode visitBooleanType(MyminiJavaParser.BooleanTypeContext ctx) {
	    return new ASTtree.BooleanTypeNode();
	}

	public ASTtree.ASTtreeNode visitIntType(MyminiJavaParser.IntTypeContext ctx) {
	    return new ASTtree.IntegerTypeNode();
	}

	public ASTtree.ASTtreeNode visitIdType(MyminiJavaParser.IdTypeContext ctx) {
	    return new ASTtree.IdentifierTypeNode();
	}

	public ASTtree.ASTtreeNode visitBlockStat(MyminiJavaParser.BlockStatContext ctx) {
	    ASTtree.BlockNode node = new ASTtree.BlockNode();
	    node.sl = new ArrayList<ASTtree.StatementNode>();
	    for(int i = 0; i < ctx.statement().size(); i++){
	        node.sl.add((ASTtree.StatementNode) visit(ctx.statement(i)));
        }
	    return node;
	}

	public ASTtree.ASTtreeNode visitIfStat(MyminiJavaParser.IfStatContext ctx) {
	    ASTtree.IfNode node = new ASTtree.IfNode();
	    node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    node.s1 = (ASTtree.StatementNode) visit(ctx.statement(0));
	    node.s2 = (ASTtree.StatementNode) visit(ctx.statement(1));
	    return node;
	}

	public ASTtree.ASTtreeNode visitWhileStat(MyminiJavaParser.WhileStatContext ctx) {
	    ASTtree.WhileNode node = new ASTtree.WhileNode();
	    node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    node.s = (ASTtree.StatementNode) visit(ctx.statement());
	    return node;
	}

	public ASTtree.ASTtreeNode visitPrintStat(MyminiJavaParser.PrintStatContext ctx) {
	    ASTtree.PrintNode node = new ASTtree.PrintNode();
	    node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    return node;
	}

	public ASTtree.ASTtreeNode visitAssignStat(MyminiJavaParser.AssignStatContext ctx) {
	    ASTtree.AssignNode node = new ASTtree.AssignNode();
	    node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
	    node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    return node;
	}

	public ASTtree.ASTtreeNode visitArrayStat(MyminiJavaParser.ArrayStatContext ctx) {
	    ASTtree.ArrayAssignNode node = new ASTtree.ArrayAssignNode();
	    node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
	    node.e1 = (ASTtree.ExpressionNode) visit(ctx.expression(0));
	    node.e2 = (ASTtree.ExpressionNode) visit(ctx.expression(1));
	    return node;
	}

	public ASTtree.ASTtreeNode visitNewExpr(MyminiJavaParser.NewExprContext ctx) {
	    ASTtree.NewObjectNode node = new ASTtree.NewObjectNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	    node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
	    return node;
	}

	public ASTtree.ASTtreeNode visitThisExpr(MyminiJavaParser.ThisExprContext ctx) {
	    return new ASTtree.ThisNode();
	}

	public ASTtree.ASTtreeNode visitArrayExpr(MyminiJavaParser.ArrayExprContext ctx) {
	    ASTtree.ArrayLookupNode node = new ASTtree.ArrayLookupNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	    node.e1 = (ASTtree.ExpressionNode) visit(ctx.expression(0));
	    node.e2 = (ASTtree.ExpressionNode) visit(ctx.expression(1));

	    return node;
	}

	public ASTtree.ASTtreeNode visitCallExpr(MyminiJavaParser.CallExprContext ctx) {
        ASTtree.CallNode node = new ASTtree.CallNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        node.e = (ASTtree.ExpressionNode) visit(ctx.expression(0));
        node.i = (ASTtree.IdentifierNode) visit(ctx.identifier());
        node.el = new ArrayList<ASTtree.ExpressionNode>();
        for(int i = 1; i < ctx.expression().size(); i++){
            node.el.add((ASTtree.ExpressionNode) visit(ctx.expression(i)));
        }

	    return node;
	}

	public ASTtree.ASTtreeNode visitTrueExpr(MyminiJavaParser.TrueExprContext ctx) {
	    return new ASTtree.TrueNode();
	}

	public ASTtree.ASTtreeNode visitNumberExpr(MyminiJavaParser.NumberExprContext ctx) {
	    return new ASTtree.IntegerLiteralNode(Integer.valueOf(ctx.INTEGER_LITERAL().getText()));
	}

	public ASTtree.ASTtreeNode visitBinaryExpr(MyminiJavaParser.BinaryExprContext ctx) {
	    ASTtree.BinaryOpNode node = new ASTtree.BinaryOpNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	    //System.out.println(ctx.Binary_operators().toString());
	    if(ctx.Binary_operators().toString().equals("&&")){
            node = new ASTtree.AndNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        else if(ctx.Binary_operators().toString().equals("<")){
            node = new ASTtree.LessThanNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        else if(ctx.Binary_operators().toString().equals("+")){
            node = new ASTtree.PlusNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        else if(ctx.Binary_operators().toString().equals("-")){
            node = new ASTtree.MinusNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        else if(ctx.Binary_operators().toString().equals("*")){
            node = new ASTtree.TimeNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        else{
            // error
            System.out.println("There is an error!");
        }
	    node.e1 = (ASTtree.ExpressionNode) visit(ctx.expression(0));
        node.e2 = (ASTtree.ExpressionNode) visit(ctx.expression(1));

        return node;
	}

	public ASTtree.ASTtreeNode visitInnerExpr(MyminiJavaParser.InnerExprContext ctx) {
	    return visit(ctx.expression());
	}

	public ASTtree.ASTtreeNode visitNewarrayExpr(MyminiJavaParser.NewarrayExprContext ctx) {
        ASTtree.NewArrayNode node = new ASTtree.NewArrayNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    return node;
	}

	public ASTtree.ASTtreeNode visitNotExpr(MyminiJavaParser.NotExprContext ctx) {
	    ASTtree.NotNode node = new ASTtree.NotNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	    node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    return node;
	}

	public ASTtree.ASTtreeNode visitExprlen(MyminiJavaParser.ExprlenContext ctx) {
	    ASTtree.ArrayLengthNode node = new ASTtree.ArrayLengthNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	    node.e = (ASTtree.ExpressionNode) visit(ctx.expression());
	    return node;
	}

	public ASTtree.ASTtreeNode visitFalseExpr(MyminiJavaParser.FalseExprContext ctx) {
	    return new ASTtree.FalseNode();
	}

	public ASTtree.ASTtreeNode visitIdExpr(MyminiJavaParser.IdExprContext ctx) {
	    return new ASTtree.IdentifierExpNode(ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	}

	public ASTtree.ASTtreeNode visitIdentifier(MyminiJavaParser.IdentifierContext ctx) {
	    return new ASTtree.IdentifierNode(ctx.getText(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
	}
}