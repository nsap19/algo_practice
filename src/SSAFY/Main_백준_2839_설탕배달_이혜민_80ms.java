package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Main_백준_2839_설탕배달_이혜민_80ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i <= n / 5; i++) {
            temp = n;
            int cnt = 0;
            if (i > 0) {
                cnt += i;
                temp -= (i * 5);
            }
            if (temp % 3 == 0) {
                cnt += temp / 3;
            } else cnt = -1;

            if (cnt != -1 && cnt < min) min = cnt;
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
