package binaryTree;

import java.util.*;

class Node {
	private Node left;
	private Node right;
	private int data;
	
	Node(int data) {
		this.data = data;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getLeft() {
		return this.left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getRight() {
		return this.right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return this.data;
	}
}

public class SpiralBinaryTree {
	private static Queue<Node> queue = new LinkedList<>();
	private static int i = 0;
	private static int j = 0;
	private static int previousDiff = 0;
	private static int previousNumber = 1;
	private static String prefix = "";

	private static void reverseQueue() {
		Stack<Node> s = new Stack<>();

		while(!queue.isEmpty()) {
		   s.push(queue.remove());
		} 

		while(!s.isEmpty()) { 
		  queue.add(s.pop());
		}
	}
	
	private static void printSpiral(Node node) {
		i++;
		System.out.print(prefix + node.getData());
		prefix = ",";
		if(node.getLeft() != null) {
			if(j == 0) {
				queue.add(node.getLeft());
				queue.add(node.getRight());
			} else {
				queue.add(node.getRight());
				queue.add(node.getLeft());
			}
		}
		if(queue.isEmpty()) {
			return;
		}
		if(i != 1 && ((i == 3) || ((i-previousNumber) == previousDiff*2))) {
			previousDiff = i-previousNumber;
			previousNumber = i;
			reverseQueue();
			if(j == 0) j = 1;
			else j = 0;
		}
		printSpiral(queue.remove());
	}

	private static Node generateBinaryTree() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		Node eleven = new Node(11);
		Node twelve = new Node(12);
		Node thirteen = new Node(13);
		Node fourteen = new Node(14);
		Node fifteen = new Node(15);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		four.setLeft(eight);
		four.setRight(nine);
		five.setLeft(ten);
		five.setRight(eleven);
		six.setLeft(twelve);
		six.setRight(thirteen);
		seven.setLeft(fourteen);
		seven.setRight(fifteen);
		eight.setLeft(null);
		eight.setRight(null);
		nine.setLeft(null);
		nine.setRight(null);
		ten.setLeft(null);
		ten.setRight(null);
		eleven.setLeft(null);
		eleven.setRight(null);
		twelve.setLeft(null);
		twelve.setRight(null);
		thirteen.setLeft(null);
		thirteen.setRight(null);
		fourteen.setLeft(null);
		fourteen.setRight(null);
		fifteen.setLeft(null);
		fifteen.setRight(null);
		return one;
	}
	
	public static void main(String[] args) {
		Node root = generateBinaryTree();
		System.out.println("Spiral traversal of binary tree: ");
		printSpiral(root);
	}
}