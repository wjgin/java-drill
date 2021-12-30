package io.java_drill.algorithm.search.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS 특징: 시작점에서 주변으로 나아가면서 개수를 카운트할 수 있음
 * 미로 찾기 최단거리
 * 모든 가중치가 같거나 없는 경우만 가능
 */
public class No2178 {
    static int N, M;
    static Queue<Integer> Q;
    static String[] A;
    static int[][] visit;
    static int[][] dist;    // x,y까지의 필요한 거리를 넣어줄 변수
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void bfs(int x, int y){
        int dx, dy;
        Q = new LinkedList<>();
        visit[x][y] = 1;
        dist[x][y] = 1; // 처음 거리는 1로 시작
        Q.add(x);   // x
        Q.add(y);   // y

        while(!Q.isEmpty()){
            x = Q.poll();
            y = Q.poll();

            for(int i =0; i < 4; i ++){
                dx = x + dir[i][0];
                dy = y + dir[i][1];

                if(dx < 0 || dy < 0 || dx >= N || dy >= M) continue;
                if(visit[dx][dy] == 1) continue;
                if(A[dx].charAt(dy) == '0') continue;
                Q.add(dx);
                Q.add(dy);
                visit[dx][dy] = 1;
                dist[dx][dy] = dist[x][y] + 1;  // 이전 좌표보다 1칸만 이동
            }
        }
    }

    public static void pro(){
        bfs(0, 0);
        System.out.println(dist[N-1][M-1]);
    }

    public static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new String[N];
            visit = new int[N][M];
            dist = new int[N][M];

            for (int i = 0; i < N; i++) {
                A[i] = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
