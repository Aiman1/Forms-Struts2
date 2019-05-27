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
import questionnaire.Sujet;
import utilisateurs.Compte;
import utilisateurs.Stagiaire;

public class SujetDAO implements DAO<Sujet>{
	private static Connection db;
	
	public SujetDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Sujet> get(long id) throws SQLException {
		Statement sql = db.createStatement();
		String sqlText = "SELECT * FROM Sujet WHERE id = " + id;
		ResultSet res = sql.executeQuery(sqlText);
		Sujet sujet = null;
		if(res.next()) {
			sujet = new Sujet((int)id, res.getString("sujet"));
		}
		
		return Optional.ofNullable(sujet);
	}

	@Override
	public List<Sujet> getAll() {
		List<Sujet> l;
		l = new ArrayList<Sujet>();
		try {
			Statement st = db.createStatement();
			ResultSet res = st.executeQuery("select * from Sujet" );
			
			while(res.next()){ 
			    l.add(new Sujet(res.getInt("id"), res.getString("sujet")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

    
        return l;
	}

	@Override
	public int create(Sujet t) {
		try{
			Statement sql = db.createStatement();
			String query = " insert into Sujet (id, sujet)"
			        + " values (?, ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setInt (1, t.getId());
			            preparedStmt.setString (2, t.getSujet());

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
	public int update(Sujet sujet, String[] params) {
		try{
			String query = " update Sujet set sujet=? where id=?";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString (1, sujet.getSujet());
			            preparedStmt.setInt (2, sujet.getId());
			            preparedStmt.execute();
			            return 1;
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Sujet t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Sujet WHERE id = " + t.getId();
			sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
