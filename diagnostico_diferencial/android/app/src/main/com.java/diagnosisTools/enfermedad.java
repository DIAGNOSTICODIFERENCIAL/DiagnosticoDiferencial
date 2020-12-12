package diagnostico_diferencial.android.app.src.main.java.diagnosisTools;
import java.util.ArrayList;

import structures.*;

public class enfermedad implements Comparable <enfermedad> {
    public stringDoubleLinkedList signos;
    public stringDoubleLinkedList sintomas;
    public String name;
    public int count =0;

    public enfermedad(String name, stringDoubleLinkedList signos, stringDoubleLinkedList sintomas){
        this.signos = signos;
        this.sintomas = sintomas;
        this.name = name;
    }
    public enfermedad(String name, stringDoubleLinkedList signos, stringDoubleLinkedList sintomas, int count){
        this.signos = signos;
        this.sintomas = sintomas;
        this.name = name;
        this.count= count;
    }
    public enfermedad(){
        this.signos = new stringDoubleLinkedList();
        this.sintomas = new stringDoubleLinkedList();
        this.name = "Covidjajaxd";
    }
    public String toString(){
        String ans = "";
        ans = "Enfermedad: "+this.name+ "\n Sintomas: "+sintomas.toString()+" Signos: "+signos.toString();
        return ans;
    }
    public void sort(){
        this.sintomas.sort();
        this.signos.sort();
    }
    public  void setName(String name){
        this.name = name;
    }
    public int getcount(){
        return this.count;
    }

    @Override
    public int compareTo(enfermedad o) {
        if (count < o.getcount()){
            return 1;
        } else if (count > o.getcount()) {
            return -1;
        } else {
            return 0;
        }
    }

    public ArrayList toArrayList(){
        ArrayList arrayListEnfermedad = new ArrayList();
        ArrayList<String> arrayListName = new ArrayList<String>();
        arrayListName.add(name);
        arrayListEnfermedad.add(arrayListName);
        arrayListEnfermedad.add(sintomas.toArrayList());
        arrayListEnfermedad.add(signos.toArrayList());
        return arrayListEnfermedad;
    }

}