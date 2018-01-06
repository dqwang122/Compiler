package miniJava.antlr;

public class SymbolEntry{
    private String kind;
    private String type;
    private int pos;
    public SymbolEntry(String kind, String type){
        this.kind = kind;
        this.type = type;
        this.pos = -1;
    }

    public SymbolEntry(String kind, String type, int pos){
        this.kind = kind;
        this.type = type;
        this.pos = pos;
    }

    public String getKind() {
        return kind;
    }

    public String getType() {
        return type;
    }

    public int getPos(){
        return pos;
    }
}
