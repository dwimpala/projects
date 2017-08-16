
import java.io.*;
import java.util.*;  
public class Node {
	public int data;
	public Node leftChild;
	public Node rightChild;
	public Node(int data){
		this.data=data;
	}
	public void displayNode(){
		System.out.println(data);
	}
}
class Tree{
	private Node root;
	public Tree(){
		root=null;
	}
	public void insert(int id){
		if(root==null){
			root=new Node(id);
			
		}else{
			recursiveInsert(root,id);
		}
			
	}
	public void recursiveInsert(Node current,int id){
		if(id<current.data){
			if(current.leftChild==null){
				current.leftChild=new Node(id);
			}else{
				recursiveInsert(current.leftChild,id);
			}
		}else{
			if(current.rightChild==null){
				current.rightChild=new Node(id);
			}else{
				recursiveInsert(current.rightChild,id);
			}
		}
			
	}
	 public void traverse(int traverseType)
     {
     switch(traverseType)
        {
        case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
        case 2: System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
        case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
     System.out.println();
     }
	 public void preOrder(Node t){
		 if(t!=null)
			 System.out.println(t.data);
		 preOrder(t.leftChild);
		 preOrder(t.rightChild);
	 }
	 public void inOrder(Node t){
      if(t!=null)
    	  inOrder(t.leftChild);
      System.out.println(t.data);
      inOrder(t.rightChild);
      
	 }
	 public void postOrder(Node t){
		 if(t!=null)
			 postOrder(t.leftChild);
		 postOrder(t.rightChild);
		 System.out.println(t.data);
	 }
	 }
/*class TreeApp
{
public static void main(String[] args) throws IOException
   {
   
   Tree theTree = new Tree();

   theTree.insert(50);
   theTree.insert(25);
   theTree.insert(75);
   theTree.insert(12);
   theTree.insert(37);
   theTree.insert(43);
   theTree.insert(30);
   theTree.insert(33);
   theTree.insert(87);
   theTree.insert(93);
   theTree.insert(97);
   
   
   theTree.traverse(1);
   theTree.traverse(2);
   theTree.traverse(3);
   
   
   }
}*/

