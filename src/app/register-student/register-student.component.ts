import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student';
import { StudentDto } from '../student-dto';
import { StudentOperationService } from '../student-operation.service';

@Component({
  selector: 'app-register-student',
  templateUrl: './register-student.component.html',
  styleUrls: ['./register-student.component.css']
})
export class RegisterStudentComponent {

  status=false;
  msg=' ';

  student: Student = new Student(0,'','','','','','',0);

  constructor(private studentService:StudentOperationService, private http:HttpClient,private router: Router){
    
  }

  onRegisteringStudent(){
    console.log(this.student);
    this.studentService.addStudent(this.student).subscribe(
      data=>{
        this.status=true;
        this.msg='Exam Registerd!';
      },err=>{
        console.log("error from spring ",err);

      }
    );

      alert("Success! Student Added");
      localStorage.setItem('pData',JSON.stringify(this.student));
  }

  moveToLogin() {
    this.router.navigate(['login']);
  }


}
