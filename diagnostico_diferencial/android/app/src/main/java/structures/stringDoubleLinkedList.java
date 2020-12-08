package diagnostico_diferencial.android.app.src.main.java.structures;

import structures.stringDoubleNode;

import java.util.ArrayList;


public class stringDoubleLinkedList {
    structures.stringDoubleNode head;
    structures.stringDoubleNode tail;
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
        this.head = new structures.stringDoubleNode(data);
        this.tail = this.head;
    }

    public stringDoubleLinkedList(ArrayList<String> data){
        this.length = data.size();
        this.head = new structures.stringDoubleNode(data.get(0));
        System.out.println("cabezaaa "+head.data);
        structures.stringDoubleNode tmp = head;
        for(int i=1; i<data.size(); i++){
            tmp.next = new structures.stringDoubleNode(data.get(i),tmp);
            tmp = tmp.next;
        }
        if(data.size()!=1){
            if(data.size()==2){{
                this.tail = tmp.prev;
            }}
            this.tail = tmp.prev.prev;
        }
        else {this.tail = this.head;}
    }

    public void append(String data){
        if(length==0){
            this.head = new structures.stringDoubleNode(data);
            this.tail = this.head;
            this.tail.prev = this.head;
            this.head.next = this.tail;
            this.length++;
            return;
        }
        structures.stringDoubleNode tmp = this.tail;
        this.tail = new structures.stringDoubleNode(data, tmp);
        tmp.next = this.tail;
        length++;
    }

    public String getK(int index) {
        if(index>length || index<0){
            structures.stringDoubleNode aux = new structures.stringDoubleNode("0");
            return (String) aux.data;
        }
        if (index == 0){
            return (String) this.head.data;
        }
        else if(index==length-1){
            System.out.println("indeeeex "+index);
            return (String) this.tail.data;
        }
        else{
            structures.stringDoubleNode aux = this.head;
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
        structures.stringDoubleNode tmp = this.head;
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
            structures.stringDoubleNode aux = this.head;
            this.head = new structures.stringDoubleNode(data);
            this.head.next = aux;
            length++;
            return;
        }
        else{
            structures.stringDoubleNode tmp = head;
            for(int i=0; i<index; i++){
                if(i+1==index){
                    structures.stringDoubleNode aux = tmp.next;
                    tmp.next = new structures.stringDoubleNode(data);
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
        structures.stringDoubleNode tmp =  this.head;
        while(tmp.data!=value) {
            tmp = tmp.next;
            idx++;
        }
        return idx;
    }

    public void print(){
        structures.stringDoubleNode tmp = head;
        if(length==0) System.out.println("Empty List");
        for(int i=0; i<length;i++){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    @Override
    public String toString(){
        String ans = "";
        structures.stringDoubleNode tmp = head;
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
    public structures.stringDoubleNode mergeSort(structures.stringDoubleNode head){
        //Caso base, si es nula o es de longitud 1
        if (head == null || head.next == null) {
            return head;
        }

        // Obtenemos la mitad de la lista
        structures.stringDoubleNode middle = getMiddle(head);
        structures.stringDoubleNode nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        structures.stringDoubleNode left = mergeSort(head);

        // Apply mergeSort on right list
        structures.stringDoubleNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        structures.stringDoubleNode sortedlist = mergeLists(left, right);
        return sortedlist;

    }
    public structures.stringDoubleNode mergeLists(structures.stringDoubleNode a, structures.stringDoubleNode b){

        structures.stringDoubleNode result = null;
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
    public structures.stringDoubleNode getMiddle(structures.stringDoubleNode head){
        if (head == null)
            return head;

        structures.stringDoubleNode slow = head, fast = head;

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
