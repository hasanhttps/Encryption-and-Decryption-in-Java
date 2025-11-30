package parsing.tokenizer;

import java.util.ArrayList;
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
        char newline = '\n';
        boolean isComment = false;
        String brackets = "{[()]}";
        StringBuilder word = new StringBuilder();
        List<Token> tokens = new ArrayList<Token>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '/' && text.charAt(i + 1) == '/') isComment = true;
            if (isComment && c == newline) isComment = false;
            if (isComment) continue;

            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                word.append(c);
            } else{
                if (keywords.contains(word.toString())){
                    tokens.add(new Keyword(word.toString()));
                    word.delete(0, word.length());
                }
                else if (word.length() > 0) {
                    tokens.add(new Word(word.toString()));
                    word.delete(0, word.length());
                }
                if (brackets.indexOf(c) != -1) {
                    tokens.add(new Bracket(Character.toString(c), (c == '{' || c == '}') ? "curl" : (c == '[' || c == ']') ? "b" : "p"));
                } else if (c != '/' && c != ' ' && c != newline) {
                    tokens.add(new Symbol(Character.toString(c)));
                }
            }
        }

        if (word.length() > 0) {
            tokens.add(new Word(word.toString()));
        }

        return tokens;
    }

    @Override
    public List<String> keywords() {
        return JavaTokenizer.keywords;
    }

}
