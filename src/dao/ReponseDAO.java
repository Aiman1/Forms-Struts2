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
import questionnaire.Reponse;
import questionnaire.Sujet;

public class ReponseDAO implements DAO<Reponse>{
	private static Connection db;
	
	public ReponseDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Reponse> get(long id) {
		Reponse reponse = null;
		try {
			Statement sql = db.createStatement();
			String sqlText = "SELECT * FROM Reponse WHERE id = " + id;
			ResultSet res = sql.executeQuery(sqlText);
			if(res.next()) {
				String sqlText2 = "SELECT * FROM Question WHERE id = " + res.getInt("question");
				ResultSet res2 = sql.executeQuery(sqlText2);
				Question question = null;
				if(res2.next()) {
					question = new Question(res.getInt("question"), res2.getString("intitule"), res.getBoolean("statut"));
				}
				reponse = new Reponse((int)id, res.getString("intitule"), res.getBoolean("statut"), res.getBoolean("bonne"), question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.ofNullable(reponse);
	}

	@Override
	public List<Reponse> getAll() {
		List<Reponse> l = new ArrayList<Reponse>();
        try {
			Statement st = db.createStatement();
			ResultSet res = st.executeQuery("select * from Reponse" );
			Question question = null;
			
			while(res.next()){ 
				ResultSet resCpt = st.executeQuery("select * from Question where id =" + res.getInt("question"));
				if(resCpt.next()) {
					question = new Question(res.getInt("question"), resCpt.getString("intitule"), res.getBoolean("statut"));
				}
			    l.add(new Reponse(res.getInt("id"), res.getString("intitule"), res.getBoolean("statut"), res.getBoolean("bonne"), question));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    
        return l;
	}

	@Override
	public int create(Reponse t) {
		try{
			String query = " insert into Reponse (intitule, statut, bonne, question)"
			        + " values (?, ?, ?, ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString(1, t.getIntitule());
			            preparedStmt.setBoolean(2, t.getStatut());
			            preparedStmt.setBoolean(3, t.getBonne());
			            preparedStmt.setInt(4, t.getQuestion().getId());

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
	public int update(Reponse t, String[] params) {
		try{
			String query = " update Reponse set (intitule = ?, sujet = ?, bonne = ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString (1, t.getIntitule());
			            preparedStmt.setBoolean (2, t.getStatut());
			            preparedStmt.setBoolean (3, t.getBonne());
			            preparedStmt.execute();
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Reponse t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Reponse WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
