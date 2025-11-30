package parsing.token;

public abstract class Token {

    protected String str;

    protected Token(String str) {
        this.str = str;
    }
    
    public abstract String toString();

    public String getString() {
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        else if (o instanceof Token t) 
            return t.getString().equals(str);
        else return false;
    }

}
