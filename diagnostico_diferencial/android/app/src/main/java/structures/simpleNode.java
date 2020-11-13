package structures;

public class simpleNode<t>{
    t data;
    simpleNode next;
    public simpleNode(t value){
        this.data = value;
        this.next = null;
    }
    public simpleNode(t value, simpleNode next){
        this.data = value;
        this.next = next;
    }
}