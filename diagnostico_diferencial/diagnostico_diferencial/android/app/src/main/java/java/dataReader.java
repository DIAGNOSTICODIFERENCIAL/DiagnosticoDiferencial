package java;
import java.io.*;
import java.util.ArrayList;

import diagnosisTools.*;
import structures.*;

public class dataReader {

    File file;
    BufferedReader br;


    public dataReader(String path) {
        this.file = new File(path);
        try {
            this.br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found at "+path);
        }
    }

    public dataReader(){
        this.file = null;
        this.br = null;
    }
    public String readPlain() throws  IOException{
        int i=0;
        String content = "\n";
        String st;
        while ((st = this.br.readLine()) != null){
            if(i==0){
                i++;
                continue;
            }
            content = content + st+"\n";
            i++;
        }
        return content;
    }
    public doubleLinkedList readList() throws IOException {
        int i=0;
        String st;
        doubleLinkedList<enfermedad> enfermedades = new doubleLinkedList<enfermedad>();
        enfermedad tmpEnfermedad = new enfermedad();
        while ((st = this.br.readLine()) != null){
            //System.out.println(i);
            if(i%4==0){
                if(i!=0){
                    tmpEnfermedad.sort();
                    enfermedades.append(tmpEnfermedad);
                }
                tmpEnfermedad = new enfermedad();
                i++;
                continue;
            }
            String[] parts = st.split(":");
            String name = parts[1];
            String functionalPart = parts[1];
            String[] caracteristicas = functionalPart.split(", ");
            if(i%4==1){
                tmpEnfermedad.setName(name);
            }
            if(i%4==2){
                for(int j=0; j<caracteristicas.length;j++){
                    tmpEnfermedad.sintomas.append(caracteristicas[j]);
                }

            }if(i%4==3){
                for(int j=0; j<caracteristicas.length;j++){
                    tmpEnfermedad.signos.append(caracteristicas[j]);
                }
            }
            i++;
        }
        return enfermedades;
    }

    public doubleLinkedList readArrayList(ArrayList<String> data){
        String st;
        doubleLinkedList<enfermedad> enfermedades = new doubleLinkedList<enfermedad>();
        enfermedad tmpEnfermedad = new enfermedad();
        for(int i=0; i<data.size(); i++){
//            System.out.println(i+"   "+data.get(i));
            //System.out.println(i);
            if(i%4==0){
                if(i!=0){
                    tmpEnfermedad.sort();
                    enfermedades.append(tmpEnfermedad);
                    System.out.println("Se creaaaaa tmpEnfermedad "+tmpEnfermedad);
                }
                tmpEnfermedad = new enfermedad();
                continue;
            }
            String[] parts = data.get(i).split(":");
            String name = parts[1];
            String functionalPart = parts[1];
            String[] caracteristicas = functionalPart.split(", ");
            if(i%4==1){
                tmpEnfermedad.setName(name);
            }
            if(i%4==2){
                for(int j=0; j<caracteristicas.length;j++){
                    tmpEnfermedad.sintomas.append(caracteristicas[j]);
                }

            }if(i%4==3){
                for(int j=0; j<caracteristicas.length;j++){
                    tmpEnfermedad.signos.append(caracteristicas[j]);
                }
            }
        }
        return enfermedades;
    }


    public enfermedad readOne()throws IOException{
        int i=0;
        String st;
        enfermedad enfermedadP = new enfermedad();
        while ((st = this.br.readLine()) != null){
            if(i==0){i++;continue;}
            String[] parts = st.split(":");
            String name = parts[1];
            String functionalPart = parts[1];
            String[] caracteristicas = functionalPart.split(", ");
            if(i%4==1){
                enfermedadP.setName(name);
            }
            if(i%4==2){
                for(int j=0; j<caracteristicas.length;j++){
                    enfermedadP.sintomas.append(caracteristicas[j]);
                }

            }if(i%4==3){
                for(int j=0; j<caracteristicas.length;j++){
                    enfermedadP.signos.append(caracteristicas[j]);
                }
            }
            i++;
        }
        enfermedadP.sort();
        return enfermedadP;
    }
}
