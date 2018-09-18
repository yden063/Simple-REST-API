package core;

public interface ObjectAPIHandler<T> {
	T getObjects();
	T getObject(int id);
	String postObject(T object);
}
