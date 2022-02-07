package io.java_drill.algorithm.tree.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N01240 {

    static class Edge{
        int edge;
        int dist;

        public Edge(int edge, int dist){
            this.edge = edge;
            this.dist = dist;
        }

    }

    static int N, M, ans;
    static ArrayList<Edge>[] tree;
    static StringBuilder sb;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() {

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            tree = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) tree[i] = new ArrayList<>();
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                tree[s].add(new Edge(e, d));
                tree[e].add(new Edge(s, d));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(int node, int goal, int pre, int dist){
        if (node == goal){
            ans = dist;
            return;
        } else {
            for (Edge x : tree[node]){
                if (x.edge == pre) continue;
                dfs(x.edge, goal, node, dist + x.dist);
            }
        }

    }

    static void pro() throws IOException {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        dfs(from, to, -1 ,0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        while (M-- > 0)
            pro();
    }
}
