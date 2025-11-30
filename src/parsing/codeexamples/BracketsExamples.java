package parsing.codeexamples;

public class BracketsExamples {
    
    public static final String balanced1 = "{ a b [ c d ( e f ) g h ] i j } ( k l [ m n ] ) o p";

    public static final String balanced2 = "{ a [ b ( c ) d ] e }";

    public static final String balanced3 = "({[()]}[])";

    public static final String unbalanced1 = "{[())}"; // [ paired with )

    public static final String unbalanced2 = "({[()]}"; // ( with no pair

    public static final String unbalanced3 = "{[()]})"; // ) with no pair

    public static final String unbalanced4 = "{[()]}([()]}"; // ( paired with }
    
}
