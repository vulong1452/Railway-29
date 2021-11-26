
create database `Testing_System`;


use Testing_System;


 create table if not exists`Department`(
	DepartmentID int,
    DepartmentName varchar(50)
);

create table `Position`(
	PositionID int,
    PositionName varchar(50)
);

create table `Account`(
		AccountID int,
        Email varchar(50),
        Username varchar(50),
        FullName varchar(50),
        DepartmentID int,
        PositionID int,
        CreateDate date
);

create table `Group`(
	GroupID int,
    GroupName varchar(50),
    CreatorId int,
    CreateName date
);

create table GroupAccount(
	GroupID int,
    AccountID int,
    JoinDate date
   ); 
   
create table TypeQuestion(
	TypeID int,
    TypeName varchar(50)
);

create table CategoryQuestion(
	CategoryID int,
    CategoryName varchar(50)
);

create table Question(
	QuestionID int,
    Content varchar(50),
    CategoryID int,
    TypeID int,
    CreatorID int,
    CreateDate date
);

create table Answer(
	AnswerID int,
    Content varchar(50),
    QuestionID varchar(50),
    isCorrect varchar(10)
);

create table Exam(
	ExamID int,
    `Code` int,
    Title varchar(50),
    CategoryID int,
    Duration time,
    CreatorID int,
    CreateDate date
);

create table ExamQuestion(
	ExamID int,
    QuestionID int
);
        
