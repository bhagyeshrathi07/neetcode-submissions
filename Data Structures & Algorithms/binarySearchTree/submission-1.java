class TreeNode {
    int key;
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key, int val) {
        this.key = key;
        this.value = val;
    }
}

class TreeMap {

    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if(root == null) {
            root = newNode;
            return;
        }
        TreeNode current = root;
        while(current != null) {
            if(current.key < key) {
                if(current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
            else if(current.key > key) {
                if(current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            }
            else {
                current.value = val;
                return;
            }
        }
    }

    public int get(int key) {
        TreeNode curr = root;
        while(curr != null) {
            if(key < curr.key) {
                curr = curr.left;
            }
            else if(key > curr.key) {
                curr = curr.right;
            }
            else {
                return curr.value;
            }
        }
        return -1;
    }

    public int getMin() {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr == null ? -1 : curr.value;
    }

    public TreeNode findMin(TreeNode root) {
        while(root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public int getMax() {
        TreeNode curr = root;
        while(curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr == null ? -1 : curr.value;
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    public TreeNode removeHelper(TreeNode curr, int key) {

        if(curr == null) return null;

        if(curr.key < key) {
            curr.left = removeHelper(curr.left, key);
        }
        else if(curr.key > key) {
            curr.right = removeHelper(curr.right, key);
        }
        else {
            if(curr.left == null) {
                return curr.right;
            }
            else if(curr.right == null) {
                return curr.left;
            }
            else {
                TreeNode min = findMin(curr.right);
                curr.key = min.key;
                curr.value = min.value;
                curr.right = removeHelper(curr.right, min.key);
            }
        }
        return curr;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> inorderKeys = new ArrayList<>();
        inorderTraversal(inorderKeys, root);
        return inorderKeys;
    }

    public void inorderTraversal(List<Integer> list, TreeNode root) {
        if(root == null) {
            return;
        }
        inorderTraversal(list, root.left);
        list.add(root.key);
        inorderTraversal(list, root.right);
    }
}
