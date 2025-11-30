package compression;

public class NucleotideCompressor {

    public static byte[] compress(String nucleotides) {
        byte length = (byte) nucleotides.length();
        byte data = (byte) 0b00000000;
        int bitCount = length * 2;

        int resLength = (bitCount % 8 == 0) ? bitCount / 8 + 1 : bitCount / 8 + 2;
        byte[] res = new byte[resLength];

        res[0] = length;
        
        for (int i = 0; i < length; i++){
            byte nucleotide = 0;

            if (nucleotides.charAt(i) == 'A') nucleotide = 0;
            else if (nucleotides.charAt(i) == 'C') nucleotide = 1;
            else if (nucleotides.charAt(i) == 'G') nucleotide = 2;
            else if (nucleotides.charAt(i) == 'T') nucleotide = 3;

            data = (byte) ((byte) (nucleotide << 6 - 2 * (i % 4)) | data);

            if ((i + 1) % 4 == 0) {
                res[(i + 1) / 4] = data;
                data = (byte) 0b00000000;
            }

        }

        if (data != 0)
            res[resLength - 1] = data;

        return res;
    }

    public static String decompress(byte[] nucleotides) {
        byte nucleotide;
        byte mask = 0b00000011;
        byte length = nucleotides[0];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = (i / 4) + 1;
            nucleotide = (byte) ((nucleotides[index] >> 6 - 2 * (i % 4)) & mask);

            if (nucleotide == 0) builder.append('A');
            else if (nucleotide == 1) builder.append('C');
            else if (nucleotide == 2) builder.append('G');
            else if (nucleotide == 3) builder.append('T');
        }
        return builder.toString();
    }
    
    public static void compressExample() {
        // In this example we have a byte where the two
        // most-significant bits represent the nucleotide T (11).
        // The rest of the bits are not used for now (zeros).
        byte data = (byte) 0b11000000; // can replace with hexadecimal: (byte) 0xC0
		System.out.println("initial data:");
		System.out.println(toBits(data));
		
		// We want to encode a nucleotide C (01),
		// so our data will look like this: 11010000
		
		// create a nucleotide C (code 1);
		byte n = 1;
		System.out.println("\nnucleotide C:");
		System.out.println(toBits(n));
		
		// shift the nucleotide 4 positions to the left
		byte res = (byte) (n << 4);
		System.out.println("\nresult after left shift:");
		System.out.println(toBits(res));
		
		// apply bitwise OR to combine the nucleotide with the data
		res = (byte) (data | res);
		System.out.println("\nresult after bitwise OR:");
		System.out.println(toBits(res));
		
		// the result shows the compressed nucleotide
		System.out.printf("\nresult: %d\n", res);
    }
    
    public static void decompressExample() {
        // In this example, we have a byte that has nucleotides:
        // T (11), C (01), A (00) and G (10) encoded in it.
        byte data = (byte) 0b11010010; // can replace with hexadecimal: (byte) 0xD2
		System.out.println("initial data:");
		System.out.println(toBits(data));
		
        // We want to decompress the nucleotide C (01).

		// shift the nucleotide 4 positions to the right
		byte res = (byte) (data >> 4);
		System.out.println("\nresult after right shift:");
		System.out.println(toBits(res));
		
		// create a mask
		byte mask = 0b00000011; // 3
		
		// apply bitwise AND to get rid of the first 6 bits
		res = (byte) (res & mask);
		System.out.println("\nresult after bitwise AND:");
		System.out.println(toBits(res));
		
		// the result is 1, therefore the nucleotide is C
		System.out.printf("\nresult: %d\n", res);
    }

    public static String toBits(byte n) {
        StringBuilder sb = new StringBuilder();

        int mask = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int a = (byte) (n & mask);
            if (a > 0 || a == Byte.MIN_VALUE) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            mask >>>= 1;
            if ((i + 1) % 8 == 0) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

}
