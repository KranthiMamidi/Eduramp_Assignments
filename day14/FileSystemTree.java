package com.day14;

import java.util.ArrayList;
import java.util.List;

class FileNode {

	String name;

	List<FileNode> children;

	public FileNode(String name) {
		super();
		this.name = name;
		this.children = new ArrayList<FileNode>();
	}

	public void addChild(FileNode child) {
		children.add(child);
	}

	public void print(String prefix) {
		System.out.println(prefix + name);
		for (FileNode child : children) {
			child.print(prefix + " ");
		}
	}

}

public class FileSystemTree {

	public static void main(String[] args) {
		FileNode root = new FileNode("Root");
		FileNode doc = new FileNode("doc");
		FileNode images = new FileNode("Images");
		FileNode text = new FileNode("text.txt");
		FileNode viz = new FileNode("Viz.viz");

		doc.addChild(images);
		doc.addChild(new FileNode("Documents"));

		images.addChild(text);
		images.addChild(viz);

		root.addChild(doc);
		root.print(" ");

	}

}
