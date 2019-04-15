package bst;

import bst.Node;

public class BinarySearchTree {

	public Node root;

	public void addNode(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {

		if (current == null) {
			return new Node(value);
		}

		if (value < current.data) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.data) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		return current;
	}

	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, int value) {

		if (current == null) {
			return false;
		}
		if (value == current.data) {
			return true;
		}
		if (value > current.data) {
			return containsNodeRecursive(current.right, value);
		} else
			return containsNodeRecursive(current.left, value);
	}

// Delete

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	private Node deleteRecursive(Node current, int value) {

		if (current == null) {
			return null;
		}
		if (current.data == value) {
			if (current.left == null && current.right == null) {
				return null;
			}
			if (current.left == null) {
				return current.right;
			}
			if (current.right == null) {
				return current.left;
			}

			// code for delete when the node has 2 children still in work

			int smallestValue = findSmallestValue(current.right);
			current.data = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;

		}
		if (current.data > value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		if (current.data < value) {
			current.right = deleteRecursive(current.right, value);
			return current;
		}
		return current;
	}

	private int findSmallestValue(Node root) {
		return root.left == null ? root.data : findSmallestValue(root.left);
	}

	public void inOrderTraversal(Node root) {

		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + "|");
			inOrderTraversal(root.right);
		}
	}

	public void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + ",");
		}
	}

}
