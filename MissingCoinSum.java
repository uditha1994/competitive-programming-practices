import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class MissingCoinSum {

    public static void main(String[] args) throws IOException {
        FastIn in = new FastIn();

        int n = in.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();

        // sort coins
        Arrays.sort(coins);
        long reach = 0;

        for (int c : coins) {
            if (c > reach + 1)
                break; //
            reach += c;
        }

        System.out.println(reach + 1);
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
            int b = read();
            while (b != -1 && b <= ' ')
                b = read();
            boolean neg = (b == '-');
            if (neg)
                b = read();
            int val = 0;
            while (b >= '0' && b <= '9') {
                val = val * 10 + (b - '0');
                b = read();
            }
            return neg ? -val : val;
        }
    }
}