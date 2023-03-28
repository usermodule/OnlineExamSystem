export class TestPaperDto {

    testPaperId:number;
	difficultyLevel:string;
	description:string;
	course:string;
	noOfQuestions:string;

    constructor(

    testPaperId:number,
	difficultyLevel:string,
	description:string,
	course:string,
	noOfQuestions:string


    ){

        this.testPaperId = testPaperId;
        this.difficultyLevel = difficultyLevel;
        this.description = description;
        this.course = course;
        this.noOfQuestions = noOfQuestions;
    }

}
