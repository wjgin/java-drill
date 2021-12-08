package io.java_drill.algorithm.sort;

// 선택 정렬 알고리즘

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 선택 정렬
 * 가장 작은 혹은 가장 큰 수를 맨 앞 index부터 차례대로 채워가나아가는 알고리즘
 * O(n^2)
 */
public class SelectionSort {

    public List sort(ArrayList<Integer> list) {
        for(int s = 0; s < list.size() - 1; s++) { // 탐색 시작 index는 0부터 하나씩 상승
            int min = s;    // 최솟값의 index
            for(int i = s + 1; i < list.size(); i++) {
                if(list.get(i) < list.get(min)) {  // 더 작은 값이 있다면 min과 index를 교환
                    min = i;    // 현재 탐색 중인 index가 시작 값보다 작다면 min 교환
                }
            }
            Collections.swap(list, s, min);    // 최솟값을 가지는 index의 값과 교환
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 30; i ++) {
            list.add((int)(Math.random()*50));
        }
        SelectionSort selectionList = new SelectionSort();
        System.out.println(list);
        System.out.println(selectionList.sort(list));
    }
}
