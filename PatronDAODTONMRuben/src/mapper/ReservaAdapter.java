package mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Entity.Reserva;

public class ReservaAdapter implements Adapter {
	private Reserva reserva;

	public ReservaAdapter(Reserva reserva) {
		super();
		this.reserva = reserva;
	}

	@Override
	public void adapt(PreparedStatement declaracion) throws SQLException {
		// Establecer los valores de los par�metros en la sentencia SQL
		declaracion.setLong(1, reserva.getIdPersona());
		declaracion.setLong(2, reserva.getIdHotel());
		declaracion.setObject(3, reserva.getFecha());
	}
}
