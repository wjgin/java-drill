package io.java_drill.data_structure;

// 이진 트리 구조 연습
public class BinaryTree {
    Node root = null;   // 초기 root는 비어있는 값

    // Node 객체
    public class Node {
        int value;
        Node leftChild = null;
        Node rightChild = null;

        public Node(int data){
            this.value = data;
        }
    }

    // 데이터 추가
    public boolean addNode(int data) {
        if(this.root == null) { // root가 비어있는 경우
            this.root = new Node(data);
        } else {
            Node curNode = this.root;   // 탐색의 주최가 될 node
            while(curNode != null) {
                if(data < curNode.value) { // 추가할 data가 현재 node의 값도 작을 경우, 왼쪽으로 이동
                    if(curNode.leftChild == null) {
                        curNode.leftChild = new Node(data); // 비어있다면 삽입
                        break;
                    } else {
                        curNode = curNode.leftChild;    // 비어있지 않다면 현재 node만 왼쪽으로 이동
                    }
                } else {    // 추가할 data가 현재 node의 값보다 크거나 같은 경우 오른쪽으로 이동
                    if(curNode.rightChild == null) {
                        curNode.rightChild = new Node(data);    // 비어있다면 삽입
                        break;
                    } else {
                        curNode = curNode.rightChild;   // 비어있지 않다면 현재 node만 오른쪽으로 이동
                    }
                }
            }
            return true;    // root가 아닌 child node에 삽입할 경우
        }
        return true;   // root을 생성할 경우
    }

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        System.out.println(myTree.addNode(33));
        System.out.println(myTree.addNode(30));
    }
}
