import structure5.BinaryTree;
import structure5.Association;

import java.util.Comparator;

public class BinarySearchTree<K, V> {
    protected BinaryTree<Association> root;
    protected final BinaryTree<Association> EMPTY;
    protected int count;
    protected Comparator<K> ordering;
    public BinarySearchTree(Comparator<K> alternateOrder) {
        this.EMPTY = new BinaryTree();
        this.root = this.EMPTY;
        this.count = 0;
        this.ordering = alternateOrder;
    }

    public void add(Association value) {
        BinaryTree<Association> newNode = new BinaryTree(value, this.EMPTY, this.EMPTY);
        if (this.root.isEmpty()) {
            this.root = newNode;
        } else {
            BinaryTree<Association> insertLocation = this.locate(this.root, (K) value.getKey());
            K nodeKey = (K) insertLocation.value().getKey();
            if (this.ordering.compare(nodeKey, (K)value.getKey()) < 0) {
                insertLocation.setRight(newNode);
            } else {
                insertLocation.setLeft(newNode);
            }
        }

        ++this.count;
    }
    public V search(K key){
        if (this.root.isEmpty()) {
            return null;
        } else {
            BinaryTree<Association> possibleLocation = this.locate(this.root, key);
            return key.equals(possibleLocation.value().getKey()) ? (V) possibleLocation.value().getValue() : null;
        }
    }

    protected BinaryTree<Association> locate(BinaryTree<Association> root, K key) {
        K rootKey = (K) root.value().getKey();
        if (rootKey.equals(key)) {
            return root;
        } else {
            BinaryTree child;
            if (this.ordering.compare(rootKey, key) < 0) {
                child = root.right();
            } else {
                child = root.left();
            }

            return child.isEmpty() ? root : this.locate(child, key);
        }
    }

    public  void InOrderPrint(){
        InOrderSearch(root);
    }
    private void InOrderSearch(BinaryTree<Association> actual){
        if (actual != null) {

            if (actual.left() != null) {
                InOrderSearch(actual.left());
            }
            System.out.print(actual.value().getValue());

            if (actual.right() != null) {
                InOrderSearch(actual.right());
            }

        }
    }

}
