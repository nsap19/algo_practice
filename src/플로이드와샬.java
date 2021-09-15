import java.io.*;
import java.util.StringTokenizer;

public class 플로이드와샬 {
    static int number = 4;
    static int INF = 10000000;
    static int[][] d = new int[number][number];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int[][] a = {{0, 5, INF, 8}, {7, 0, 9, INF}, {2, INF, 0, 4}, {INF, INF, 3, 0}};
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                d[i][j] = a[i][j];
            }
        }

        floydWarshall();

        //결과 출력
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floydWarshall() {
        //k=거쳐가는 노드
        for (int k = 0; k < number; k++) {
            // i=출발노드
            for (int i = 0; i < number; i++) {
                //j = 도착노드
                for (int j = 0; j < number; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
}
