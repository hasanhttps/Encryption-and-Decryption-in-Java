package messages;

public class XOREncoder extends Encoder { // https://en.wikipedia.org/wiki/XOR_cipher

    private String _key;
    
    public XOREncoder(String key){
        _key = key;
    }

    @Override
    public String encode(String message) { // https://stackoverflow.com/questions/66283799/java-xor-decryption

        int len = _key.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = (char) (message.charAt(i) ^ _key.charAt(i % len));
            result.append(c);
        }

        return result.toString();
    }

    @Override
    public String decode(String message) {
        String result = encode(message);
        return result;
    }
    
}
