use todomvc;
create table todo
(
    id      bigint auto_increment,
    message varchar(255),
    primary key (id)
);

select *
from todo;

delete
from todo;



