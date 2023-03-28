import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TestQuestion } from '../test-question';
import { TestQuestionDto } from '../test-question-dto';
import { TestQuestionOperationService } from '../test-question-operation.service';

@Component({
  selector: 'app-view-question',
  templateUrl: './view-question.component.html',
  styleUrls: ['./view-question.component.css']
})
export class ViewQuestionComponent {

testQuestion:  TestQuestion = new TestQuestion(0,'','','','','','');

allTestQuestion : TestQuestionDto[]=[];
testPaperId: number = 0;

constructor(private testQuestionService: TestQuestionOperationService, private router: Router){}



  getAllTestQuestion(){ 
    this.allTestQuestion=[];
   this.testQuestionService.getAllQuestion().subscribe(
    data=>{
      console.log("data :- "+data);
      
      this.allTestQuestion = data;
    },err=>{
      console.log("error from spring ",err);

    }
  );
  }

  getQuestionsByTestPaperId(){
   

    this.testQuestionService.getAllQuestionsByTestPaperId(this.testPaperId).subscribe(
      data=>{
        console.log("data :- "+data);
        
        this.allTestQuestion = data;
      },err=>{
        console.log("error from spring ",err);
  
      } 
    );
    
  }


}
