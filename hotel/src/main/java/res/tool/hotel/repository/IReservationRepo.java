package res.tool.hotel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import res.tool.hotel.entity.Reservation;


@Repository
public interface IReservationRepo {

    int createReservation(Reservation reservation);

    int deleteReservationById(String rId);

    public Reservation getReservationByClientId(String cId);
}
