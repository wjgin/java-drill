package io.java_drill.data_structure;

public class DoublyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    // add new Node to tail
    public void addNode(T data) {
        if(this.head == null){
            this.head = new Node<>(data);
            this.tail = this.head;
        } else {
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    // find item from head
    public T findFromHead(T data) {
        if(this.head != null) {
            Node<T> node = head;
                while(node != null) {
                    if(node.data == data) {
                        return node.data;
                    } else {
                        node = node.next;
                }
            }
            return null;
        }
        return null;
    }

    // find item from tail
    public T findFromTail(T data) {
        if(this.tail != null) {
            Node<T> node = this.tail;
                while(node != null) {
                    if(node.data == data){
                        return node.data;
                    } else {
                        node = node.prev;
                }
            }
            return null;
        }
        return null;
    }

    // param의 값을 가지는 Node에 node 추가하기(head 에서부터 찾기)
    public boolean addNodeToFront(T addData, T targetData){
        if(this.head == null) {
            this.head = new Node<>(addData);
            this.tail = this.head;
            return true;
        } else if(this.head.data == targetData) {
            Node<T> newHead = new Node<>(addData);
            newHead.next = this.head;
            this.head = newHead;
            this.head.next.prev = this.head;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if(node.data == targetData){
                    Node<T> addNode = new Node<>(addData);
                    addNode.prev = node.prev;
                    addNode.next = node;
                    node.prev.next = addNode;
                    node.prev = addNode;
                    return true;
                } else{
                    node = node.next;
                }
            }
            return false;
        }
    }

    // print all nodes in list
    public void printAll(){
        // head가 null이면 null 출력
        if(this.head != null) {
            System.out.println(head.data);
            Node<T> node = head;
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }


    // test
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // addNode Test
        dll.addNode(3);
        dll.addNode(5);
        dll.addNode(2);

        dll.printAll();

        // finde Test
        System.out.println("data from head 5= " + dll.findFromHead(5));
        System.out.println("data from head 7= " + dll.findFromHead(7));
        System.out.println("data from tail 5= " + dll.findFromHead(5));
        System.out.println("data from tail 7= " + dll.findFromHead(7));

        // addNodePre Test
        dll = new DoublyLinkedList();
        System.out.println("head가 null일 경우 추가 >> " + dll.addNodeToFront(1, 5));
        dll.printAll();
        System.out.println("target이 head일 경우 >> " + dll.addNodeToFront(6, 1));
        dll.printAll();
        System.out.println("target이 중앙 혹은 끝 단일 경우 >> " + dll.addNodeToFront(5, 1));
        dll.printAll();

    }
}
