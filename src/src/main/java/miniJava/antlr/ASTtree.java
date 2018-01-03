package miniJava.antlr;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ASTtree {
    private static SymTabScopeNode mainScope;
    private static HashMap<String, SymTabScopeNode> ClassScopeTab;
    public static List<String> semanticerrormsg;
    public static int semanticserrnum = 0;

    public static void PrintSymTabScope() {
        System.out.println("==========The Symbol Table Hierarchy==========");
        mainScope.printSymTab();
        System.out.println();
        for(SymTabScopeNode n : mainScope.next){
            PrintSymTabScopeLoop(n);
            System.out.println("----------------");
        }
    }

    private static void PrintSymTabScopeLoop(SymTabScopeNode root) {
        root.printSymTab();
        for(SymTabScopeNode n : root.next){
            PrintSymTabScopeLoop(n);
            System.out.println("----------------");
        }
    }

    public static void PrintClassScope(){
        System.out.println("\n==========Symbol Table===========");
        for(String key : ASTtree.ClassScopeTab.keySet()){
            System.out.println(key+":");
            ASTtree.ClassScopeTab.get(key).printSymTab();
            System.out.println();
        }
    }

    public abstract static class ASTtreeNode{
        public abstract String printNode();
        public abstract void createSymTab(SymTabScopeNode curScope);
        public abstract String TypeCheck(SymTabScopeNode curScope);
    };

    public abstract static class StatementNode extends ASTtreeNode {

    };

    public static class ExpressionNode extends StatementNode {
        int line, charPositionInLine;

        ExpressionNode(){

        }

        ExpressionNode(int line, int charpos){
            this.line = line;
            this.charPositionInLine = charpos;
        }
        public String GetTypeErr(int errornum, String msg, String require, String get){
            return "[" + Integer.toString(errornum) + "]Semantic Error: Line "+line+":"+charPositionInLine+" "+ msg +
                    "\n\tRequire: " + require + ", Get: "+ get + "\n";
        }
        public String printNode(){
            return "";
        }
        public void createSymTab(SymTabScopeNode curScope){

        }
        public String TypeCheck(SymTabScopeNode curScope){
            return "";
        }
    };

    public static class IdentifierNode extends ExpressionNode {
        String s;
        int line, charPositionInLine;
        public IdentifierNode(String str, int line, int charPositionInLine){
            this.s = str;
            this.line = line;
            this.charPositionInLine = charPositionInLine;
        }

        public String Getsemanticerr(int errornum, String msg){
            return "[" + Integer.toString(errornum) + "]Semantic Error: Line "+line+":"+charPositionInLine+" "+ msg + ":" + s + "\n";
        }

        public String GetTypeErr(int errornum, String msg, String require, String get){
            return "[" + Integer.toString(errornum) + "]Semantic Error: Line "+line+":"+charPositionInLine+" "+ msg + ":" + s +
                    "\n\tRequire: " + require + ", Get: "+ get + "\n";
        }

        @Override
        public String printNode() {
            return "Identifier:"+s;
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}

        @Override
        public String TypeCheck(SymTabScopeNode curScope){
            SymbolEntry entry;
            while(curScope != null){
                if((entry = curScope.getSymTab(s)) != null)
                    return entry.getKind();
                else{
                    curScope = curScope.parent;
                }
            }
            return "null";
        }
    };

    public static class ProgramNode extends ASTtreeNode {
        MainClassNode m;
        List<ClassDeclNode> cl;
        SymTabScopeNode mainScope;

        @Override
        public String printNode() {
            StringBuilder builder  = new StringBuilder("Program ( ");
            builder.append(m.printNode()).append(" , ");
            for(ClassDeclNode c : cl){
                builder.append(c.printNode()).append(" , ");
            }
            builder.delete(builder.length()-3, builder.length());
            builder.append(" ) ");
            return builder.toString();
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope){
            ClassScopeTab = new HashMap<>();
            mainScope = new SymTabScopeNode(curScope);

            m.createSymTab(mainScope);
            for(ClassDeclNode c : cl){
                c.createSymTab(mainScope);
            }
        }

        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            m.TypeCheck(ClassScopeTab.get("mainclass"));
            for(ClassDeclNode c : cl){
                c.TypeCheck(ClassScopeTab.get(c.i.s));
            }
            return "null";
        }
    };

    public static class MainClassNode extends ASTtreeNode {
        IdentifierNode i1, i2;
        StatementNode s;
        SymTabScopeNode clsScope;
        @Override
        public String printNode() {
            return "MainClass ( " + i1.printNode() + " , " + i2.printNode() + " , " + s.printNode() + " ) ";
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope){
            SymbolEntry clsentry = new SymbolEntry("class", "class");
            if(!curScope.insertSym(i1.s, clsentry)){
                semanticserrnum ++;
                semanticerrormsg.add(i1.Getsemanticerr(semanticserrnum, "Duplicate class definition"));
            }

            clsScope = new SymTabScopeNode(curScope);
            curScope.next.add(clsScope);
            ClassScopeTab.put(i1.s, clsScope);

            SymbolEntry fentry = new SymbolEntry("func", "void");
            clsScope.insertSym("mainclass", fentry);

            SymTabScopeNode fScope = new SymTabScopeNode(clsScope);
            clsScope.next.add(fScope);
            SymbolEntry argentry = new SymbolEntry("arg", "String[]");
            if(!fScope.insertSym(i2.s, argentry)){
                semanticserrnum ++;
                semanticerrormsg.add(i2.Getsemanticerr(semanticserrnum, "Duplicate arg definition"));
            }

            s.createSymTab(fScope);

        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!i2.TypeCheck(curScope).equals("String[]")){
                semanticserrnum++;
                semanticerrormsg.add(i2.GetTypeErr(semanticserrnum, "Type Error", "String[]", i2.TypeCheck(curScope)));
            }
            s.TypeCheck(curScope);
            return "null";
        }
    };

    public abstract static class ClassDeclNode extends ASTtreeNode {
        IdentifierNode i;
    };
    public static class ClassDeclSimpleNode extends ClassDeclNode {
        List<VarDeclNode> vl;
        List<MethodDeclNode> ml;
        SymTabScopeNode clsScope;
        @Override
        public String printNode() {
            StringBuilder builder = new StringBuilder("ClassDeclSimple ( ");
            builder.append(i.printNode()).append(" , ");
            for(VarDeclNode v : vl){
                builder.append(v.printNode()).append(" , ");
            }
            for(MethodDeclNode m : ml){
                builder.append(m.printNode()).append(" , ");
            }
            builder.delete(builder.length()-3, builder.length());
            builder.append(" ) ");

            return builder.toString();
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope){
            SymbolEntry clsentry = new SymbolEntry("class", "class");
            if(!curScope.insertSym(i.s, clsentry)){
                semanticserrnum ++;
                semanticerrormsg.add(i.Getsemanticerr(semanticserrnum, "Duplicate class definition"));
            }

            clsScope = new SymTabScopeNode(curScope);
            curScope.next.add(clsScope);
            ClassScopeTab.put(i.s, clsScope);

            for(VarDeclNode v : vl){
                v.createSymTab(clsScope);
            }
            for(MethodDeclNode m : ml){
                m.createSymTab(clsScope);
            }
        }

        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            for(VarDeclNode v : vl){
                v.TypeCheck(clsScope);
            }
            for(MethodDeclNode m : ml){
                m.TypeCheck(clsScope);
            }
            return "null";
        }
    };
    public static class ClassDeclExtendsNode extends ClassDeclSimpleNode {
        IdentifierNode j;
        @Override
        public String printNode() {
            StringBuilder builder = new StringBuilder("ClassDeclExtends ( ");
            builder.append(i.printNode()).append(" , ");
            builder.append(j.printNode()).append(" , ");
            for(VarDeclNode v : vl){
                builder.append(v.printNode()).append(" , ");
            }
            for(MethodDeclNode m : ml){
                builder.append(m.printNode()).append(" , ");
            }
            builder.delete(builder.length()-3, builder.length());
            builder.append(" ) ");

            return builder.toString();
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope){
            SymbolEntry clsentry = new SymbolEntry("class", "class");
            if(!curScope.insertSym(i.s, clsentry)){
                semanticserrnum ++;
                semanticerrormsg.add(i.Getsemanticerr(semanticserrnum, "Duplicate class definition"));
            }

            clsScope = new SymTabScopeNode(curScope);
            curScope.next.add(clsScope);
            ClassScopeTab.put(i.s, clsScope);

            // extends
            if(ClassScopeTab.containsKey(j.s)){
                clsScope.setSymTab(ClassScopeTab.get(j.s).getSymTab());
            }
            else{
                semanticserrnum ++;
                semanticerrormsg.add(j.Getsemanticerr(semanticserrnum, "class identifier does not exist"));
            }

            for(VarDeclNode v : vl){
                v.createSymTab(clsScope);
            }
            for(MethodDeclNode m : ml){
                m.createSymTab(clsScope);
            }

        }
    };

    public static class VarDeclNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        @Override
        public String printNode() {
            return "VarDecl ( " + t.printNode() + " , " + i.printNode() + " ) ";
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope){
            SymbolEntry varentry = new SymbolEntry("var", t.printNode());
            if(!curScope.insertSym(i.s, varentry)){
                semanticserrnum ++;
                semanticerrormsg.add(i.Getsemanticerr(semanticserrnum, "Duplicate var definition"));
            }
        }

        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!curScope.getSymTab(i.s).getKind().equals(t.printNode())){
                semanticserrnum++;
                semanticerrormsg.add(i.GetTypeErr(semanticserrnum, "Type Error", t.printNode(), curScope.getSymTab(i.s).getKind()));
            }
            return "null";
        }
    };

    public static class MethodDeclNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        List<FormalNode> fl;
        List<VarDeclNode> vl;
        List<StatementNode> sl;
        ExpressionNode e;

        SymTabScopeNode mscope;

        @Override
        public String printNode() {
            StringBuilder builder = new StringBuilder("MethodDecl ( ");
            builder.append(t.printNode()).append(" , ");
            builder.append(i.printNode()).append(" , ");
            for(FormalNode f : fl){
                builder.append(f.printNode()).append(" , ");
            }
            for(VarDeclNode v : vl){
                builder.append(v.printNode()).append(" , ");
            }
            for(StatementNode s : sl){
                builder.append(s.printNode()).append(" , ");
            }

            builder.append(e.printNode()).append(" ) ");
            return builder.toString();
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope) {
            SymbolEntry mentry = new SymbolEntry("func", t.printNode());
            if (!curScope.insertSym(i.s, mentry)) {
                semanticserrnum++;
                semanticerrormsg.add(i.Getsemanticerr(semanticserrnum, "Duplicate method definition"));
            }

            mscope = new SymTabScopeNode(curScope);
            curScope.next.add(mscope);

            for(FormalNode f : fl){
                f.createSymTab(mscope);
            }
            for(VarDeclNode v : vl){
                v.createSymTab(mscope);
            }
            for(StatementNode s : sl){
                s.createSymTab(mscope);
            }
            e.createSymTab(mscope);

        }

        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e.TypeCheck(mscope).equals(t.printNode())){
                semanticserrnum++;
                semanticerrormsg.add(i.GetTypeErr(semanticserrnum, "Type Error", t.printNode(), curScope.getSymTab(i.s).getKind()));
            }
            for(FormalNode f : fl){
                f.TypeCheck(mscope);
            }
            for(VarDeclNode v : vl){
                v.TypeCheck(mscope);
            }
            for(StatementNode s : sl){
                s.TypeCheck(mscope);
            }
            return "null";
        }
    };

    public static class FormalNode extends ASTtreeNode {
        TypeNode t;
        IdentifierNode i;
        @Override
        public String printNode() {
            return "Formal ( " + t.printNode() + " , " + i.printNode() + " ) ";
        }

        @Override
        public void createSymTab(SymTabScopeNode curScope){
            SymbolEntry argentry = new SymbolEntry("arg", t.printNode());
            if (!curScope.insertSym(i.s, argentry)) {
                semanticserrnum++;
                semanticerrormsg.add(i.Getsemanticerr(semanticserrnum, "Duplicate arg definition"));
            }
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!curScope.getSymTab(i.s).getKind().equals(t.printNode())){
                semanticserrnum++;
                semanticerrormsg.add(i.GetTypeErr(semanticserrnum, "Type Error", t.printNode(), curScope.getSymTab(i.s).getKind()));
            }
            return "null";
        }

    };

    public abstract static class TypeNode extends ASTtreeNode {
    };
    public static class IntArrayTypeNode extends TypeNode {
        @Override
        public String printNode() { return "IntArrayType"; }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return printNode();
        }
    };
    public static class BooleanTypeNode extends TypeNode {
        @Override
        public String printNode() { return "BooleanType"; }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return printNode();
        }
    };
    public static class IntegerTypeNode extends TypeNode {
        @Override
        public String printNode() { return "IntegerType"; }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return printNode();
        }
    };
    public static class IdentifierTypeNode extends TypeNode {
        String s;
        @Override
        public String printNode() { return "IdentifierType"; }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return printNode();
        }
    };

    public static class BlockNode extends StatementNode {
        List<StatementNode> sl;
        SymTabScopeNode blockScope;
        @Override
        public String printNode() {
            String ret = "Block ( ";
            StringBuilder builder = new StringBuilder(ret);
            for(StatementNode s : sl) {
                builder.append(s.printNode()).append(" , ");
            }
            builder.delete(builder.length()-3, builder.length());
            builder.append(" ) ");
            return builder.toString();
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
            blockScope = new SymTabScopeNode(curScope);
            curScope.next.add(blockScope);
            for(StatementNode s : sl){
                s.createSymTab(blockScope);
            }
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            for(StatementNode s : sl){
                s.TypeCheck(blockScope);
            }
            return "null";
        }
    };
    
    public static class IfNode extends StatementNode {
        ExpressionNode e;
        StatementNode s1,s2;
        @Override
        public String printNode() {
            return "If ( " + e.printNode() + " , " + s1.printNode() + " , " + s2.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
            s1.createSymTab(curScope);
            s2.createSymTab(curScope);
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope){
            if(!e.TypeCheck(curScope).equals("BooleanType")){
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in If statement", "BooleanType", e.TypeCheck(curScope)));
            }
            s1.TypeCheck(curScope);
            s2.TypeCheck(curScope);
            return "null";
        }
    };
    public static class WhileNode extends StatementNode {
        ExpressionNode e;
        StatementNode s;
        @Override
        public String printNode() {
            return "While ( " + e.printNode() + " , " + s.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
            s.createSymTab(curScope);
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope){
            if(!e.TypeCheck(curScope).equals("BooleanType")){
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in while statement", "BooleanType", e.TypeCheck(curScope)));
            }
            s.TypeCheck(curScope);
            return "null";
        }
    };
    public static class PrintNode extends StatementNode {
        ExpressionNode e;
        @Override
        public String printNode() {
            return "Print ( " + e.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope){
            e.TypeCheck(curScope);
            return "null";
        }
    };
    public static class AssignNode extends StatementNode {
        IdentifierNode i;
        ExpressionNode e;
        @Override
        public String printNode() {
            return "Assign ( " + i.printNode() + " , " + e.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope){
            if(!e.TypeCheck(curScope).equals(i.TypeCheck(curScope))){
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in Assign statement", i.TypeCheck(curScope), e.TypeCheck(curScope)));
            }
            return "null";
        }
    };
    public static class ArrayAssignNode extends StatementNode {
        IdentifierNode i;
        ExpressionNode e1,e2;
        @Override
        public String printNode() {
            return "ArrayAssign ( " + i.printNode() + " , " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope){
            if(!e2.TypeCheck(curScope).equals(i.TypeCheck(curScope))){
                semanticserrnum++;
                semanticerrormsg.add(e2.GetTypeErr(semanticserrnum, "Type Error in Assign Array statement", i.TypeCheck(curScope), e2.TypeCheck(curScope)));
            }
            if(!e1.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e1.GetTypeErr(semanticserrnum, "Type Error in Assign Array statement", "IntegerType", e1.TypeCheck(curScope)));
            }
            return "null";
        }
    };

    public static class BinaryOpNode extends ExpressionNode {
        ExpressionNode e1,e2;

        BinaryOpNode(int line, int charpos){
            super(line,charpos);
        }


        @Override
        public String printNode() { return " "; }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e1.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e1.GetTypeErr(semanticserrnum, "Type Error in Binary Expression", "IntegerType", e1.TypeCheck(curScope)));
            }
            if(!e2.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e2.GetTypeErr(semanticserrnum, "Type Error in Binary Expression", "IntegerType", e2.TypeCheck(curScope)));
            }
            return "IntegerType";
        }
    };
    public static class AndNode extends BinaryOpNode {
        AndNode(int line, int charpos){
            super(line, charpos);
        }

        @Override
        public String printNode() {
            return "And ( " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e1.TypeCheck(curScope).equals("BooleanType")){
                semanticserrnum++;
                semanticerrormsg.add(e1.GetTypeErr(semanticserrnum, "Type Error in Binary Expression", "IntegerType", e1.TypeCheck(curScope)));
            }
            if(!e2.TypeCheck(curScope).equals("BooleanType")){
                semanticserrnum++;
                semanticerrormsg.add(e2.GetTypeErr(semanticserrnum, "Type Error in Binary Expression", "IntegerType", e2.TypeCheck(curScope)));
            }
            return "BooleanType";
        }
    };
    public static class LessThanNode extends BinaryOpNode {
        LessThanNode(int line, int charpos){
            super(line, charpos);
        }
        
        @Override
        public String printNode() {
            return "LessThan ( " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e1.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e1.GetTypeErr(semanticserrnum, "Type Error in Binary Expression", "IntegerType", e1.TypeCheck(curScope)));
            }
            if(!e2.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e2.GetTypeErr(semanticserrnum, "Type Error in Binary Expression", "IntegerType", e2.TypeCheck(curScope)));
            }
            return "BooleanType";
        }
    };
    public static class PlusNode extends BinaryOpNode {
        PlusNode(int line, int charpos){
            super(line, charpos);
        }
        @Override
        public String printNode() {
            return "Plus ( " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }

    };
    public static class MinusNode extends BinaryOpNode {
        MinusNode(int line, int charpos){
            super(line, charpos);
        }
        @Override
        public String printNode() {
            return "Minus ( " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }

    };
    public static class TimeNode extends BinaryOpNode {
        TimeNode(int line, int charpos){
            super(line, charpos);
        }
        @Override
        public String printNode() {
            return "Time ( " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }

    };
    public static class ArrayLookupNode extends BinaryOpNode {
        ArrayLookupNode(int line, int charpos){
            super(line, charpos);
        }
        @Override
        public String printNode() {
            return "ArrayLookup ( " + e1.printNode() + " , " + e2.printNode() + " ) ";
        }
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e1.TypeCheck(curScope).equals("IdentifierType")){
                semanticserrnum++;
                semanticerrormsg.add(e1.GetTypeErr(semanticserrnum, "Type Error in ArrayLookup Expression", "IdentifierType", e1.TypeCheck(curScope)));
            }
            if(!e2.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e2.GetTypeErr(semanticserrnum, "Type Error in ArrayLookup Expression", "IntegerType", e2.TypeCheck(curScope)));
            }
            return "IntegerType";
        }
    };

    public static class ArrayLengthNode extends ExpressionNode {
        ExpressionNode e;
        
        ArrayLengthNode(int line, int charpos){
            super(line, charpos);
        }

        
        @Override
        public String printNode() {
            return "ArrayLength ( " + e.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if (!e.TypeCheck(curScope).equals("IdentifierType")) {
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in ArrayLength Expression", "IdentifierType", e.TypeCheck(curScope)));
            }
            return "IntegerType";
        }
    };

    public static class CallNode extends ExpressionNode {
        ExpressionNode e;
        IdentifierNode i;
        List<ExpressionNode> el;
        
        CallNode(int line, int charpos){
            super(line, charpos);
        }

        
        @Override
        public String printNode() {
            String ret =  "Call ( " + e.printNode() + " , " + i.printNode();
            StringBuilder builder = new StringBuilder(ret);
            for(ExpressionNode enode : el){
                builder.append(" , ");
                builder.append(enode.printNode());
            }
            builder.append(" ) ");
            return builder.toString();
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if (!e.TypeCheck(curScope).equals("IdentifierType")) {
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in Call Object", "IdentifierType", e.TypeCheck(curScope)));
            }
            if(!i.TypeCheck(curScope).equals("func")){
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in Call Object", "func", i.TypeCheck(curScope)));
            }
            for(ExpressionNode enode : el){
                // args should match
            }

            return "null";
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
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return "IntegerType";
        }
    };

    public static class TrueNode extends ExpressionNode {
        @Override
        public String printNode() {
            return "True";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return "BooleanType";
        }
    };
    public static class FalseNode extends ExpressionNode {

        @Override
        public String printNode() {
            return "False";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return "BooleanType";
        }
    };

    public static class IdentifierExpNode extends ExpressionNode {
        String s;
        IdentifierExpNode(String str, int line, int charPositionInLine){
             super(line,charPositionInLine);
             this.s = str;
        }
        @Override
        public String printNode() {
            return "Expression ( " + "Identifier:" + s + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return "IdentifierType";
        }
    };

    public static class ThisNode extends ExpressionNode {

        @Override
        public String printNode() {
            return "This";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            return "null";
        }
    };

    public static class NewArrayNode extends ExpressionNode {
        ExpressionNode e;
        
        NewArrayNode(int line, int charpos){
            super(line,charpos);
        }

        
        @Override
        public String printNode() {
            return "NewArray ( " + e.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in New Array Expression", "IntegerType", e.TypeCheck(curScope)));
            }
            return "IntArrayType";
        }
    };

    public static class NewObjectNode extends ExpressionNode {
        IdentifierNode i;
        
        NewObjectNode(int line, int charpos){
            super(line, charpos);
        }

        
        @Override
        public String printNode() {
            return "NewObject ( " + i.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!i.TypeCheck(curScope).equals("class")){
                semanticserrnum++;
                semanticerrormsg.add(i.GetTypeErr(semanticserrnum, "Type Error in New Object Expression", "class", i.TypeCheck(curScope)));
            }
            return "IdentifierType";
        }
    };

    public static class NotNode extends ExpressionNode {
        ExpressionNode e;
        
        NotNode(int line, int charpos){
            super(line, charpos);
        }

        
        @Override
        public String printNode() {
            return "Not ( " + e.printNode() + " ) ";
        }
        @Override
        public void createSymTab(SymTabScopeNode curScope) {}
        @Override
        public String TypeCheck(SymTabScopeNode curScope) {
            if(!e.TypeCheck(curScope).equals("BooleanType") && !e.TypeCheck(curScope).equals("IntegerType")){
                semanticserrnum++;
                semanticerrormsg.add(e.GetTypeErr(semanticserrnum, "Type Error in Not Expression", "BooleanType or IntegerType", e.TypeCheck(curScope)));
            }
            return "BooleanType";
        }
    };

};

