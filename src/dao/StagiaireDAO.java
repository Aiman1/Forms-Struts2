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
		String sqlText = "SELECT * FROM Stagiaire WHERE id = " + id;
		ResultSet res = sql.executeQuery(sqlText);
		Stagiaire stagiaire = null;
		if(res.next()) {
			String sqlText2 = "SELECT * FROM Compte WHERE id = " + res.getString("compte");
			ResultSet res2 = sql.executeQuery(sqlText2);
			Compte compte = null;
			if(res2.next()) {
				compte = new Compte(res.getInt("compte"), res2.getString("email"), res2.getString("mdp"));
			}
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
        			compte = new Compte(res.getInt("compte"), resCpt.getString("email"), resCpt.getString("mdp"));
        		}
                l.add(new Stagiaire(res.getInt("id"), res.getString("family_name"), res.getString("first_name"), res.getString("tel"), res.getString("societe"), res.getString("gender"), res.getBoolean("actif"), compte));
            } 

        
        return l;
	}

	@Override
	public int create(Stagiaire t){
		try{
			Statement sql = db.createStatement();
			String query = " insert into Stagiaire (family_name, first_name, tel, societe, gender, actif, compte)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString (1, t.getFamily_name());
			            preparedStmt.setString (2, t.getFirst_name());
			            preparedStmt.setString (3, t.getTel());
			            preparedStmt.setString (4, t.getSociete());
			            preparedStmt.setString (5, t.getGender());
			            preparedStmt.setBoolean (6, t.isActif());
			            preparedStmt.setInt(7, t.getCompte().getId());

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
	public int update(Stagiaire t, String[] params) {
		try{
			String query = " update Stagiaire set (family_name = ?, first_name = ?, tel = ?, societe = ?, gender = ?, actif = ?) where id=?";

			            PreparedStatement preparedStmt = db.prepareStatement(query);
			            preparedStmt.setString (1, t.getFamily_name());
			            preparedStmt.setString (2, t.getFirst_name());
			            preparedStmt.setString (3, t.getTel());
			            preparedStmt.setString (4, t.getSociete());
			            preparedStmt.setString (5, t.getGender());
			            preparedStmt.setBoolean (6, t.isActif());
			            preparedStmt.setInt(7, t.getId());
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