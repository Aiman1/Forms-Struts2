package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import db.Database;
import questionnaire.Reponse;

public class ReponseDAO implements DAO<Reponse>{
	private static Connection db;
	
	public ReponseDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Reponse> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reponse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Reponse t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Reponse t, String[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Reponse t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
