CREATE TABLE IF NOT EXISTS Employee (
    id identity,
    email varchar(25) not null,
    username varchar(25) not null,
    password varchar(255) not null,
    name varchar(10) not null
);

CREATE TABLE IF NOT EXISTS Role (
    id identity,
    name varchar(50) not null
);

CREATE TABLE IF NOT EXISTS Employee_Roles (
    employee_id bigint not null,
    role_id bigint not null
);

ALTER TABLE Employee_Roles add foreign key (employee_id) references Employee(id);
ALTER TABLE Employee_Roles add foreign key (role_id) references Role(id);