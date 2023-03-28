import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from './exam';
import { ExamDto } from './exam-dto';

@Injectable({
  providedIn: 'root'
})
export class ExamOperationService {
  baseURL:string = 'http://localhost:2025';

  addExamEndPoint:string=this.baseURL+'/exam/add';
  updateScoreByExamIdEndPoint:string=this.baseURL+'/exam/studentAnswer';
  getScoreByExamIdEndPoint:string=this.baseURL+'/exam/scoreByExamId'


  constructor(private http: HttpClient) { }


  addExam(examDto:ExamDto):Observable<ExamDto>{
    console.log("inside service: "+ExamDto);
    return this.http.post<ExamDto>(`${this.addExamEndPoint}`,examDto);
  }



  updateScoreByExamId(data: any):Observable<ExamDto[]>{

   console.log("inside the method :");
    
    //  let updateScoreByExamIdEndPoint='';
    
     let examFromDB:ExamDto=new ExamDto(0,0,0,0,0,'');
    let examId = sessionStorage.getItem("examId");
    // let questionId = sessionStorage.getItem("questionId");
    //  updateScoreByExamIdEndPoint =this.baseURL+'/exam'+examId;
    this.updateScoreByExamIdEndPoint=this.baseURL+'/exam/studentAnswer/'+examId;
    // this.updateScoreByExamIdEndPoint=this.updateScoreByExamIdEndPoint+'/'+questionId;
   return this.http.put<ExamDto[]>(`${this.updateScoreByExamIdEndPoint}`,data);
    
   }



   getScoreByExamId(examId: number):Observable<Exam>
  {
    console.log("inside service : "+this.getScoreByExamIdEndPoint);
    this.getScoreByExamIdEndPoint=this.getScoreByExamIdEndPoint+'/'+examId;
    return this.http.get<Exam>(`${this.getScoreByExamIdEndPoint}`);
  }




  // public updateScoreByExamId(examId: number) {
  //   // let endPoints = "/posts/1"
  //   this.http.put(`${this.updateScoreByExamIdEndPoint}`, examId).subscribe((data: any) => {
  //     console.log(data);
  //   });
  }



  // updateScoreByExamId(examId:number):Observable<ExamDto[]>{
  //   // console.log("Inside Method 1 "+this.updateScoreByExamIdEndPoint);
  //   this.updateScoreByExamIdEndPoint=this.updateScoreByExamIdEndPoint+'/'+examId;
  //   // console.log("Inside Method 2 "+this.updateScoreByExamIdEndPoint);
  //   return this.$http.put<ExamDto[]>(`${this.updateScoreByExamIdEndPoint}`);
  // }

//   ngOnInit(examId:number){
//     const body = { title: 'Angular PUT Request Example' };
//     this.http.put<ExamDto[]>(`${this.updateScoreByExamIdEndPoint}`, examId)
//         // .subscribe(data => this.updateScoreByExamIdEndPoint= data.);
// }


