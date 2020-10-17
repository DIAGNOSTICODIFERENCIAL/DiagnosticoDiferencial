package src.main;
import structures.*;

public class history {
    doubleLinkedList<doubleLinkedList> historial;
    int size;

    public history(){
        historial = new doubleLinkedList<doubleLinkedList>();
        size = 0;
    }
    public void addSearch(doubleLinkedList lista){
        historial.append(lista);
        size++;
    }
}
