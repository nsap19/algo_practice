import java.io.*;
import java.util.StringTokenizer;

public class BOJ1976_여행가자 {
    static int[] parents;
    private static void union(int a, int b){
        int ap = find(a);
        int bp = find(b);
        if(ap==bp) return;

        parents[bp]= ap;
    }

    private static int find(int a){
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



    }
}