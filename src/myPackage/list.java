package myPackage;

public interface list<T> extends collection<T>  {
	void add(int index,T o);
	boolean addAll(int index,collection<T> c);
	T get(int index);
	T remove(int index);
	T set(int index,T o);
	int indexof(T o);
	int lastindexof(T o);
}
