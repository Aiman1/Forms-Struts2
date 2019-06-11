package dao;

import db.Database;
import utilisateurs.Compte;

import java.sql.*;
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
        Connection db = Database.getConnection();
        try{
            String query = " insert into compte (email, mdp)"
                    + " values (?, ?)";

            PreparedStatement preparedStmt = db.prepareStatement(query);
            preparedStmt.setString(1, compte.getEmail());
            preparedStmt.setString(2, compte.getMdp());

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
    public int update(Compte compte, String[] params) {
        return 0;
    }

    @Override
    public int delete(Compte compte) {
        return 0;
    }

    public boolean isAdmin(Compte compte) {
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
    public String getName(Compte compte) {
        Connection db = Database.getConnection();
        try{
            String query;
            if(isAdmin(compte))
                query = "SELECT family_name, first_name FROM administrateur INNER JOIN compte ON administrateur.compte = compte.id WHERE email = ? AND mdp = ? ;";
            else if(isStagiaire(compte))
                query = "SELECT family_name, first_name FROM stagiaire INNER JOIN compte ON stagiaire.compte = compte.id WHERE email = ? AND mdp = ? ;";
            else
                return "non connecté";

            PreparedStatement sql = db.prepareStatement(query);
            sql.setString(1,compte.getEmail());
            sql.setString(2,compte.getMdp());
            ResultSet res = sql.executeQuery();
            if (res.next())
                return res.getString(1) + ", " + res.getString(2);
            return "?";
        }
        catch (SQLException e){
            e.printStackTrace();
            return "exception survenu";
        }
    }
    
}
