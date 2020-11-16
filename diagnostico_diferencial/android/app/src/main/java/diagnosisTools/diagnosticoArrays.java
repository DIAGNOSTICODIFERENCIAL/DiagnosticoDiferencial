package diagnosisTools;

//import org.graalvm.compiler.graph.spi.Canonicalizable.Binary;

import structures.*;
public class diagnosticoArrays {

    public BinaryHeap<enfermedad> resultadoDiagnostico;

    public BinaryHeap<enfermedad> getDiagnostico() {
        return resultadoDiagnostico;
    }
    public void diagnosticar(enfermedad enfermedadPaciente, doubleLinkedList<enfermedad> Enfermedades){
        resultadoDiagnostico = new BinaryHeap<>();
        System.out.println(Enfermedades.length());
        for(int i=0; i<Enfermedades.length();i++) {
            //análisis síntomas:
            enfermedad enfermedadX = Enfermedades.getK(i);// Analizaremos enfermedad una por una
            System.out.println("enfermedad x= "+enfermedadX);
            stringDoubleLinkedList InterseccionSignos = interseccionArreglos(enfermedadX.signos,enfermedadPaciente.signos);
            stringDoubleLinkedList intersecciónSintomas = interseccionArreglos(enfermedadX.sintomas,enfermedadPaciente.sintomas);
            int instersecciones = intersecciónSintomas.length()+InterseccionSignos.length();
            enfermedad enfermedadTmp = new enfermedad(enfermedadX.name,InterseccionSignos, intersecciónSintomas, instersecciones);// se crea la enfermedad con el número de intersecciones
            System.out.println("enfermedad temporal "+enfermedadTmp.sintomas);
            resultadoDiagnostico.insert(enfermedadTmp); // se agrega la enfermedad a la cola, donde la que tenga mayor numero de coincidencia tendra la mayor prioridad
            //los datos se reciben ordenados
        }
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
        //for(int idx=0; idx<n; idx++){
        while(i<lenghtEnfermedadPaciente && j<lenghtEnfermedad){
            //if(i<lenghtEnfermedad && i<lenghtEnfermedadPaciente){
                System.out.println("iii "+caracteristicaEnfermedadPaciente.getK(i));
                String caracteristicaEnfermedadPacienteTmp = caracteristicaEnfermedadPaciente.getK(i);
                String caracteristicaEnfermedadXTmp = caracteristicaEnfermedadX.getK(j);
                if(caracteristicaEnfermedadPacienteTmp.equals(caracteristicaEnfermedadXTmp)){
                    //Crear objeto respuesta
                    commonItems.append(caracteristicaEnfermedadPaciente.getK(i));
                    i++;j++;
                }
                else if(caracteristicaEnfermedadPacienteTmp.compareTo(caracteristicaEnfermedadXTmp)<0){
                    i++;
                }
                else{
                    j++;
                }
            //}
        }
        return commonItems;
    }


}