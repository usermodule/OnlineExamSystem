import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Exam } from '../exam';
import { ExamDto } from '../exam-dto';
import { ExamOperationService } from '../exam-operation.service';
import { TestQuestion } from '../test-question';
import { TestQuestionDto } from '../test-question-dto';
import { TestQuestionOperationService } from '../test-question-operation.service';

@Component({
  selector: 'app-start-exam',
  templateUrl: './start-exam.component.html',
  styleUrls: ['./start-exam.component.css']
})
export class StartExamComponent {

  status=false;
  msg=' ';
  i:number=0;


   seconds:number = 30;

   

  testQuestion: TestQuestion= new TestQuestion(0,'','','','','','');
exam : Exam=new Exam(0,0,0,'');
  testQuestionDto: TestQuestionDto[]=[];

  attempt: boolean[]=[];

  allTestQuestionDto: TestQuestionDto= new TestQuestionDto(0,'','','','','',false);

  examDto: ExamDto[]=[];
  testPaperId: number = 0;
  examId: number=1;

  // questionId:number=1;
  // questionId: number=1;
  constructor( private testQuestionService: TestQuestionOperationService, private router: Router,private examService:ExamOperationService){
   
  }

  getTestQuestionById(){
  //  this.testQuestionDto=[];
    // let testPaperId:number=parseInt(tId);
    
    this.testQuestionService.getAllQuestionsByTestPaperId(this.testPaperId).subscribe(
      data=>{
        sessionStorage.setItem("examId",this.examId+"");
         
        console.log("data :- "+data);
        
        this.testQuestionDto = data;
        for (let i = 0; i < this.testQuestionDto.length; i++) {
          this.attempt[i]=false;
          
        }
      },err=>{
        console.log("error from spring ",err);

      }
    );
  }

 selectedAnswer = " ";

  updateScoreByExamId(questionId:number){
console.log(this.selectedAnswer);
console.log(questionId);
console.log(this.testQuestionDto);
this.attempt[questionId-1]=true;
    let JSONData = {
      "studentAnswer" : this.selectedAnswer,
      "questionNo" : questionId
    } 
    this.examService.updateScoreByExamId(JSONData).subscribe(
   
         
   data=>{
    // sessionStorage.setItem("questionId",this.questionId+"");
     this.status=true;
     
   this.msg="Score updated";
  },
    
  err=>{
    console.log("error from spring ",err);

      }
    );
    localStorage.setItem('pData',JSON.stringify(this.examDto));
      

    }

  // updateScoreByExamId(){
  //   //  this.testQuestionDto=[];
  //     // let testPaperId:number=parseInt(tId);
  //     this.examService.updateScoreByExamId(this.examId)
        
  //     alert("Success! Question Added");
  //     localStorage.setItem('pData',JSON.stringify(this.examDto));
  //   }


  moveToSubmittedExam() {

    alert("Success! Answer Saved");
      localStorage.setItem('pData',JSON.stringify(this.testQuestion));
    this.router.navigate(['submittedExam']);
  }

  startTimer() {
     setInterval(() => { 
      if (this.seconds > 0) {
         this.seconds--; 
        }
         else { // Do something when the timer is done 
        } }, 1000); 
        
      }
 
        ngOnInit() {
           this.startTimer(); 
          }
  
}
