package parsing.token;

public class Word extends Token {
    
    public Word(String str) {
        super(str);
    }

    @Override
    public String toString() {
        return String.format("Word(%s)", str);
    }

}
