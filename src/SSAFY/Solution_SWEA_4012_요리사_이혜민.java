package SSAFY;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_이혜민 {
    static int N;
    static int[][] food;
    static boolean[] visited;
    static ArrayList<int[]> list1, list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine()); //식재료 갯수
            //food 배열 초기화
            food = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= N; j++) {
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            visited = new boolean[N + 1];
            combi(0, 1);


            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list1.size(); i++) {
                int gap = getSum(list1.get(i)) - getSum(list2.get(i));
                gap = Math.abs(gap);

                if (min > gap) min = gap;
            }

            sb.append("#").append(testCase).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void combi(int cnt, int start) {
        if (cnt == N / 2) {
            int[] result1 = new int[N / 2];
            int[] result2 = new int[N / 2];
            int index1 = 0, index2 = 0;
            for (int i = 1; i <= N; i++) {
                if (visited[i]) result1[index1++] = i;
                else result2[index2++] = i;
            }
            //서로 겹치지않는 수 add
            list1.add(result1);
            list2.add(result2);
            return;
        }

        for (int i = start; i <= N; i++) {
            visited[i] = true;
            combi(cnt + 1, i + 1);
            visited[i] = false;
        }
    }

    private static int getSum(int[] num) { // N/2개의 뽑힌 수가 들어오면 두개씩 뽑아서 시너지값을 구함
        int sum = 0;
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int a = num[i];
                int b = num[j];
                sum += food[a][b] + food[b][a];
            }
        }
        return sum;
    }
}
