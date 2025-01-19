package modelo.AbstractDAO;

import java.time.LocalDate;

import modelo.Entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva, Long> {
	public Reserva find(Long idPersona, Long idHotel, LocalDate fecha);
	public Reserva findByIdHotel(Long idHotel);
	public Reserva findByFecha(LocalDate fecha);
	public Reserva deleteByIds(Long idPersona, Long idHotel, LocalDate fecha);
	public Reserva deleteByIdHotel(Long idHotel);
	public Reserva deleteByFecha(LocalDate fecha);

}
