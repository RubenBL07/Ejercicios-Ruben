package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import modelo.Entity.Reserva;

public class ReservaMapper implements Mapper<ResultSet, Reserva> {

	@Override
	public Reserva map(ResultSet s) {
		try {
			while (s.next()) {
				Object object1 = s.getObject(1);
				Long object2 = (long) object1;
				Object object3 = s.getObject(2);
				Long object4 = (long) object3;
				Object object5 = s.getObject(3);
				LocalDate object6 = (LocalDate) object5;
				return new Reserva(object2, object4, object6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
