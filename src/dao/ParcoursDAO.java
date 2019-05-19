package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import db.Database;
import parcours.Parcours;

public class ParcoursDAO implements DAO<Parcours>{
	private static Connection db;
	
	public ParcoursDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Parcours> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Parcours> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Parcours t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Parcours t, String[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Parcours t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
