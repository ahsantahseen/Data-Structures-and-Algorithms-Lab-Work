
class TreeNode {
    int key;
    String name;

    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return name + " has a key " + key;
    }

}

/**
 * binarySearchTree
 */
public class binarySearchTree {

    TreeNode rootNode;

    public void addNode(int key, String name) {
        TreeNode newNode = new TreeNode(key, name);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            TreeNode focusNode = rootNode; // This node will be traversed in the tree and will be attached to it's
                                           // parent
            TreeNode parentNode;
            while (true) {
                parentNode = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild; // Now we focus on the left child and traverse from it
                    if (focusNode == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild; // Now we focus on the right child and traverse from it
                    if (focusNode == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversal(TreeNode focusNode) { // This will traverse array from small to large
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftChild); // left child
            System.out.println(focusNode);// parent
            inOrderTraversal(focusNode.rightChild); // right child

        }
    }

    public void preOrderTraversal(TreeNode focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);// parent
            preOrderTraversal(focusNode.leftChild);// left child
            preOrderTraversal(focusNode.rightChild);// Right child
        }
    }

    public void postOrderTraversal(TreeNode focusNode) {
        if (focusNode != null) {
            postOrderTraversal(focusNode.leftChild);// left child
            postOrderTraversal(focusNode.rightChild);// Right child
            System.out.println(focusNode);// parent
        }
    }

    public void findNode(int key) {
        TreeNode focusNode = rootNode; // setting our node from top aka root
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild; // if it's smaller than root then go to left

            } else {
                focusNode = focusNode.rightChild; // if it's greater than root then go to right
            }
            if (focusNode == null) { // if it's not present just print not found
                System.out.println("NOT FOUND!");
            }
        }
        System.out.println(focusNode); // print the node
    }

    public TreeNode getReplacementNode(TreeNode replacementNode) {
        TreeNode replacementParent = replacementNode;
        TreeNode replacement = replacementNode;
        TreeNode focusNode = replacementNode.rightChild; // because in this case we are using the right child
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if (replacement != replacementNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacementNode.rightChild;
        }
        return replacement;
    }

    public void remove(int key) {
        TreeNode focusNode = rootNode; // setting our focus node from top aka root
        TreeNode parentNode = rootNode; // setting our parent node
        boolean is_it_a_leftChild = true; // if the node is a right child
        while (focusNode.key != key) { // run loop while our required key is not matched
            parentNode = focusNode; // our parent node will be set to focus node
            if (key < focusNode.key) { // if the node is smaller
                focusNode = focusNode.leftChild;
                is_it_a_leftChild = true;
            } else { // if the node is bigger
                focusNode = focusNode.rightChild;
                is_it_a_leftChild = false;
            }
            if (focusNode == null) { // if there is no node
                System.out.println("NOT FOUND");
            }
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) { // situation if no child
            if (focusNode == rootNode) {
                rootNode = null;
            } else if (is_it_a_leftChild) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
        } else if (focusNode.rightChild == null) { // situation if no right child
            if (focusNode == rootNode) {
                rootNode = focusNode.leftChild;
            } else if (is_it_a_leftChild) {
                parentNode.leftChild = focusNode.leftChild;
            } else {
                parentNode.rightChild = focusNode.rightChild;
            }
        } else if (focusNode.leftChild == null) { // situation if no left child
            if (focusNode == rootNode) {
                rootNode = focusNode.rightChild;
            } else if (is_it_a_leftChild) {
                parentNode.leftChild = focusNode.rightChild;
            } else {
                parentNode.rightChild = focusNode.leftChild;
            }
        }

        else { // if there are both children
            TreeNode replacementNode = getReplacementNode(focusNode);
            if (focusNode == rootNode) {
                rootNode = replacementNode;
            } else if (is_it_a_leftChild) {
                parentNode.leftChild = replacementNode;
            } else {
                parentNode.rightChild = replacementNode;
            }
            replacementNode.leftChild = focusNode.leftChild;

        }
    }

    public int height(TreeNode rootNode) { // Find the height of the linked list
        if (rootNode == null) {
            return -1;
        } else if (rootNode.leftChild == null && rootNode.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(rootNode.leftChild), height(rootNode.rightChild));
    }

    public TreeNode minNode(TreeNode rootNode) { // Find the min node of the tree
        if (rootNode == null) { // if node not found
            throw new IllegalStateException();
        }
        var current = rootNode;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;// return node if found
    }

    public TreeNode maxNode(TreeNode rootNode) { //// Find the min node of the tree
        if (rootNode == null) { // if node not found
            throw new IllegalStateException();
        }
        var current = rootNode;
        var last = current;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last; // return node if found
    }

    public void printNodesAtDistance(TreeNode rootNode, int distance) { // print node at an specific distnance for like
                                                                        // print nodes at 0
        if (rootNode == null) {
            return;
        } else if (distance == 0) {
            System.out.println(rootNode);
            return;
        }
        printNodesAtDistance(rootNode.leftChild, distance - 1);
        printNodesAtDistance(rootNode.rightChild, distance - 1);
    }

    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();
        bst.addNode(100, "GTX 1050");
        bst.addNode(134, "GTX 1050 Ti");
        bst.addNode(1124, "GTX 1060");
        bst.addNode(10, "RX 680");
        bst.addNode(1, "GTX 1070");
        bst.inOrderTraversal(bst.rootNode);
        bst.preOrderTraversal(bst.rootNode);
        bst.postOrderTraversal(bst.rootNode);
        bst.findNode(100);
        bst.remove(100);
        System.out.println(bst.height(bst.rootNode));
        System.out.println("MIN: " + bst.minNode(bst.rootNode) + "\n MAX: " + bst.maxNode(bst.rootNode));
        bst.printNodesAtDistance(bst.rootNode, 0);

    }
}