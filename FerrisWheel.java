import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        FastIn in = new FastIn();

        int n = in.nextInt();
        int x = in.nextInt();

        int[] w = new int[n];
        for (int i = 0; i < n; i++)
            w[i] = in.nextInt();

        // sort weights
        Arrays.sort(w);

        int l = 0, r = n - 1;
        int gondolas = 0;

        while (l <= r) {
            if (w[l] + w[r] <= x) {
                // lightest kid
                l++;
            }
            // heaviest kid
            r--;
            gondolas++;
        }

        System.out.println(gondolas);
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