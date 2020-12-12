package structures;

import src.diagnosisTools.paciente;

import static java.lang.StrictMath.pow;

public class hashTable {

    dynamicArray[] table;

    public hashTable(){
        this.table = new dynamicArray[1013];
    }

    public int hash(String number){
        int ans = 0;
        int exp = number.length()/2-1;
        for(int i=0; i<number.length();i+=2) {
            ans += pow(10, exp) * (number.charAt(i)-48);
            exp--;
        }
        //System.out.println(ans);
        ans = ans%1013;
        return  ans;
    }


    public void insert(int index,Object objeto){
        if(this.table[index]==null){
            this.table[index] = new dynamicArray();
        }
        dynamicArray container = this.table[index];
        container.insert(objeto);
    }


    public void delete(int index,String cedula){
        dynamicArray container = this.table[index];
        if(container.getSize()>1){
            for(int i=0; i< container.getSize(); i++){
                paciente p = (paciente) container.get(i);
                if(p.cedula.compareTo(cedula)==0){
                    container.delete(i);
                }
            }
        }else{
            container = new dynamicArray();
        }
    }

    public Object search(String cedula){
        return search(hash(cedula),cedula);
    }
    public Object search(int index,String cedula){
        dynamicArray container = this.table[index];
        if(container.getSize()>1){
            for(int i=0; i< container.getSize(); i++){
                paciente p = (paciente) container.get(i);
                if(p.cedula.compareTo(cedula)==0){
                    return p;
                }
            }
        }else{
            return container.get(0);
        }
        System.out.println("El item no existe");
        return null;
    }
}
