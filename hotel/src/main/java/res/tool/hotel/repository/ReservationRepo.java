package res.tool.hotel.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import res.tool.hotel.entity.Reservation;


@Repository
public class ReservationRepo implements IReservationRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createReservation(Reservation reservation){
//        try {
            String insertReservation = "insert into reservation(reservationid, clientid, start_date, end_date) values (?, ?, ?, ?)";
//            int insertReservationReturn =
            return jdbcTemplate.update(insertReservation, reservation.getReservationId(), reservation.getClientId(), reservation.getStart_date(), reservation.getEnd_date());
//            if (insertReservationReturn != 1){
//                throw new Exception("insertReservationReturn returned: " + insertReservationReturn);
//            }
//            String insertReservationHelper = "insert into reservation_helper(reservationid, roomid) values (?, ?)";
//            for(Room room : rooms){
//                int insertReservationHelperReturn = jdbcTemplate.update(insertReservationHelper, reservation.getReservationId(), room.getRoomId());
//                if (insertReservationHelperReturn != 1){
//                    throw new Exception("insertReservationHelperReturn returned: " + insertReservationHelperReturn);
//                }
//            }
//        }catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public int deleteReservationById(String rId) {
        String insertReservation = "DELETE FROM hotel.reservation WHERE reservationid = ?";
        return jdbcTemplate.update(insertReservation, rId);
    }

    public Reservation getReservationByClientId(String cId) {
        String insertReservation = "SELECT * FROM hotel.reservation WHERE clientid = ?";
        return jdbcTemplate.queryForObject(insertReservation, new BeanPropertyRowMapper<>(Reservation.class), cId);
    }
}
