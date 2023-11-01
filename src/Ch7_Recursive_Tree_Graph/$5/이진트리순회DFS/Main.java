//문제
//             1
//        2         3
//     4     5   6     7
//        의 이진트리가 있을때 전위, 중위,후위순회 출력하기

package Ch7_Recursive_Tree_Graph.$5.이진트리순회DFS;



class Node {
    int data;
    Node lt;
    Node rt;
    public Node(int data){
        this.data=data;
        lt=rt=null;
    }
}
public class Main {
    Node root;
    public void DFS(Node root){
        if(root == null);
        else {
            System.out.print(root.data+" "); // 전위
            DFS(root.lt);
//            System.out.print(root.data+" "); // 중위
            DFS(root.rt);
//            System.out.print(root.data+" "); // 후위

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
        tree.DFS(tree.root);

    }
}
