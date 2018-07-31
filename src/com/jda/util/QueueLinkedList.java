package com.jda.util;

public class QueueLinkedList<T> {
	private class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> head;
	public int size = 0;

	public void push(T x) {
		Node newNode = new Node(x);
		if (head == null)
		{
			head = newNode;
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		size = size + 1;
	}

	public T pop() {
		if (head == null) {
			return null;
		}
		T data = head.data;
		head = head.next;
		size = size - 1;
		return data;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
}