import structure5.BinaryTree;
import structure5.Association;

import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<K, V> {
    protected BinaryTree<Association<K, V>> root;
    protected int count;
    protected Comparator<K> ordering;

    /**
     * Inicialización de la clase y sus elementos
     * 
     * @param alternateOrder Comparador de elementos, especial para el tipo de datos
     *                       empleado
     */
    public BinarySearchTree(Comparator<K> alternateOrder) {
        this.root = new BinaryTree<Association<K, V>>();
        this.count = 0;
        this.ordering = alternateOrder;
    }

    /**
     * Permite la adición de elementos, en formato de asociación, lo cual implica
     * que habrá una llave y un valor para cada elemento del arbol
     * 
     * @param value - Asociación por agregar al arbol binario
     */
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

    /**
     * Permite la búsqueda de un dato a través de la llave de la asociación
     * 
     * @param key
     * @return - valor encontrado para la clave dada
     */
    public V search(K key) {
        if (this.root.isEmpty()) {
            return null;
        } else {
            BinaryTree<Association<K, V>> possibleLocation = this.locate(this.root, key);
            return key.equals(possibleLocation.value().getKey()) ? (V) possibleLocation.value().getValue() : null;
        }
    }

    /**
     * Permite ubicar el espacio adecuado para ingreasar un dato
     * 
     * @param root
     * @param key
     * @return
     */
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

    /**
     * Imprime los datos del arbol desde su raíz
     */
    public void InOrderPrint() {
        InOrderSearch(root);
    }

    /**
     * Permite buscar e imprimir los elementos del arbol en orden
     * 
     * @param actual punto de partida para la busqueda
     */
    private void InOrderSearch(BinaryTree<Association<K, V>> actual) {
        if (actual != null) {
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
        } else {
            System.out.println("Cuidado, aún no se han ingresado datos al diccionario");
        }

    }

}
