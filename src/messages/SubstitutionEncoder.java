package messages;

import java.util.HashMap;
import java.util.Map;

public class SubstitutionEncoder extends Encoder{ // https://en.wikipedia.org/wiki/Substitution_cipher

    private String _key;

    public SubstitutionEncoder(String key){
        if (key.length() == 26) _key = key;
        else System.out.println("You must enter 26 charachter.");
    }

    @Override
    public String encode(String message) { // https://java.algorithmexamples.com/web/ciphers/SimpleSubstitutionCipher.html
        String encoded = "";

        Map<Character,Character> cipherMap = new HashMap<Character,Character>();
 
        char beginSmallLetter = 'a';
        char beginCapitalLetter = 'A';
        
        _key = _key.toLowerCase();
        String cipherCapital = _key.toUpperCase();
 
        for(int i = 0; i < _key.length(); i++){
            cipherMap.put(beginSmallLetter++,_key.charAt(i));
            cipherMap.put(beginCapitalLetter++,cipherCapital.charAt(i));
        }
 
        for(int i = 0; i < message.length(); i++){
            if(Character.isAlphabetic(message.charAt(i)))
                encoded += cipherMap.get(message.charAt(i));
            else
                encoded += message.charAt(i);
        }
 
        return encoded;
    }
    
    @Override
    public String decode(String message) { // https://java.algorithmexamples.com/web/ciphers/SimpleSubstitutionCipher.html
        String decoded = "";
 
        Map<Character,Character> cipherMap = new HashMap<Character,Character>();
 
        char beginSmallLetter = 'a';
        char beginCapitalLetter = 'A';
 
        _key = _key.toLowerCase();
        String keyCapital = _key.toUpperCase();
 
        for(int i = 0; i < _key.length(); i++){
            cipherMap.put(_key.charAt(i),beginSmallLetter++);
            cipherMap.put(keyCapital.charAt(i),beginCapitalLetter++);
        }
 
        for(int i = 0; i < message.length(); i++){
            if(Character.isAlphabetic(message.charAt(i)))
                decoded += cipherMap.get(message.charAt(i));
            else
                decoded += message.charAt(i);
        }
 
        return decoded;
    }
}
