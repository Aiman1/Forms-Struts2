package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import DB.Database;
import db.ConfigConnection;
import questionnaire.Sujet;

public class SujetDAO implements DAO<Sujet>{
	private static Connection db;
	
	public SujetDAO() throws SQLException {
		db = ConfigConnection.getConnection();
	}

	@Override
<<<<<<< HEAD
	public Optional<Sujet> get(long id) {
		Database.getConnection();
		try {
			Statement sql = db.createStatement();
			String sqlText = "SELECT * FROM Sujet WHERE id = " + id;
			ResultSet res = sql.executeQuery(sqlText);
			return null;
		} catch (SQLException e) {
			return null;
=======
	public Optional<Sujet> get(long id) throws SQLException {
		Statement sql = db.createStatement();
		String sqlText = "SELECT * FROM Sujet WHERE id = " + id;
		ResultSet res = sql.executeQuery(sqlText);
		while(res.next()) {
			return Optional.ofNullable(new Sujet())
>>>>>>> df75935f78f7a7a8da4060c9a64c004bda85d5fe
		}
	}

	@Override
	public List<Sujet> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Sujet t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sujet t, String[] params) {
		// TODO Auto-generated method stub
		t.setSujet(Objects.requireNonNull(params[0], "Le sujet ne peut etre nul"));
	}

	@Override
	public void delete(Sujet t) {
		// TODO Auto-generated method stub
		
	}

}
