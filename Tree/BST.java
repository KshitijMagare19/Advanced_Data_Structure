package Tree;

class Node {
    int data;
    Node left;
    Node right;
}

 class BSTree {
    Node root;

    public Node getRoot() {
        return root;
    }
    void inOrder(Node t){
        if(t!= null){
            inOrder(t.left);
            System.out.println(t.data);
            inOrder(t.right);
        }
    }
    void insert(int val){
        Node nn = new Node();
        nn.data = val;
        nn.left = null;
        nn.right = null;

        Node p = null;
        Node t = root;
        if(t == null){
            root = nn;
            return;
        }
        else{
            while(t != null){
                if(t.data > val){
                    p = t;
                    t = t.left;
                }
                else if(t.data < val){
                    p = t;
                    t = t.right;
                }
                else{
                    return;
                }
            }
        }
        if(p.data > val){
            p.left = nn;
        }
        else if(p.data < val){
            p.right = nn;
        } 
        else{
            return;
        }

    }

    BSTree() {
        root = null;
    }
}

class BST{
 public static void main(String[] args) {
    BSTree tree = new BSTree();
    tree.insert(76);
    tree.insert(28);
    tree.insert(96);
    Node t = tree.getRoot();
    tree.inOrder(t);
 }
}
