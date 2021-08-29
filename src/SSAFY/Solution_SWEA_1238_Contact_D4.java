package SSAFY;

import java.io.*;
import java.util.*;

public class Solution_SWEA_1238_Contact_D4 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            list = new ArrayList[101];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i += 2) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
            }

            visited = new int[101];
            result = 0;
            bfs(start);

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num]++;
        int maxLevel = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int fr : list[cur]) {
                if (visited[fr] == 0) {
                    visited[fr] = visited[cur] + 1; //상위노드+1 함으로서 레벨 증가 처리
                    queue.add(fr);
                }
            }
            maxLevel = visited[cur]; //가장 높은 레벨을 찾아줌
        }


        for (int i = 0; i < 101; i++) {
            if (visited[i] == maxLevel) { //가장 높은 레벨을 가진 숫자 중
                result = Math.max(i, result); //최댓값을 찾음
            }
        }
    }
}
