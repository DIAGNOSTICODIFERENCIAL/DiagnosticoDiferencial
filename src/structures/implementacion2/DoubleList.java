package implementacion2;

public class DoubleList<T> extends list<T> {
    int length;
    DNode first; // referencia al primer nodo
    DNode last;

    public DoubleList() {
        this.length=0;
        this.first=null;
        this.last=null;
    }

    @Override
    void insert(T data) {
        if (this.length==0){
            this.first = new DNode(data,null);
            this.last=this.first;
            length++;
            return;
        }else{

        DNode newDnode = new DNode(data, this.last);
        this.last.next=newDnode;
        this.last = newDnode;
        length++;
        }
        }
    T last(){
        return (T) this.last.data;
    }

    @Override
    void remove(T data) {
        if(this.first == null){
            System.out.println("Lista Vacía");
            
        }
        if(this.first.data == data){
            this.removeFirst();
    
        }
        
        else{
            DNode aux = this.first;
            while(aux.next.data != data){
                aux = aux.next;
                if (aux.next == null){
                    System.out.println("elemento no se encuentra en la lista");
                    return;
                }

        }
        if (aux.next==this.last){
            this.last= aux; // si se quiere eliminar el ultimo se debe cambiar la referencia hacia el ultimo de la lista
        }
        else{
            aux.next.next.prev= aux.next; //si no se quiere eliminar el ultimo se debe cambiar la referencia del siguiente al que se va a eliminar.

        }
        aux.next = aux.next.next; 
        length--;
        }
        
    }

    @Override
    T getK(int index) {
        if (index==0){
            return (T)this.first.data;
        } 
        else if (index >= length || index<0){
            System.out.println("indice fuera de rango");
            DNode aux = new DNode (-1, this.last); 
            return (T) aux.data;
        }
        
        else{
            DNode aux = this.first;
            for(int i = 0; i < index;i++ ){
                aux = aux.next;
            }
            return (T) aux.data;
        }
        
    }

    @Override
    T getFirst() {
        if (this.length!=0){
            return (T) this.first.data;
        }
        else{
            return null;
        }
        
    }

    @Override
    void removeFirst() {
        if (length!=0){
        this.first= this.first.next; //se cambia el primer nodo por el segundo 
        length--;
        }
        else{
            System.out.println("no hay datos");
        }

    }

    @Override
    boolean listEmpty() {

        return this.length==0;
        
    }

    @Override
    int lengthlist() {
        
        return this.length;
    }

    @Override
    void insertFirst(T first) {
        if (this.first==null){
            DNode newfirst = new DNode (first, null);
            this.first= newfirst;
        }else{
            DNode newfirst = new DNode(first, null);
            newfirst.next = this.first;
            this.first.prev=newfirst;
            this.first = newfirst;
            if (this.last==null){
                this.last=this.first.next;
            }
            
        } 
        length++;
    }

    @Override
     int getIndex(T data) {
        if (length==0){
            System.out.println("Lista vacía");
        }
        DNode aux = this.first;
        int indice = 0; //indice empieza en 0
        while (aux.data!=data){
            if (aux.next == null ){
                return -1;}
            aux=aux.next;
            indice++;
        }
        return indice;
    }

    

    @Override
    void insertIndex(int index, T data) {
        if(index>=length || index<0){
            System.out.println("Index out of range");
            return;
        }
        if(index==length){
            this.insert(data);
            return;
        }
        if(index==0){
            this.insertFirst(data);
            length++;
            return;
        }else{
            DNode aux = this.first;
            for(int i =0; i<index;i++){
            
                if(i+1==index){
                    DNode auxNext = aux.next;
                    DNode newNode = new DNode (data,aux);
                    newNode.next = auxNext;
                    aux.next = newNode;
                    auxNext.prev= newNode;
                    
                    this.length++;
                }
                else{
                    aux = aux.next;
                }
            }
        }
        
    }

    @Override
    void printlist(){
        DNode aux = this.first;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(aux.next!=null){
            sb.append(aux.data + ", ");
            aux=aux.next;
        }
        sb.append(aux.data + ", ");
        sb.append("]");

        System.out.println(sb.toString());
        
    }

    public static void main(String[] args) {
 
            
    }
    

}