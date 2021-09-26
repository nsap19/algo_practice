//package SSAFY;
//
//import java.io.*;
//import java.util.*;
//
////class Node implements Comparable<Node> {
////    int vertex;
////    int weight;
////
////    public Node(int end, int weight) {
////        this.vertex = end;
////        this.weight = weight;
////    }
////
////
////    @Override
////    public int compareTo(Node o) {
////        return weight - o.weight;
////    }
////
////    @Override
////    public String toString() {
////        return "Node{" +
////                "end=" + vertex +
////                ", weight=" + weight +
////                '}';
////    }
////}
//
//public class Main_백준_1753_최단경로_이혜민_760ms {
//    static List<Node>[] list;
//    static int[] distance;
//    static boolean[] visited;
//    static int V, E, start;
//    static final int MAX = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        st = new StringTokenizer(br.readLine(), " ");
//        V = Integer.parseInt(st.nextToken()); //정점 갯수
//        E = Integer.parseInt(st.nextToken()); //간선 갯수
//
//        list = new List[V + 1];
//        distance = new int[V + 1];
//        visited = new boolean[V + 1];
//
//        start = Integer.parseInt(br.readLine()); //시작 정점
//
//        for (int i = 0; i <= V; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//
//            list[u].add(new Node(v, w));
//        }
//
//        Arrays.fill(distance, MAX);
//
//        dijkstra();
//
//        for (int i = 1; i <= V; i++) {
//            if (distance[i] == MAX) {
//                sb.append("INF");
//            } else {
//                sb.append(distance[i]);
//            }
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
//
//    }
//
//    private static void dijkstra() {
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        pq.add(new Node(start, 0));
//        distance[start] = 0;
//
//        while (!pq.isEmpty()) {
//            Node curNode = pq.poll();
//            int current = curNode.vertex;
//
//            if (visited[current]) continue;
//            visited[current] = true;
//
//            for (Node node : list[current]) {
//                // start ~ node.vertex 거리 vs start ~ current 경유 ~ node.vertex 거리
//                if (distance[node.vertex] > distance[current] + node.weight) {
//                    distance[node.vertex] = distance[current] + node.weight;
//                    pq.add(new Node(node.vertex, distance[node.vertex]));
//                }
//            }
//        }
//    }
//}
