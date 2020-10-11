package src.diagnosisTools;
import structures.*;

public class enfermedadDoubleList {
    doubleLinkedList<String> signos;
    doubleLinkedList<String> sintomas;

    public enfermedadDoubleList(doubleLinkedList<String> signos, doubleLinkedList<String> sintomas){
        this.signos = signos;
        this.sintomas = sintomas;
    }
}
