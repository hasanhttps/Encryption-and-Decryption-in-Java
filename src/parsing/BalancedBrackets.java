package parsing;

import java.util.*;
import parsing.token.*;

public class BalancedBrackets {

    public static boolean areBracketsBalanced(List<Token> tokens) { 
    // resource: https://www.geeksforgeeks.org/dsa/java-program-to-check-for-balanced-brackets-in-an-expression-well-formedness-using-stack/

        Deque<Bracket> stack = new ArrayDeque<Bracket>();
        List<Bracket> brackets = new ArrayList<Bracket>();

        for (int i = 0; i < tokens.size(); i++)
            if (tokens.get(i) instanceof Bracket b) 
                brackets.add(b);

        for (int i = 0; i < brackets.size(); i++){
            Bracket bracket = brackets.get(i);
            if (bracket.isOpen()) {
                stack.push(bracket);
                continue;
            }

            if (stack.isEmpty()) return false;

            Bracket other = stack.pop();
            if (!bracket.matches(other))
                return false;

        }

        return stack.isEmpty();
    }
}
