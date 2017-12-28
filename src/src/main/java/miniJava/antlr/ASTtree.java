package miniJava.antlr;

import java.beans.Expression;
import java.util.List;

public class ASTtree {
    public abstract static class ASTtreeNode{
        public abstract String printNode();
    };

    public static class TypeNode extends ASTtreeNode {
        @Override
        public String printNode() {
            return "";
        }

    };

    public static class StatementNode extends ASTtreeNode {
        @Override
        public String printNode() {
            return "";
        }

    };

    public static class ExpressionNode extends StatementNode {
        @Override
        public String printNode() {
            return "";
        }

    };

    public static class IdentifierNode extends ExpressionNode {
        String s;
        public IdentifierNode(String str){
            s = str;
        }

        @Override
        public String printNode() {
            return "Identifier:"+s;
        }
    };

    public static class ProgramNode extends ASTtreeNode {
        MainClassNode m;
        List<ClassDeclNode> cl;
        @Override
        public String printNode() { return " "; }
    };

    public static class MainClassNode extends ASTtreeNode {
        IdentifierNode i1, i2;
        StatementNode s;
        @Override
        public String printNode() { return " "; }
    };


    public abstract static class ClassDeclNode extends ASTtreeNode {

    };
    public static class ClassDeclSimpleNode extends ClassDeclNode {
        IdentifierNode i;
        List<VarDeclNode> vl;
        List<MethodDeclNode> ml;
        @Override
        public String printNode() { return " "; }
    };
    public static class ClassDeclExtendsNode extends ClassDeclSimpleNode {
        IdentifierNode j;
        @Override
        public String printNode() { return " "; }
    };

    public static class VarDeclNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        @Override
        public String printNode() { return " "; }
    };

    public static class MethodDeclNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        List<FormalNode> fl;
        List<VarDeclNode> vl;
        List<StatementNode> sl;
        ExpressionNode e;
        @Override
        public String printNode() { return " "; }
    };

    public static class FormalNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        @Override
        public String printNode() { return " "; }
    };

    public static class IntArrayTypeNode extends TypeNode {
        @Override
        public String printNode() { return " "; }
    };
    public static class BooleanTypeNode extends TypeNode {
        @Override
        public String printNode() { return " "; }
    };
    public static class IntegerTypeNode extends TypeNode {
        @Override
        public String printNode() { return " "; }
    };
    public static class IdentifierTypeNode extends TypeNode {
        String s;
        @Override
        public String printNode() { return " "; }
    };

    public static class BlockNode extends ASTtreeNode {
        List<StatementNode> sl;
        @Override
        public String printNode() { return " "; }
    };

    public static class IfNode extends StatementNode {
        ExpressionNode e;
        StatementNode s1,s2;
        @Override
        public String printNode() { return " "; }
    };
    public static class WhileNode extends StatementNode {
        ExpressionNode e;
        StatementNode s;
        @Override
        public String printNode() { return " "; }
    };
    public static class PrintNode extends StatementNode {
        ExpressionNode e;
        @Override
        public String printNode() { return " "; }
    };
    public static class AssignNode extends StatementNode {
        IdentifierNode i;
        ExpressionNode e;
        @Override
        public String printNode() { return " "; }
    };
    public static class ArrayAssignNode extends StatementNode {
        IdentifierNode i;
        ExpressionNode e1,e2;
        @Override
        public String printNode() { return " "; }
    };

    public static class BinaryOpNode extends ExpressionNode {
        ExpressionNode e1,e2;
        @Override
        public String printNode() { return " "; }
    };
    public static class AndNode extends BinaryOpNode {
        @Override
        public String printNode() { return " "; }

    };
    public static class LessThanNode extends BinaryOpNode {
        @Override
        public String printNode() { return " "; }

    };
    public static class PlusNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "Plus(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };
    public static class MinusNode extends BinaryOpNode {
        @Override
        public String printNode() { return " "; }

    };
    public static class TimeNode extends BinaryOpNode {
        @Override
        public String printNode() { return " "; }

    };
    public static class ArrayLookupNode extends ExpressionNode {
        @Override
        public String printNode() { return " "; }

    };

    public static class ArrayLengthNode extends ExpressionNode {
        ExpressionNode e;
        @Override
        public String printNode() { return " "; }
    };

    public static class CallNode extends StatementNode {
        ExpressionNode e;
        IdentifierNode i;
        List<ExpressionNode> el;
        @Override
        public String printNode() { return " "; }
    };

    public static class IntegerLiteralNode extends ExpressionNode {
        int i;
        @Override
        public String printNode() { return " "; }
    };

    public static class TrueNode extends ExpressionNode {
        @Override
        public String printNode() {
            return "True";
        }

    };
    public static class FalseNode extends ExpressionNode {
        @Override
        public String printNode() {
            return "False";
        }

    };

    public static class IdentifierExpNode extends ExpressionNode {
        String s;
        @Override
        public String printNode() { return " "; }
    };

    public static class ThisNode extends ExpressionNode {
        @Override
        public String printNode() {
            return "This";
        }

    };

    public static class NewArrayNode extends ExpressionNode {
        ExpressionNode e;
        @Override
        public String printNode() { return " "; }
    };

    public static class NewObjectNode extends ExpressionNode {
        IdentifierNode i;
        @Override
        public String printNode() { return " "; }
    };

    public static class NotNode extends ExpressionNode {
        ExpressionNode e;
        @Override
        public String printNode() { return " "; }
    };

};

