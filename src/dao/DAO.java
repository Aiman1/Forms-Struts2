package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T>{
	//Get an object by its ID (can be null)
	Optional<T> get(long id) throws SQLException;
	
	//Get all objects
	List<T> getAll();
	
	//Create an object
	void create(T t);
	
	//Update an object
	void update(T t, String[] params);
	
	//Delete an object
	void delete(T t);
	
}
