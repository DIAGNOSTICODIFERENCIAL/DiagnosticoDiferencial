package src.main;
import src.diagnosisTools.*;
import structures.*;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        dataReader dr = new dataReader("muestra.txt");
        dataReader dr2 = new dataReader("enfermedadPaciente.txt");
        doubleLinkedList<enfermedad> enfermedades = dr.readList();
        //System.out.println(enfermedades.length());
        //System.out.println(enfermedades);
        //System.out.println(enfe1);
        enfermedad enfermedadPaciente = dr2.readOne();
        diagnosticoArrays diagnostico = new diagnosticoArrays();
        diagnostico.diagnostico(enfermedadPaciente,enfermedades);
        BinaryHeap<enfermedad> resultado = diagnostico.getDiagnostico();

    }
}
