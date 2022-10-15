package ds303.Trees;

import net.datastructures.BinaryTree;

public class BST {
    public static void main(String[] args) {
        BinaryTree<Integer> myTree = new BinaryTree<>();

        Integer[] keys = {15, 10, 20, 8, 12, 25};
        for (Integer key : keys) {
            myTree.insert(key);
        }
        //Integer data[] = new Integer[5];

/*		for (int i = 0; i < 5; i++)
		{
			int r = (int)(Math.random() * 100) + 1;
			data[i] = r;
			System.out.println("Inserting " + r + "...");
			myTree.insert(r);
		}*/

        System.out.println("count: " + myTree.count());
        myTree.inorder();
        myTree.preorder();
        myTree.postorder();
        System.out.println("delete 12 ");
        myTree.delete(12);
        myTree.inorder();
        System.out.println(25 + " data found: " + myTree.search(25));

        myTree.preorder();
        myTree.postorder();

        //count
        System.out.println("count: " + myTree.count());
        myTree.printLeaves();

        myTree.reverseRecursive();
        myTree.inorder();

        myTree.reverseIterative();
        myTree.inorder();

        //count nodes within a range
        myTree.countNodes(15, 25);
    }
}
