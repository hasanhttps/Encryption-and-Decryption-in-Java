package messages;

public class CaesarEncoder extends Encoder { // https://en.wikipedia.org/wiki/Caesar_cipher
    
    private final int _offset;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public CaesarEncoder(int offset) {
        _offset = offset;
    }

    @Override
    public String encode(String message) { // https://www.geeksforgeeks.org/ethical-hacking/caesar-cipher-in-cryptography/ by changing the code
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < message.length(); i++) {
            if (ALPHABET.contains(Character.toString(message.charAt(i)).toLowerCase())){
                if (Character.isUpperCase(message.charAt(i))) {
                    char ch = (char)(((int)message.charAt(i) +
                                      _offset - 65) % 26 + 65);
                    result.append(ch);
                }
                else {
                    char ch = (char)(((int)message.charAt(i) +
                                      _offset - 97) % 26 + 97);
                    result.append(ch);
                }
            }
            else result.append(message.charAt(i));
        }

        return result.toString();
    }

    @Override
    public String decode(String message) { // by myself according to encryption
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < message.length(); i++){
            if (ALPHABET.contains(Character.toString(message.charAt(i)).toLowerCase())){
                if (Character.isUpperCase(message.charAt(i))) {
                    char ch;
                    if((int)message.charAt(i) >= 70)
                        ch = (char)(((int)message.charAt(i) - _offset - 65) % 26 + 65);
                    else 
                        ch = (char)((26 - (_offset - ((int)message.charAt(i) - 65))) % 26 + 65);
                    result.append(ch);
                }
                else {
                    char ch = (char)(((int)message.charAt(i) -
                                      _offset - 97) % 26 + 97);
                    result.append(ch);
                }
            }
            else result.append(message.charAt(i));
        }

        return result.toString();
    }
    
}
