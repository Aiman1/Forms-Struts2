package dao;

import db.Database;
import utilisateurs.Stagiaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import utilisateurs.Stagiaire;

public class StagiaireDAO implements DAO<Stagiaire>{
	private static Connection db;
	
	public StagiaireDAO() throws SQLException {
		db = Database.getConnection();
	}
	
	@Override
	public Optional<Stagiaire> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stagiaire> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Stagiaire t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(Stagiaire t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Stagiaire t) {
		// TODO Auto-generated method stub
		
	}
}