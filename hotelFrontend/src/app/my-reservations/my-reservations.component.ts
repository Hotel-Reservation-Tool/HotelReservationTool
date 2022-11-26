import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Reservation} from "../book-room/reservation";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ReservationService} from "../book-room/reservation.service";
import {Router} from "@angular/router";
import {ClientService} from "../book-room/client.service";
import {Client} from "../book-room/client";

@Component({
  selector: 'app-my-reservations',
  templateUrl: './my-reservations.component.html',
  styleUrls: ['./my-reservations.component.css']
})
export class MyReservationsComponent implements OnInit {

  isLoggedIn: boolean = true;
  public loggedInUSer: Client = null;
  public reservations: any[] = [];

  constructor(private modalService: NgbModal, private fb: FormBuilder, private reservationService: ReservationService,
              private router : Router, private clientService: ClientService) { }

  ngOnInit(): void {
    this.reservations = [];
    this.clientService.getLoggedInClients().subscribe( logged => {
      if (logged.length == 0) {
        this.isLoggedIn = false;
      }else{
        this.loggedInUSer = logged[0];
        this.getReservations();
      }
    })
  }

  getReservations(){
    if(this.loggedInUSer){
      this.reservationService.getGuestReservations(this.loggedInUSer.id).subscribe( r => {
        r.forEach( res =>{
          this.reservations.push(res);
        })
      })
    }
  }

}
