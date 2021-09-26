package SSAFY.IM_Prepare;

import java.io.*;
import java.util.StringTokenizer;

public class Main_백준_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dir = new int[6];
        int[] len = new int[6];
        int garoMax = 0, seroMax = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if (dir[i] == 1 || dir[i] == 2) {
                if (garoMax < len[i]) garoMax = len[i];
            } else {
                if (seroMax < len[i]) seroMax = len[i];
            }
        }

        int minusGaro = 0, minusSero = 0;
        for (int i = 0; i < 6; i++) {
            if (dir[i] == dir[(i + 2) % 6]) {
                if (dir[i] == 1 || dir[i] == 2) minusGaro = len[i];
                else minusSero = len[(i + 2) % 6];
            }
        }


//        System.out.println(garoMax+" "+seroMax+" "+minusGaro+" "+minusSero);
        int area = garoMax * seroMax - minusGaro * minusSero;
        System.out.println(area * N);

    }
}
