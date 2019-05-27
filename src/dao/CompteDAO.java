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

    public boolean isAdmin(Compte compte) {
        System.out.println("-----------------------------");
        System.out.println(compte.toString());
        System.out.println("-----------------------------");
        Connection db = Database.getConnection();
        try {
            String sqlText = "SELECT * FROM administrateur INNER JOIN compte ON administrateur.compte = compte.id WHERE email = ? AND mdp = ? ;";

            PreparedStatement sql = db.prepareStatement(sqlText);
            sql.setString(1,compte.getEmail());
            sql.setString(2,compte.getMdp());
            ResultSet res = sql.executeQuery();
            if (res.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isStagiaire(Compte compte) {
        Connection db = Database.getConnection();
        try {
        String sqlText = "SELECT * FROM stagiaire INNER JOIN compte ON stagiaire.compte = compte.id WHERE email = ? AND mdp = ? ;";

        PreparedStatement sql = db.prepareStatement(sqlText);
        sql.setString(1,compte.getEmail());
        sql.setString(2,compte.getMdp());
        ResultSet res = sql.executeQuery();
        if (res.next())
            return true;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
