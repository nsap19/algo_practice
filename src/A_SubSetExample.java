import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_SubSetExample {
    static int N, arr[] = {1, 2, 3};
    static boolean isSelected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 3; //수의 범위

        isSelected = new boolean[N];

//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }


        subset(0);


    }

    //    private static void subset(){
//    }
    private static void subset(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print((isSelected[i] ? arr[i] : "X") + " ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        subset(cnt + 1);

        isSelected[cnt] = false;
        subset(cnt + 1);

    }
}
