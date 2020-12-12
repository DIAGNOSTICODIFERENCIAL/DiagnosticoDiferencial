package src.diagnosisTools;
import src.main.history;

import java.util.ArrayList;


public class paciente {
    public String cedula;
    history diagnosticos;

    public paciente(String cedula){
        this.cedula = cedula;
        diagnosticos = new history();
    }

    public void añadirDiagnostico(){
        ArrayList a = null;
        this.diagnosticos.addSearch("a",a);
    }
}
