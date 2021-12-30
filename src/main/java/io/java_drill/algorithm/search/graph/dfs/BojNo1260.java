package io.java_drill.algorithm.search.graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS와 DFS
 */
public class BojNo1260 {
    static int N, M, V;
    static ArrayList<Integer>[] A;
    static int[] visited;
    static StringBuilder sb;
    static Queue<Integer> q;

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            // 초기 생성
            A = new ArrayList[N + 1];
            for(int i = 1; i <= N; i ++){
                A[i] = new ArrayList<>();
            }

            int s;
            int e;
            for(int i =1; i <=M; i++){
                st = new StringTokenizer(br.readLine());

                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                A[s].add(e);
                A[e].add(s);    // 주의! 양방향이므로 e->s 도 함께 추가해야한다.
            }

            // 오름차순으로 정렬
            for (int i = 1; i <= N; i++) {
                Collections.sort(A[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int start) {
        visited[start] = 1;
        sb.append(start).append(' ');
        for(int x : A[start]){
            if(visited[x] == 1) continue;
            else dfs(x);
        }
    }

    private static void bfs(int start) {
        q = new LinkedList<Integer>();  // queue 생성
        q.add(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int node = q.poll();
            sb.append(node).append(' ');

            for(int x : A[node]){
                if(visited[x] == 1) continue;

                q.add(x);
                visited[x] = 1;
            }
        }
    }

    static void pro(){
        visited = new int[N+1];
        sb = new StringBuilder();
        dfs(V);
        sb.append('\n');

        visited = new int[N+1];
        bfs(V);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

}
