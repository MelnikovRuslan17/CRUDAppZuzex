create table if not exists zuzex_app.houses(
    h_id serial not null primary key,
    h_adress varchar(255) not null,
    foreign key (h_id) references zuzex_app.persons(p_id)

)