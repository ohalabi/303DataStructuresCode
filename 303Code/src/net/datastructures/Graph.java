package net.datastructures;

public class Graph {
    //---- nested Vertex class -------//
    public class Vertex {
        public char label;  // label (e.g. 'A')

        public Vertex(char lab) {
            label = lab;
        }
    }

    //-------- end of nested Vertex class ---------//
    //private final int MAX_VERTS = 20;
    private Vertex vertexList[];   //array of vertices
    private int adjMat[][];  //adjacency matrix
    private int nVerts; // current number of vertices
    private boolean wasVisited[];

    public Graph(int MAX_VERTS) {
        vertexList = new Vertex[MAX_VERTS]; //adjacency matrix
        //adjMat = new int[MAX_VERTS][MAX_VERTS];
        adjMat = new int[MAX_VERTS][];
        for (int j = 0; j < MAX_VERTS; j++) //set adjacency matrix
            adjMat[j] = new int[MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) //set adjacency matrix
            for (int k = 0; k < MAX_VERTS; k++)
                adjMat[j][k] = 0;
    }

    public void addVertex(char lab) {   //argument is label
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && wasVisited[j] == false)
                return j;
        return -1; // no such vertices
    } // end getAdjUnvisi

    public void dfs() {
        //boolean[] wasVisited = new boolean[vertexList.length];
        wasVisited = new boolean[vertexList.length];
        Stack<Integer> theStack = new ArrayStack<>();
        wasVisited[0] = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.top());
            if (v == -1)
                theStack.pop();
            else // if it exists,
            {
                wasVisited[v] = true; // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
            }
        }
    }

    public void bfs() {
        //boolean[] wasVisited = new boolean[vertexList.length];
        wasVisited = new boolean[vertexList.length];
        Queue<Integer> theQueue = new ArrayQueue<>();
        wasVisited[0] = true;
        displayVertex(0);
        theQueue.enqueue(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.dequeue();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                wasVisited[v2] = true;
                displayVertex(v2);
                theQueue.enqueue(v2);
            }
        }
    }

    public void dfsRecursive() {
        wasVisited = new boolean[vertexList.length];
        DFSRecursiveCall(0);
    }

    private void DFSRecursiveCall(int v) {
        wasVisited[v] = true; //mark it
        displayVertex(v);     //display it
        int v2;
        while ((v2 = getAdjUnvisitedVertex(v)) != -1)
            DFSRecursiveCall(v2);
    }
} // end class Graph






