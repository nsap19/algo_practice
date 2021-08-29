package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Main_백준_1074_Z_이혜민 {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //2^N * 2^N;
        r = Integer.parseInt(st.nextToken()); //행
        c = Integer.parseInt(st.nextToken()); //열

        int size = (int) Math.pow(2, N);

        divide(size, size * size, 0, 0);

    }

    private static void divide(int size, int num, int sr, int sc) {
        if (size==1) {
            System.out.println(num-1);
            return;
        }

        int midR = sr + size / 2;
        int midC = sc + size / 2;

        num /= size;
        if (r < midR && c < midC) {
            divide(size / 2, num, sr, sc);
        } else if (r < midR && c >= midC) {
            divide(size / 2, num * 2, sr, midC);

        } else if (r >= midR && c < midC) {
            divide(size / 2, num * 3, midR, sc);

        } else {
            divide(size / 2, num * 4, midR, midC);

        }

    }


}
