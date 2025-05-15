package binarytree;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void testInsertAndContain() {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);
        root.insert(7);
        root.insert(12);
        root.insert(18);

        assertTrue(root.contain(10));
        assertTrue(root.contain(5));
        assertTrue(root.contain(3));
        assertTrue(root.contain(7));
        assertTrue(root.contain(15));
        assertTrue(root.contain(12));
        assertTrue(root.contain(18));

        assertFalse(root.contain(0));
        assertFalse(root.contain(6));
        assertFalse(root.contain(20));
    }

    @Test
    public void testContainWithSingleNode() {
        Node root = new Node(42);
        assertTrue(root.contain(42));
        assertFalse(root.contain(10));
    }


    @Test
    public void testPrintInorder() {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);
        root.insert(7);
        root.insert(18);

        // 출력 캡처
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        root.printInorder();

        // 줄바꿈은 시스템마다 다를 수 있으므로 \n 기준 비교
        String expectedOutput = "3\n5\n7\n10\n15\n18\n";
        assertEquals(expectedOutput, outContent.toString());

        // 원래 출력 복원
        System.setOut(System.out);
    }



    @Test
    public void testCheckBinarySearchTree() {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);
        root.insert(7);
        root.insert(18);

        assertTrue(root.checkBinarySearchTree(root));
        assertTrue(root.checkBinarySearchTree(null));
        assertFalse(root.checkBinarySearchTree(root, 13, 30));
        assertFalse(root.checkBinarySearchTree(root, 1, 5));
        assertTrue(root.checkBinarySearchTree(root, 3, 18));
    }
}
