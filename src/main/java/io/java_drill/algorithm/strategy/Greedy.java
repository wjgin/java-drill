package io.java_drill.algorithm.strategy;

/**
 * 탐욕 알고리즘 -> 최적에 가까운 해를 구하기 위함
 * 매 순간 최적에 가까운 방법을 선택하는 알고리즘
 * 대표: 동전 사용의 최소 개수 구하기 문제
 *
 */
public class Greedy {

    public int minCoinCount(int money, int[] coinList){
        int totalCount = 0;
        int count = 0;

        for (int item : coinList) {
            count = money / item;
            totalCount += count;
            money -= count * item;
            if(money == 0)
                break;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        int[] coinList = {500, 100, 50, 1};
        Greedy gc = new Greedy();
        System.out.println(gc.minCoinCount(4720, coinList));
    }
}
