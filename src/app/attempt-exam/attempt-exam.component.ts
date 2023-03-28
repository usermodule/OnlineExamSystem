import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TestPaper } from '../test-paper';
import { TestPaperDto } from '../test-paper-dto';
import { TestPaperOperationService } from '../test-paper-operation.service';

@Component({
  selector: 'app-attempt-exam',
  templateUrl: './attempt-exam.component.html',
  styleUrls: ['./attempt-exam.component.css']
})
export class AttemptExamComponent {

  testPaper : TestPaper = new TestPaper(0,'','','',0);

  allTestPaper:TestPaperDto[]=[];

  constructor(private testPaperService: TestPaperOperationService, private router: Router){
   
  }

  getAllTestPaper(){ 
    this.allTestPaper=[];
   this.testPaperService.getAllTestPaper().subscribe(
    data=>{
      console.log("data :- "+data);
      
      this.allTestPaper = data;
    },err=>{
      console.log("error from spring ",err);

    }
  );
  }

  

  moveToStartExam(){
    this.router.navigate(['startExam']);
  }
}
