package io.java_drill.algorithm.strategy;

public class DynamicProgramming {
    // 피보나치 수열 재귀함수로 구현
    public int fibonacciR(int n) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacciR(n-1) + fibonacciR(n -2);  // 기존의 계산한 값을 다시 계산 해야함
    }

    // 피보나치 수열을 memorization기법을 활용한 DP
    public int fibonacciDP(int n) {
        int[] cache = new int[n+1]; // index n까지 존재하는 캐시 배열(메모리제이션)
        for(int i = 0; i < n+1; i++){
            if(i <= 1)
                cache[i] = i;
            else
                cache[i] = cache[i-1] + cache[i-2]; // 배열에 이미 저장되어있는 값은 다시 계산하지 않고 사용(시간 복잡도에 도움, 공간복잡도 악화)
        }
        return cache[n];
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.fibonacciR(10));
        System.out.println(dp.fibonacciDP(10));
    }
}
