package io.java_drill.algorithm.search.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No3055 {
    /**
     * 탈출
     * S -> D로 이동할 때, 최소 시간
     * 한번 이동의 시간이 동일하다 => 간선의 가중치가 없는 문제
     * 풀이: 죄표별 물이 채워지는 최소시간 보다 S가 움직이는 최소시간이 적다면 갈 수 있는 곳이다.
     *
     */

    static int R, C;
    static ArrayList<int[]> W = new ArrayList<>();  // 물의 좌표를 모아놓을 곳
    static String[] A;
    static boolean[][] visit;
    static int[][] Tw;  // 좌표별 물이 차는 최소 시간
    static int[][] Ts;  // 좌표별 S가 도착하는 시간
    static int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Integer> Q;

    public static void main(String[] args) {
        input();
        pro();
    }

    static void pro(){
        // 물이 차는 경우 탐색
        w_bfs();
        // S가 이동하는 경우 탐색
        s_bfs();
        // D의 좌표를 찾아서 시간 출력
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(A[i].charAt(j) == 'D'){
                    if(Ts[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(Ts[i][j]);
                    break;
                }

            }
        }
    }

    static void s_bfs(){
        Q = new LinkedList<>();

        // 기본 값 모두 큐에 넣기, 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;
                Ts[i][j] = -1;
                if(A[i].charAt(j) == 'S') {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                    Ts[i][j] = 0;
                }
            }
        }

        int x, y;
        int dx, dy;
        while (!Q.isEmpty()) {
            // S의 이동 탐색
            x = Q.poll();
            y = Q.poll();
            for (int i = 0; i < 4; i++) {
                dx = x + dir[i][0];
                dy = y + dir[i][1];

                if(dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
                if(visit[dx][dy]) continue;
                if(A[dx].charAt(dy) == 'X' || A[dx].charAt(dy) == '*' ) continue;
                if(Tw[dx][dy] != -1 && Ts[x][y] + 1 >= Tw[dx][dy]) continue;    // S가 다음번 이동할 시간이 물이 차는 시간과 같거나 크다면 갈 수 없다.

                visit[dx][dy] = true;
                Ts[dx][dy] = Ts[x][y] + 1;

                Q.add(dx);
                Q.add(dy);
            }
        }

    }

    static void w_bfs(){
        Q = new LinkedList<>();

        // 기본 값 모두 큐에 넣기, 초기화
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visit[i][j] = false;
                Tw[i][j] = -1;

                if(A[i].charAt(j) == '*') {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                    Tw[i][j] = 0;
                }
            }
        }

        int x, y;
        int dx, dy;
        while (!Q.isEmpty()) {
            // 물을 채워주기
            x = Q.poll();
            y = Q.poll();
            for (int i = 0; i < 4; i++) {
                dx = x + dir[i][0];
                dy = y + dir[i][1];

                if(dx < 0 || dy < 0 || dx >= R || dy >= C) continue;
                if(visit[dx][dy]) continue;
                if(!(A[dx].charAt(dy) == '.')) continue;

                visit[dx][dy] = true;
                Tw[dx][dy] = Tw[x][y] + 1;

                Q.add(dx);
                Q.add(dy);
            }
        }

    }



    static void input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            A = new String[R];
            visit = new boolean[R][C];
            Tw = new int[R][C];
            Ts = new int[R][C];
            for(int i =0; i < R; i ++){
                A[i] = new String(br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
