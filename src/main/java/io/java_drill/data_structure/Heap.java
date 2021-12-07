package io.java_drill.data_structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PrimitiveIterator;

// Max heap 구조 구현 연습
public class Heap {
    // heap 구조를 만들 array
    public ArrayList<Integer> heapArr;

    // 생성자
    public Heap(int data) {
        // 비어있는 heap array 생성 후 삽입
        heapArr = new ArrayList<>();
        // index 0은 계산의 유리함을 위해서 비워 놓기
        heapArr.add(null);
        // root는 Index 1에서 시작
        heapArr.add(data);
    }

    // 데이터 추가
    public boolean add(int data) {
        // heap array가 비어있는 경우, index 1에 추가
        if(heapArr == null) {
            this.heapArr.add(null);
            this.heapArr.add(data);
            return true;
        } else {
            this.heapArr.add(data); // data를 끝 단에 추가
            int idx = this.heapArr.size() - 1;  // 추가될 data의 index
            int parentIdx = idx / 2;    // 부모 node의 index

            // idx가 root가 아닐때까지 반복
            while(idx > 1) {
                // 부모의 node보다 크다면 교환
                if(this.heapArr.get(idx) > this.heapArr.get(parentIdx)) {
                    Collections.swap(this.heapArr, idx, parentIdx); // array 상의 자리 교환
                    idx = parentIdx;    // index 값을 부모의 값으로 교환
                    parentIdx = idx / 2;    // 부모 index 갱신
                } else {
                    break;  // 부모가 현재 node보다 크다면 탐색 종료
                }
            }
        }
        return true;
    }

    // Max 데이터 추출(root 데이터 추출)
    public Integer pop(){
        if(this.heapArr == null) {  // 빈 객체일 경우
            return null;
        } else {
            Integer root = this.heapArr.get(1);
            this.heapArr.set(1, this.heapArr.get(this.heapArr.size()-1));
            this.heapArr.remove(this.heapArr.size() -1 );
            this.sort();

            return root;
        }
    }

    public void sort() {
        int idx = 1;
        int leftChild = idx * 2;
        int rightChild = idx * 2 + 1;
        int child;

        while(true) {
            // 자식 노드가 없을 경우
            if(leftChild >= this.heapArr.size()){
                break;
            } else {    // 자식 노드가 있는 경우
                // 자식 노드가 하나 일 경우(left child 만 존재)
                if(rightChild >= this.heapArr.size()){
                    Collections.swap(this.heapArr, idx, leftChild);
                    idx = leftChild;
                    leftChild = idx * 2;
                    rightChild = leftChild + 1;
                } else {    // 자식 node가 2개일 경우
                    child = this.heapArr.get(leftChild) > this.heapArr.get(rightChild) ? leftChild : rightChild;
                    Collections.swap(this.heapArr, idx, child);
                    idx = child;
                    leftChild = idx * 2;
                    rightChild = leftChild + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Heap myHeap = new Heap(10);
        myHeap.add(11);
        myHeap.add(13);
        myHeap.add(16);
        myHeap.add(20);
        myHeap.add(28);
        System.out.println(myHeap.heapArr);

        myHeap.pop();
        System.out.println(myHeap.heapArr);
    }
}
