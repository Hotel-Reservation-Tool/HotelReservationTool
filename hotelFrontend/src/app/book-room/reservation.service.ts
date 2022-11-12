import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {reservation} from "./reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private URL = "http://localhost:9999/reservation/create";

  constructor(private httpClient: HttpClient) { }

  createReservation(res: reservation): Observable<Object>{
    return this.httpClient.post(this.URL, res);
  }

  getClientByEmail(email: string): Observable<Object>{
    return this.httpClient.get(``);
  }

}
