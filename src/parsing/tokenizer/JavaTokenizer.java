package parsing.tokenizer;

import java.util.Arrays;
import java.util.List;

import parsing.token.*;

public class JavaTokenizer extends Tokenizer {
    
    // some of the Java keywords
    private static List<String> keywords = Arrays.asList(
        "for",
        "while",
        "if",
        "switch",
        "do",
        "int",
        "double",
        "boolean",
        "char"
        // ...
    );

    @Override
    public List<Token> tokenize(String text) {
        // TODO: Complete this method for Block 2 Task 1 and Task 2
        List<Token> tokens = makeKeywords(makeTokens(text));
        return tokens;
    }

    @Override
    public List<String> keywords() {
        return JavaTokenizer.keywords;
    }

}
