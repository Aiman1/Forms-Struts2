package dao;

import db.Database;
import utilisateurs.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CompteDAO implements DAO<Compte> {
    @Override
    public Optional<Compte> get(long id){

        return Optional.empty();
    }

    @Override
    public List<Compte> getAll() {
        return null;
    }

    @Override
    public int create(Compte compte) {
        return 0;
    }

    @Override
    public int update(Compte compte, String[] params) {
        return 0;
    }

    @Override
    public int delete(Compte compte) {
        return 0;
    }

    public boolean find(Compte compte) {
        Connection db = Database.getConnection();
        try {
            String sqlText = "SELECT * FROM COMPTE WHERE login= ? AND mdp = ?";
            PreparedStatement sql = db.prepareStatement(sqlText);
            sql.setString(1,compte.getEmail());
            sql.setString(1,compte.getMdp());
            ResultSet res = sql.executeQuery();
            if (res.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
