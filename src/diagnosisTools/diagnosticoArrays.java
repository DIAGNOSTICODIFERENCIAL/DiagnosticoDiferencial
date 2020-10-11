package src.diagnosisTools;
import structures.*;
public class diagnosticoArrays {

    doubleLinkedList<enfermedadDoubleList> resultadoDiagnostico;

    public void diagnostico(enfermedadArray enfermedadPaciente, enfermedadArray[] Enfermedades){
        resultadoDiagnostico = new doubleLinkedList<>();
        for(int i=0; i<Enfermedades.length;i++) {
            //análisis síntomas:
            enfermedadArray enfermedadX = Enfermedades[i];// Analizaremos enfermedad una por una
            enfermedadDoubleList enfermedadTmp = new enfermedadDoubleList
                    (interseccionArreglos(enfermedadX.signos,enfermedadPaciente.signos)
                    ,interseccionArreglos(enfermedadX.sintomas,enfermedadPaciente.sintomas));
            resultadoDiagnostico.append(enfermedadTmp);
            //los datos se reciben ordenados
        }
    }

    /*Metodo que recibe sintomas o signos de las enfermedades a comparar y encuentra la intersección entre las listas.
    Retorna un arreglo con los matches para cada enfermedad.
     */
    public doubleLinkedList<String> interseccionArreglos(String[] caracteristicaEnfermedadX, String[] caracteristicaEnfermedadPaciente){
        int lenghtEnfermedadPaciente = caracteristicaEnfermedadPaciente.length;
        int lenghtEnfermedad = caracteristicaEnfermedadX.length;
        int n = Math.max(lenghtEnfermedad, lenghtEnfermedadPaciente);
        /*Definimos dos apuntadores para encontrar la intersección de las listas, si son iguales ambos aumentan
        si no, aumenta el indice que apunte al elemento menor*/
        int i=0;//Apunta a enfermedadPaciente;
        int j = 0;//Apunta a enfermedadX
        doubleLinkedList<String> commonItems = new doubleLinkedList();
        for(int idx=0; idx<n; idx++){
            if(i<lenghtEnfermedad && i<lenghtEnfermedadPaciente){
                if(caracteristicaEnfermedadPaciente[i].equals(caracteristicaEnfermedadX[j])){
                    //Crear objeto respuesta
                    commonItems.append(caracteristicaEnfermedadPaciente[i]);
                    i++;j++;
                }
                else if(caracteristicaEnfermedadPaciente[i].compareTo(caracteristicaEnfermedadX[j])<0){
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
