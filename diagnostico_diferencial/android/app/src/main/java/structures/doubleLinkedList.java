package diagnostico_diferencial.android.app.src.main.java.structures;

import diagnosisTools.enfermedad;
import structures.doubleNode;

public class doubleLinkedList<t> {
    structures.doubleNode head;
    structures.doubleNode tail;
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
        this.head = new structures.doubleNode(data);
        this.tail = this.head;
    }

    public void append(t data){
        if(length==0){
            this.head = new structures.doubleNode(data);
            this.tail = this.head;
            this.tail.prev = this.head;
            this.head.next = this.tail;
            this.length++;
            return;
        }
        structures.doubleNode tmp = this.tail;
        this.tail = new structures.doubleNode(data, tmp);
        tmp.next = this.tail;
        length++;
    }

    public t getK(int index) {
        if(index>length || index<0){
            System.out.println("Index out of range");
            structures.doubleNode aux = new structures.doubleNode(0);
            return (t) aux.data;
        }
        if (index == 0){
            return (t) this.head.data;
        }
        else if(index==length-1){
            return (t) this.tail.data;
        }
        else{
            structures.doubleNode aux = this.head;
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
        structures.doubleNode tmp = this.head;
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
            structures.doubleNode aux = this.head;
            this.head = new structures.doubleNode(data);
            this.head.next = aux;
            length++;
            return;
        }
        else{
            structures.doubleNode tmp = head;
            for(int i=0; i<index; i++){
                if(i+1==index){
                    structures.doubleNode aux = tmp.next;
                    tmp.next = new structures.doubleNode(data);
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
        structures.doubleNode tmp =  this.head;
        while(tmp.data!=value) {
            tmp = tmp.next;
            idx++;
        }
        return idx;
    }

    public void print(){
        structures.doubleNode tmp = head;
        if(length==0) System.out.println("Empty List");
        for(int i=0; i<length;i++){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public String toString(){
        String ans = "";
        structures.doubleNode tmp = head;
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
    public structures.doubleNode mergeSort(structures.doubleNode head){
        //Caso base, si es nula o es de longitud 1
        if (head == null || head.next == null) {
            return head;
        }

        // Obtenemos la mitad de la lista
        structures.doubleNode middle = getMiddle(head);
        structures.doubleNode nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        structures.doubleNode left = mergeSort(head);

        // Apply mergeSort on right list
        structures.doubleNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        structures.doubleNode sortedlist = mergeLists(left, right);
        return sortedlist;

    }
    public structures.doubleNode mergeLists(structures.doubleNode a, structures.doubleNode b){
        structures.doubleNode result = null;
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
    public structures.doubleNode getMiddle(structures.doubleNode head){
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
