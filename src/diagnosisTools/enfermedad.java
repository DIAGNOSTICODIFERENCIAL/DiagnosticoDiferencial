package src.diagnosisTools;
import structures.*;

public class enfermedad {
    public stringDoubleLinkedList signos;
    public stringDoubleLinkedList sintomas;

    public enfermedad(stringDoubleLinkedList signos, stringDoubleLinkedList sintomas){
        this.signos = signos;
        this.sintomas = sintomas;
    }
    public enfermedad(){
        this.signos = new stringDoubleLinkedList();
        this.sintomas = new stringDoubleLinkedList();
    }
    public String toString(){
        String ans = "";
        ans = sintomas.toString()+"\n"+signos.toString();
        return ans;
    }
}
