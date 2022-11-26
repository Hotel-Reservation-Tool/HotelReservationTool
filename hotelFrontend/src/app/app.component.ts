import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Reservation} from "./book-room/reservation";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ReservationService} from "./book-room/reservation.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'hotelFrontend';
  closeResult: string | undefined;
  myForm: FormGroup;
  email: string = "";
  password: string = "";
  name: string = "";
  phone: string = "";
  newRes: Reservation = new Reservation();

  constructor(private modalService: NgbModal, private fb: FormBuilder, private reservationService: ReservationService,
              private router : Router) { }

  ngOnInit(): void {
    this.myForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")],
    });
  }
   open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  onSubmit() {
    this.reservationService.getClientByEmail(this.email).subscribe(client => {
      this.newRes.clientId = client.id;
      this.reservationService.createReservation(this.newRes).subscribe();
    })
    this.router.navigate(['/home']);

  }
}

