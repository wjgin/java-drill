package io.java_drill.data_structure;

// hash table 중 chaining 기법(linked list) 구현
public class HashTableChaining {
    // slot배열 hash table
    public Slot[] hashTable;

    // slot 배열의 크기를 할당 받는 생성자
    public HashTableChaining(Integer size) {
        this.hashTable = new Slot[size];
    }

    // hash table에 담길 slot 객체
    public class Slot{
        String value;
        String key;
        Slot next = null;
        public Slot(String key, String data){
            this.key = key;
            this.value = data;
        }
    }

    // hash function
    // key인자의 첫 문자의 아스키코드를 이용하여 hashTable의 index 설정
    public int hashFunc(String key){
        return (int)key.charAt(0) % this.hashTable.length;
    }

    // data save 하기
    public boolean setData(String key, String value){
        int address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot preSlot = findSlot;
            while(findSlot != null) {   // chain을 탐색
                if(findSlot.key == key){
                    findSlot.value = value; // key가 이미 존재한다면 value를 교환
                    return true;
                } else {    // chain에 동일한 key가 없다면 chain 이동
                    preSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            preSlot.next = new Slot(key, value);    // chain에 찾는 slot이 없다면 이전 slot next에 새로 저장
            return true;
        } else{
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    // get slot data
    public String getData(String key) {
        int address = this.hashFunc(key);
        if(this.hashTable[address] == null) {
            return null;
        } else {
            Slot findSlot = this.hashTable[address];
            while(findSlot != null) {   // chain 탐색
                if(findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        }
    }
}
