import java.util.LinkedList;

class Node{
    Integer value;
    Node next;

    public Node(Integer value){
        this.value = value;
        this.next = null;
    }
}

abstract class List{
    abstract void insert(Node element);
    abstract void delete(Node element);
    abstract Integer getK(Integer index);
    abstract Integer getFirst();
    abstract void insertFirst(Integer element);
    abstract void deleteFirst();
    abstract boolean isEmpty();
    abstract Integer length();
    abstract Integer getIndex(Integer value);
}

public class SimpleLinkedList extends List {

    Node first;
    Integer length;

    public SimpleLinkedList(){
        this.length = 0;
        this.first = null;
    }

    @Override
    Integer getK(Integer index) {
        if (index == 0){
            return this.first.value;
        }else{
            Node aux = this.first;
            for(int i = 0; i < index; i++){
                aux = aux.next;
            }
            return aux.value;
            //TODO qué pasa si index > length;
        }
    }

    @Override
    Integer getFirst() {
        if (this.length != 0){
            return first.value;
        } else {
            return null;
        }
    }

    @Override
    void deleteFirst() {
        if (this.length != 0){
            this.first = this.first.next;
            this.length--;
        } else {
            System.out.println("No puedo eliminar en una lista vacia");
        }
    }

    @Override
    void insertFirst(Integer element) {
        this.length++;
        Node newFirst = new Node(element);
        newFirst.next = this.first;
        this.first = newFirst;
    }

    @Override
    boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    Integer length() {
        return this.length;
    }

    @Override
    void insert(Node element) {

    }

    @Override
    void delete(Node element) {

    }

    @Override
    Integer getIndex(Integer value) {
        return null;
    }
}

class Main{
    public static void main(String[] args) {
        SimpleLinkedList myList = new SimpleLinkedList();
        myList.insertFirst(8);
        myList.insertFirst(13);
        myList.insertFirst(15);
        myList.insertFirst(81);
        myList.insertFirst(18);
        myList.insertFirst(80);
        myList.insertFirst(0);
        System.out.println("Longitud " + myList.length());
        myList.deleteFirst();
        System.out.println("Longitud " + myList.length());
        System.out.println("Empty? " + myList.isEmpty());
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
        myList.deleteFirst();
    }
}
