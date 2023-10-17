package SkipList;

import java.util.Random;

class Node {
    public int key;
    public Node[] forward;

    public Node(int key, int level) {
        this.key = key;
        forward = new Node[level + 1];
    }
}

class skipList {
    private static final float P = 0.5f;
    private int MAXLVL;
    private int level;
    private Node header;

    public skipList(int MAXLVL, float probability) {
        this.MAXLVL = MAXLVL;
        level = 0;
        header = new Node(-1, MAXLVL);
    }

    private int randomLevel() {
        Random rand = new Random();
        float r = rand.nextFloat();
        int lvl = 0;
        while (r < P && lvl < MAXLVL) {
            lvl++;
            r = rand.nextFloat();
        }
        return lvl;
    }

    private Node createNode(int key, int level) {
        return new Node(key, level);
    }

    public void insertElement(int key) {
        Node[] update = new Node[MAXLVL + 1];
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        int randomLevel = randomLevel();

        if (randomLevel > level) {
            for (int i = level + 1; i < randomLevel + 1; i++) {
                update[i] = header;
            }
            level = randomLevel;
        }

        Node newNode = createNode(key, randomLevel);

        for (int i = 0; i <= randomLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public void displayList() {
        System.out.println("---------------------------------------------");
        System.out.println("|                 Skip List                 |");
        System.out.println("---------------------------------------------");
        for (int i = 0; i <= level; i++) {
            Node node = header.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.key + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        skipList lst = new skipList(3, 0.5f);
        lst.insertElement(3);
        lst.insertElement(6);
        lst.insertElement(7);
        lst.insertElement(9);
        lst.insertElement(12);
        lst.insertElement(19);
        lst.insertElement(17);
        lst.insertElement(26);
        lst.insertElement(21);
        lst.insertElement(25);
        lst.displayList();
    }
}

