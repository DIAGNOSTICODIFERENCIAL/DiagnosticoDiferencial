package structures;

public class simpleLinkedList<t> {
    simpleNode head;
    int length;
    public simpleLinkedList(){
        this.length = 0;
        this.head = null;
    }
    public simpleLinkedList(t data){
        this.length = 1;
        this.head = new simpleNode(data);
    }
    public void append(t data){
        if(length==0)head = new simpleNode(data);
        else{
            simpleNode tmp = this.head;
            while(tmp.next != null) tmp = tmp.next;
            tmp.next = new simpleNode(data);
        }
        length++;
    }

    public t getK(int index) {
        if(index>length || index<0){
            System.out.println("Index out of range");
            simpleNode aux = new simpleNode(0);
            return (t) aux.data;
        }
        if (index == 0){
            return (t) this.head.data;
        }else{
            simpleNode aux = this.head;
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
        simpleNode tmp = this.head;
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
            simpleNode aux = this.head;
            this.head = new simpleNode(data);
            this.head.next = aux;
            length++;
            return;
        }
        else{
            simpleNode tmp = head;
            for(int i=0; i<index; i++){
                if(i+1==index){
                    simpleNode aux = tmp.next;
                    tmp.next = new simpleNode(data);
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
        simpleNode tmp =  this.head;
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
