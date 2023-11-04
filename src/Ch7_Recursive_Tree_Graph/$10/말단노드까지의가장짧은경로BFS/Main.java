package Ch7_Recursive_Tree_Graph.$10.말단노드까지의가장짧은경로BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt;
    Node rt;

    public Node(int data) {
        this.data = data;
        lt = null;
        rt = null;
    }
}

public class Main {
    Node root;

    public int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                Node tmp = Q.poll();
                if(tmp.lt != null){
                    Q.offer(tmp.lt);
                }
                if(tmp.rt != null){
                    Q.offer(tmp.rt);
                }
                if((tmp.lt == null && tmp.rt == null)){
                    return L;
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        System.out.println(T.BFS(T.root));
    }

}
