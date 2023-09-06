CREATE TABLE zuzex_app.persons
(
    p_id       serial       not null primary key,
    p_login     varchar(255) not null unique ,
    p_age      integer      not null,
    p_password varchar(255) not null,
    p_role     varchar(255)

);

INSERT INTO zuzex_app.persons(p_id, p_login, p_age, p_password, p_role)
values (1, 'Anton', 22,
        '$2a$12$wMASPVQfLQoo2wfxosGOCOMhjJaekaV8W4XL.S3/xZelJ5SOdSx4a', 'Admin'), /*password1*/
       (2, 'Kirill', 35,
        '$2a$12$NB4.ZVGcQ6gUXA1Nbqvbz.2abZGPhKxRELDsny04wv.7Gr3WIknXC','Admin'),   /*password2*/
       (3, 'Anna', 30,
        '$2a$12$Q6rIbF2SAqKcxSQrgOja4uift8lvQWmW9.eSH5Ze1omTQWnxwTpMi', 'Guest')  /*password3*/
