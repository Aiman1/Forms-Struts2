package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import db.Database;
import questionnaire.Questionnaire;

public class QuestionnaireDAO implements DAO<Questionnaire>{
	private static Connection db;
	
	public QuestionnaireDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Questionnaire> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questionnaire> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Questionnaire t) {
		// TODO Auto-generated method stub
	}

	@Override
	public int update(Questionnaire t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(Questionnaire t) {
		// TODO Auto-generated method stub
		
	}

}
