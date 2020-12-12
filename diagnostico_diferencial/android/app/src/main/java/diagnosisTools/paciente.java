package diagnosisTools;
import java.history;

import java.util.ArrayList;


public class paciente {
    public String cedula;
    public history diagnosticos;

    public paciente(String cedula){
        this.cedula = cedula;
        diagnosticos = new history();
    }

    public void añadirDiagnostico(String enfermedad, ArrayList resultado){
        
        this.diagnosticos.addSearch(enfermedad,resultado);
    }
}
