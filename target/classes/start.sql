
drop table USER;
drop table POST;
drop table COMMENT;
CREATE TABLE USER(
   ID INT NOT NULL,
   NAME VARCHAR(50) NOT NULL,
   EMAIL VARCHAR(50) NOT NULL,
   CREATION_DATE DATE,
);
CREATE TABLE POST(
   ID INT NOT NULL,
   USER_ID INT NOT NULL,
   TITLE VARCHAR(4000) NOT NULL,
   BODY VARCHAR(4000) NOT NULL
);
CREATE TABLE COMMENT(
   ID INT NOT NULL,
   POST_ID INT NOT NULL,
   NAME VARCHAR(2000) NOT NULL,
   EMAIL VARCHAR(50) NOT NULL,
   BODY VARCHAR(4000) NOT NULL
);

insert into USER (ID,NAME,EMAIL,CREATION_DATE)  values (1,'Sandeep Kamath','sandeepkamathkr@gmail.com', CURRENT_DATE());
insert into USER (ID,NAME,EMAIL,CREATION_DATE) values (2,'Shubham Shenoy','shubhamshenoy@gmail.com', CURRENT_DATE());

insert into POST (ID, USER_ID, TITLE, BODY) values (1,1,'this is book','this is a book , its is red');
insert into POST (ID, USER_ID, TITLE, BODY) values (2,1,'this is second book','this is a second book , its is red second book');
insert into POST (ID, USER_ID, TITLE, BODY) values (3,1,'this is third book','this is a third book , its is red third book');
insert into POST (ID, USER_ID, TITLE, BODY) values (4,1,'this is fourth book','this is a fourth book , its is red fourth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (5,1,'this is fifth book','this is a fifth book , its is red fifth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (6,1,'this is sixth book','this is a sixth book , its is red sixth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (7,2,'this is seventh book','this is a seventh book , its is red seventh book');
insert into POST (ID, USER_ID, TITLE, BODY) values (8,2,'this is eight book','this is a eighth book , its is red eighth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (9,2,'this is ninth book','this is a ninth book , its is red ninth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (10,2,'this is tenth book','this is a tenth book , its is red tenth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (11,2,'this is eleventh book','this is a eleventh book , its is red eleventh book');
insert into POST (ID, USER_ID, TITLE, BODY) values (12,2,'this is twelveth book','this is a twelveth book , its is red twelveth book');
insert into POST (ID, USER_ID, TITLE, BODY) values (13,2,'this is thirteenth book','this is a thirteenth book , its is red thirteenth book');

insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (1,1,'Sandeep Kamath','sandeepkamath@gmail.com','comment for this is a book , its is red');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (2,2,'Sandeep Kamath','sandeepkamath@gmail.com','comment for this is a second book , its is red second book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (3,3,'Sandeep Kamath','sandeepkamath@gmail.com','comment for this is a third book , its is red third book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (4,4,'Sandeep Kamath','sandeepkamath@gmail.com','comment for this is a fourth book , its is red fourth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (5,5,'Sandeep Kamath','sandeepkamath@gmail.com','comment for this is a fifth book , its is red fifth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (6,6,'Sandeep Kamath','sandeepkamath@gmail.com','comment for this is a sixth book , its is red sixth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (7,7,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a seventh book , its is red seventh book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (8,8,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a eighth book , its is red eighth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (9,9,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a ninth book , its is red ninth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (10,10,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a tenth book , its is red tenth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (11,11,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a eleventh book , its is red eleventh book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (12,12,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a twelveth book , its is red twelveth book');
insert into COMMENT (ID, POST_ID, NAME, EMAIL, BODY) values (13,13,'Shubham Shenoy','shubhamshenoy@gmail.com','comment for this is a thirteenth book , its is red thirteenth book');

commit;