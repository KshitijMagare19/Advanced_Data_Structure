package Tree;

class Node {
    int data;
    Node left;
    Node right;
    int lth, rth;
}

class BSTree {
    Node root;

    public Node getRoot() {
        return root;
    }

    void inOrder(Node root) {
        Node t = root;
        while(true) {
            while (t.lth == 0) {
                t = t.left;
            }
            System.out.println(t.data);
            while (t.rth == 1) {
                t = t.right;
                if (t == null) {
                    return;
                }
                System.out.println(t.data);
            }
            t = t.right;
        }

    }
    void preOrder(Node root) {
        Node t = root;
        while(true) {
            System.out.println(t.data);
            while (t.lth == 0) {
                t = t.left;
            }           
            while (t.rth == 1) {
                t = t.right;
                if (t == null) {
                    return;
                }
                System.out.println(t.data);
            }
            t = t.right;
        }

    }
    

    void insert(int val) {
        Node nn = new Node();
        nn.data = val;
        nn.left = null;
        nn.right = null;
        nn.lth = 1;
        nn.rth = 1;

        Node t = root;
        if (t == null) {
            root = nn;
            return;
        } else {
            while (t != null) {
                if (t.data > val) {
                    if (t.lth == 0) {
                        t = t.left;
                    } else {
                        nn.left = t.left;
                        nn.right = t;
                        t.lth = 0;
                        t.left = nn;
                    }

                } else if (t.data < val) {
                    if (t.rth == 0) {
                        t = t.right;
                    } else {
                        nn.left = t;
                        nn.right = t.right;
                        t.rth = 0;
                        t.right = nn;
                    }

                } else {
                    System.out.println("Duplicate");
                    return;
                }
            }
        }

    }

    BSTree() {
        root = null;
    }
}

class Threaded_Binary_Tree {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(46);
        tree.insert(21);
        tree.insert(15);
        tree.insert(14);
        tree.insert(17);
        tree.insert(16);
        tree.insert(19);

        Node t = tree.getRoot();
        tree.inOrder(t);
        //tree.preOrder(t);
    }
}
