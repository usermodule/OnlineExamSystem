import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TestQuestion } from '../test-question';
import { TestQuestionOperationService } from '../test-question-operation.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent {

  status=false;
  msg=' ';

testQuestion: TestQuestion = new TestQuestion(0,'','','','','','');


constructor(private testQuestionService:TestQuestionOperationService, private http:HttpClient,private router: Router){
   
}

  onAddingQuestion(){
    console.log(this.testQuestion);
    this.testQuestionService.addTestQuestion(this.testQuestion).subscribe(
      data=>{
        this.status=true;
        this.msg='Doctor Registerd!';
      },err=>{
        console.log("error from spring ",err);

      }
    );

      alert("Success! Question Added");
      localStorage.setItem('pData',JSON.stringify(this.testQuestion));
      
  }


  moveToAboutUs() {
    this.router.navigate(['aboutUs']);
  }


}
