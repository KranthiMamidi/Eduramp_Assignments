package com.day14;

class ProductNode {
	int price;
	ProductNode left, right;

	public ProductNode(int price) {
		super();
		this.price = price;
	}

	public void insert(int newprice) {
		if (newprice < price) {
			if (left == null) {
				left = new ProductNode(newprice);
			} else {
				left.insert(newprice);
			}
		} else {
			if (right == null) {
				right = new ProductNode(newprice);
			} else {
				right.insert(newprice);
			}
		}

	}

	public boolean search(int targetaPrice) {
		if (price == targetaPrice) {
			return true;
		} else if (targetaPrice < price) {
			return left != null && left.search(targetaPrice);
		} else {
			return right != null && right.search(targetaPrice);
		}
	}

	public void inorder() {
		if (left != null) {
			left.inorder();
		}
		System.out.print(price + " ");
		if (right != null)
			right.inorder();
	}

}

public class ProductSerchTree {
	public static void main(String[] args) {
		ProductNode root = new ProductNode(500);
		int prices[] = { 300, 900, 800, 200, 400, 100 };

		for (int price : prices) {
			root.insert(price);
		}

		System.out.println("Inorder tree traversal ( sorted price)");

		root.inorder();

		int searchPrice = 800;
		System.out.println("\n" + searchPrice + " Available");
		System.out.println(root.search(searchPrice) ? "Found" : "Not Found");
	}

}
