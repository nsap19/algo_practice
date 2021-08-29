import java.io.*;
import java.util.StringTokenizer;

public class A_SubSetTest {
    static int N, arr[];
    static boolean isSelected[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //수의 범위
        arr = new int[N];
        isSelected = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);



    }

    private static void subset(int cnt){
        if(cnt == N){
            for (int i = 0; i < N; i++) {
                System.out.print((isSelected[i]? arr[i] : "X")+" ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        subset(cnt+1);

        isSelected[cnt] = false;
        subset(cnt+1);

    }
}
