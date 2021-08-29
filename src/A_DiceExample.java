import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_DiceExample {
    static int number[], N, total;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //뽑으려는 수의 갯수
        number = new int[N];
        visited = new boolean[6+1]; //주사위 각 숫자를 체크 (1~6)

        //N=3, total = 120
        System.out.println("순열");
        total = 0;
        dice1(0);
        System.out.println(total);

        //N=3, total = 216
//        System.out.println("중복순열");
//        total = 0;
//        dice2(0);
//        System.out.println(total);
//
        //N=3, total = 20
        System.out.println("조합");
        total = 0;
        dice3(0,1);
        System.out.println(total);
//
        //N=3, total = 56
//        System.out.println("중복조합");
//        total = 0;
//        dice4(0,1);
//        System.out.println(total);


    }

    //순열
//    private static void dice1(){
//    }
    private static void dice1(int cnt){
        if(cnt==N){
            total++;
            System.out.println(Arrays.toString(number));
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            number[cnt] = i;
            dice1(cnt+1);
            visited[i] = false;
        }
    }

    //중복순열
//    private static void dice2(){
//    }

    //조합
//    private static void dice3(){
//    }

    private static void dice3(int cnt, int start){
        if(cnt==N) {
            total++;
            System.out.println(Arrays.toString(number));
            return;
        }

        for (int i = start; i <= 6; i++) {
            number[cnt] = i;
            dice3(cnt+1, i+1);
        }

    }

    //중복조합
//    private static void dice4(){
//    }
}
