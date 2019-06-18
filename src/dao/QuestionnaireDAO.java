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
			String sqlText = "SELECT * FROM questionnaire WHERE id = " + id;
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
			ResultSet res = st.executeQuery("select * from questionnaire" );
			
			while(res.next()){ 
			    l.add(new Questionnaire(res.getInt("id"), res.getBoolean("statut"), res.getInt("sujet"), res.getString("intitule")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

    
        return l;
	}

	private int lastID() throws SQLException {
		Statement sql = db.createStatement();
		String sqltxt = "SELECT LAST_INSERT_ID() FROM questionnaire;";
		ResultSet res = sql.executeQuery(sqltxt);
		if(res.next())
			return res.getInt(1);
		else return -1;
	}

	@Override
	public int create(Questionnaire t) {
		try{
			t.setStatut(true);
			Statement sql = db.createStatement();
			String query = " insert into questionnaire (statut, sujet, intitule)"
			        + " values (?, ?, ?);";

			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setBoolean(1, t.getStatut());
			preparedStmt.setInt(2, t.getIdSujet());
			preparedStmt.setString(3, t.getIntitule());

			preparedStmt.executeUpdate();
			//ResultSet res = preparedStmt.getResultSet();
			//if(res.next()) System.out.println(res.getInt(1));
			ResultSet re = preparedStmt.executeQuery("SELECT LAST_INSERT_ID() FROM questionnaire;");
			if (!re.next())
				//System.out.println("id = "+ re.getInt(1) + "\nlastID = " + lastID());
				return 0;
			int id = re.getInt(1);
			//System.out.println("id = "+ id + " et lastId() = "+ lastID());
			DAO questionDao = new QuestionDAO();
			for (Question q : t.getQuestions()){
				q.setIdQuestionnaire(id);
				questionDao.create(q);
			}
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
