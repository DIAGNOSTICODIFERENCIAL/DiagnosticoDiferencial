package structures;

public class doubleLinkedList<t> {
    doubleNode head;
    doubleNode tail;
    int length;

    public doubleLinkedList(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public t getFirst(){
        return (t) this.head.data;
    }

    public t getLast(){
        return (t) this.tail.data;
    }

    public doubleLinkedList(t data){
        this.length = 1;
        this.head = new doubleNode(data);
        this.tail = this.head;
    }

    public void append(t data){
        if(length==0){
            insertAt(0,data);
            return;
        }
        doubleNode tmp = this.tail;
        this.tail = new doubleNode(data, tmp);
        tmp.next = this.tail;
        length++;
    }

    public t getK(int index) {
        if(index>length || index<0){
            System.out.println("Index out of range");
            doubleNode aux = new doubleNode(0);
            return (t) aux.data;
        }
        if (index == 0){
            return (t) this.head.data;
        }
        else if(index==length-1){
            return (t) this.tail.data;
        }
        else{
            doubleNode aux = this.head;
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
        if(idx==0){
            deleteFirst();
            return;
        }
        if(idx==length-1){
            this.tail = this.tail.prev;
            return;
        }
        if(idx>=length || idx<0){
            System.out.println("Index out of range");
        }
        doubleNode tmp = this.head;
        for(int i=1; i<idx; i++){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        tmp.next.prev = tmp.next;
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
            doubleNode aux = this.head;
            this.head = new doubleNode(data);
            this.head.next = aux;
            length++;
            return;
        }
        else{
            doubleNode tmp = head;
            for(int i=0; i<index; i++){
                if(i+1==index){
                    doubleNode aux = tmp.next;
                    tmp.next = new doubleNode(data);
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
        doubleNode tmp =  this.head;
        while(tmp.data!=value) {
            tmp = tmp.next;
            idx++;
        }
        return idx;
    }

    public void print(){
        doubleNode tmp = head;
        if(length==0) System.out.println("Empty List");
        for(int i=0; i<length;i++){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}
