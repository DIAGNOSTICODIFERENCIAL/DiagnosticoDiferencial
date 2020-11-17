package diagnosisTools;

import structures.*;

import java.util.Queue;

public class diagnosticoArrays {

    public BinaryHeap<enfermedad> resultadoDiagnostico;
    public PQueue resultadoDiagnostico2;

    public BinaryHeap<enfermedad> getDiagnostico() {
        return resultadoDiagnostico;
    }
    public PQueue getDiagnostico2() {
        return resultadoDiagnostico2;
    }

    public void diagnostico(enfermedad enfermedadPaciente, doubleLinkedList Enfermedades){
        resultadoDiagnostico = new BinaryHeap<>();
        resultadoDiagnostico2 = new PQueue();
        System.out.println(Enfermedades.length());
        long startTime = System.nanoTime();
        for(int i=0; i<Enfermedades.length();i++) {
            //análisis síntomas:
            enfermedad enfermedadX = (enfermedad)Enfermedades.getK(i);// Analizaremos enfermedad una por una
            stringDoubleLinkedList InterseccionSignos = interseccionArreglos(enfermedadX.signos,enfermedadPaciente.signos);
            stringDoubleLinkedList intersecciónSintomas = interseccionArreglos(enfermedadX.sintomas,enfermedadPaciente.sintomas);
            int instersecciones = intersecciónSintomas.length()+InterseccionSignos.length();
            enfermedad enfermedadTmp = new enfermedad(enfermedadX.name,InterseccionSignos, intersecciónSintomas, instersecciones);// se crea la enfermedad con el número de intersecciones
            //resultadoDiagnostico.insert(enfermedadTmp); // se agrega la enfermedad a la cola, donde la que tenga mayor numero de coincidencia tendra la mayor prioridad
            resultadoDiagnostico2.add(enfermedadTmp);
            //los datos se reciben ordenados
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println(endTime); 
    }

    /*Metodo que recibe sintomas o signos de las enfermedades a comparar y encuentra la intersección entre las listas.
    Retorna un arreglo con los matches para cada enfermedad.
     */
    public stringDoubleLinkedList interseccionArreglos(stringDoubleLinkedList caracteristicaEnfermedadX, stringDoubleLinkedList caracteristicaEnfermedadPaciente){
        int lenghtEnfermedadPaciente = caracteristicaEnfermedadPaciente.length();
        int lenghtEnfermedad = caracteristicaEnfermedadX.length();
        int n = Math.max(lenghtEnfermedad, lenghtEnfermedadPaciente);
        /*Definimos dos apuntadores para encontrar la intersección de las listas, si son iguales ambos aumentan
        si no, aumenta el indice que apunte al elemento menor*/
        int i=0;//Apunta a enfermedadPaciente;
        int j = 0;//Apunta a enfermedadX
        stringDoubleLinkedList commonItems = new stringDoubleLinkedList();
        for(int idx=0; idx<n; idx++){
            if(i<lenghtEnfermedad && i<lenghtEnfermedadPaciente){
                if(caracteristicaEnfermedadPaciente.getK(i).equals(caracteristicaEnfermedadX.getK(j))){
                    //Crear objeto respuesta
                    commonItems.append(caracteristicaEnfermedadPaciente.getK(i));
                    i++;j++;
                }
                else if(caracteristicaEnfermedadPaciente.getK(i).compareTo(caracteristicaEnfermedadX.getK(j))<0){
                    i++;
                }
                else{
                    j++;
                }
            }
        }
        return commonItems;
    }


}
