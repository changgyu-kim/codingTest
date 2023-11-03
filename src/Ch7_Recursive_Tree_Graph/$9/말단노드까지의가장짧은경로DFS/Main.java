//문제
//아래 그림과 같은 이진트리 말단노드까지의 길이 중 가장 짧은 거리 구하기
//             1
//        2         3
//     4     5

package Ch7_Recursive_Tree_Graph.$9.말단노드까지의가장짧은경로DFS;

class Node {
    int data;
    Node lt;
    Node rt;
    public Node(){}
    public Node(int data){
        this.data = data;
        lt=rt=null;
    }

}

public class Main {
    Node root;
    public int DFS(int L,Node root){
        if(root.lt == null && root.rt == null){
            return L;
        } else {
            return Math.min(DFS(L+1, root.lt), DFS(L+1,root.rt));
        }
    }
    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.DFS(0, tree.root));

    }
}
