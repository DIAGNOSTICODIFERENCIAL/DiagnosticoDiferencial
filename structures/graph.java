
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class graph {

    public int[][] adjMatrix;
    private int size;
    public int nodos;
    private vertex[] vertices;
    ArrayList<String>  ansTopSort;

    public graph(int size){
        this.nodos = 0;
        this.size = size;
        adjMatrix = new int[size][size];
        vertices = new vertex[size];
        for(int i = 0; i<size; i++){
            for(int j=0; j<size;j++){
                adjMatrix[i][j]=0;
            }
            vertices[i] = new vertex("null");
        }
        ansTopSort = new ArrayList<String>();
    }

    public void addVertex(String name){
        nodos++;
        vertices[nodos-1] = new vertex(name);
    }

    public void removeVertex(String name){
        int idx = findVertexIndex(name);
        vertices[idx] = null;
        for(int i=0; i<size; i++){
            adjMatrix[i][idx] = 0;
            adjMatrix[idx][i] = 0;
        }
        nodos-=1;
    }

    public void addEdge(String name1, String name2){
        int index1=-1, index2=-1;
        index1 = findVertexIndex(name1);
        index2 = findVertexIndex(name2);
        //System.out.println(index1+" a "+index2);
        adjMatrix[index1][index2] = 1;
    }

    public void removeEdge(String name1, String name2){
        int index1=-1, index2=-1;
        index1 = findVertexIndex(name1);
        index2 = findVertexIndex(name2);
        adjMatrix[index1][index2] = 0;
    }

    private class vertex{
        String name;
        int[] weights;
        vertex(String name){
            this.name = name;
        }
    }

    public void showMatrix(){
        for(int i=0; i<size;i++){
            for(int j=0; j<size; j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void topSort(){
        //retorna un string con el topological sort
        ansTopSort = new ArrayList<String>();
        vertex vTmp = null;
        for(int i=0 ; i<nodos; i++){
            vTmp = findIndegreeZero();
            if( vTmp == null){
                System.out.println("Failed or ready xdd");
              //  System.out.println(ansTopSort);
                return;
            }
            int idx = findVertexIndex(vTmp.name);
            ansTopSort.add(vTmp.name);
           // showMatrix();
            for(int j = 0; j<size; j++){
                adjMatrix[idx][j]=-1;
            }
        }
        System.out.println(ansTopSort);
    }

    public vertex findIndegreeZero(){
        for(int i = 0; i<nodos; i++){
          //  System.out.println(vertices[i].name);
            //showMatrix();
            if(isInDegreeZero(vertices[i].name) && !ansTopSort.contains(vertices[i].name)){
                //System.out.println(vertices[i].name);
                return vertices[i];
            }
        }
        return null;
    }

    public boolean contains(String name){
        for(int i=0; i<nodos; i++){
            if(vertices[i].name==name){
                return true;
            }
        }
        return false;
    }

    public boolean isInDegreeZero(String name){
        if(name!="null" && contains(name)){
            int idx = findVertexIndex(name);
            //System.out.println(idx);
            //System.out.println(name);
            for(int i=0; i<size;i++){
               // System.out.println(i+" "+idx);
                if(adjMatrix[i][idx]==1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int findVertexIndex(String name){
        for(int i=0; i<nodos; i++){
            if(vertices[i].name.equals(name)){
                return i;
            }
        }
        return -1;
    }
}
