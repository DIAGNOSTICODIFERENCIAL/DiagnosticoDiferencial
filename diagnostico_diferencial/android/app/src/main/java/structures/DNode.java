package diagnostico_diferencial.android.app.src.main.java.structures;

public class DNode <T>{
        T data;
        DNode next;
        DNode prev;

public DNode (T data, DNode prev){
        this.data = data;
        this.next = null;
        this.prev = prev;
        }

}
