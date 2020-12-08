package structures;

public class stringDoubleNode{
    String data;
    stringDoubleNode next;
    stringDoubleNode prev;
    public stringDoubleNode(String value){
        this.data = value;
        this.next = null;
        this.prev = null;
    }
    public stringDoubleNode(String value, stringDoubleNode prev){
        this.data = value;
        this.next = null;
        this.prev = prev;
    }
}