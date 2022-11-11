import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-room',
  templateUrl: './book-room.component.html',
  styleUrls: ['./book-room.component.css']
})
export class BookRoomComponent implements OnInit {

  floor : number = 1;

  constructor() { }

  ngOnInit(): void {
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

}
