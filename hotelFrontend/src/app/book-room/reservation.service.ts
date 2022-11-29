 import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable }   from "rxjs";
import { Reservation } from "./Models/reservation";
import { Client } from "./client";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private createReservationURL = "http://localhost:9999/reservation/create";

  constructor(private httpClient: HttpClient) { }

  createReservation(res: Reservation): Observable<Object>{
    return this.httpClient.post(this.createReservationURL, res);
  }

}
