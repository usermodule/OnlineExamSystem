export class Exam {

    examId:number;
	score:number;
	dateOfExam:number;
    studentAnswer:string;


    constructor(
    examId:number,
	score:number,
	dateOfExam:number,
    studentAnswer:string,

    ){
        this.examId = examId;
        this.score = score;
        this.dateOfExam = dateOfExam;
        this.studentAnswer = studentAnswer;
    }
}
