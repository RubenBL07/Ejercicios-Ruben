package modelo.ImplDAOJDBC;

import java.sql.SQLException;

import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.HotelDAO;
import modelo.AbstractDAO.PersonaDAO;
import modelo.AbstractDAO.ReservaDAO;
import modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	AccessJdbc accessJdbc;

	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		// EStos parametros pueden ser pasado por parametros o configurados en otro
		// sitio
		accessJdbc = new AccessJdbc("hoteles", "harnina", "zzzz");
	}

	@Override
	public PersonaDAO getPersonaDAO() {
		return new PersonaDAOJdbc(accessJdbc);
	}

	@Override
	public HotelDAO getHotelDAO() {
		return new HotelDAOJdbc(accessJdbc);                                                                                        
	}

	@Override
	public ReservaDAO getReservaDAO() {
		return new ReservaDAOJdbc(accessJdbc);
	}

	public AccessJdbc getAccessJDBC() {
		return accessJdbc;
	}
}
