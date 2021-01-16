public class AVLtree {

    private class AVLNode {
        // Creating a class for the NODE in the tree
        private int value;

        private AVLNode leftchild;
        private AVLNode rightchild;

        private int height;

        public AVLNode(int value) {
            this.value = value;

        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Value: " + this.value;
        }

    }

    private AVLNode root; // Declaring a root node of the tree

    // Insert in tree

    public void Insert(int value) {
        root = Insert(root, value);
    }

    private AVLNode Insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value) {
            root.leftchild = Insert(root.leftchild, value);
        } else {
            root.rightchild = Insert(root.rightchild, value);
        }
        root.height = Math.max(height(root.leftchild), height(root.rightchild)) + 1;
        var BalanceFactor = BalanceFactor(root);

        setHeight(root);
        root = balance(root);

        return root;
    }

    // Checking the height of the tree
    private int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // Functions for Checking if the Tree is LEFT HEAVY, RIGHT HEAVY OR BALANCE
    private boolean isLeftHeavy(AVLNode node) {
        return BalanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return BalanceFactor(node) < -1;
    }

    private int BalanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftchild) - height(node.rightchild);
    }

    // Function to balance the tree

    // Function to balance the tree

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (BalanceFactor(root.leftchild) < 0) {
                root.leftchild = rotateLeft(root.leftchild); // Perfom First left then Right Rotate in the next line if
                                                             // condition is true
            }
            return rotateRight(root); // return new node after Right rotate only if the above conditon is false

        } else if (isRightHeavy(root)) {
            if (BalanceFactor(root.rightchild) > 0) {
                root.rightchild = rotateRight(root.rightchild); // Perform First Right then left rotate in the next line
                                                                // if the conidtion is true
            }
            return rotateLeft(root); // return new node after Left rotate only if the above conditon is false
        }
        return root;

    }

    // Rotation Function

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightchild;
        root.leftchild = newRoot.rightchild;
        newRoot.leftchild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftchild;
        root.rightchild = newRoot.leftchild;
        newRoot.rightchild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;

    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(root.leftchild), height(root.rightchild)) + 1;
    }

    public static void main(String[] args) {
        AVLtree AVLtree = new AVLtree();
        AVLtree.Insert(30);
        AVLtree.Insert(20);
        AVLtree.Insert(10);
        AVLtree.balance(AVLtree.root);
        System.out.println("IS LEFT HEAVY? " + AVLtree.isLeftHeavy(AVLtree.root));
        System.err.println("IS RIGHT HEAVY? " + AVLtree.isRightHeavy(AVLtree.root));
    }
}
