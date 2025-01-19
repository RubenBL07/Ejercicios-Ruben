package modelo.ImplDAOJDBC;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import mapper.ReservaAdapter;
import mapper.ReservaMapper;
import modelo.AbstractDAO.ReservaDAO;
import modelo.Entity.Persona;
import modelo.Entity.Reserva;
import modelo.acceso.AccessJdbc;

public class ReservaDAOJdbc implements ReservaDAO {
	private AccessJdbc accessJdbc;
	private ReservaMapper reservaMapper;

	public ReservaDAOJdbc(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
		this.reservaMapper = new ReservaMapper();
	}

	@Override
	public void create(Reserva entidad) {
		String sql = "INSERT INTO " + accessJdbc.getBBDD() + ".reserva(idPersona, idHotel, fecha) VALUES (?,?,?)";
		accessJdbc.update(sql, new ReservaAdapter(entidad));

	}

	@Override
	public Collection<Reserva> findAll() {
		ResultSet conjuntoResultados = accessJdbc.execute("SELECT * FROM reserva");
		Collection<Reserva> reservas = new ArrayList<>();
		try {
			while (conjuntoResultados.next()) {
				reservas.add(new ReservaMapper().map(conjuntoResultados));
			}
		} catch (Exception e) {
			return null;
		}
		return reservas;
	}

	@Override
	public Reserva findById(Long idPersona) {
		String sql = "SELECT * FROM " + accessJdbc.getBBDD() + ".reserva WHERE idPersona LIKE " + idPersona;
		ResultSet conjuntoResultados = accessJdbc.execute(sql);
		return reservaMapper.map(conjuntoResultados);
	}

	@Override
	public Reserva findByIdHotel(Long idHotel) {
		String sql = "SELECT * FROM " + accessJdbc.getBBDD() + ".reserva WHERE idHotel LIKE " + idHotel;
		ResultSet conjuntoResultados = accessJdbc.execute(sql);
		return reservaMapper.map(conjuntoResultados);
	}
	
	@Override
	public Reserva findByFecha(LocalDate fecha) {
		String sql = "SELECT * FROM " + accessJdbc.getBBDD() + ".reserva WHERE fecha LIKE " + fecha;
		ResultSet conjuntoResultados = accessJdbc.execute(sql);
		return reservaMapper.map(conjuntoResultados);
	}

	@Override
	public Reserva find(Long idPersona, Long idHotel, LocalDate fecha) {
		String sql = "SELECT * FROM " + accessJdbc.getBBDD() + ".reserva WHERE fecha LIKE " + fecha + 
				" and idHotel LIKE " + idHotel +" and idPersona LIKE " + idPersona;
		ResultSet conjuntoResultados = accessJdbc.execute(sql);
		return reservaMapper.map(conjuntoResultados); 
	}

	@Override
	public Reserva delete(Long idPersona) {
		Reserva byIdPersona = findById(idPersona);
		if (byIdPersona != null) {
			String sql = "delete from " + accessJdbc.getBBDD() + ".reserva where idPersona = " + String.valueOf(idPersona);
			accessJdbc.executeUpdate(sql);
			return byIdPersona;
		}
		return null;
	}

	@Override
	public Reserva deleteByIds(Long idPersona, Long idHotel, LocalDate fecha) {
		Reserva byId = find(idPersona, idHotel, fecha);
		if (byId != null) {
			String sql = "delete from " + accessJdbc.getBBDD() + ".reserva WHERE fecha = " + String.valueOf(fecha) + 
					" and idHotel = " + String.valueOf(idHotel) +" and idPersona = " + String.valueOf(idPersona);
			accessJdbc.executeUpdate(sql);
			return byId;
		}
		return null;
	}

	@Override
	public Reserva deleteByIdHotel(Long idHotel) {
		Reserva byIdHotel = findByIdHotel(idHotel);
		if (byIdHotel != null) {
			String sql = "delete from " + accessJdbc.getBBDD() + ".reserva where idHotel = " + String.valueOf(idHotel);
			accessJdbc.executeUpdate(sql);
			return byIdHotel;
		}
		return null;
	}

	@Override
	public Reserva deleteByFecha(LocalDate fecha) {
		Reserva byFecha = findByFecha(fecha);
		if (byFecha != null) {
			String sql = "delete from " + accessJdbc.getBBDD() + ".reserva where fecha = " + String.valueOf(fecha);
			accessJdbc.executeUpdate(sql);
			return byFecha;
		}
		return null;
	}
}
