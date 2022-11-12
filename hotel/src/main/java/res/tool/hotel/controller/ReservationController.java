package res.tool.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import res.tool.hotel.entity.Client;
import res.tool.hotel.entity.Reservation;
import res.tool.hotel.entity.Room;
import res.tool.hotel.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping("/create")
    public void createReservation(@RequestBody Reservation reservation){ service.createReservation(reservation);};
}
