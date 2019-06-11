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

public class QuestionnaireDAO implements DAO<Questionnaire>{
	private static Connection db;
	
	public QuestionnaireDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Questionnaire> get(long id) {
		Questionnaire questionnaire = null;
		try {
			Statement sql = db.createStatement();
			String sqlText = "SELECT * FROM Questionnaire WHERE id = " + id;
			ResultSet res = sql.executeQuery(sqlText);
			if(res.next()) {
				questionnaire = new Questionnaire((int)id, res.getBoolean("statut"), res.getInt("sujet"), res.getString("intitule"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.ofNullable(questionnaire);
	}

	@Override
	public List<Questionnaire> getAll() {
		List<Questionnaire> l = new ArrayList<Questionnaire>();
        try {
			Statement st = db.createStatement();
			ResultSet res = st.executeQuery("select * from Questionnaire" );
			
			while(res.next()){ 
			    l.add(new Questionnaire(res.getInt("id"), res.getBoolean("statut"), res.getInt("sujet"), res.getString("intitule")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

    
        return l;
	}

	@Override
	public int create(Questionnaire t) {
		try{
			DAO questionDao = new QuestionDAO();
			for (Question q : t.getQuestions()){
				questionDao.create(q);
			}
			Statement sql = db.createStatement();
			String query = " insert into Questionnaire (statut, sujet, intitule)"
			        + " values (?, ?, ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setBoolean(1, t.getStatut());
			            preparedStmt.setInt(2, t.getIdSujet());
			            preparedStmt.setString(3, t.getIntitule());

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
	public int update(Questionnaire t, String[] params) {
		try{
			String query = " update Questionnaire set (statut = ?, sujet = ?, intitule = ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setBoolean (1, t.getStatut());
			            preparedStmt.setInt (2, t.getIdSujet());
			            preparedStmt.setString (3, t.getIntitule());
			            preparedStmt.execute();
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Questionnaire t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Questionnaire WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
