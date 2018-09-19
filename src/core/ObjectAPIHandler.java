package core;

import java.util.List;

public interface ObjectAPIHandler<T> {
	List<T> getObjects();
	T getObject(int id);
	String postObject(T object);
}
