import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from '../exam';
import { ExamDto } from '../exam-dto';
import { ExamOperationService } from '../exam-operation.service';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent {

exam: Exam=new Exam(0,0,0,'');
examDto: ExamDto = new ExamDto(0,0,0,0,0,'');
  allExam : ExamDto[]=[];

examId: number=0;
  constructor(private examService: ExamOperationService, private router: Router){}


  getScoreByExamId(){
    this.examService.getScoreByExamId(this.examId).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.exam = data;
      },err=>{
        console.log("error from spring ",err);
  
      } 
    );
    
  }



}
