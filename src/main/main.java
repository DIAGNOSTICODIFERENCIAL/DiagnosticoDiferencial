package src.main;
import src.diagnosisTools.enfermedad;
import structures.*;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        dataReader dr = new dataReader("muestra.txt");
        doubleLinkedList<enfermedad> enfermedades = dr.read();
        System.out.println(enfermedades.getK(1));
    }
}
