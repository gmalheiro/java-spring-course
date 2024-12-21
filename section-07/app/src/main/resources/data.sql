insert into course(id,name,created_date,update_date) 
values (10001,'JPA in 50 steps',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());
insert into course(id,name,created_date,update_date)
values (10002,'Spring in 50 steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id,name,created_date,update_date)
values (10003,'Spring boot in 100 steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into passport(id,number)
values (3001,'E123456');
insert into passport(id,number)
values (3002,'N123457');
insert into passport(id,number)
values (3003,'L123890');

insert into student(id,name,passport_id)
values (2001,'Gabriel',3001);
insert into student(id,name,passport_id)
values (2002,'Ranga',3002);
insert into student(id,name,passport_id)
values (2003,'Jane',3003);

insert into review(id,rating,description,course_id)
values (4001,'5','Wonderful course',10001);
insert into review(id,rating,description,course_id)
values (4002,'4','Nice course',10001);
insert into review(id,rating,description,course_id)
values (4003,'5', 'Great course',10003);

insert into student_course(student_id,course_id)
values(2001,10001);
insert into student_course(student_id,course_id)
values(2002,10001);
insert into student_course(student_id,course_id)
values(2003,10001);
insert into student_course(student_id,course_id)
values(2001,10003);