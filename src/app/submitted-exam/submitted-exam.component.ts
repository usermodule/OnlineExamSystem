import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-submitted-exam',
  templateUrl: './submitted-exam.component.html',
  styleUrls: ['./submitted-exam.component.css']
})
export class SubmittedExamComponent {

constructor(private router: Router){
  
}
  moveToAboutUs() {
    this.router.navigate(['aboutUs']);
  }
}
