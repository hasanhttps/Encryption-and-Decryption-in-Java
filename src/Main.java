import compression.NucleotideCompressor;
import java.util.List;
import java.util.Scanner;
import messages.*;
import parsing.BalancedBrackets;
import parsing.Parser;
import parsing.TokenCompare;
import parsing.codeexamples.*;
import parsing.token.*;
import parsing.tokenizer.*;

public class Main {
    
    public static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        loop: while (true) {
            System.out.print("block> ");
            String line = sc.nextLine();
            switch (line) {
                case "1": {
                    messagesTask();
                    break;
                }
                case "2": {
                    parsingTask();
                    break;
                }
                case "3": {
                    compressionTask();
                    break;
                }
                case "x":
                    break loop;
            }
        }
        sc.close();
    }

    public static void messagesTask() {
        System.out.print("message: ");
        String message = sc.nextLine();

        Encoder joinEncoder = new JoinEncoder(
            new SubstitutionEncoder("qwertyuiopasdfghjklzxcvbnm"),
            new CaesarEncoder(5),
            new XOREncoder("I shall not copy")
        );

        String encoded = joinEncoder.encode(message);
        System.out.println("encoded:");
        System.out.println(encoded);

        String decoded = joinEncoder.decode(encoded);
        System.out.println("decoded:");
        System.out.println(decoded);
    }

    public static void parsingTask() {
        Tokenizer tokenizer = new JavaTokenizer();
        
        System.out.print("task> ");
        String task = sc.nextLine();
        switch (task) {
            case "1": {
                System.out.println(tokenizer.tokenize(CommentsExamples.example1));
                break;
            }
            case "2": {
                System.out.println(tokenizer.tokenize(BracketsExamples.balanced1));
                break;
            }
            case "3": {
                List<Token> tokens = tokenizer.tokenize(BracketsExamples.balanced1);
                System.out.printf(
                    "brackets are balanced: %b\n", 
                    BalancedBrackets.areBracketsBalanced(tokens)
                );
                break;
            }
            case "4": {
                List<Token> tokens = tokenizer.tokenize(BracketsExamples.balanced1);
                System.out.println(Parser.syntaxTree(tokens));
                break;
            }
            case "5": {
                List<Token> tokens1 = tokenizer.tokenize(CodeExamples.example1);
                List<Token> tokens2 = tokenizer.tokenize(CodeExamples.example2);
                System.out.printf("lcs length: %d\n", TokenCompare.lcs(tokens1, tokens2));
                break;
            }
        }
    }

    public static void compressionTask() {
        System.out.print("nucleotides: ");
        String nucl = sc.nextLine();

        byte[] comp = NucleotideCompressor.compress(nucl);
        
        System.out.println("\ncompressed nucleotides in decimal:");
        for (int i = 0; i < comp.length; i++) {
            System.out.print(comp[i] + " ");
        }

        System.out.println("\n\ncompressed nucleotides in binary:");
        for (int i = 0; i < comp.length; i++) {
            System.out.print(NucleotideCompressor.toBits(comp[i]));
        }
        
        String decomp = NucleotideCompressor.decompress(comp);
        System.out.println("\n\ndecompressed nucleotides:");
        System.out.println(decomp);
    }

}
