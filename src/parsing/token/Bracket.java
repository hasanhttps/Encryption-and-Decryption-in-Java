package parsing.token;

public class Bracket extends Token {

    public String bracketType;

    public Bracket(String str, String bracketType) {
        super(str);
        this.bracketType = bracketType;
    }

    public boolean isOpen(){
        return str.equals("{") || str.equals("[") || str.equals("(");
    }

    public boolean isClosed(){
        return str.equals("}") || str.equals("]") || str.equals(")");
    }

    public boolean matches(Bracket other){
        return ((other.isOpen() && isClosed()) || (other.isClosed() && isOpen()) && other.bracketType.equals(bracketType));
    }

    @Override
    public String toString() {
        return String.format("Bracket(%s)", str);
    }
    
}
