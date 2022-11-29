package res.tool.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import res.tool.hotel.entity.Reservation;
import res.tool.hotel.repository.IReservationRepo;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private IReservationRepo reservationRepo;

    public int createReservation(Reservation reservation) {
        return reservationRepo.createReservation(reservation);
    }

    public int deleteReservationById(String rId) {
        return reservationRepo.deleteReservationById(rId);
    }

    public Reservation getReservationByClientId(String cId) {
        return reservationRepo.getReservationByClientId(cId);
    }
}
