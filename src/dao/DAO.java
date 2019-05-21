package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T>{
	//Get an object by its ID (can be null)
	Optional<T> get(long id) throws SQLException;
	
	//Get all objects
	List<T> getAll() throws SQLException;
	
	//Create an object
	int create(T t) throws SQLException;
	
	//Update an object
	int update(T t, String[] params);
	
	//Delete an object
	int delete(T t) throws SQLException;
	
}
