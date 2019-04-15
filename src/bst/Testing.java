package bst;

public class Testing {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(5);
		bst.addNode(3);
		bst.addNode(7);
		bst.addNode(6);
		bst.addNode(8);
		bst.addNode(4);
		bst.addNode(1);

		System.out.println(bst.containsNode(5));
//		System.out.println(bst.containsNode(7));

//		bst.delete(5);

		System.out.println(bst.containsNode(5));
//		System.out.println(bst.containsNode(50));
//		System.out.println(bst.containsNode(20));
//		System.out.println(bst.containsNode(10));
//		System.out.println(bst.containsNode(80));
//		System.out.println(bst.containsNode(8));
//		System.out.println(bst.containsNode(7));

		bst.inOrderTraversal(bst.root);
		bst.preOrderTraversal(bst.root);
		bst.postOrderTraversal(bst.root);

	}
}
