import org.junit.jupiter.api.Test;
import structure5.Association;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    String[] pruebaA = {"a", "b"};
    String[] pruebaB = {"c", "d"};
    BinarySearchTree<String, String[]> bst = new BinarySearchTree<>(new WordComparator());
    @Test
    void Add_SearchTest() {
        Association a1 = new Association("Hola", pruebaA);
        Association a2 = new Association("Abc", pruebaB);
        bst.add(a1);bst.add(a2);
        assertEquals(a1, bst.root.value());
        assertEquals(a2, bst.root.left().value());

        assertEquals(pruebaA, bst.search("Hola"));
        assertEquals(pruebaB, bst.search("Abc"));
    }

}