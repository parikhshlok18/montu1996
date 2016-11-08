package myPackage;

public interface collection<T> {
	boolean add(T o);
	boolean addAll(collection<T> c);
	boolean remove(T o);
	boolean removeAll(collection<T> c);
	boolean retainAll(collection<T> c);
	boolean contains(T o);
	boolean containsAll(collection<T> c);
	boolean isEmpty();
	int size();
	T[] toArray();
}
