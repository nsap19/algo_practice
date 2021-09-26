import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node2 implements Comparable<Node2>{
    int edge;
    int animal;

    Node2(int edge, int ani){
        this.edge = edge;
        this.animal = ani;
    }

    @Override
    public int compareTo(Node2 o) {
        return o.animal-this.animal;
    }
}
public class Example5 {
    static ArrayList<Node2>[] list;
//    static boolean[] visited;
    static int result =0;

    public static void main(String[] args) throws IOException {
        System.out.println(solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}));
    }
    public static int solution(int[] info, int[][] edges) {
//        int answer = 0;

        list = new ArrayList[info.length];
//        visited = new boolean[info.length];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            list[a].add(new Node2(b,info[b]));
//            list[b].add(new Node2(a,info[a]));
        }

        bfs(0);

        return result;
    }

    static void bfs(int start){
        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.add(new Node2(start, 0));
        int sheep = 0;
        int wolf = 0;

        while (!pq.isEmpty()) {
            Node2 node = pq.poll();
            int nodeNum = node.edge;
            if(node.animal==0) sheep++;
            if(list[nodeNum].size()==0) continue;
            else {
                if(node.animal==1) wolf++;
                for (Node2 next : list[nodeNum]) {
                    pq.add(new Node2(next.edge, next.animal));
                }
            }
        }

        result = sheep;
    }
}
