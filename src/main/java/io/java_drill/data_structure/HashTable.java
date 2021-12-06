package io.java_drill.data_structure;

// hash table function 구현 연습
public class HashTable {
    // slot배열 hash table
    public Slot[] hashTable;

    // slot 배열의 크기를 할당 받는 생성자
    public HashTable(Integer size) {
        this.hashTable = new Slot[size];
    }

    // value를 갖는 slot 객체
    public class Slot{
        String value;
        public Slot(String data){
            this.value = data;
        }
    }

    // hash function
    // key인자의 첫 문자의 아스키코드를 이용하여 hashTable의 index 설정
    public int hashFunc(String key){
        return (int)key.charAt(0) % this.hashTable.length;
    }

    // data save 하기
    public void setData(String key, String value){
        int address = this.hashFunc(key);
        if(this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else{
            this.hashTable[address] = new Slot(value);
        }
    }

    // get slot data
    public String getData(String key) {
        int address = this.hashFunc(key);
        if(this.hashTable[address] == null) {
            return null;
        } else {
            return this.hashTable[address].value;
        }
    }
}
