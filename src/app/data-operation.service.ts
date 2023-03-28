import { Injectable } from '@angular/core';

interface LoginUser{
  username:string;
  password:string;
  role:string;
}

@Injectable({
  providedIn: 'root'
})
export class DataOperationService {

  allloginUsers : LoginUser[] = [];

  constructor() { 

    let user1:LoginUser = {
      username:"Mrunal",
      password:"123",
      role:"User"
    }

    let user2:LoginUser = {
      username:"Mounika",
      password:"123",
      role:"User"
    }

    let user3:LoginUser = {
      username:"Girija",
      password:"123",
      role:"User"
    }

    let user4:LoginUser = {
      username:"Shravani",
      password:"123",
      role:"User"
    }

    let user5:LoginUser = {
      username:"Admin",
      password:"123",
      role:"Admin"
    }

    this.allloginUsers = [user1,user2,user3,user4,user5];

  }

  doLogin(ipUsername:string,ipPassword:string):boolean{
    localStorage.removeItem('username')
    localStorage.removeItem('role')
    localStorage.removeItem('loginStatus')

    console.log("inside Service : "+ipUsername+" & "+ipPassword);

    for(let i=0;i<this.allloginUsers.length;i++){
      let thisUser:LoginUser=this.allloginUsers[i];

      if(thisUser.username==ipUsername && thisUser.password==ipPassword){
        
        localStorage.setItem("username",ipUsername);
          localStorage.setItem("role",thisUser.role);
          localStorage.setItem("loginStatus",true+'');
         
          
          console.log("inside service for true ");
          
          return true; 
      }
    }

    return false;

  }

  doUserLogout()
  {
    localStorage.removeItem('username')
    localStorage.removeItem('role')
    localStorage.removeItem('loginStatus')
    localStorage.removeItem('photo')

    console.log("inside Service logout ");

  }

}
