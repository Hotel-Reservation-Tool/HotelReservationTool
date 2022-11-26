import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Reservation} from "./book-room/reservation";
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ReservationService} from "./book-room/reservation.service";
import {Router} from "@angular/router";
import {Component, OnInit} from '@angular/core';
import {ClientService} from "./book-room/client.service";
import {Client} from "./book-room/client";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'hotelFrontend';
  closeResult: string | undefined;
  myForm: FormGroup;
  email: string = "";
  password: string = "";
  name: string = "";
  phone: string = "";
  newClient: Client = new Client();
  public isLoggedIn: boolean = false;
  public loggedInUSer: Client = null;
  private badPw: boolean = false;

  constructor(private modalService: NgbModal, private fb: FormBuilder, private reservationService: ReservationService,
              private router : Router, private clientService: ClientService) { }

  ngOnInit(): void {
    this.myForm = this.fb.group({
      name: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]]
    });
    this.clientService.getLoggedInClients().subscribe( logged => {
      this.isLoggedIn = logged.length != 0;
      if(logged.length != 0){
        this.loggedInUSer = logged[0];
      }
  })
  }
   open(content: any) {
     this.name = "";
     this.email = "";
     this.password = "";
     this.phone = "";
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

  login(): void{
    this.clientService.getClientByEmail(this.email).subscribe( c => {
      if(c.password == this.password){
        c.isLoggedIn = 1;
        this.badPw = false;
        this.clientService.updateClient(c.id, c).subscribe(
        );
      }
      else{
        alert("Bad password!")
        this.badPw = true;
      }
    },
      () => alert("Bad email or password!"),
      () => {
      if(!this.badPw){
        window.location.reload()
        this.name = "";
        this.email = "";
        this.password = "";
        this.phone = "";
      }
    })
  }

  logout(): void{
    this.clientService.getClientByEmail(this.loggedInUSer.email).subscribe( c => {
      c.isLoggedIn = 0;
      this.clientService.updateClient(c.id, c).subscribe();
      this.loggedInUSer = null;
      window.location.reload()
      this.name = "";
      this.email = "";
      this.password = "";
      this.phone = "";
    })
  }

  register(){
    this.newClient.name = this.name;
    this.newClient.email = this.email;
    this.newClient.password = this.password;
    this.newClient.mobile = this.phone;
    this.newClient.isLoggedIn = 1;
    this.clientService.createClient(this.newClient).subscribe( (result) => {
        console.log(result);
    },
      () => alert("Registration failed! Please try again! "),
      () => {
      alert("Registration successful!")
        window.location.reload();
      });

  }
}

