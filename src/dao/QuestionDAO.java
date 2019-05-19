package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import db.Database;
import questionnaire.Question;

public class QuestionDAO implements DAO<Question>{
	private static Connection db;
	
	public QuestionDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Question> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Question t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Question t, String[] params) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Question t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
