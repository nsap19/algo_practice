package SSAFY;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//그냥 무겁고 가벼운 노드 검색으로 하니 메모리 초과 남
//플로이드 와샬을 이용해서 풀어야하는듯 -> 다시 공부해보기

public class Main_정올_1515_구슬찾기_이혜민 {
    static ArrayList<Integer>[] heavy;
    static ArrayList<Integer>[] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //구슬의 갯
        int M = Integer.parseInt(st.nextToken()); //저울에 올려본 쌍의 갯수

        heavy = new ArrayList[N + 1];
        light = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            heavy[i] = new ArrayList<>();
            light[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            // a > b
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            heavy[b].add(a);
            light[a].add(b);
        }

        int mid = N - ((N + 1) / 2);

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int h = 0, l = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            while (q.size() > 0) {
                int num = q.poll();

                for (int n : heavy[num]) {
                    h++;
                    q.offer(n);
                }
            }

            q.offer(i);
            while (q.size() > 0) {
                int num = q.poll();

                for (int n : light[num]) {
                    l++;
                    q.offer(n);
                }
            }
            if (h > mid || l > mid) cnt++;
        }

        System.out.println(cnt);
    }
}
