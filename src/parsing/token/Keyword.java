package parsing.token;

public class Keyword extends Token {
    
    public Keyword(String str) {
        super(str);
    }

    @Override
    public String toString() {
        return String.format("Keyword(%s)", str);
    }
    
}
