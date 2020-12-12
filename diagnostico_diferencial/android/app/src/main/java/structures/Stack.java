package structures;

public class Stack<t> {
    simpleNode top;
    int size;
    public Stack(){
        this.top = null;
        size = 0;
    }
    public Stack(t data){
        this.top = new simpleNode(data);
        size = 1;
    }

    public void push(t data){
        simpleNode tmp = new simpleNode(data,this.top);
        this.top = tmp;
        size++;
    }

    public void pop(){
        if(size==0){
            System.out.println("Stack is empty");
            return;
        }
        this.top = this.top.next;
        size--;
    }

    public t top(){
        if(size==0){
            System.out.println("Stack is empty");
            return null;
        }
        return (t) this.top.data;
    }

    public void makeEmpty(){
        this.size = 0;
        this.top = null;
    }
    public int size(){
        return size;
    }
    public void print(){
        if(size==0){
            System.out.println("Stack is empty");
            return;
        }
        simpleNode tmp = this.top;
        for(int i=0; i<size; i++){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
