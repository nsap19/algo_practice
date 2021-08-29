package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_소수출력_이혜민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //에라토스테네스의 체
        boolean[] arr = new boolean[10000];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < 100; i++) {
            for (int j = 2; i * j < 10000; j++) {
                arr[i * j] = true; //소수에서 제외되는 수
            }
        }


        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            int index = 0;
            for (int i = 0; i < 10000; i++) {
                if (!arr[i]) index++;
                if (index == n) {
                    sb.append("#").append(testCase).append(" ").append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
