package io.java_drill.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 버블 정렬
 * 인접한 두 값을 비교해 교환하면서 끝자리부터 채워나아가는 알고리즘
 * O(n^2)
 *  */
public class BubbleSort {

    ArrayList<Integer> list;

    public BubbleSort(ArrayList<Integer> list) {
        this.list = list;
    }

    public List sort(){
        // 최대 index에서 index 1까지 반복
        for(int n = this.list.size() - 1; n > 0; n--) {
            boolean sorted = false; // 한번이라도 교환 여부 확인
            for(int i = 0; i < n; i++) {    // index 0부터 최대 index까지 반복
                if(this.list.get(i) > this.list.get(i + 1)){    // 앞이 뒤보다 크다면 교환
                    Collections.swap(this.list, i, i + 1);
                    sorted = true;  // 교환 여부를 변경
                }
            }
            if(!sorted){    // 한번도 교환이 안되었다면, 모든 정렬이 이뤄진 상태 => 루프 탈출
                break;
            }
        }
        return this.list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 0; i ++) {
            list.add((int)(Math.random()*50));
        }
        System.out.println(list);

        BubbleSort bubbleSort = new BubbleSort(list);
        System.out.println(bubbleSort.sort());

    }
}
