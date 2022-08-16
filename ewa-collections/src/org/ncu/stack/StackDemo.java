/*1. Insertion/Add -- Push 
2. Deletion/Remove - Pop
3. Peek -- return the top element
4. Traverse
5. Search*/
package org.ncu.stack;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		// Add integer values
		stack.add(100);
		stack.add(120);
		stack.add(80);
		stack.add(800);
		stack.add(850);
		stack.add(520);
		stack.add(760);
		
		System.out.println("Elements inside stack: "+stack);
		
		stack.push(950);
		
		System.out.println("Top element in stack: "+stack.peek());
		
		System.out.println("Element deleted from stack is: "+stack.pop());
		
		System.out.println("Position of element is: "+stack.search(80));
		
		System.out.println("Updated stack is: "+stack);
		
		System.out.println("Stack is empty: "+stack.empty());
		
		System.out.println("======Traversing a Stack======");
		
		for(Integer in : stack) {
			System.out.println(in);
		}
		
		System.out.println("elements: "+stack);
	}

}
