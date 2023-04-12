package ds303.Trees;

import net.datastructures.BinaryTree;

public class BST {
    public static void main(String[] args) {
        BinaryTree<Integer> myTree = new BinaryTree<>();

        int[] keys = {10, 7, 15, 5, 8, 12, 20, 6, 18, 14};
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

        myTree.inorder();
        System.out.println(25 + " data found: " + myTree.search(25));

        myTree.preorder();
        myTree.postorder();
        myTree.inorder();

        myTree.delete(15);
        myTree.preorder();
        //count
        System.out.println("count: " + myTree.count());
        myTree.printLeaves();

        myTree.reverseRecursive();
        myTree.inorder();


        //count nodes within a range

    }

}
