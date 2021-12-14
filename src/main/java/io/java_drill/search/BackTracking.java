package io.java_drill.search;

import java.util.ArrayList;

/**
 * 백 트래킹은 특정 문제를 풀기위한 알고리즘이 아닌 다양한 문제 풀이를 위한 기법
 * 답이 될수 있는 후보군을 State Space Tree(상태 공간 트리)개념으로 생각함
 * 후보군 중 하나가 해답이 될 수 없다면 트리 하위의 모든 후보는 해가 될 수 없어서 버림처리 - 가지치기(pruning)
 * 후보군이 해의 조건에 부합한다면 체크(promising)
 */
public class BackTracking {

    /**
     * 백 트래킹 문제의 대표적인 예 N queen 문제
     * N x N 체스판에 퀸 말이 놓일 수 있는 후보군 출력(서로 공격을 할 수 없는 위치의 후보군)
     */


    public boolean isCandidate(int row, int col, ArrayList<Integer> candidate){
        /**
         * 후보가 될 수 없는 경우
         * 1. 같은 행, 열에 후보가 존재하는 경우(한 행씩 추가하므로 열만 고려한다.)
         * 2. 후보군 중 대각선에 존재하는 경우 (기울기가 1)
         */

        for(int i = 0; i < row; i++){   // 후보군들으 탐색하면서 현재 선택된 노드와의 조건 비교
            // 같은 열에 있있있거나 기울기가 1인 경우, 현재 노드는 후보군에서 탈락
            if(candidate.get(i) == col || Math.abs(candidate.get(i) - col) == (row - i)){
                return false;
            }
        }
        return true;
    }

    public void NQueenFunc(int N, int row, ArrayList<Integer> candidate){

        if(row == N){   // 진행할 row가 N이면 N개의 후보가 확정되어 candidate에 들어가있는 상태
            System.out.println(candidate);
            return;
        } else {
            for(int i = 0; i < N; i++){
                if(isCandidate(row, i, candidate)){
                    candidate.add(i);
                    this.NQueenFunc(N, row + 1, candidate);
                    candidate.remove(candidate.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();
        backTracking.NQueenFunc(4, 0, new ArrayList<>());
    }
}
