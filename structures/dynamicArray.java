package structures;

public class dynamicArray {
    private int[] array;
    private int size;
    private int capacity;
    public static int number = 0;

    public dynamicArray(){
        this.array = new int[2];
        this.size = 0;
        this.capacity = 2;
        number++;
    }

    public int getSize() {
        return this.size;
    }

    public int get(int index){
        if(index >= size || index < 0){
            System.out.println("Índice no permitido");
            return Integer.MIN_VALUE;
        };
        return this.array[index];
    }

    public void insert(int index, int value){
        if(index >= size || index < 0)
            System.out.println("Índice no permitido");
        if(this.size == this.capacity)
            this.resize(10);
        for(int i = this.size; i > index; i--)
            this.array[i] = this.array[i-1];
        this.array[index] = value;
        this.size++;
    }

    public void insert(int value){ //PUSHBACK
        if(this.size == this.capacity) this.resize(2);
        this.array[this.size++] = value;
    }

    public void set(int index, int value){
        if(index >= size || index < 0)
            System.out.println("Índice no permitido");
        this.array[index] = value;
    }

    public void delete(int index){
        if(index >= size || index < 0){
            System.out.println("Índice no permitido");
            return;
        }
        int[] newArray = new int[this.capacity];
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
        int[] newArray = new int[mult*this.size];
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


}