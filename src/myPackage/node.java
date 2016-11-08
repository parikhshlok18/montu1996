package myPackage;

public class node<T> implements Cloneable {
	private T data;
	private node<T> left;
	private node<T> right;
	public node(){
		this.left=null;
		this.right=null;
	}
	public node(T data){
		this.data = data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	public void setleft(node<T> left){
		this.left = left;
	}
	public void setRight(node<T> right){
		this.right = right;
	}
	public T getData(){
		return this.data;
	}
	public node<T> getLeft(){
		return this.left;
	}
	public node<T> getRight(){
		return this.right;
	}
}
