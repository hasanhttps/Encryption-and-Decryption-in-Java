package messages;

public class JoinEncoder extends Encoder {
    
    private final Encoder[] encoders;

    public JoinEncoder(Encoder... encoders) {
        this.encoders = encoders;
    }

    @Override
    public String encode(String message) {
        String encoded = message;
        for (int i = 0; i < encoders.length; i++) {
            encoded = encoders[i].encode(encoded);
        }
        return encoded;
    }

    @Override
    public String decode(String message) {
        String decoded = message;
        for (int i = encoders.length - 1; i >= 0; i--) {
            decoded = encoders[i].decode(decoded);
        }
        return decoded;
    }

}
