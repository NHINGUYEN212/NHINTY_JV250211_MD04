create
database student_management_db_md4;
use
student_management_db_md4;

create table students
(
    student_id   int auto_increment primary key,
    student_name varchar(100) not null,
    email        varchar(100) not null unique,
    birthday     date         not null,
    avg_mark double not null
);

delimiter
&&
create procedure get_student_list()
begin
select *
from students;
end
&&
delimiter &&

delimiter &&
create procedure add_student(
    name_in varchar (100),
    email_in varchar (100),
    birthday_in date,
    avg_mark_in double
)
begin
insert into students(student_name, email, birthday, avg_mark)
values (name_in, email_in, birthday_in, avg_mark_in);
end
&&
delimiter &&

delimiter &&
create procedure get_student_by_id(id_in int)
begin
select *
from students
where student_id = id_in;
end
&&
delimiter &&

delimiter &&
create procedure update_student(
    id_in int,
    name_in varchar (100),
    email_in varchar (100),
    birthday_in date,
    avg_mark_in double
)
begin
update students
set student_name = name_in,
    email        = email_in,
    birthday     = birthday_in,
    avg_mark     = avg_mark_in
where student_id = id_in;
end
&&
delimiter &&

delimiter &&
create procedure delete_student(id_in int)
begin
delete
from students
where student_id = id_in;
end
&&
delimiter &&

delimiter &&
create procedure get_all_students(in search_name varchar (100), in sort_order varchar (10))
begin
    if
search_name is not null and search_name != '' then

        if sort_order is not null and sort_order = 'DESC' then
select *
from students
where student_name like concat('%', search_name, '%')
   or email like concat('%', search_name, '%')
order by student_id DESC;

else
select *
from students
where student_name like concat('%', search_name, '%')
   or email like concat('%', search_name, '%')
order by student_id ASC;
end if;

else

        if sort_order is not null and sort_order = 'DESC' then
select *
from students
order by student_id DESC;

else
select *
from students
order by student_id ASC;
end if;
end if;
end
&&
delimiter ;
