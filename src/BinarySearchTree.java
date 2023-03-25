import structure5.BinaryTree;
import structure5.Association;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<K, V> {
    protected BinaryTree<Association<K, V>> root;
    protected int count;
    protected Comparator<K> ordering;

    public BinarySearchTree(Comparator<K> alternateOrder) {
        this.root = new BinaryTree<Association<K, V>>();
        this.count = 0;
        this.ordering = alternateOrder;
    }

    public void add(Association<K, V> value) {
        BinaryTree<Association<K, V>> newNode = new BinaryTree<Association<K, V>>(value);
        if (this.root.isEmpty()) {
            this.root = newNode;
        } else {
            BinaryTree<Association<K, V>> insertLocation = this.locate(this.root, (K) value.getKey());
            K nodeKey = (K) insertLocation.value().getKey();
            if (this.ordering.compare(nodeKey, (K) value.getKey()) < 0) {
                insertLocation.setRight(newNode);
            } else {
                insertLocation.setLeft(newNode);
            }
        }

        ++this.count;
    }

    public V search(K key) {
        if (this.root.isEmpty()) {
            return null;
        } else {
            BinaryTree<Association<K, V>> possibleLocation = this.locate(this.root, key);
            return key.equals(possibleLocation.value().getKey()) ? (V) possibleLocation.value().getValue() : null;
        }
    }

    protected BinaryTree<Association<K, V>> locate(BinaryTree<Association<K, V>> root, K key) {
        K rootKey = (K) root.value().getKey();
        if (rootKey.equals(key)) {
            return root;
        } else {
            BinaryTree<Association<K, V>> child;
            if (this.ordering.compare(rootKey, key) < 0) {
                child = root.right();
            } else {
                child = root.left();
            }

            return child.isEmpty() ? root : this.locate(child, key);
        }
    }

    public void InOrderPrint() {
        InOrderSearch(root);
    }

    private void InOrderSearch(BinaryTree<Association<K, V>> actual) {
        Iterator<Association<K, V>> iterador = actual.inorderIterator();
        System.out.println("\nIn order process...");
        // Iterar sobre los elementos del árbol y mostrarlos
        while (iterador.hasNext()) {
            Association<K, V> elemento = iterador.next();
            System.out.print("\n" + elemento.getKey() + "\t");
            for (String valor : (String[]) elemento.getValue()) {
                System.out.print(valor + "\t");
            }
        }
        System.out.println("\n*** Se ha concluido el proceso ***");

    }

}
