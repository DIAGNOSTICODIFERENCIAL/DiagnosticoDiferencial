package structures;

import src.diagnosisTools.enfermedad;

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
            this.head = new doubleNode(data);
            this.tail = this.head;
            this.tail.prev = this.head;
            this.head.next = this.tail;
            this.length++;
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
        if(index!=0 && index>=length || index<0){
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
    public String toString(){
        String ans = "";
        doubleNode tmp = head;
        if(length==0) ans="Empty List";
        for(int i=0; i<length;i++){
            ans = ans + tmp.data+" ";
            tmp = tmp.next;
        }
        return ans;
    }
    /*-----------------------Merge Sort--------------------------------------------*/
    public void sort(){
        this.head = mergeSort(this.head);
    }
    public doubleNode mergeSort(doubleNode head){
        //Caso base, si es nula o es de longitud 1
        if (head == null || head.next == null) {
            return head;
        }

        // Obtenemos la mitad de la lista
        doubleNode middle = getMiddle(head);
        doubleNode nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        doubleNode left = mergeSort(head);

        // Apply mergeSort on right list
        doubleNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        doubleNode sortedlist = mergeLists(left, right);
        return sortedlist;

    }
    public doubleNode mergeLists(doubleNode a, doubleNode b){
        doubleNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (((enfermedad) a.data).signos.length+((enfermedad) a.data).sintomas.length>((enfermedad) b.data).signos.length+((enfermedad) b.data).sintomas.length){
            result = a;
            result.next = mergeLists(a.next, b);
        }
        else {
            result = b;
            result.next = mergeLists(a, b.next);
        }
        return result;


    }
    public doubleNode getMiddle(doubleNode head){
        if (head == null)
            return head;

        doubleNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
