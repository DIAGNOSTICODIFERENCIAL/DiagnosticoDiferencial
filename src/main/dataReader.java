package src.main;
import java.io.*;

import src.diagnosisTools.enfermedad;
import structures.*;

public class dataReader {

    File file;
    BufferedReader br;

    public dataReader(String path){
        this.file = new File(path);
        try{
            this.br = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException ex){
            System.out.println("F");
        }
    }
    public doubleLinkedList read() throws IOException {
        int i=0;
        String st;
        doubleLinkedList<enfermedad> enfermedades = new doubleLinkedList<enfermedad>();
        enfermedad tmpEnfermedad = new enfermedad();
        while ((st = this.br.readLine()) != null){
            if(i%3==0){
                if(i!=0){
                    enfermedades.append(tmpEnfermedad);
                }
                tmpEnfermedad = new enfermedad();
            }
            if(i%3==1){
                tmpEnfermedad.sintomas.append(st);
            }if(i%3==2){
                tmpEnfermedad.signos.append(st);
            }
            i++;
        }
        return enfermedades;
    }
}
