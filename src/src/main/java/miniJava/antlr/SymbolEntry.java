package miniJava.antlr;

public class SymbolEntry{
    private String kind;
    private String type;
    public SymbolEntry(String kind, String type){
        this.kind = kind;
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public String getType() {
        return type;
    }
}
