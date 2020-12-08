package src.diagnosisTools;
import src.main.history;

import java.util.ArrayList;


public class paciente {
    public String cedula;
    public String busqueda;
    public ArrayList resultado;
    public history diagnosticos;
    String cadena="";

    public paciente(String cedula, String busqueda, ArrayList resultado){
        this.cedula = cedula;
        this.busqueda= busqueda;
        this.resultado=resultado;
        diagnosticos = new history();
        diagnosticos.addSearch(busqueda, resultado);
    }
    public String pacienteToString(){
        if (resultado!=null){
            cadena += "Cédula del paciente: "+cedula.toString()+"\n"+ busqueda+"\n"+"Resultado de diagnostico: "+ resultado.toString();


        }else{
            cadena += "Cédula del paciente: "+cedula.toString()+"\n"+"Signos y sintomas presentados: "+ busqueda+"\n"+"Resultado de diagnostico: "+"Ninguna enfermedad asociada alos sintomas y signos se ha encontrado";
        }
        return cadena;
    }
}
