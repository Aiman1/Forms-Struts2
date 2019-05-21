package dao;

import db.Database;
import questionnaire.Sujet;
import utilisateurs.Compte;
import utilisateurs.Stagiaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import utilisateurs.Stagiaire;

public class StagiaireDAO implements DAO<Stagiaire>{
	private static Connection db;
	
	public StagiaireDAO() throws SQLException {
		db = Database.getConnection();
	}
	
	@Override
	public Optional<Stagiaire> get(long id) throws SQLException {
		Statement sql = db.createStatement();
		String sqlText = "SELECT * FROM Compte WHERE id = " + id;
		ResultSet res = sql.executeQuery(sqlText);
		Compte compte = null;
		if(res.next()) {
			compte = new Compte(res.getString("email"), res.getString("mdp"));
		}
		sqlText = "SELECT * FROM Stagiaire WHERE id = " + id;
		res = sql.executeQuery(sqlText);
		Stagiaire stagiaire = null;
		if(res.next()) {
			stagiaire = new Stagiaire((int)id, res.getString("family_name"), res.getString("first_name"), res.getString("tel"), res.getString("societe"), res.getString("gender"), res.getBoolean("actif"), compte);
		}
		
		return Optional.ofNullable(stagiaire);
	}

	@Override
	public List<Stagiaire> getAll() throws SQLException{
		List<Stagiaire> l = new ArrayList<Stagiaire>();
            Statement st = db.createStatement();
            ResultSet res = st.executeQuery("select * from Stagiaire" );
        	Compte compte = null;
            
            while(res.next()){ 
            	ResultSet resCpt = st.executeQuery("select * from compte where id =" + res.getInt("compte"));
        		if(resCpt.next()) {
        			compte = new Compte(resCpt.getString("email"), resCpt.getString("mdp"));
        		}
                l.add(new Stagiaire(res.getInt("id"), res.getString("family_name"), res.getString("first_name"), res.getString("tel"), res.getString("societe"), res.getString("gender"), res.getBoolean("actif"), compte));
            } 

        
        return l;
	}

	@Override
	public int create(Stagiaire t){
		try{
			Statement sql = db.createStatement();
			String sqlText = "SELECT Max(id) FROM Compte";
			ResultSet res = sql.executeQuery(sqlText);
			int idCompte = res.getInt("id");
			String query = " insert into Stagiaire (id, family_name, first_name, tel, societe, gender, actif)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setInt (1, idCompte);
			            preparedStmt.setString (2, t.getFamily_name());
			            preparedStmt.setString (3, t.getFirst_name());
			            preparedStmt.setString (4, t.getTel());
			            preparedStmt.setString (5, t.getSociete());
			            preparedStmt.setString (6, t.getGender());
			            preparedStmt.setBoolean (7, t.isActif());

			            preparedStmt.execute();
                		return 1;
		}
		catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Stagiaire t, String[] params) {
		try{
			String query = " update Stagiaire set (family_name = ?, first_name = ?, tel = ?, societe = ?, gender = ?, actif = ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString (1, t.getFamily_name());
			            preparedStmt.setString (2, t.getFirst_name());
			            preparedStmt.setString (3, t.getTel());
			            preparedStmt.setString (4, t.getSociete());
			            preparedStmt.setString (5, t.getGender());
			            preparedStmt.setBoolean (6, t.isActif());

			            preparedStmt.execute();
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Stagiaire t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Stagiaire WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}