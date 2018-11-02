package com.learn;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    	Node<Integer> root =new Node<>(7);
	    for (int i = 0; i < 5; i++) {
	    	  root.add(root, i);
		  } System.out.println(root.toString());
	    
	    root.Delete(root, 4);
	    System.out.println(root.Search(root, 7));
	    Node<Integer> dnode =new Node<>(3);
      
       
	}

}
