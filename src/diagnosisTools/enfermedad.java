package src.diagnosisTools;
import structures.*;

public class enfermedad {
    public stringDoubleLinkedList signos;
    public stringDoubleLinkedList sintomas;
    public String name;

    public enfermedad(String name, stringDoubleLinkedList signos, stringDoubleLinkedList sintomas){
        this.signos = signos;
        this.sintomas = sintomas;
        this.name = name;
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
}
