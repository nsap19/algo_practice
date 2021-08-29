package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_이혜민_404ms {
    static int N;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken()); //수의 범위
            int M = Integer.parseInt(st.nextToken()); //연산의 갯수

            make();
            sb.append("#").append(testCase).append(" ");
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (num == 0) { //합집합
                    union(a, b);
                } else { //확인
                    if (find(a) == find(b)) sb.append("1");
                    else sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void make() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a) {
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}

