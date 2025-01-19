package modelo.AbstractDAO;

import modelo.Entity.Hotel;

public abstract class DaoFactory {
	public DaoFactory factory;

	public DaoFactory(DaoFactory factory) {
		super();
		this.factory = factory;
	}

	public DaoFactory getFactory() {
		return factory;
	}

	public void setFactory(DaoFactory factory) {
		this.factory = factory;
	}

	public abstract PersonaDAO getPersonaDAO();

	public abstract HotelDAO getHotelDAO();
	
	public abstract ReservaDAO getReservaDAO();

}
