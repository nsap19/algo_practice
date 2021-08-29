package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_이혜민_719ms {
    static int[] weights;
    static int N, totalCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //TestCase

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine()); //추의 갯수
            weights = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
            }

            totalCnt = 0;
            perm(0);

            sb.append("#").append(testCase).append(" ").append(totalCnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == N) {
//            System.out.println(Arrays.toString(weights));
            getWeights(0, 0, 0);
            return;
        }

        for (int i = cnt; i < N; i++) {
            int temp = weights[cnt];
            weights[cnt] = weights[i];
            weights[i] = temp;
            perm(cnt + 1);
            temp = weights[cnt];
            weights[cnt] = weights[i];
            weights[i] = temp;
        }
    }

    private static void getWeights(int cnt, int leftSum, int rightSum) {
        if (cnt == N) {
            totalCnt++;
            return;
        }

        getWeights(cnt + 1, leftSum + weights[cnt], rightSum);
        if (rightSum + weights[cnt] <= leftSum) getWeights(cnt + 1, leftSum, rightSum + weights[cnt]);
    }


}
