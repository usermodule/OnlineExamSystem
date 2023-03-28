export class TestPaper {

    testPaperId:number;
	difficultyLevel:string;
	description:string;
	course:string;
	noOfQuestions:number;


    constructor(
        testPaperId:number,
        difficultyLevel:string,
        description:string,
        course:string,
        noOfQuestions:number
    
    ){
        this.testPaperId =testPaperId;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
        this.course = course;
        this.noOfQuestions = noOfQuestions;
    }
}
