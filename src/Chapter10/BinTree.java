package Chapter10;

import java.util.Comparator;

public class BinTree<K, V> {
    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root; // 루트
    private Comparator<? super K> comparator = null;

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> c) {
        this();  // BinTree() 호출
        comparator = c;
    }

    // 두 키 값을 비교 (같으면 0, key1 > key2 이면 양수, 나머지는 음수)
    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    // 키에 의한 검색
    public V search(K key) {
        Node<K, V> p = root;  // 루트에서 시작

        while (true) {
            if (p == null)
                return null;
            int cond = comp(key, p.getKey());
            if (cond == 0)
                return p.getValue();
            else if (cond < 0)
                p = p.left;
            else
                p = p.right;
        }
    }

    // node를 루트로 하는 서브 트리에 노드<K, V> 삽입
    public void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0)
            return;
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<K, V>(key, data, null, null);
            else
                addNode(node.left, key, data);
        } else {
            if (node.right == null)
                node.right = new Node<K, V>(key, data, null, null);
            else
                addNode(node.right, key, data);
        }
    }

    // 노드를 삽입
    public void add(K key, V data) {
        if (root == null)
            root = new Node<K, V>(key, data, null, null);
        else
            addNode(root, key, data);
    }

    // 키 값이 key인 노드를 삭제
    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        while (true) {
            if (p == null)
                return false;
            int cond = comp(key, p.getKey());
            if (cond == 0)
                break;
            else {
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if (p.left == null) {
            if (p == root)
                root = p.right;
            else if (isLeftChild)
                parent.left = p.right;
            else
                parent.right = p.right;
        } else if (p.right == null) {
            if (p == root)
                root = p.left;
            else if (isLeftChild)
                parent.left = p.left;
            else
                parent.right = p.left;
        } else {
            parent = p;
            Node<K, V> left = p.left;
            isLeftChild = true;
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;
            p.data = left.data;
            if (isLeftChild)
                parent.left = left.left;
            else
                parent.right = left.left;
        }
        return true;
    }

    // node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right);
        }
    }

    // 모든 노드를 키 값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }

    // 키 값의 내림차순으로 모든 노드를 표시
    public void printReverse(Node node) {
        if (node != null) {
            printReverse(node.right);
            System.out.println(node.key + " " + node.data);
            printReverse(node.left);
        }
    }

    public void printDown() {
        printReverse(root);
    }

    // 가장 작은 키 값을 반환
    public K getMinKey() {
        Node<K, V> p = root;

        if (p == null)
            return null;
        while (p.left != null)
            p = p.left;
        return p.getKey();
    }

    // 가장 작은 키 값을 갖는 노드의 데이터를 반환
    public V getDataWithMinKey() {
        Node<K, V> p = root;

        if (p == null)
            return null;
        while (p.left != null)
            p = p.left;
        return p.getValue();
    }

    // 가장 큰 키 값을 반환
    public K getMaxKey() {
        Node<K, V> p = root;

        if (p == null)
            return null;
        while (p.right != null)
            p = p.left;
        return p.getKey();
    }

    // 가장 큰 키 값을 갖는 노드의 데이터를 반환
    public V getDataWithMaxKey() {
        Node<K, V> p = root;

        if (p == null)
            return null;
        while (p.right != null)
            p = p.left;
        return p.getValue();
    }
}
