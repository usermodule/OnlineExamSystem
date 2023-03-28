export class StudentDto {

    studentId:number;
	username:string;
	password:string;
	firstName:string;
	lastName:string;
	gender:string;
	emailId:string;
	mobileNo:number;


    constructor(
        studentId:number,
        username:string,
        password:string,
        firstName:string,
        lastName:string,
         gender:string,
        emailId:string,
        mobileNo:number,
    

    ){
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }
}
