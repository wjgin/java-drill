package io.java_drill.algorithm.strategy;

import java.util.ArrayList;
import java.util.List;

// 재귀함수 구현 연습
public class recursiveCall {

    // 팩토리얼(!) 구현 함수
    public int factorial(int n) {
        if(n <= 1)
            return 1;
        else {
            return n * factorial(n-1);
        }
    }

    // list의 합(재귀 사용)
    public int sum(List<Integer> list){
        if(list.size() == 1)    // 크기가 1이면 가장 앞의 값 리턴
            return list.get(0);
        else {  // 크기가 2이상이면 가장 앞의 값 + 재귀(인덱스 1부터 끝까지의 리스트)
            return list.get(0) + sum(list.subList(1, list.size()));
        }
    }

    // 재귀 예제

    /**
     * 정수n을 정수 1, 2, 3의 조합으로 만들 수 있는 경우의 수
     * 경우의수를 계산했을 때 결론 => f(n) = f(n-1) + f(n-2) + f(n-3) 점화식
     * ex) 4의 경우 => 1을 뺏을 때 f(3), 2를 뺏을 때 f(2), 3을 뺏을 때 f(1)과 같음
     */
    public int exSum(int n) {
        if(n == 1) {    // 1을 만들 수 있는 조합(1)
            return 1;
        } else if(n == 2) { // 2를 만들 수 있는 조합(1+1, 2)
            return 2;
        } else if(n == 3) { // 3을 만들 수 있는 조합(1+1+1, 1+2, 2+1, 3)
            return 4;
        } else {
            return exSum(n-1) + exSum(n-2) + exSum(n-3);
        }
    }


    public static void main(String[] args) {
        recursiveCall recursiveCall = new recursiveCall();

        System.out.println(recursiveCall.factorial(3));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(recursiveCall.sum(list));

        System.out.println(recursiveCall.exSum(5));
    }
}
