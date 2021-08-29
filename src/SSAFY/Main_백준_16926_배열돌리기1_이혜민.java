package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Main_백준_16926_배열돌리기1_이혜민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //row
        int M = Integer.parseInt(st.nextToken()); //col
        int R = Integer.parseInt(st.nextToken()); //회전수

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // r== c 찾기 (1 ~ N/2)
        int check = Math.min(N, M) / 2;
//        int cnt = R%(원소의 갯수);
        for (int count = 0; count < R; count++) {
            for (int i = 1; i <= check; i++) {

                //범위 구하기
                //r의 범위 : r ~ N - i +1 , c의 범위 : c ~ M-i+1;
                int r = i, c = i;
                int maxR = N - i + 1, maxC = M - i + 1;
                int temp = arr[maxR][c];

                //좌측 세로
                for (int j = maxR; j > r; j--) {
                    arr[j][c] = arr[j - 1][c];
                }
                //상단 가로
                for (int j = c; j < maxC; j++) {
                    arr[r][j] = arr[r][j + 1];
                }
                //우측 세로
                for (int j = r; j < maxR; j++) {
                    arr[j][maxC] = arr[j + 1][maxC];
                }
                //하단 가로
                for (int j = maxC; j > c; j--) {
                    arr[maxR][j] = arr[maxR][j - 1];
                }

                arr[maxR][c + 1] = temp;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
