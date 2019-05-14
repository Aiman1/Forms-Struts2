package dao;

import DB.Database;
import utilisateurs.Stagiaire;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StagiaireDAO implements DAO<Stagiaire>{


    @Override
    public Optional<Stagiaire> get(long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Stagiaire> getAll() {
        return null;
    }

    @Override
    public void create(Stagiaire stagiaire) {
        Database.getConnection();
    }

    @Override
    public void update(Stagiaire stagiaire, String[] params) {

    }

    @Override
    public void delete(Stagiaire stagiaire) {

    }
}
