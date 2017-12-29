package miniJava.antlr;

import java.beans.Expression;
import java.util.List;

public class ASTtree {
    public abstract static class ASTtreeNode{
        public abstract String printNode();
    };

    public abstract static class TypeNode extends ASTtreeNode {
    };

    public abstract static class StatementNode extends ASTtreeNode {

    };

    public abstract static class ExpressionNode extends StatementNode {
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
        public String printNode() {
            StringBuilder builder  = new StringBuilder("Program(");
            builder.append(m.printNode()).append(',');
            for(ClassDeclNode c : cl){
                builder.append(c.printNode()).append(',');
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append(')');
            return builder.toString();
        }
    };

    public static class MainClassNode extends ASTtreeNode {
        IdentifierNode i1, i2;
        StatementNode s;
        @Override
        public String printNode() {
            return "MainClass(" + i1.printNode() + ',' + i2.printNode() + ',' + s.printNode() + ')';
        }
    };


    public abstract static class ClassDeclNode extends ASTtreeNode {

    };
    public static class ClassDeclSimpleNode extends ClassDeclNode {
        IdentifierNode i;
        List<VarDeclNode> vl;
        List<MethodDeclNode> ml;
        @Override
        public String printNode() {
            StringBuilder builder = new StringBuilder("ClassDeclExtends(");
            builder.append(i.printNode()).append(',');
            for(VarDeclNode v : vl){
                builder.append(v.printNode()).append(',');
            }
            for(MethodDeclNode m : ml){
                builder.append(m.printNode()).append(',');
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append(')');

            return builder.toString();
        }
    };
    public static class ClassDeclExtendsNode extends ClassDeclSimpleNode {
        IdentifierNode j;
        @Override
        public String printNode() {
            StringBuilder builder = new StringBuilder("ClassDeclExtends(");
            builder.append(i.printNode()).append(',');
            builder.append(j.printNode()).append(',');
            for(VarDeclNode v : vl){
                builder.append(v.printNode()).append(',');
            }
            for(MethodDeclNode m : ml){
                builder.append(m.printNode()).append(',');
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append(')');

            return builder.toString();
        }
    };

    public static class VarDeclNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        @Override
        public String printNode() {
            return "VarDecl(" + t.printNode() + ',' + i.printNode() + ')';
        }
    };

    public static class MethodDeclNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        List<FormalNode> fl;
        List<VarDeclNode> vl;
        List<StatementNode> sl;
        ExpressionNode e;
        @Override
        public String printNode() {
            StringBuilder builder = new StringBuilder("MethodDecl(");
            builder.append(t.printNode()).append(',');
            builder.append(i.printNode()).append(',');
            for(FormalNode f : fl){
                builder.append(f.printNode()).append(',');
            }
            for(VarDeclNode v : vl){
                builder.append(v.printNode()).append(',');
            }
            for(StatementNode s : sl){
                builder.append(s.printNode()).append(',');
            }

            builder.append(e.printNode()).append(')');
            return builder.toString();
        }
    };

    public static class FormalNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        @Override
        public String printNode() {
            return "Formal(" + t.printNode() + ',' + i.printNode() + ')';
        }
    };

    public static class IntArrayTypeNode extends TypeNode {
        @Override
        public String printNode() { return "IntArrayType"; }
    };
    public static class BooleanTypeNode extends TypeNode {
        @Override
        public String printNode() { return "BooleanType"; }
    };
    public static class IntegerTypeNode extends TypeNode {
        @Override
        public String printNode() { return "IntegerType"; }
    };
    public static class IdentifierTypeNode extends TypeNode {
        String s;
        @Override
        public String printNode() { return "IdentifierType"; }
    };

    public static class BlockNode extends ASTtreeNode {
        List<StatementNode> sl;
        @Override
        public String printNode() {
            String ret = "Block(";
            StringBuilder builder = new StringBuilder(ret);
            for(StatementNode s : sl) {
                builder.append(s.printNode()).append(',');
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append(")");
            return builder.toString();
        }
    };

    public static class IfNode extends StatementNode {
        ExpressionNode e;
        StatementNode s1,s2;
        @Override
        public String printNode() {
            return "If(" + e.printNode() + ',' + s1.printNode() + ',' + s2.printNode() + ')';
        }
    };
    public static class WhileNode extends StatementNode {
        ExpressionNode e;
        StatementNode s;
        @Override
        public String printNode() {
            return "While(" + e.printNode() + ',' + s.printNode() + ')';
        }
    };
    public static class PrintNode extends StatementNode {
        ExpressionNode e;
        @Override
        public String printNode() {
            return "Print(" + e.printNode() + ')';
        }
    };
    public static class AssignNode extends StatementNode {
        IdentifierNode i;
        ExpressionNode e;
        @Override
        public String printNode() {
            return "Assign(" + i.printNode() + ',' + e.printNode() + ')';
        }
    };
    public static class ArrayAssignNode extends StatementNode {
        IdentifierNode i;
        ExpressionNode e1,e2;
        @Override
        public String printNode() {
            return "ArrayAssign(" + i.printNode() + ',' + e1.printNode() + ',' + e2.printNode() + ')';
        }
    };

    public static class BinaryOpNode extends ExpressionNode {
        ExpressionNode e1,e2;
        @Override
        public String printNode() { return " "; }
    };
    public static class AndNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "And(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };
    public static class LessThanNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "LessThan(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };
    public static class PlusNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "Plus(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };
    public static class MinusNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "Minus(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };
    public static class TimeNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "Time(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };
    public static class ArrayLookupNode extends BinaryOpNode {
        @Override
        public String printNode() {
            return "ArrayLookup(" + e1.printNode() + ',' + e2.printNode() + ')';
        }

    };

    public static class ArrayLengthNode extends ExpressionNode {
        ExpressionNode e;
        @Override
        public String printNode() {
            return "ArrayLength(" + e.printNode() + ')';
        }
    };

    public static class CallNode extends StatementNode {
        ExpressionNode e;
        IdentifierNode i;
        List<ExpressionNode> el;
        @Override
        public String printNode() {
            String ret =  "Call(" + e.printNode() + ',' + i.printNode();
            StringBuilder builder = new StringBuilder(ret);
            for(ExpressionNode enode : el){
                builder.append(',');
                builder.append(enode.printNode());
            }
            builder.append(")");
            return builder.toString();
        }
    };

    public static class IntegerLiteralNode extends ExpressionNode {
        int i;
        IntegerLiteralNode(int num){
            i = num;
        }
        @Override
        public String printNode() {
            return "Number:" + Integer.toString(i);
        }
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
        IdentifierExpNode(String str){
            s = str;
        }
        @Override
        public String printNode() {
            return "Expression(" + "Identifier:" + s + ')';
        }
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
        public String printNode() {
            return "NewArray(" + e.printNode() + ')';
        }
    };

    public static class NewObjectNode extends ExpressionNode {
        IdentifierNode i;
        @Override
        public String printNode() {
            return "NewObject(" + i.printNode() + ')';
        }
    };

    public static class NotNode extends ExpressionNode {
        ExpressionNode e;
        @Override
        public String printNode() {
            return "Not(" + e.printNode() + ')';
        }
    };

};

