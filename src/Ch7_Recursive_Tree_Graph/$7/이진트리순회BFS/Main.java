//문제
//아래 그림과 같은 이진트리를 레벨탐색 연습하세요
//             1
//        2         3
//     4     5   6     7

package Ch7_Recursive_Tree_Graph.$7.이진트리순회BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt;
    Node rt;

    Node(){}
    Node(int data){
        this.data = data;
        lt=rt=null;
    }
}

public class Main {
    Node root;
    void BFS(Node root){
        int L = 0;
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            System.out.println("this level == "+L);
            for(int i=0; i<Q.size(); i++){
                Node tmp = Q.poll();
                System.out.print (tmp.data+" ");
                if(tmp.lt != null) Q.offer(tmp.lt);
                if(tmp.rt != null) Q.offer(tmp.rt);
            }
            System.out.println();
            L++;
        }

    }
    public static void main(String[] args) {
       Main tree = new Main();
       tree.root = new Node(1);
       tree.root.lt = new Node(2);
       tree.root.rt = new Node(3);
       tree.root.lt.lt = new Node(4);
       tree.root.lt.rt = new Node(5);
       tree.root.rt.lt = new Node(6);
       tree.root.rt.rt = new Node(7);
       tree.BFS(tree.root);
    }
}
