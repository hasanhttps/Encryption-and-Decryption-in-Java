package parsing;

import java.util.List;
import parsing.token.*;

public class Parser {
    
    public static String syntaxTree(List<Token> tokens) {

        int count = 0;
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if (token instanceof Bracket b){
                if (b.isOpen()) {
                    printRow(count, token.getString());
                    count++;
                }
                else {
                    count--;
                    printRow(count, token.getString());
                }
            }
            else printRow(count, token.getString());

        }
        return "";
    }

    public static  void printRow(int count, String c){
        for (int j = 0; j < count; j++) 
            System.out.print("    ");
        System.out.println(c);
    }

}
