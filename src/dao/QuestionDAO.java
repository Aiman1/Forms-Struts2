package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.Database;
import questionnaire.Question;
import questionnaire.Questionnaire;
import questionnaire.Sujet;

public class QuestionDAO implements DAO<Question>{
	private static Connection db;
	
	public QuestionDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Question> get(long id) {
		Question question = null;
		try {
			Statement sql = db.createStatement();
			String sqlText = "SELECT * FROM Question WHERE id = " + id;
			ResultSet res = sql.executeQuery(sqlText);
			if(res.next()) {
				question = new Question((int)id, res.getString("intitule"), res.getBoolean("statut"), res.getInt("questionnaire"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.ofNullable(question);
	}

	@Override
	public List<Question> getAll() {
		List<Question> l = new ArrayList<Question>();
        try {
			Statement st = db.createStatement();
			ResultSet res = st.executeQuery("select * from Question" );
			
			while(res.next()){ 
				
			    l.add(new Question(res.getInt("id"), res.getString("intitule"), res.getBoolean("statut"), res.getInt("questionnaire")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

    
        return l;
	}

	@Override
	public int create(Question t) {
		try{
			Statement sql = db.createStatement();
			String query = " insert into Question (intitule, statut, questionnaire)"
			        + " values (?, ?, )";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString(1, t.getIntitule());
			            preparedStmt.setBoolean(2, t.getStatut());
			            preparedStmt.setInt(3, t.getIdQuestionnaire());

			            preparedStmt.execute();
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int update(Question t, String[] params) {
		try{
			String query = " update Question set (intitule = ?, sujet = ?, questionnaire = ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString (1, t.getIntitule());
			            preparedStmt.setBoolean (2, t.getStatut());
			            preparedStmt.setInt(3, t.getIdQuestionnaire());
			            preparedStmt.execute();
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Question t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Question WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
