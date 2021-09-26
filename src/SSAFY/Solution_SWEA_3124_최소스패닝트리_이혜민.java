package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
class Node implements Comparable<Node>{
    int v1,v2, weight;

    public Node(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}
public class Solution_SWEA_3124_최소스패닝트리_이혜민 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트케이스
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine()," ");
            int V = Integer.parseInt(st.nextToken()); //정점의 수
            int E = Integer.parseInt(st.nextToken()); //간선의 수

            parents = new int[V+1];
            Node[] list = new Node[E];
            make();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list[i] = new Node(v1,v2,w);
            }

            Arrays.sort(list);

            int cnt =0, result =0;
            for (int i = 0; i < E; i++) {
                int v1 = list[i].v1;
                int v2 = list[i].v2;
                int w = list[i].weight;

                if(union(v1,v2)){
                    result+=w;
                    if(++cnt==V-1) break;
                }
            }

            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void make(){
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot==bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
