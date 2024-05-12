DROP TABLE IF EXISTS student_laptop;
DROP TABLE IF EXISTS laptop;
DROP TABLE IF EXISTS student;

create table ajp.student
(
    rollno int          not null  primary key,
    name   varchar(255) null,
    marks  int          null
);

create table ajp.laptop
(
    lid   int          not null    primary key,
    Lname varchar(255) null
);

CREATE TABLE student_laptop (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    studentid int NOT NULL,
    laptopid int NOT NULL,

    FOREIGN KEY (studentid) REFERENCES student(rollno)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (laptopid) REFERENCES laptop(lid)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
