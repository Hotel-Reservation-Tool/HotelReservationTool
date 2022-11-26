import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GalleryComponent} from "./gallery/gallery.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {ContactComponent} from "./contact/contact.component";
import {BookRoomComponent} from "./book-room/book-room.component";

const routes: Routes = [
  { path: 'gallery', component: GalleryComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'home', component: MainPageComponent },
  { path: 'rooms', component: BookRoomComponent },
  { path: 'rooms', component: BookRoomComponent },
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
