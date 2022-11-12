package res.tool.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import res.tool.hotel.entity.Client;
import res.tool.hotel.entity.Reservation;
import res.tool.hotel.entity.Room;
import res.tool.hotel.repository.ReservationRepo;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    public int createReservation(Reservation reservation) {
        return reservationRepo.createReservation(reservation);
    }
}
