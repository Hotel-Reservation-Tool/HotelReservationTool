package res.tool.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import res.tool.hotel.entity.Reservation;
import res.tool.hotel.repository.ReservationRepo;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    public int createReservation(Reservation reservation) {
        return reservationRepo.createReservation(reservation);
    }

    public int deleteReservationById(String rId) {
        return reservationRepo.deleteReservationById(rId);
    }

    public List<Reservation> getReservationByClientId(String cId) {
        return reservationRepo.getReservationByClientId(cId);
    }
}
