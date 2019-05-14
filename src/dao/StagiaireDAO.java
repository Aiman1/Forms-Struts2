package dao;

<<<<<<< HEAD
import DB.Database;
import utilisateurs.Stagiaire;
=======
import java.util.List;
import java.util.Optional;

import utilisateurs.Stagiaire;

public class StagiaireDAO implements DAO<Stagiaire>{

	@Override
	public Optional<Stagiaire> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stagiaire> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Stagiaire t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Stagiaire t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Stagiaire t) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> df75935f78f7a7a8da4060c9a64c004bda85d5fe

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
