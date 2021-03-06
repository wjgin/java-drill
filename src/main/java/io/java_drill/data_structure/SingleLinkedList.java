package io.java_drill.data_structure;

public class SingleLinkedList<T> {

    // 기준이 되는 가장 첫번째 node
    public Node<T> head = null;

    // 내장 객체 Node 정의
    public class Node<T> {
        T data;
        Node<T> next = null;

        // Node class의 생성자
        public Node(T data) {
            this.data = data;
        }
    }

    // 맨 끝 단에 노드 추가
    public void addNode(T newData) {
        if(head == null) {  // List는 비어있는 상태
            head = new Node<>(newData);
        }
        else {  // 비어있지 않다면 가장 끝 node를 탐색
            // head 로 이동
            Node<T> node = this.head;
            // node의 next가 null 일 때 까지
            while (node.next != null) {
                node = node.next;
            }
            // 다음 링크를 연결
            node.next = new Node<T>(newData);
        }
    }

    // 노드 중간 추가
    public void insertNode(T data, T where){    // data: 삽입할 데이터, where: 삽입할 데이터의 기준 위치
        Node<T> searchNode = this.search(where);
        if (searchNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchNode.next;
            searchNode.next = new Node<>(data); // 기준점 뒤에 삽입
            searchNode.next.next = nextNode;    // 새로 삽입한 데이터에 기준점의 기존 next를 삽입
        }
    }

    // node 검색
    public Node<T> search(T where) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = head;
            while(node.next != null) {
                if(node.data == where){
                    return node;
                } else {
                    node = node.next;
                }
            }
            // 모든 탐색 후 없다면 null 리턴
            return null;
        }
    }

    // node 삭제 메소드
    public boolean delNode(T data) {
        if(this.head == null) {
            return false;
        } else {
            Node<T> node = this.head;
            if(node.data == data) {
                this.head = this.head.next;
                return true;
            } else {
                // node 이동
                while(node.next != null) {
                    if(node.next.data == data) {
                        node.next = node.next.next;
                        return true;
                    } else {
                        node = node.next;
                    }
                    // 모든 탐색을 마친 후 없으면 false;
                }
                return false;
            }
        }
    }

    // 모든 노드 출력
    public void printAll(){
        Node<T> node = this.head;
        System.out.println(node.data);
        while(node.next != null) {
            node = node.next;
            System.out.println(node.data);
        }

    }


    public static void main(String[] args) {
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        // 출력 테스트
        // myLinkedList.printAll();

        // insertNode 테스트
        myLinkedList.insertNode(5, 1);
        // myLinkedList.printAll();
        myLinkedList.insertNode(10, 20);

        // 삭제 테스트
        System.out.println("삭제 전 ~~~~");
        myLinkedList.printAll();
        System.out.println("삭제 후 ~~~~");
        myLinkedList.delNode(10);
        myLinkedList.printAll();
    }
}
