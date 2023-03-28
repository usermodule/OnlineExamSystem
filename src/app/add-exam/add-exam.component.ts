import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ExamDto } from '../exam-dto';
import { ExamOperationService } from '../exam-operation.service';
import { TestPaper } from '../test-paper';
import { TestPaperOperationService } from '../test-paper-operation.service';

@Component({
  selector: 'app-add-exam',
  templateUrl: './add-exam.component.html',
  styleUrls: ['./add-exam.component.css']
})
export class AddExamComponent {


  status=false;
  msg=' ';
  testPaper:TestPaper=new TestPaper(0,'','','',0);
  exam:ExamDto=new ExamDto(0,0,0,0,0,'');
  

  constructor(private testPaperService:TestPaperOperationService,private examService: ExamOperationService, private http:HttpClient){

  }

  onAddingTestPaper(){
    console.log(this.testPaper);
    this.testPaperService.addTestPaper(this.testPaper).subscribe(
      data=>{
        this.status=true;
        this.msg='Exam Registerd!';
      },err=>{
        console.log("error from spring ",err);

      }
    );

     
      localStorage.setItem('pData',JSON.stringify(this.testPaper));
      
      //this.addUser(this.h);
  }


  onAddingExam(){
    console.log(this.exam);
    this.examService.addExam(this.exam).subscribe(
      data=>{
        this.status=true;
        this.msg='Exam Registerd!';
      },err=>{
        console.log("error from spring ",err);

      }
    );

      alert("Success! Exam Added");
      localStorage.setItem('pData',JSON.stringify(this.exam));
  }




}
