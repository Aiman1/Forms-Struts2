package dao;

import db.Database;
import utilisateurs.Compte;
import utilisateurs.Administrateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.DAO;

public class AdministrateurDAO implements DAO<Administrateur>{
	private static Connection db;
	
	public AdministrateurDAO() throws SQLException {
		db = Database.getConnection();
	}
	
	@Override
	public Optional<Administrateur> get(long id) throws SQLException {
		Statement sql = db.createStatement();
		String sqlText = "SELECT * FROM Administrateur WHERE id = " + id;
		ResultSet res = sql.executeQuery(sqlText);
		Administrateur admin = null;
		if(res.next()) {
			String sqlText2 = "SELECT * FROM Compte WHERE id = " + res.getInt("compte");
			ResultSet res2 = sql.executeQuery(sqlText2);
			Compte compte = null;
			if(res2.next()) {
				compte = new Compte(res.getInt("compte"), res2.getString("email"), res2.getString("mdp"));
			}
			admin = new Administrateur((int)id, res.getString("family_name"), res.getString("first_name"), res.getString("tel"), res.getString("societe"), res.getString("gender"), res.getBoolean("actif"), compte);
		}
		
		return Optional.ofNullable(admin);
	}

	@Override
	public List<Administrateur> getAll() throws SQLException {
		List<Administrateur> l = new ArrayList<Administrateur>();
        Statement st = db.createStatement();
        ResultSet res = st.executeQuery("select * from Administrateur" );
    	Compte compte = null;
        
        while(res.next()){ 
        	ResultSet resCpt = st.executeQuery("select * from compte where id =" + res.getInt("compte"));
    		if(resCpt.next()) {
    			compte = new Compte(res.getInt("compte"), resCpt.getString("email"), resCpt.getString("mdp"));
    		}
            l.add(new Administrateur(res.getInt("id"), res.getString("family_name"), res.getString("first_name"), res.getString("tel"), res.getString("societe"), res.getString("gender"), res.getBoolean("actif"), compte));
        } 

    
        return l;
	}

	@Override
	public int create(Administrateur t) throws SQLException{
		try{
			Statement sql = db.createStatement();
			String query = " insert into Administrateur (family_name, first_name, tel, societe, gender, actif, compte)"
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
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Administrateur t, String[] params) {
		try{
			String query = " update Administrateur set (family_name = ?, first_name = ?, tel = ?, societe = ?, gender = ?, actif = ?)";

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
	public int delete(Administrateur t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Administrateur WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}