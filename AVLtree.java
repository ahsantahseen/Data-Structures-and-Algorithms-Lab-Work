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
        if (isLeftHeavy(root)) {
            System.out.println(root.value + " is left heavy");
        } else if (isRightHeavy(root)) {
            System.out.println(root.value + " is right heavy");
        }
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

    public static void main(String[] args) {
        AVLtree AVLtree = new AVLtree();
        AVLtree.Insert(10);
        AVLtree.Insert(8);
        AVLtree.Insert(11);
        System.out.println(AVLtree.height(AVLtree.root));
    }
}
