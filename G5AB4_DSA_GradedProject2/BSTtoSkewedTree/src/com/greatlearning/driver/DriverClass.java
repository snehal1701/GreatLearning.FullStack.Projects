package com.greatlearning.driver;

import com.greatlearning.tree.BinarySearchTree;

public class DriverClass {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(60);
		bst.insert(10);
		bst.insert(55);
		System.out.println("Input Binary Search Tree");
		bst.printBST();
		BinarySearchTree skt = new BinarySearchTree();
		System.out.println("Right Skewed Binary Search Tree");
		skt.BSTtoSkew(bst);
		bst.printBST();

	}
}
