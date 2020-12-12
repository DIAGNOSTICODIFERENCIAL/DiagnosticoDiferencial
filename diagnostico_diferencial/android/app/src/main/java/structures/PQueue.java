package structures;

import diagnosisTools.enfermedad;

import java.util.ArrayList;

public class PQueue
{
    private int size; // Number of elements in queue
    private ArrayList items; // The queue binary heap array



    public PQueue() {
        size = 0;
        items = new ArrayList();
        // create space for sentinel
        items.add(null);
    }



    public void add(Comparable x)
    {
        // increase the size of the items heap to create a hole for the new item
        items.add(null);

        // Insert item at end of heap and then re-establish ordering
        size += 1;
        int hole = size;
        // set the item as a sentinel at the base of the heap
        items.set(0, x);

        // move the item up from the hole position to its correct place
        for (; x.compareTo(items.get(hole / 2)) < 0; hole /= 2) {
            items.set(hole, items.get(hole / 2));
        }
        // insert the new item in the correct place
        items.set(hole, x);
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void clear() {
        size = 0;
        items.clear();
    }



    public Object poll()
    {
        if (isEmpty())
            return null;
        Object minItem = items.get(1);
        items.set(1, items.get(size));
        size -= 1;
        reorder(1);

        return minItem;
    }

    public Object peek()
    {
        if (isEmpty())
            return null;
        Object minItem = items.get(1);
        return minItem;
    }



    private void reorder(int hole)
    {
        int child;
        Object tmp = items.get(hole);

        for (; hole * 2 <= size; hole = child) {
            child = hole * 2;
            if (child != size
                    && ((Comparable) items.get(child + 1)).compareTo(items.get(child)) < 0)
                child++;
            if (((Comparable) items.get(child)).compareTo(tmp) < 0)
                items.set(hole, items.get(child));
            else
                break;
        }
        items.set(hole, tmp);
    }


    public ArrayList toArrayList(){
        ArrayList lista = new ArrayList<>();
        int i = 0;
        while(!isEmpty() && i<10){
            enfermedad tempEnf = (enfermedad) poll();
            lista.add(tempEnf.toArrayList());
            i++;
        }
        return lista;
    }



}
