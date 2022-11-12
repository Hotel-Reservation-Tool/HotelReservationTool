import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-book-room',
  templateUrl: './book-room.component.html',
  styleUrls: ['./book-room.component.css']
})
export class BookRoomComponent implements OnInit {

  floor : number = 1;
  selectedRooms: number[] = [];
  closeResult: string | undefined;
  myForm: FormGroup;

  constructor(private modalService: NgbModal, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.myForm = this.fb.group({
      name: ['', Validators.required],
      phone: ['', Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")],
      email: ['', [Validators.required, Validators.email]],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required]
    });
  }

  clickOnFloor1(){
    this.floor = 1;
  }
  clickOnFloor2(){
    this.floor = 2;
  }
  clickOnFloor3(){
    this.floor = 3;
  }

  clickOnRoom(room: number){

    let roomElement = document.getElementById("room-" + room);

    if(this.selectedRooms.includes(room)){
      const index = this.selectedRooms.indexOf(room);
      this.selectedRooms.splice(index, 1);
      if(roomElement){
        roomElement.classList.remove("selectedRoom");
      }
    }else{
      this.selectedRooms.push(room);
      if(roomElement){
        roomElement.classList.add("selectedRoom");
      }
    }
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

  onSubmit(form: FormGroup) {
    if (form.valid) {
      console.log("Form Submitted!");
    }
  }
}
