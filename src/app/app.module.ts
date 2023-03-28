import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddExamComponent } from './add-exam/add-exam.component';
import { ViewQuestionComponent } from './view-question/view-question.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { RegisterStudentComponent } from './register-student/register-student.component';
import { AttemptExamComponent } from './attempt-exam/attempt-exam.component';
import { StartExamComponent } from './start-exam/start-exam.component';
import { ScoreComponent } from './score/score.component';
import { SubmittedExamComponent } from './submitted-exam/submitted-exam.component';

const allLinks:Routes = [
  {path:'login',component:AppComponent},
  {path: 'aboutUs',component: AboutUsComponent},
  {path:'resgisterStudent',component:RegisterStudentComponent},
  {path: 'addQuestion', component: AddQuestionComponent},
  {path: 'viewQuestion',component: ViewQuestionComponent},
  {path:'addTestPaper',component: AddExamComponent},
  {path: 'getAllTestPaper',component: AttemptExamComponent},
  {path: 'startExam',component: StartExamComponent},
  {path: 'getScore',component:ScoreComponent},
  {path: 'submittedExam',component:SubmittedExamComponent}
  
]

@NgModule({
  declarations: [
    AppComponent,
    AddExamComponent,
    ViewQuestionComponent,
    AboutUsComponent,
    AddQuestionComponent,
    RegisterStudentComponent,
    AttemptExamComponent,
    StartExamComponent,
    ScoreComponent,
    SubmittedExamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(allLinks),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
