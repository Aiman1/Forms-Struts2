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
				reponse = new Reponse((int)id, res.getString("intitule"), res.getBoolean("statut"), res.getBoolean("bonne"), res.getInt("question"));
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
			
			while(res.next()){ 
			    l.add(new Reponse(res.getInt("id"), res.getString("intitule"), res.getBoolean("statut"), res.getBoolean("bonne"), res.getInt("question")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    
        return l;
	}


	private int lastID() throws SQLException {
		Statement sql = db.createStatement();
		String sqltxt = "SELECT SELECT LAST_INSERT_ID() as \"id\" FROM question;";
		ResultSet res = sql.executeQuery(sqltxt);
		if(res.next())
			return res.getInt("id");
		else return -1;
	}

	@Override
	public int create(Reponse t) {
		try{
			//t.setIdQuestion(lastID());
			t.setStatut(true);
			t.setBonne(true);// TODO
			String query = " insert into reponse (intitule, statut, bonne, question)"
			        + " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, t.getIntitule());
			preparedStmt.setBoolean(2, t.getStatut());
			preparedStmt.setBoolean(3, t.getBonne());
			preparedStmt.setInt(4, t.getIdQuestion());

			preparedStmt.executeUpdate();

			//ResultSet re =preparedStmt.executeQuery("")
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
			String query = " update reponse set (intitule = ?, sujet = ?, bonne = ?)";

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
			String sqlText = "DELETE FROM reponse WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
