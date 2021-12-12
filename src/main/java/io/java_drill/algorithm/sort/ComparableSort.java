package io.java_drill.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

// Comparable 정렬 테스트
// 두 개 이상의 프로퍼티를 정렬할 수 있는 인터페이스
// Comparable<Object> 인터페이스를 상속 정렬할 Object를 제네릭으로 표시
public class ComparableSort implements Comparable<ComparableSort> {
    public int num;
    public String str;

    public ComparableSort(int num, String str){
        this.num = num;
        this.str = str;
    }

    @Override   // 오버라이딩할 메소드 인자는 제니릭으로 표시한 object
    public int compareTo(ComparableSort object) {
        return this.num - object.num;   // num 오름차순
    }

    public static void main(String[] args) {
        ComparableSort cs1 = new ComparableSort(15, "a");
        ComparableSort cs2 = new ComparableSort(11, "a");
        ComparableSort cs3 = new ComparableSort(12, "a");

        ComparableSort[] csList = new ComparableSort[] {cs1, cs2, cs3};

        Arrays.sort(csList);

        Arrays.stream(csList).forEach(item-> {
            System.out.println(item.num);
        });
    }
}
