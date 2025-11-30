package parsing.token;

public class LineToken extends Token {
    
    public LineToken(String str) {
        super(str);
    }

    @Override
    public String toString() {
        return String.format("LineToken()", str);
    }

}
