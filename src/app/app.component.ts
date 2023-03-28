import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DataOperationService } from './data-operation.service';
import { ExamDto } from './exam-dto';
import { ExamOperationService } from './exam-operation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'OnlineExamSystem';

  status=false;
  msg=' ';
  
  loginUsername:string = '';
  userRole :string = '';
  loginStatus:boolean = false;
  photo:string='';

  __dataService:DataOperationService;
  

  constructor(dataService:DataOperationService,private router: Router)
  {
    this.__dataService = dataService;
    this.loginStatus = false;
  }

  verifyUser(username:string,password:string)
  {
    console.log("inside component ts : "+username+" & "+password);
    
    this.loginStatus = this.__dataService.doLogin(username,password);
    
    if(this.loginStatus == true)
    {
      // becoz local storage may give u null
      this.userRole =  localStorage.getItem('role') || '';
      this.loginUsername = localStorage.getItem('username') || '';
      this.photo = localStorage.getItem('photo') || '';
      
      console.log("username "+this.loginUsername)
      console.log("user role "+this.userRole);
      
    }
  }

  doLogout()
  {
    this.loginUsername = '';
    this.userRole = '';
    this.loginStatus= false;
    this.photo='';
    this.__dataService.doUserLogout();
  }


  moveToRegister() {
    this.router.navigate(['resgisterStudent']);
  }
  

}
