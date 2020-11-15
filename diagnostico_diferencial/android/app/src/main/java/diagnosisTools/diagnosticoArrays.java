package diagnosisTools;
import java.util.ArrayList;

import structures.*;
public class diagnosticoArrays {

    public doubleLinkedList<enfermedad> resultadoDiagnostico;

   


    public doubleLinkedList<enfermedad> getDiagnostico(){
        return resultadoDiagnostico;
    }
    public void diagnostico(enfermedad enfermedadPaciente, doubleLinkedList Enfermedades){
        resultadoDiagnostico = new doubleLinkedList<>();
        System.out.println(Enfermedades.length());
        for(int i=0; i<Enfermedades.length();i++) {
            //análisis síntomas:
            enfermedad enfermedadX = (enfermedad)Enfermedades.getK(i);// Analizaremos enfermedad una por una
            enfermedad enfermedadTmp = new enfermedad
                    (enfermedadX.name,
                    interseccionArreglos(enfermedadX.signos,enfermedadPaciente.signos)
                    ,interseccionArreglos(enfermedadX.sintomas,enfermedadPaciente.sintomas));
            resultadoDiagnostico.append(enfermedadTmp);
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
