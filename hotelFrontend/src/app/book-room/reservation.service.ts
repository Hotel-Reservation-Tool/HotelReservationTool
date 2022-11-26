import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Reservation} from "./reservation";
import {Client} from "./client";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private createReservationURL = "http://localhost:9999/reservation/create";
  private getClientByEmailURL = "http://localhost:9999/client/getByEmail";

  constructor(private httpClient: HttpClient) { }

  createReservation(res: Reservation): Observable<Object>{
    return this.httpClient.post(this.createReservationURL, res);
  }

  getClientByEmail(email: string): Observable<any>{
    return this.httpClient.get(`${this.getClientByEmailURL}/${email}`);
  }

}
