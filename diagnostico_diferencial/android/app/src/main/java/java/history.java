package java;
import structures.*;

public class history {
    dynamicArray historial; //se usa un array para guardar las búsquedas
    int size;

    public history(){
        historial = new dynamicArray();
        size = 0;
    }
    public void addSearch(String lista){
        historial.insert(lista);
        size++;
    }

}
