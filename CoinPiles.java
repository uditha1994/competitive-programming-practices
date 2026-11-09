import java.io.DataInputStream;
import java.io.IOException;

public class CoinPiles {

    public static void main(String[] args) throws IOException {
        FastIn in = new FastIn();
        int t = in.nextInt();

        // collect all outputs in a StringBuilder and print at once to avoid TLE
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long a = in.nextLong();
            long b = in.nextLong();

            boolean divisibleByThree = (a + b) % 3 == 0;
            boolean balanced = Math.max(a, b) <= 2 * Math.min(a, b);

            sb.append(divisibleByThree && balanced ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    static final class FastIn {
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr == len) {
                len = din.read(buf, 0, buf.length);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int b = read();
            while (b != -1 && b <= ' ')
                b = read();
            boolean neg = (b == '-');
            if (neg)
                b = read();
            long val = 0;
            while (b >= '0' && b <= '9') {
                val = val * 10 + (b - '0');
                b = read();
            }
            return neg ? -val : val;
        }
    }
}