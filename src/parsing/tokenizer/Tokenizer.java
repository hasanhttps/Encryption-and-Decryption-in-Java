package parsing.tokenizer;

import java.util.ArrayList;
import java.util.List;

import parsing.token.*;

public abstract class Tokenizer {

    public abstract List<Token> tokenize(String text);
    public abstract List<String> keywords();

    protected List<Token> makeTokens(String text) {
        StringBuilder word = new StringBuilder();
        List<Token> tokens = new ArrayList<Token>();

        char newline = '\n';

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    tokens.add(new Word(word.toString()));
                    word.delete(0, word.length());
                }
                if (c == newline) {
                    tokens.add(new LineToken("\n"));
                } else {
                    tokens.add(new Symbol(Character.toString(c)));
                }
            }
        }

        if (word.length() > 0) {
            tokens.add(new Word(word.toString()));
        }

        return tokens;
    }

    protected List<Token> makeKeywords(List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i) instanceof Word w && isKeyword(w.getString())) {
                Token keyword = new Keyword(w.getString());
                tokens.set(i, keyword);
            }
        }
        return tokens;
    }

    protected boolean isKeyword(String str) {
        List<String> keywords = keywords();
        for (String keyword : keywords) {
            if (keyword.equals(str)) {
                return true;
            }
        }
        return false;
    }

}
