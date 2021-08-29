package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_이혜민 {
    static int N;
    static char arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N + 1];
            Arrays.fill(arr, '0');

            for (int i = 0; i < N; i++) {
                String temp[] = br.readLine().split(" ");
                int index = Integer.parseInt(temp[0]);
                char value = temp[1].charAt(0);
                arr[index] = value;
            }
            int result = dfs(1) ? 1 : 0;
            sb.append("#").append(testCase).append(" ").append(result).append("\n");

        }
        System.out.println(sb);
    }

    public static boolean check(int current) {
        if (current <= N && arr[current] != '0') {
            return true;
        }
        return false;
    }

    public static boolean dfs(int current) {
        if (current > N) return false;

        char c = arr[current];
        int left = current * 2;
        int right = current * 2 + 1;
        if (Character.isDigit(c)) { //숫자인 경우 자식 노드가 없어야함
            if (check(left)) return false;
            if (check(right)) return false;
        } else {
            return dfs(left) && dfs(right);
        }

        return true;
    }
}
