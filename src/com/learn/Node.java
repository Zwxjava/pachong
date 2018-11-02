package com.learn;



public class Node<T extends Comparable<T>> {
  private T date;
  private int index;
  private Node<T> lchile;
  private Node<T> rchile;
  
  public Node(){
	  
  }
  public Node(T date) {
	  this.date =date;
  }
  public Node(T date,Node<T> lNode,Node<T> rNode) {
    this.date =date;
    this.lchile =lNode;
    this.rchile =rNode;
  }
  
  
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Node<T> getLchile() {
		return lchile;
	}
	public void setLchile(Node<T> lchile) {
		this.lchile = lchile;
	}
	public Node<T> getrNode() {
		return rchile;
	}
	public void setrNode(Node<T> rchile) {
		this.rchile = rchile;
	}
	@Override
	public String toString() {
		return "Node [date=" + date + ", index=" + index + ", lchile=" + lchile + ", rchile=" + rchile + "]";
	}
     
	 public void add(Node<T> node,T date){
		if (node ==null) {
		System.out.println("头结点为空");
		}else {
			if (node.date.compareTo(date) == -1) {
				if (node.rchile !=null) {
					 add(node.rchile, date);
				}else {
					Node<T> node2 =new Node<>(date);
					node.rchile =node2;
				}
			}else {
				  if (node.lchile !=null) {
						 add(node.lchile, date);
					}else {
						Node<T> node2 =new Node<>(date);
						node.lchile =node2;
					}
			}
			
		}
		 
	}
	
	 public Node<T> Search(Node<T> node,T date) {
		
			if (node.date.compareTo(date) == -1 && node.rchile!=null ) {			
				return Search(node.rchile, date);
			}else if (node.date.compareTo(date) == 1 && node.lchile !=null) {
				
				return Search(node.lchile, date);
			}else{				
				return node;
			}
		}
	 
	 public boolean Delete(Node<T> root,T date){
	        //引用当前节点，从根节点开始
	        Node curr = root;
	        //应用当前节点的父节点
	        Node parentNode = root;
	        //是否为左节点
	        boolean isLeftChild = true;
	        //进行比较，查找是否存在要删除的节点
	        while(curr.date.compareTo(date)!=0){
	            parentNode = curr;
	            if(curr.date.compareTo(date)==1){
	                curr = curr.lchile;
	                isLeftChild = true;
	            }else {
	                curr = curr.rchile;
	                isLeftChild = false;
	            }
	            //如果查找不到
	            if(curr == null) {
	                return false;
	            }
	        }
	        //刪除叶子节点
	        if(curr.lchile == null && curr.rchile == null){
	            if(curr == root) {
	                root = null;
	            } else if(isLeftChild) {
	                parentNode.lchile = null;
	            } else {
	                parentNode.rchile = null;
	            }
	        }else if(curr.lchile == null){//删除节点的左节点为空
	            if(curr == root){
	                root = root.rchile;
	            }else if(isLeftChild) {
	                parentNode.lchile = curr.rchile;
	            }else {
	                parentNode.rchile = curr.rchile;
	            }
	        }else if (curr.rchile == null) {//删除节点的右节点为空
	            if(curr == root){
	                root = root.lchile;
	            }else if(isLeftChild) {
	                parentNode.lchile = curr.lchile;
	            }else {
	                parentNode.rchile = curr.lchile;
	            }
	        }else {//如果要删除的节点有左右两个子节点
	            Node successor = getSuccessor(curr);
	            if(curr == root){
	                root = successor;
	            }else if(isLeftChild){
	                parentNode.lchile = successor;
	            }else {
	                parentNode.rchile = successor;
	            }
	            successor.lchile = curr.lchile;
	        }
	        return true;
	    }
	  public Node getSuccessor(Node delNode) {
	        Node successor = delNode;
	        Node successorParent = delNode;
	        Node curr = delNode.rchile;
	        while(curr != null){
	            successorParent = successor;
	            successor = curr;
	            curr = curr.lchile;
	        }
	        if(successor != delNode.rchile){
	            successorParent.lchile = successor.rchile;
	            successor.rchile = delNode.rchile;
	        }
	        return successor;
	    }
	
}
 

