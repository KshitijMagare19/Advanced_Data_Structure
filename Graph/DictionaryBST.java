package Graph;

import java.util.*;

class TreeNode {
    String key;
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class DictionaryBST {
    private TreeNode root;

    public void insert(String key, String value) {
        root = insertRec(root, key, value);
    }

    private TreeNode insertRec(TreeNode root, String key, String value) {
        if (root == null) {
            root = new TreeNode(key, value);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, value);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, value);
        } else {
            root.value = value;
        }

        return root;
    }

    public String search(String key) {
        TreeNode result = searchRec(root, key);
        return (result != null) ? result.value : null;
    }

    private TreeNode searchRec(TreeNode root, String key) {
        if (root == null || root.key.equals(key)) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    public void delete(String key) {
        root = deleteRec(root, key);
    }

    private TreeNode deleteRec(TreeNode root, String key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private String minValue(TreeNode root) {
        String minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public void update(String key, String newValue) {
        TreeNode nodeToUpdate = searchRec(root, key);
        if (nodeToUpdate != null) {
            nodeToUpdate.value = newValue;
        } else {
            System.out.println("Key not found in the dictionary.");
        }
    }

    public void inorderTraversal(TreeNode root, List<String> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.key + ": " + root.value);
            inorderTraversal(root.right, result);
        }
    }

    public List<String> getAscendingOrder() {
        List<String> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    public List<String> getDescendingOrder() {
        List<String> result = new ArrayList<>();
        descendingOrder(root, result);
        return result;
    }

    private void descendingOrder(TreeNode root, List<String> result) {
        if (root != null) {
            descendingOrder(root.right, result);
            result.add(root.key + ": " + root.value);
            descendingOrder(root.left, result);
        }
    }

    public void displayDictionary() {
        displayTree(root);
    }

    private void displayTree(TreeNode node) {
        if (node != null) {
            displayTree(node.left);
            System.out.println(node.key + ": " + node.value);
            displayTree(node.right);
        }
    }

    public static void main(String[] args) {
        DictionaryBST dictionary = new DictionaryBST();
        dictionary.insert("1", "one");
        dictionary.insert("2", "two");
        dictionary.insert("3", "three");
        dictionary.insert("4", "four");

        System.out.println("\nAscending Order:");
        List<String> ascendingOrder = dictionary.getAscendingOrder();
        for (String entry : ascendingOrder) {
            System.out.println(entry);
        }

        System.out.println("\nDescending Order:");
        List<String> descendingOrder = dictionary.getDescendingOrder();
        for (String entry : descendingOrder) {
            System.out.println(entry);
        }

        dictionary.update("4", "FOUR");
        System.out.println("\nAfter Updating key 4 with value FOUR:");
        dictionary.displayDictionary();

        dictionary.deleteRec(dictionary.root, "4");
        System.out.println("\nAfter Deleting key 4 :");
        dictionary.displayDictionary();

    }
}
