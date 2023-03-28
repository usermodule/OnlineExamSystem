export class ExamDto {

    examId:number;
	score:number;
	dateOfExam:number;
    testId:number;
    questionNo:number;
    studentAnswer:string;



    constructor(
    examId:number,
	score:number,
	dateOfExam:number,
    testId:number,
    questionNo:number,
    studentAnswer:string,

    ){
        this.examId = examId;
        this.score = score;
        this.dateOfExam = dateOfExam;
        this.testId=testId;
        this.questionNo=questionNo;
        this.studentAnswer = studentAnswer;
    }
}
