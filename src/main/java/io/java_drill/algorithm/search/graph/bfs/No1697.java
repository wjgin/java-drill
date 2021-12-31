package io.java_drill.algorithm.search.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1697 {
    /**
     * 숨바꼭질
     * N 위치에서 K까지 가는데 최소 시간
     * 한번 움직이는데 1초의 시간이 걸림 => 가중치가 없는 간선
     */

    static int N, K;
    static int[] dist;
    static boolean[] visit;
    static Queue<Integer> Q;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void bfs(){
        Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;    // 처음 N에 있을 때는 0초

        int x;  // 현재 위치
        int y;  // 다음 위치
        while (!Q.isEmpty()) {
            x = Q.poll();

            // 모든 경우를 탐색
            // 다음 위치가 -1
            y = x - 1;
            if (y >= 0 && y <= 100000 && !visit[y]) {   // 범위를 벗어나지 않고 방문한적이 없을 경우
                visit[y] = true;
                dist[y] = dist[x] + 1;
                Q.add(y);
            }

            // 다음 위치가 +1
            y = x + 1;
            if (y >= 0 && y <= 100000 && !visit[y]) {   // 범위를 벗어나지 않고 방문한적이 없을 경우
                visit[y] = true;
                dist[y] = dist[x] + 1;
                Q.add(y);
            }

            // 다음 위치가 * 2
            y = x * 2;
            if (y >= 0 && y <= 100000 && !visit[y]) {   // 범위를 벗어나지 않고 방문한적이 없을 경우
                visit[y] = true;
                dist[y] = dist[x] + 1;
                Q.add(y);
            }
        }
    }

    static void pro(){
        bfs();  // 탐색
        System.out.println(dist[K]);    // N이 K까지 이동하는데 걸린 시간
    }

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            dist = new int[100000 + 1];
            visit = new boolean[100000 + 1];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
