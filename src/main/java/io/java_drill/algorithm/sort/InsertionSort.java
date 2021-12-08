package io.java_drill.algorithm.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 삽입 정렬즘
 * 인접한 두 값을 비교해 앞 자리부터 채워나아가는 알고리즘
 * O(n^2)
 *  */
public class InsertionSort {
    public List sort(ArrayList<Integer> list) {
        for (int s = 0; s < list.size() - 1; s++) {
            for (int i = s + 1; i > 0; i--) {
                if (list.get(i) < list.get(i - 1)) {
                    Collections.swap(list, i, i - 1);   // 앞 자리의 value보다 더 작다면 교환
                } else {
                    break;  // 이미 정렬된 상태
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 30; i ++){
            list.add((int) (Math.random() * 30));
        }

        InsertionSort sortedList = new InsertionSort();
        System.out.println(list);
        System.out.println(sortedList.sort(list));
    }
}
