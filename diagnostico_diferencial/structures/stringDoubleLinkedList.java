package structures;

import java.util.ArrayList;

public class stringDoubleLinkedList {
    stringDoubleNode head;
    stringDoubleNode tail;
    int length;

    public stringDoubleLinkedList(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public String getFirst(){
        return (String) this.head.data;
    }

    public String getLast(){
        return (String) this.tail.data;
    }

    public stringDoubleLinkedList(String data){
        this.length = 1;
        this.head = new stringDoubleNode(data);
        this.tail = this.head;
    }

    public void append(String data){
        if(length==0){
            this.head = new stringDoubleNode(data);
            this.tail = this.head;
            this.tail.prev = this.head;
            this.head.next = this.tail;
            this.length++;
            return;
        }
        stringDoubleNode tmp = this.tail;
        this.tail = new stringDoubleNode(data, tmp);
        tmp.next = this.tail;
        length++;
    }

    public String getK(int index) {
        if(index>length || index<0){
            stringDoubleNode aux = new stringDoubleNode("0");
            return (String) aux.data;
        }
        if (index == 0){
            return (String) this.head.data;
        }
        else if(index==length-1){
            return (String) this.tail.data;
        }
        else{
            stringDoubleNode aux = this.head;
            //si algo quitar ese -1 jaja
            for(int i = 0; i < index-1; i++){
                aux = aux.next;
            }
            return aux.data;
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
        stringDoubleNode tmp = this.head;
        for(int i=1; i<idx; i++){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        tmp.next.prev = tmp.next;
        length--;
    }

    public void insertAt(int index,String data){
        if(index!=0 && index>=length || index<0){
            System.out.println("Index out of range");
            return;
        }
        if(index==length-1){
            this.append(data);
            return;
        }
        if(index==0){
            stringDoubleNode aux = this.head;
            this.head = new stringDoubleNode(data);
            this.head.next = aux;
            length++;
            return;
        }
        else{
            stringDoubleNode tmp = head;
            for(int i=0; i<index; i++){
                if(i+1==index){
                    stringDoubleNode aux = tmp.next;
                    tmp.next = new stringDoubleNode(data);
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

    public int getIndex(String value) {
        int idx = 0;
        stringDoubleNode tmp =  this.head;
        while(tmp.data!=value) {
            tmp = tmp.next;
            idx++;
        }
        return idx;
    }

    public void print(){
        stringDoubleNode tmp = head;
        if(length==0) System.out.println("Empty List");
        for(int i=0; i<length;i++){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }
    public String toString(){
        String ans = "";
        stringDoubleNode tmp = head;
        if(length==0) ans="Empty List";
        for(int i=0; i<length;i++){
            ans = ans + tmp.data+" ";
            tmp = tmp.next;
        }
        ans = ans + "\n";
        return ans;
    }
    /*-----------------------Merge Sort--------------------------------------------*/
    public void sort(){
        this.head = mergeSort(this.head);
    }
    public stringDoubleNode mergeSort(stringDoubleNode head){
        //Caso base, si es nula o es de longitud 1
        if (head == null || head.next == null) {
            return head;
        }

        // Obtenemos la mitad de la lista
        stringDoubleNode middle = getMiddle(head);
        stringDoubleNode nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        stringDoubleNode left = mergeSort(head);

        // Apply mergeSort on right list
        stringDoubleNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        stringDoubleNode sortedlist = mergeLists(left, right);
        return sortedlist;

    }
    public stringDoubleNode mergeLists(stringDoubleNode a, stringDoubleNode b){

        stringDoubleNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data.compareTo(b.data)<=0){
            result = a;
            result.next = mergeLists(a.next, b);
        }
        else {
            result = b;
            result.next = mergeLists(a, b.next);
        }
        return result;


    }
    public stringDoubleNode getMiddle(stringDoubleNode head){
        if (head == null)
            return head;

        stringDoubleNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ArrayList<String> toArrayList(){
        ArrayList<String> ans = new ArrayList<String>();
        stringDoubleNode tmp = head;
        if(length==0){ System.out.println("EmptyList");return null;};
        for(int i=0; i<length;i++){
            ans.add(tmp.data);
            tmp = tmp.next;
        }
        return ans;
    }
}
