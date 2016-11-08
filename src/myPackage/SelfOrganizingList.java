package myPackage;

public class SelfOrganizingList<T> implements list<T>{

	private node<T> head;
	private node<T> tail;
	private int size;
	
	public SelfOrganizingList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	@Override
	public boolean add(T o) {
		// TODO Auto-generated method stub
		try{
			node<T> newNode = new node<T>();
			newNode.setData(o);
			if(this.isEmpty()){
				this.head =  newNode;
				this.tail = newNode;
			}
			else{
				this.tail.setRight(newNode);
				newNode.setleft(this.tail);
				this.tail = newNode;
			}
			this.size++;
			return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean addAll(collection<T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T o) {
		// TODO Auto-generated method stub
		try{
			node<T> n = this.head;
			while(n != null){
				if(n.getData().equals(o)){
					if(this.head==this.tail){
						this.head = null;
						this.tail = null;
					}
					else if(n == this.head){
						this.head = this.head.getRight();
						this.head.setleft(null);
						n.setleft(null);
						n.setRight(null);
					}
					else if(n == this.tail){
						this.tail = this.tail.getLeft();
						this.tail.setRight(null);
						n.setleft(null);
						n.setRight(null);
					}
					else{
						n.getLeft().setRight(n.getRight());
						n.getRight().setleft(n.getLeft());
						n.setleft(null);
						n.setRight(null);
					}
					this.size--;
					return true;
				}
				n = n.getRight();
			}
			return false;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}			
	}

	@Override
	public boolean removeAll(collection<T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(collection<T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T o) {
		// TODO Auto-generated method stub
		try{
			node<T> n = this.head;
			while(n != null){
				if(n.getData().equals(o)){
					if(n.getLeft()==this.head && this.tail!=n){
						this.head.setRight(n.getRight());
						n.getRight().setleft(this.head);
						n.setRight(this.head);
						this.head.setleft(n);
						this.head = n;
						this.head.setleft(null);
					}
					else if(n.getLeft()==this.head && this.tail==n){
						n.setRight(this.head);
						this.head.setleft(n);
						n.setleft(null);
						this.head.setRight(null);
						this.tail = this.head;
						this.head = n;
					}
					else if(this.tail == n){
						node<T> temp = this.tail.getLeft();
						this.tail.getLeft().getLeft().setRight(this.tail);
						this.tail.setleft(this.tail.getLeft().getLeft());
						temp.setRight(null);
						temp.setleft(this.tail);
						this.tail.setRight(temp);
						this.tail = temp;
					}
					else if(this.head == n){
						return true;
					}
					else{
						node<T> prev = n.getLeft();
						node<T> next = n.getRight();
						prev.setRight(next);
						next.setleft(prev);
						n.setRight(prev);
						n.setleft(prev.getLeft());
						prev.setleft(n);
						n.getLeft().setRight(n);
					}
					return true;
				}
				n = n.getRight();
			}
			return false;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean containsAll(collection<T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.head==null && this.tail==null){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T o) {
		// TODO Auto-generated method stub
		try{
			this.size++;
			if(index>=this.size || index<0){
				throw new Exception("Index Out Of Bounds");
			}
				
			node<T> temp = this.head;
			node<T> newNode = new node<T>();
			newNode.setData(o);
			if(index==0){
				this.head.setleft(newNode);
				newNode.setRight(this.head);
				this.head = newNode;
				return;
			}
			else if(index==this.size-1){
				this.tail.getLeft().setRight(newNode);
				newNode.setleft(this.tail.getLeft());
				newNode.setRight(this.tail);
				this.tail.setleft(newNode);
				return;
			}
			else{
				int i=0;
				while(i!=index){
					temp = temp.getRight();
					i++;
				}
				temp.getLeft().setRight(newNode);
				newNode.setleft(temp.getLeft());
				newNode.setRight(temp);
				temp.setleft(newNode);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean addAll(int index, collection<T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		try{
			if(index>=this.size() || index <0){
				throw new Exception("Index Out Of Bounds");
			}
			node<T> n = this.head;
			int i=0;
			while(n != null){
				if(i==index){
					if(n.getLeft()==this.head && this.tail!=n){
						this.head.setRight(n.getRight());
						n.getRight().setleft(this.head);
						n.setRight(this.head);
						this.head.setleft(n);
						this.head = n;
						this.head.setleft(null);
						return this.head.getData();
					}
					else if(n.getLeft()==this.head && this.tail==n){
						n.setRight(this.head);
						this.head.setleft(n);
						n.setleft(null);
						this.head.setRight(null);
						this.tail = this.head;
						this.head = n;
						return this.head.getData();
					}
					else if(this.tail == n){
						node<T> temp = this.tail.getLeft();
						this.tail.getLeft().getLeft().setRight(this.tail);
						this.tail.setleft(this.tail.getLeft().getLeft());
						temp.setRight(null);
						temp.setleft(this.tail);
						this.tail.setRight(temp);
						this.tail = temp;
						return this.tail.getLeft().getData();
					}
					else if(this.head == n){
						return this.head.getData();
					}
					else{
						node<T> prev = n.getLeft();
						node<T> next = n.getRight();
						prev.setRight(next);
						next.setleft(prev);
						n.setRight(prev);
						n.setleft(prev.getLeft());
						prev.setleft(n);
						n.getLeft().setRight(n);
						return n.getData();
					}
				}
				n = n.getRight();
				i++;
			}
			return null;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		try{
			if(index>=this.size || index<0){
				throw new Exception("Index out of bounds");
			}
			node<T> temp;
			node<T> temp2 = new node<T>();
			if(index==0){
				temp=this.head;
				this.head=this.head.getRight();
				this.head.setleft(null);
				this.size--;
				return temp.getData();
			}
			else if(index==(this.size-1)){
				temp=this.tail;
				this.tail=this.tail.getLeft();
				this.tail.setRight(null);
				this.size--;
				return temp.getData();
			}
			else{
				int i=0;
				temp=this.head;	
				while(i!=index){
					temp=temp.getRight();
					i++;
				}
				temp2.setData(temp.getData());
				temp.getLeft().setRight(temp.getRight());
				temp.getRight().setleft(temp.getLeft());
				temp.setRight(null);
				temp.setleft(null);
				this.size--;
				return temp2.getData();
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

		
	@Override
	public T set(int index, T o) {
		// TODO Auto-generated method stub
		try{
			node<T> n = this.head;
			int i=0;
			while(i!=index){
				i++;
				n = n.getRight();
			}
			T temp = n.getData();
			n.setData(o);
			return temp;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public int indexof(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastindexof(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void display(){
		node<T> n = this.head;
		while(n != null){
			System.out.print(n.getData().toString() + " ");
			n = n.getRight();
		}
		System.out.println();
	}

}
