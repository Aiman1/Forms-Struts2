package dao;

import java.util.List;
import java.util.Optional;

import DB.Database;
import questionnaire.Questionnaire;

public class QuestionnaireDAO implements DAO<Questionnaire>{

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
	public void create(Questionnaire t) {
		// TODO Auto-generated method stub
		Database.getConnection();
	}

	@Override
	public void update(Questionnaire t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Questionnaire t) {
		// TODO Auto-generated method stub
		
	}

}
