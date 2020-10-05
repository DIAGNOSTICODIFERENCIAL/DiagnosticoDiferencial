package implementacion2;

public class DNode <T>{
    T data;
    DNode next;
    DNode prev;
    
    DNode (T data, DNode prev){
        this.data = data;
        this.next = null;
        this.prev = prev;
    }

}
