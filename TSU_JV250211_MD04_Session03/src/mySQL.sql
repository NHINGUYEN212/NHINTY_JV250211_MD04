create database Projects_db;
use Projects_db;
create table projects(
                         project_id int primary key auto_increment,
                         project_name varchar(100) not null unique,
                         project_description text not null,
                         project_image text not null
);

delimiter &&
create procedure find_all_projects()
begin
select * from projects;
end &&
delimiter &&
call find_all_projects();

delimiter &&
create procedure create_project(
    name_in varchar(100),
    desc_in text,
    image_in text
)
begin
insert into projects(project_name, project_description, project_image)
VALUES (name_in, desc_in, image_in);
end &&
delimiter &&

delimiter &&
create procedure find_project_by_id(
    id_in int
)
begin
select * from projects where project_id = id_in;
end &&
delimiter &&

delimiter &&
create procedure update_project(
    id_in int,
    name_in varchar(100),
    desc_in text,
    image_in text
)
begin
update projects
set project_name = name_in,
    project_description = desc_in,
    project_image = image_in
where project_id = id_in;
end &&
delimiter &&

delimiter &&
create procedure delete_project(
    id_in int
)
begin
delete from projects where project_id = id_in;
end &&
delimiter &&