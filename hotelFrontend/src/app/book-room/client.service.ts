import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Reservation} from "./reservation";
import {Client} from "./client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private httpClient: HttpClient) { }

  private createClientURL = "http://localhost:9999/client/createClient";
  private getClientByEmailURL = "http://localhost:9999/client/getByEmail";
  private getLoggedInURL = "http://localhost:9999/client/getLoggedInClients";
  private editClientURL = "http://localhost:9999/client/editClient";

  createClient(c: Client): Observable<Client>{
    return this.httpClient.post<Client>(this.createClientURL, c);
  }

  getClientByEmail(email: string): Observable<Client>{
    return this.httpClient.get<Client>(`${this.getClientByEmailURL}/${email}`);
  }

  getLoggedInClients(): Observable<Client[]>{
    return this.httpClient.get<Client[]>(this.getLoggedInURL);
  }

  updateClient(id: string, client: Client): Observable<Client>{
    return this.httpClient.put<Client>(`${this.editClientURL}/${id}`, client);
  }

}
