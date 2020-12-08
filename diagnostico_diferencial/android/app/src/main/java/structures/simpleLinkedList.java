package diagnostico_diferencial.android.app.src.main.java.structures;

import structures.simpleNode;

public class simpleLinkedList<t> {
    structures.simpleNode head;
    int length;
    public simpleLinkedList(){
        this.length = 0;
        this.head = null;
    }
    public simpleLinkedList(t data){
        this.length = 1;
        this.head = new structures.simpleNode(data);
    }
    public void append(t data){
        if(length==0)head = new structures.simpleNode(data);
        else{
            structures.simpleNode tmp = this.head;
            while(tmp.next != null) tmp = tmp.next;
            tmp.next = new structures.simpleNode(data);
        }
        length++;
    }

    public t getK(int index) {
        if(index>length || index<0){
            System.out.println("Index out of range");
            structures.simpleNode aux = new structures.simpleNode(0);
            return (t) aux.data;
        }
        if (index == 0){
            return (t) this.head.data;
        }else{
            structures.simpleNode aux = this.head;
            for(int i = 0; i < index; i++){
                aux = aux.next;
            }
            return (t) aux.data;
        }
    }

    public void deleteFirst() {
        if (this.length != 0){
            this.head = this.head.next;
            this.length--;
        } else {
            System.out.println("Index out of range");
        }
    }

    public void deleteK(int idx){
        if(idx==0){deleteFirst();return;}
        if(idx>=length || idx<0){
            System.out.println("Index out of range");
            return;
        }
        structures.simpleNode tmp = this.head;
        for(int i=1; i<idx; i++){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        length--;
    }

    public void insertAt(int index,t data){
        if(index>=length || index<0){
            System.out.println("Index out of range");
            return;
        }
        if(index==length-1){
            this.append(data);
            return;
        }
        if(index==0){
            structures.simpleNode aux = this.head;
            this.head = new structures.simpleNode(data);
            this.head.next = aux;
            length++;
            return;
        }
        else{
            structures.simpleNode tmp = head;
            for(int i=0; i<index; i++){
                if(i+1==index){
                    structures.simpleNode aux = tmp.next;
                    tmp.next = new structures.simpleNode(data);
                    tmp.next.next = aux;
                    length++;
                    return;
                }
                tmp = tmp.next;
            }
        }
    }

    public int length() {
        return this.length;
    }

    public int getIndex(t value) {
        int idx = 0;
        structures.simpleNode tmp =  this.head;
        while(tmp.data!=value) {
            tmp = tmp.next;
            idx++;
        }
        return idx;
    }

    public void print(){
        simpleNode tmp = head;
        if(length==0) System.out.println("Empty List");
        for(int i=0; i<length;i++){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
