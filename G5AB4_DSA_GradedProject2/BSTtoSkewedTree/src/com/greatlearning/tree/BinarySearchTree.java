package com.greatlearning.tree;

public class BinarySearchTree {
	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

		public int data() {
			return this.data;
		}

		public Node left() {
			return this.left;
		}

		public Node right() {
			return this.right;
		}

	}

	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public BinarySearchTree() {
	}

	public void insert(int data) {
		if (this.root == null) {
			this.root = new Node(data);
		} else {
			insert(this.root, data);
		}
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			return node;
		}
		if (data < node.data()) {
			node.left = insert(node.left(), data);
		} else {
			node.right = insert(node.right(), data);
		}
		return node;
	}

	private boolean ConvertInOrder(Node inputNode) {
		if (inputNode == null)
			return false;
		ConvertInOrder(inputNode.left());
		this.insert(inputNode.data());
		ConvertInOrder(inputNode.right());
		return false;
	}

	private boolean traversePreOrderPrint(Node node) {
		if (node == null)
			return false;
		int nodeData = node.data();
		System.out.print(nodeData + " ");
		if ((node.left() != null && traversePreOrderPrint(node.left()))
				|| (node.right() != null && traversePreOrderPrint(node.right()))) {

			return true;
		}
		return false;
	}

	public void printBST() {
		traversePreOrderPrint(this.root);
		System.out.println();
	}

	public void BSTtoSkew(BinarySearchTree inputbst) {

		this.ConvertInOrder(inputbst.getRoot());
		inputbst.setRoot(this.root);
	}

}
