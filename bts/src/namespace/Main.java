package namespace;
public final class Module
{

    //=================================================================SEARCH
    public static Object search_iteratively(Object key, Object node)
    {
        Object current_node = node;
        while (current_node.has_value())
        {
            if (key == current_node.key)
            {
                return current_node;
            }
            if (key < current_node.key)
            {
                current_node = current_node.left;
            }
            else
            {
                current_node = current_node.right;
            }
        }
        return current_node;
    }

    //=================================================================INSERT
    public static Object binary_tree_insert(Object node, Object key, Object value)
    {
        if (!node.has_value())
        {
            return NodeTree(null, key, value, null);
        }
        if (key == node.key)
        {
            return NodeTree(node.left, key, value, node.right);
        }
        if (key < node.key)
        {
            return NodeTree(binary_tree_insert(node.left, key, value), node.key, node.value, node.right);
        }
        return NodeTree(node.left, node.key, node.value, binary_tree_insert(node.right, key, value));
    }

    //=================================================================DELETE
    public static Object find_min(Object self)
    {
        namespace.Module current_node = this;
        while (current_node.left_child)
        {
            current_node = current_node.left_child;
        }
        return new namespace.Module(current_node);
    }

    public static Object replace_node_in_parent(Object self)
    {
        return replace_node_in_parent(self, Object());
    }
    public static Object replace_node_in_parent(Object self, Object new_value)
    {
        if (this.parent)
        {
            if (this == this.parent.left_child)
            {
                this.parent.left_child = new_value;
            }
            else
            {
                this.parent.right_child = new_value;
            }
        }
        if (new_value)
        {
            new_value.parent = this.parent;
        }
    }

    public static Object binary_tree_delete(Object self, Object key)
    {
        if (key < this.key)
        {
            this.left_child.binary_tree_delete(key);
            return;
        }
        if (key > this.key)
        {
            this.right_child.binary_tree_delete(key);
            return;
            // Delete the key here
        }
        if (this.left_child && this.right_child)
        {
            // If both children are present
//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent to implicit typing in Java unless the Java 10 inferred typing option is selected:
            auto successor = this.right_child.find_min();
            this.key = successor.key;
            successor.binary_tree_delete(successor.key);
        }
        else if (this.left_child)
        {
            // If the node has only a *left* child
            namespace.Module.replace_node_in_parent(this.left_child);
        }
        else if (this.right_child)
        {
            // If the node has only a *right* child
            namespace.Module.replace_node_in_parent(this.right_child);
        }
        else
        {
            namespace.Module.replace_node_in_parent(null);
        }
    }

    public static class Node
    {

        public Node(Object key)
        {
            this.left = null;
            this.right = null;
            this.val = key;
        }
    }

    //=================================================================preorder-inorder-postorder
    public static Object printInorder(Object root)
    {
        if (root)
        {
            // First recur on left child
            printInorder(root.left);
            // then print the data of node
            System.out.print(root.val);
            System.out.print("\n");
            printInorder(root.right);
        }
    }

    public static Object printPostorder(Object root)
    {
        if (root)
        {
            // First recur on left child
            printPostorder(root.left);
            // the recur on right child
            printPostorder(root.right);
            // now print the data of node
            System.out.print(root.val);
        }
    }

    public static Object printPreorder(Object root)
    {
        if (root)
        {
            // First print the data of node
            System.out.print(root.val);
            // Then recur on left child
            printPreorder(root.left);
            // Finally recur on right child
            printPreorder(root.right);
        }
    }

    public static Object root = Node(1);

    private static class StaticConstructor
    {
        public StaticConstructor()
        {
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            printPreorder(root);
            printInorder(root);
            printPostorder(root);
        }
    }

    private static Module.StaticConstructor staticConstructor = new Module.StaticConstructor();

}
