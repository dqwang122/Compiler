package miniJava.antlr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SymTabScopeNode {
    String Scopename;
    private HashMap<String, SymbolEntry> SymTab;
    public HashMap<String, SymTabScopeNode> next;
    public SymTabScopeNode parent;

    public SymTabScopeNode(String name, SymTabScopeNode p){
        this.Scopename = name;
        this.SymTab = new HashMap<>();
        this.parent = p;
        this.next = new HashMap<>();
    }

    public SymbolEntry getSymTab(String name) {
        return SymTab.getOrDefault(name, null);
    }

    public boolean insertSym(String name, SymbolEntry symbol){
        if(SymTab.containsKey(name))
            return false;

        SymTab.put(name, symbol);
        return true;

    }

    public HashMap<String, SymbolEntry> getSymTab(){
        return SymTab;
    }

    public void setSymTab(HashMap<String, SymbolEntry> symtable){
        this.SymTab.putAll(symtable);
    }

    public void printSymTab(){
        for(String key : SymTab.keySet()){
            System.out.println(key + "\t" + "kind:" + SymTab.get(key).getKind() + "\ttype:" + SymTab.get(key).getType() + "\tpos:" + SymTab.get(key).getPos());
        }
    }

}




