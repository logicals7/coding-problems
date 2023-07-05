import java.util.*;

//defining the node class
class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data = data;
		//this.next = null;
	}
}


public class d45_insertANodeInLL {
	
	public static Node<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;
		
		while(data != -1) {
			Node<Integer> currNode = new Node<>(data);
			//if head = null > this means first node > update head & last node tail
			if(head == null) {
				head = currNode;
				tail = currNode;
			}
			else {
				tail.next = currNode;
				tail = currNode; //tail = tail.next;
			}
			data = sc.nextInt();
		}
		return head;
	}

	public static void printLL(Node<Integer> head){
		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node<Integer> insertNode(Node<Integer> head, int i, int data) {
	    Node<Integer> insertNode = new Node<>(data);
	    
	    //In this code, if the index i is 0, it means we need to insert the node at the beginning. 
	    //In that case, the insertNode is connected to the current head, 
	    //and then head is updated to insertNode.
	    if (i == 0) {
	        insertNode.next = head;
	        head = insertNode;
	        return head;
	    }

	    Node<Integer> temp = head;
	    int counter = 0;
	    
	    //If the index i is greater than 0, 
	    //the while loop traverses the linked list until it reaches the node just before the desired insertion position (i.e., i-1). 
	    while (temp != null && counter < i - 1) {
	        temp = temp.next;
	        counter++;
	    }
	    
	    //Once the correct position is found (temp != null), 
	    //the insertNode is connected to the next node, 
	    //and the temp.next is updated to insertNode.
	    if (temp != null) {
	        insertNode.next = temp.next;
	        temp.next = insertNode;
	    }

	    return head;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = takeInput();
		printLL(head);
		
		int insertPos = sc.nextInt();
		int insertData = sc.nextInt();
		head = insertNode(head, insertPos, insertData);
		
		printLL(head);
	}
}
