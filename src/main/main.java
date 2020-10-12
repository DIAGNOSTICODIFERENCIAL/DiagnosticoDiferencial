package main;
import structures.*;

public class main {
    public static void main(String[] args){
        stringDoubleLinkedList prueba = new stringDoubleLinkedList();
        prueba.append("d");
        prueba.print();
        prueba.append("c");
        prueba.print();
        prueba.append("f");
        prueba.print();
        prueba.append("a");
        prueba.print();
        prueba.sort();
        prueba.print();
    }
}
