package src.main;
import src.diagnosisTools.*;
import structures.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {


//        dataReader dr = new dataReader("muestra.txt");
//        dataReader dr2 = new dataReader("enfermedadPaciente.txt");
//        doubleLinkedList<enfermedad> enfermedades = dr.readList();
////        //System.out.println(enfermedades.length());
////        //System.out.println(enfermedades);
////        //System.out.println(enfe1);
//        enfermedad enfermedadPaciente = dr2.readOne();
//        diagnosticoArrays diagnostico = new diagnosticoArrays();
//        diagnostico.diagnostico(enfermedadPaciente, enfermedades);
//        BinaryHeap<enfermedad> resultado = diagnostico.getDiagnostico();
//        PQueue resultado2 = diagnostico.getDiagnostico2();
//        ArrayList a = resultado.toArrayList();
////      System.out.println(a);
//        hashTable ht = new hashTable();
//        paciente p1 = new paciente("1000465638", enfermedadPaciente.toString(), a);
//        int s =ht.hash(p1.cedula);
//        ht.insert(s,p1);
//        paciente ps = (paciente) ht.search(p1.cedula);
//        System.out.println(ps.cedula);
//        System.out.println(p1.pacienteToString());
//        dataReader dr = new dataReader("muestra.txt");
//        dataReader dr2 = new dataReader("enfermedadPaciente.txt");
//        doubleLinkedList<enfermedad> enfermedades = dr.readList();
//        //System.out.println(enfermedades.length());
//        //System.out.println(enfermedades);
//        //System.out.println(enfe1);
//        enfermedad enfermedadPaciente = dr2.readOne();
//        diagnosticoArrays diagnostico = new diagnosticoArrays();
//        diagnostico.diagnostico(enfermedadPaciente,enfermedades);
//        //BinaryHeap<enfermedad> resultado = diagnostico.getDiagnostico();
//        PQueue resultado = diagnostico.getDiagnostico2();
//        ArrayList a = resultado.toArrayList();
//        System.out.println(a);
        hashTable ht = new hashTable();
        paciente p1 = new paciente("1000465638");
        paciente p2 = new paciente("1234567899");
        paciente p3 = new paciente("6545789185");
        ht.insert(ht.hash(p1.cedula),p1);
        ht.insert(ht.hash(p2.cedula),p2);
        ht.insert(ht.hash(p3.cedula),p3);
        paciente ptmp = (paciente)ht.search(p1.cedula);
        System.out.println( ptmp.cedula);
    }
}
