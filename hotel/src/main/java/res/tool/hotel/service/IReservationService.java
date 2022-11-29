package res.tool.hotel.service;

import org.springframework.stereotype.Service;
import res.tool.hotel.entity.Reservation;

@Service
public interface IReservationService {

    int createReservation(Reservation reservation);

    int deleteReservationById(String rId);

    Reservation getReservationByClientId(String cId);
}
