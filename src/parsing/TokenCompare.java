package parsing;

import java.util.List;
import parsing.token.*;

public class TokenCompare {

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int lcs(List<Token> x, List<Token> y) {

        int xlen = x.size(), ylen = y.size();
        
        int[][] arr = new int[xlen + 1][ylen + 1];

        for (int i = 1; i <= xlen; i++)
            for (int j = 1; j <= ylen; j++) {
                
                if (x.get(i - 1).equals(y.get(j - 1)))
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                else 
                    arr[i][j] = max(arr[i - 1][j], arr[i][j - 1]);
                
            }
        
        return arr[xlen][ylen];
    }

}
