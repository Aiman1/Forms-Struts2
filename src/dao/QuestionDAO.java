package dao;

import java.util.List;
import java.util.Optional;

import DB.Database;
import questionnaire.Question;

public class QuestionDAO implements DAO<Question>{

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
	public void create(Question t) {
		// TODO Auto-generated method stub
		Database.getConnection();
	}

	@Override
	public void update(Question t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Question t) {
		// TODO Auto-generated method stub
		
	}

}
