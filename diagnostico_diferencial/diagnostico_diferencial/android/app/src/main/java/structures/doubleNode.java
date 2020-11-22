package structures;

public class doubleNode<t>{
    t data;
    doubleNode next;
    doubleNode prev;
    public doubleNode(t value){
        this.data = value;
        this.next = null;
        this.prev = null;
    }
    public doubleNode(t value, doubleNode prev){
        this.data = value;
        this.next = null;
        this.prev = prev;
    }
}