package structures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import diagnosisTools.*;

public class dynamicArray {
    private Object[] array;
    private int size;
    private int capacity;
    public static int number = 0;

    public dynamicArray(){
        this.array = new Object[2];
        this.size = 0;
        this.capacity = 2;
        number++;
    }

    public int getSize() {
        return this.size;
    }

    public Object get(int index) {
        if(index >= size || index < 0){
            System.out.println("Índice no permitido");
            return Integer.MIN_VALUE;
        };
        return this.array[index];
    }

    public <T> void insert(int index, T value) {
        if(index >= size || index < 0)
            System.out.println("Índice no permitido");
        if(this.size == this.capacity)
            this.resize(10);
        for(int i = this.size; i > index; i--)
            this.array[i] = this.array[i-1];
        this.array[index] = value;
        this.size++;
    }

    public <T> void insert(T value) { // PUSHBACK
        if(this.size == this.capacity) this.resize(2);
        this.array[this.size++] = value;
    }

    public <T> void set(int index, T value) {
        if(index >= size || index < 0)
            System.out.println("Índice no permitido");
        this.array[index] =  value;
    }

    public void delete(int index){
        if(index >= size || index < 0){
            System.out.println("Índice no permitido");
            return;
        }
        Object[] newArray = new Object[this.capacity];
        for(int i = 0; i < index; i++)
            newArray[i] = this.array[i];
        for (int j = index+1; j < this.size;j++)
            newArray[j-1] = this.array[j];
        this.size--;
    }

    public void deleteV2(int index){
        if(index >= size || index < 0){
            System.out.println("Índice no permitido");
            return;
        }
        for(int i = index; i < this.size-1; i++){
            this.array[i] = this.array[i+1];
        }
        this.array[--this.size] = 0;
    }

    private void resize(int mult){
        Object[] newArray = new  Object[mult * this.size];
        for(int i = 0; i < this.size; i++)
            newArray[i] = this.array[i];
        this.capacity *= mult;
        this.array = newArray;
    }

    public String toString(){
        String content = "";
        for(int i=0; i<this.size; i++){
            content = content + this.array[i] + " ";
        }
        return content;
    }

    public ArrayList toArrayList(){
        ArrayList arrayListAns = new ArrayList();
        for(int i=0; i<this.size;i++){
            //this.array[i] es una enferemdad.toString()
            arrayListAns.add(this.array[i]);
        }
        return arrayListAns;
    }

}