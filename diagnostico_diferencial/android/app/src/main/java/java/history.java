package diagnostico_diferencial.android.app.src.main.java.java;
import java.util.ArrayList;

import structures.*;

public class history {
    dynamicArray registro; //se usa un array para guardar las búsquedas
    int size;

    public history(){
        registro = new dynamicArray();
        size = 0;
    }
    public void addSearch(String enfermedad, ArrayList resultado){
        ArrayList datos = new ArrayList();
        datos.add(enfermedad);
        datos.add(resultado);
        registro.insert(datos);
        size++;

    }
    

    public ArrayList toArrayList(){
        return this.registro.toArrayList();
    }
    
}
