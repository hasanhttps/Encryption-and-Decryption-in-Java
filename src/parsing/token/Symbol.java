package parsing.token;

public class Symbol extends Token {
    
    public Symbol(String str) {
        super(str);
    }

    @Override
    public String toString() {
        return String.format("Symbol(%s)", str);
    }

}
