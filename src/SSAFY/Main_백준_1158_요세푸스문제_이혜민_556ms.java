package SSAFY;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1158_요세푸스문제_이혜민_556ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //사람 수
        int K = Integer.parseInt(st.nextToken()); //뽑아야할 번호

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 0;
        sb.append("<");
        while (!queue.isEmpty()) {

            count++;
            if (count == K) {
                sb.append(queue.poll()).append(", ");
                count = 0;
            } else queue.offer(queue.poll());
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");
        System.out.println(sb);

    }
}
