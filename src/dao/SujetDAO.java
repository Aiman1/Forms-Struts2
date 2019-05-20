package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import db.Database;
import questionnaire.Sujet;

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
			sujet = new Sujet();
			sujet.setSujet(res.getString("sujet"));
		}
		
		return Optional.ofNullable(sujet);
	}

	@Override
	public List<Sujet> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Sujet t) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public int update(Sujet t, String[] params) {
		// TODO Auto-generated method stub
		//t.setSujet(Objects.requireNonNull(params[0], "Le sujet ne peut etre nul"));
		return 0;
	}

	@Override
	public int delete(Sujet t) {
		// TODO Auto-generated method stub
		return 0;
		
	}

}
