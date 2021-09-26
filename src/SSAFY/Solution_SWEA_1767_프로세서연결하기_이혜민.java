package SSAFY;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Core {
    int r, c;

    public Core(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution_SWEA_1767_프로세서연결하기_이혜민 {
    static int N, arr[][], maxCore, minLen;
    static ArrayList<Core> coreList;
    static int[] dr = {-1, 0, 1, 0, 0}, dc = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            coreList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] == 1) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) continue; //벽에 붙어있는 코어는 저장하지 않음
                        coreList.add(new Core(i, j)); //연결되어있지 않은 코어의 위치 저장
                    }
                }
            }

            maxCore = 0;
            minLen = Integer.MAX_VALUE;
            linkCore(0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(minLen).append("\n");

        }
        System.out.println(sb);
    }

    private static void linkCore(int cnt, int len, int core) { //확인한 코어의 수, 전선의 길이, 연결한 코어의 수
        if (cnt == coreList.size()) {
            if (maxCore == core) minLen = Math.min(len, minLen);
            else if (maxCore < core) {
                maxCore = core;
                minLen = len;
            }
            return;
        }

        Core cur = coreList.get(cnt);
        int r = cur.r, c = cur.c;

        for (int dir = 0; dir < 4; dir++) { //상하좌우로 뻗어나가는 방법
            boolean flag = true;
            int nr = r, nc = c;
            while (true) { //전원에 연결할 수 있는지 확인 먼저
                nr += dr[dir];
                nc += dc[dir];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
                if (arr[nr][nc] != 0) {//가고자하는 방향에 전선이나 코어가 있는 경우
                    flag = false;
                    break;
                }
            }

            if (flag) { //가능하다면 선 깔기
                int sum = 0;
                nr = r;
                nc = c;
                while (true) {
                    nr += dr[dir];
                    nc += dc[dir];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;

                    arr[nr][nc] = 2;
                    sum++;
                }
                linkCore(cnt + 1, len + sum, core + 1);

                //깔았던 전선 되돌리기
                while (true) {
                    nr -= dr[dir];
                    nc -= dc[dir];
                    if (nr == r && nc == c) break;
                    arr[nr][nc] = 0;
                }

            }
            //전원에 연결할수없으면 넘어가기
            else linkCore(cnt + 1, len, core);
        }


    }
}
