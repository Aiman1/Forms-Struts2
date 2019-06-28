package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.Database;
import parcours.Parcours;
import questionnaire.Questionnaire;

public class ParcoursDAO implements DAO<Parcours>{
	private static Connection db;
	
	public ParcoursDAO() throws SQLException {
		db = Database.getConnection();
	}

	@Override
	public Optional<Parcours> get(long id) {
		Parcours parcours = new Parcours();
		try {
			Statement sql = db.createStatement();
			String sqlText = "SELECT * FROM parcours WHERE id = " + id;
			ResultSet res = sql.executeQuery(sqlText);
			if(!res.next()) {
				return null;
			}
			parcours = new Parcours((int)id, res.getDouble("duree"), res.getInt("score"), res.getInt("idUtilisateur"), res.getInt("idQuestionnaire"));
			//create new statement
			sqlText = "SELECT * FROM questionnaire WHERE cleParcours= " + id;
			sql = db.createStatement();
			res = sql.executeQuery(sqlText);

			if (res.next()) {
				int lid = res.getInt("id");
				parcours.setQ(lid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.ofNullable(parcours);
	}

	@Override
	public List<Parcours> getAll() {
		List<Parcours> l = new ArrayList<Parcours>();
		try {
			Statement st = db.createStatement();
			ResultSet res = st.executeQuery("select * from Parcours" );

			while(res.next()){
				l.add(new Parcours((int) res.getInt("id"), res.getDouble("duree"), res.getInt("score"), res.getInt("idUtilisateur"), res.getInt("idQuestionnaire")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public int create(Parcours t) {
		try{
			Statement sql = db.createStatement();
			String query = " insert into Parcours (duree, score, idUtilisateur, idQuestionnaire)"
					+ " values (?, ?, ?, ?)";

			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, t.getIntitule());
			preparedStmt.setBoolean(2, t.getStatut());
			preparedStmt.setInt(4, t.getIdQuestionnaire());
			preparedStmt.setInt(3, t.getIdUtilisateur());

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
	public int update(Parcours t, String[] params) {
		try{
			String query = " update Parcours set (duree = ?, score = ?, idUtilisateur = ?, idQuestionnaire = ?)";

			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setString(1, t.getIntitule());
			preparedStmt.setBoolean(2, t.getStatut());
			preparedStmt.setInt(4, t.getIdQuestionnaire());
			preparedStmt.setInt(3, t.getIdUtilisateur());

			preparedStmt.execute();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Parcours t) {
		try {
			Statement sql = db.createStatement();
			String sqlText = "DELETE FROM Parcours WHERE id = " + t.getId();
			ResultSet res = sql.executeQuery(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
