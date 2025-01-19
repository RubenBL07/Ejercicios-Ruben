package mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Entity.Hotel;

public class HotelAdapter implements Adapter {
	private Hotel hotel;

	public HotelAdapter(Hotel hotel) {
		super();
		this.hotel = hotel;
	}

	@Override
	public void adapt(PreparedStatement declaracion) throws SQLException {
		// Establecer los valores de los par�metros en la sentencia SQL
		declaracion.setLong(1, hotel.getId());
		declaracion.setString(2, hotel.getNombre());
	}
}
