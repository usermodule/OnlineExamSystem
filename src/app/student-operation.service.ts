import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './student';
import { StudentDto } from './student-dto';

@Injectable({
  providedIn: 'root'
})
export class StudentOperationService {

  baseURL:string = 'http://localhost:2025';

  addStudentEndPoint:string =this.baseURL+ '/student/register';

  constructor(private http:HttpClient) { }

  addStudent(student:Student):Observable<Student>{
    console.log("inside service: "+student);
    return this.http.post<Student>(`${this.addStudentEndPoint}`,student);
  }



  

}
