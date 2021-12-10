package io.java_drill.search;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * 이진 탐색
 * 정렬된 배열이 필요함
 * 정렬된 배열에서 특정 값을 최소한의 횟수로 찾을 때 유리함 ex) 순서대로 나열된 음료의 병뚜껑에서 병뚜껑을 최소로 열면서 특정 숫자 찾기
 * O(logN)
 */
public class BinarySearch {
    public int sort(ArrayList<Integer> list, Integer target){
        // 특수 케이스
        // 배열의 값이 하나일 경우
        if(list.size() == 1 && list.get(0) == target){
            return 0;   // 발견되었을 때 index = 0;
        }if(list.size() == 1 && list.get(0) != target){
            return -1;  // 발견되지 않는다면,
        }

        // 배열의 값이 2개 이상일 경우
        int mid = list.size() / 2;
        if(list.get(mid) == target){
            return mid;
        } else {
            int result; // 발견 여부
            if (target < list.get(mid)) {
                result = sort(new ArrayList<>(list.subList(0, mid)), target);
                if(result > -1){
                    mid = result;
                    return mid;
                } else {
                    return -1;
                }
            } else {
                result = sort(new ArrayList<>(list.subList(mid, list.size())), target);
                if(result > -1){
                    mid += result;
                    return mid;
                } else{
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        ArrayList<Integer> testList = new ArrayList<>();
        for(int i = 0; i < 30; i ++){
            testList.add((int) (Math.random() * 30));
        }
        System.out.println(testList);
        System.out.println(bs.sort(testList, 21));
    }
}
