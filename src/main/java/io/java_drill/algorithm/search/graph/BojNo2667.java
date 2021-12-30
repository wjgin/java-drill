package io.java_drill.algorithm.search.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BojNo2667 {

    static int N, cnt;
    static String[] A;
    static int[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(br.readLine());
            A = new String[N];
            visit = new int[N][N];

            for(int i = 0; i < N; i ++){
                A[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = 1;
        cnt ++;

        // 4방향과 인접한 노드를 탐색
        int dx;
        int dy;
        for(int k = 0; k < 4; k ++){
            dx = x + dir[k][0];
            dy = y + dir[k][1];

            // 범위를 벗어나거나, 이미 방문한 노드이거나 인접한 집이 없다면 통과
            if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;    // 범위를 벗어남
            if(visit[dx][dy] == 1) continue;    // 이미 방문함
            if(A[dx].charAt(dy) == '0') continue;   // 인접한 집이없음(0)
            dfs(dx, dy);
        }
    }

    static void pro(){
        ArrayList<Integer> ans = new ArrayList<>();

        // 모든  배열을 돌아 다니며 단지 내의 집 수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j] == 1) continue;  // 이미 방문한 노드
                if(A[i].charAt(j) == '0') continue; // 집이 없는 노드
                cnt = 0;
                dfs(i, j);
                ans.add(cnt);
            }
        }
        // 오름차순으로 정렬해서 더하기
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int x : ans) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
