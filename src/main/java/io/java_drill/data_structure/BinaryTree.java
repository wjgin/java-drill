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

    // 검색
    public Node findNode(int data) {
        Node curNode = this.root;   // 탐색의 주체가 될 node
        if(curNode == null) {   // root가 비어있다면 빈 객체 => null
            return null;
        } else {    // 비어있지 않을 경우 탐색
            while(curNode != null) {
                if(curNode.value == data) { // 현재 node의 값이 찾을 data와 같다면(찾았다면) node를 리턴
                    return curNode;
                } else {    // 아니라면 크기를 비교해 탐색 나누기
                    if(data < curNode.value) {
                        curNode = curNode.leftChild;
                    } else {
                        curNode = curNode.rightChild;
                    }
                }
            }
            return null;    // 탐색을 마친 후 값이 없다면 null 리턴
        }
    }

    // node 삭제
    public boolean deleteNode(int data) {
        // 비어있는 경우
        if(this.root == null)
            return false;
        // 하나의 node만 존재하는 경우
        else if(this.root != null && this.root.leftChild == null && this.root.rightChild == null){
            if(this.root.value == data) {   // root의 value와 삭제할 data가 동일할 경우
                this.root = null;
                return true;
            } else {
                return false;
            }
        }
        // 둘 이상의 node가 존재하는 경우
        else {
            Node parentNode = this.root;
            Node currentNode = this.root;
            boolean findeData = false;  //  데이터를 찾았는지 여부를 나타내느 변수
            // 삭제할 data와 동일한 value를 갖는 node를 탐색
            while(currentNode != null){
                if(data < currentNode.value){   // 찾을 data다 현재 node의 value보다 작다면 왼쪽으로 이동
                    parentNode = currentNode;
                    currentNode = currentNode.leftChild;
                } else if(data > currentNode.value) {    // 크다면 오른쪽으로 이동
                    parentNode = currentNode;
                    currentNode = currentNode.rightChild;
                } else {    // 동일한 경우, 삭제할 data를 찾는 경우
                    findeData = true;
                    break;
                }
            }
            // 탐색 후 완료 후
            if(!findeData){ // data를 찾지 못한 경우,
                return false;
            } else {    // data를 찾은 경우, currentNode는 삭제할 node
                // node가 leaf일 경우
                if(currentNode.rightChild == null && currentNode.leftChild == null) {
                    if (parentNode.leftChild == currentNode) { // leaf가 왼쪽일 경우
                        parentNode.leftChild = null;
                        return true;
                    } else if (parentNode.rightChild == currentNode) {    // leaf가 오른쪽일 경우
                        parentNode.rightChild = null;
                        return true;
                    }
                }
                // child node가 1개일 경우
                else if(currentNode.leftChild != null && currentNode.rightChild == null) {  // 삭제할 currentNode가 왼쪽 childNode만 있을 경우
                    if(parentNode.leftChild == currentNode) {   // 삭제할 currentNode가 parentNode의 왼쪼에 있을 경우
                        parentNode.leftChild = currentNode.leftChild;
                    } else {    // 오른쪽에 있을 경우
                        parentNode.rightChild = currentNode.leftChild;
                    }
                } else if(currentNode.leftChild == null && currentNode.rightChild != null) {    // 오른쪽 childNode만 있을 경우
                    if(parentNode.leftChild == currentNode) {
                        parentNode.leftChild = currentNode.rightChild;
                    } else {
                        parentNode.rightChild = currentNode.rightChild;
                    }
                }

                // child node가 2개일 경우
                else {
                    Node minNode = currentNode.rightChild; // 삭제할 currentNode 자리에 들어갈 currentNode보다 큰 node 중 제일 작은 node
                    Node minParentNode = currentNode.rightChild;   // minNode의 부모 node
                    while (minNode.leftChild != null) {
                        minParentNode = minNode;
                        minNode = minParentNode.leftChild;
                    }
                    // minNode 탐색 완료
                    // minNode와 minParentNode가 같다면
                    if (minNode == minParentNode) {
                        if (currentNode == parentNode.leftChild) {
                            parentNode.leftChild = minNode;
                            minNode.leftChild = currentNode.leftChild;
                        } else {
                            parentNode.rightChild = minNode;
                            minNode.leftChild = currentNode.leftChild;
                        }
                    } else {    // minNode와 minParentNode가 각각 존재할 때
                        if(minNode.rightChild == null) {    // minNode가 자식이 없을 경우(오른쪽 자식)
                            minParentNode.leftChild = null;
                        } else {    // 자식이 있을 경우
                            minParentNode.leftChild = minNode.rightChild;
                        }

                        if (currentNode == parentNode.leftChild) {   // 삭제할 currentNode가 parentNode의 왼쪽에 있을 경우
                            parentNode.leftChild = minNode;
                        } else {    // 삭제할 node가 parentNode의 오른쪽에 있을 경우
                            parentNode.rightChild = minNode;
                        }
                        minNode.leftChild = currentNode.leftChild;  // 삭제할 node의 자식 node들을 새로 바꾼 min node의 자식으로 영입
                        minNode.rightChild = currentNode.rightChild;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.addNode(10);
        myTree.addNode(15);
        myTree.addNode(13);
        myTree.addNode(11);
        myTree.addNode(14);
        myTree.addNode(18);
        myTree.addNode(16);
        myTree.addNode(19);
        myTree.addNode(17);
        myTree.addNode(7);
        myTree.addNode(8);
        myTree.addNode(6);
        System.out.println(myTree.deleteNode(15));
        System.out.println("HEAD: " + myTree.root.value);
        System.out.println("HEAD LEFT: " + myTree.root.leftChild.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.root.leftChild.leftChild.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.root.leftChild.rightChild.value);

        System.out.println("HEAD RIGHT: " + myTree.root.rightChild.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.root.rightChild.leftChild.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.root.rightChild.rightChild.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.root.rightChild.rightChild.leftChild.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.root.rightChild.rightChild.rightChild.value);

    }
}

