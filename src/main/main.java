package src.main;
import structures.*;
import src.diagnosisTools.*;


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
        graph grafo = new graph(10);
        grafo.addVertex("Bogota");
        grafo.addVertex("Ibague");
        grafo.addVertex("Biota");
        grafo.addVertex("Casa");
        grafo.addVertex("perro");
        grafo.addEdge("Bogota","Ibague");
        grafo.addEdge("Ibague","Casa");
        grafo.addEdge("Bogota","Casa");
        grafo.addEdge("perro","Bogota");
        grafo.showMatrix();
        System.out.println(grafo.nodos);
        grafo.topSort();
    }
}
