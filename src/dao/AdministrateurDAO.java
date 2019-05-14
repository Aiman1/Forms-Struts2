package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import db.Database;
import utilisateurs.Administrateur;

public class AdministrateurDAO implements DAO<Administrateur>{
	private static Connection db;
	
	public AdministrateurDAO() throws SQLException {
		db = Database.getConnection();
	}
	
	
	@Override
	public Optional<Administrateur> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Administrateur t) {
		// TODO Auto-generated method stub
	}

	@Override
	public int update(Administrateur t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Administrateur t) {
		// TODO Auto-generated method stub
		
	}

}
