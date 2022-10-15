package net.datastructures;
// BinaryTree.java
// ========
// Basic generic binary search tree (BST) implementation that supports insert() and
// delete() operations, accepting objects that implement the Comparable interface.

class Node<E> {
    E data;
    Node<E> left, right;

    Node(E data) {
        this.data = data;
    }

    public void display() {
        System.out.print(data + " ");
    }
}

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    /**
     * Adds a node to the binary search tree
     *
     * @param data data of type T that implements the Comparable interface
     * @return void
     */
    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> root, E data) {
        // instantiate a new Node with data as data if the current root has not been previously instantiated
        if (root == null) {
            return new Node<>(data);
        }
        // if the value of the data being searched for is less than the value of the current root node, then
        // traverse to the left node of the current root, setting the current left node to whatever gets returned
        // from the insert method
        else if (data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data);
        }
        // if the value of the data being searched for is less than the value of the current root node, then
        // traverse to the right node of the current root, setting the current right node to whatever gets returned
        // from the insert method
        else if (data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data);
        } else {
            // explicitly state that we are disallowing insertion of duplicate values.
            ;
        }

        return root;
    }

    /**
     * Removes a node from the binary search tree
     *
     * @param data data of type E that implements the Comparable interface
     * @return void
     */
    public void delete(E data) {
        root = delete(root, data);
    }

    private Node<E> delete(Node<E> root, E data) {
        // if the root node is null, then either there's nothing to delete or no more traversal is necessary
        if (root == null) {
            return null;
        }
        // if the value of the data being searched for is less than the value of the current root node, then
        // traverse to the left node of the current root, setting the current left node to whatever gets returned
        // from the delete method
        else if (data.compareTo(root.data) < 0) {
            root.left = delete(root.left, data);
        }
        // if the value of the data being searched for is greater than the value of the current root node, then
        // traverse to the right node of the current root, setting the current right node to whatever gets returned
        // from the delete method
        else if (data.compareTo(root.data) > 0) {
            root.right = delete(root.right, data);
        }
        // this else statement means that the data being searched for is equal to the current root, meaning that
        // we've found the node we wish to delete
        else {
            // if the node has no children, then return a value of null
            if (root.left == null && root.right == null) {
                return null;
            }
            // if the node has a left child, but no right child, then return the left child
            else if (root.right == null) {
                return root.left;
            }
            // if the node has a right child, but no left child, then return the right child
            else if (root.left == null) {
                return root.right;
            }
            // if the node has two children, then set the node's data to be the largest element
            // in the left sub-tree of the node, and then set the left child's data to be equal to
            // whatever data is returned when deleting the new root data from the left sub-tree
            // (i.e., the data that is currently set in the left child)
            else {
                root.data = findMax(root.left);
                root.left = delete(root.left, root.data);
            }
        }
        return root;
    }

    // This method assumes root is non-null, since this is only called by
    // delete() on the left subtree, and only when that subtree is non-empty.
    private E findMax(Node<E> root) {
        // simply continue traversing to the right until you can't go no mo', and then you've found
        // the largest element
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    /**
     * Returns true if the value is contained in the binary search tree and false otherwise
     *
     * @param data the value that's being searched for
     * @return boolean evaluation
     * @see boolean
     */
    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node<E> root, E data) {
        // if the root is null, then either the binary search tree is empty or the value has
        // not been found and traversal cannot continue
        if (root == null) {
            return false;
        }
        // if the data being searched for is less than the value of the current root's data,
        // check if the data exists in the current root's left sub-tree
        else if (data.compareTo(root.data) < 0) {
            return search(root.left, data);
        }
        // if the data being searched for is greater than the value of the current root's data,
        // check if the data exists in the current root's right sub-tree
        else if (data.compareTo(root.data) > 0) {
            return search(root.right, data);
        }
        // if the data being searched for is equal to the value of the current root's data, then
        // the search was successful and the method should return true
        else {
            return true;
        }
    }

    /**
     * Prints the values in the binary search using in-order traversal
     *
     * @param
     * @retrun void
     */
    public void inorder() {
        System.out.print("In-order Traversal:");
        inorder(root);
        System.out.println();
    }

    // ORDER - Left, Root, Right
    // traverses left as far as possible until a null node is reached, then prints the root node
    // and then goes as far right as possible until a null node is reached.
    private void inorder(Node<E> root) {
        if (root == null)
            return;

        inorder(root.left);
        root.display();
        inorder(root.right);
    }

    /**
     * Prints the values in the binary search tree using pre-order traversal
     *
     * @param
     * @return void
     */
    public void preorder() {
        System.out.print("Pre-order Traversal:");
        preorder(root);
        System.out.println();
    }

    // ORDER - Root, Left, Right
    // Prints the root node, then traverses left as far as possible until a null node is reached,
    // and then goes as far right as possible until a null node is reached.
    private void preorder(Node<E> root) {
        if (root == null)
            return;

        root.display();
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * Prints the values in the binary search tree using post-order traversal
     *
     * @param
     * @return void
     */
    public void postorder() {
        System.out.print("Post-order Traversal:");
        postorder(root);
        System.out.println();
    }

    // ORDER - Left, Right, Root
    // Traverses left as far as possible until a null node is reached,
    // and then goes as far right as possible until a null node is reached,
    // and finally prints the root node.
    private void postorder(Node<E> root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        root.display();
    }

    /**
     * To class Tree, add method count( ), which return how many nodes in the tree.
     *
     * @return int
     */
    //To class Tree, add method count( ), which return how many nodes in the tree.
    public int count() {
        return countNodes(root);
    }

    private int countNodes(Node<E> root) {
        if (root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }


    /**
     * Reversing a Binary Tree
     */
    public void reverseRecursive() {
        System.out.print("Reversing BST Recursively...");
        reverseRecursiveAll(root);
        System.out.println();
    }

    private void reverseRecursiveAll(Node<E> root) {
        if (root == null) {
            return;
        }

        Node<E> temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverseRecursiveAll(root.left);
        reverseRecursiveAll(root.right);
    }

    /**
     * Reverse BST iteratively using queue
     */
    public void reverseIterative() {
        System.out.print("Reversing BST Iteratively...");
        reverseIterativeAll(root);
        System.out.println();
    }

    private void reverseIterativeAll(Node<E> root) {
        // maintain a queue and push the root node
        LinkedQueue<Node<E>> queue = new LinkedQueue<>();
        if (root != null) {
            queue.enqueue(root);
        }

        // loop till queue is empty
        while (!queue.isEmpty()) {
            // dequeue front node
            Node<E> curr = queue.dequeue();

            // swap the left child with the right child
            Node<E> temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // enqueue left child of the popped node
            if (curr.left != null) {
                queue.enqueue(curr.left);
            }

            // enqueue right child of the popped node
            if (curr.right != null) {
                queue.enqueue(curr.right);
            }

        }
    }

    /**
     * Count the nodes of a binary search tree within a range
     *
     * @param low
     * @param high
     */
    public void countNodes(E low, E high) {
        System.out.print("Count Nodes in BST within " + low + " and " + high + ": ");
        System.out.println(countNodesAll(root, low, high));
    }

    // Function to count nodes in the BST that lie within a given range
    private int countNodesAll(Node<E> root, E low, E high) {
        // base case
        if (root == null) {
            return 0;
        }

        // keep track of the total number of nodes in the tree rooted with `root`
        // that lies within the current range [low, high]
        int count = 0;

        // increment count if the current node lies within the current range
        if (low.compareTo(root.data) <= 0 && high.compareTo(root.data) >= 0) {
            count += 1;
        }

        // recur for the left subtree
        count += countNodesAll(root.left, low, high);

        // recur for the right subtree and return the total count
        return count + countNodesAll(root.right, low, high);
    }
}

