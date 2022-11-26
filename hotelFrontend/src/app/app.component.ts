import {Component, OnInit} from '@angular/core';
import {ReservationService} from "./book-room/reservation.service";
import {Router} from "@angular/router";
import {ClientService} from "./book-room/client.service";
import {Client} from "./book-room/client";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'hotelFrontend';
  public isLoggedIn: boolean;

  constructor(private reservationService: ReservationService,
              private router : Router, private clientService: ClientService) { }


  ngOnInit(): void {
    this.clientService.getLoggedInClients().subscribe( logged => {
      this.isLoggedIn = logged.length != 0;
  })
  }

  login(): void{
    this.clientService.getClientByEmail("j@gmail.com").subscribe( c => {
      c.isLoggedIn = 1;
      this.clientService.updateClient(c.id, c).subscribe(
      );
    })
  }

  logout(): void{
    this.clientService.getClientByEmail("j@gmail.com").subscribe( c => {
      c.isLoggedIn = 0;
      this.clientService.updateClient(c.id, c).subscribe();
    })
  }

  register(client : Client){
    this.clientService.createClient(client).subscribe();
  }
}
