create table shift
(
    primary_id int AUTO_INCREMENT PRIMARY KEY,
    hour_start  int         NOT NULL,
    day        varchar(10) NOT NULL,
    total_slots int         NOT NULL
);


create table assignment
(
    primary_id int AUTO_INCREMENT PRIMARY KEY,
    email varchar(255) NOT NULL,
    shift_id int,
    FOREIGN KEY (shift_id) REFERENCES shift(primary_id)
);

insert into shift(hour_start, day, total_slots) VALUES
    (07, 'Thursday', 15),
    (08, 'Thursday', 27),
    (09, 'Thursday', 4),
    (10, 'Thursday', 6),
    (11, 'Thursday', 6),
    (12, 'Thursday', 6),
    (13, 'Thursday', 6),
    (14, 'Thursday', 6),
    (15, 'Thursday', 6),
    (16, 'Thursday', 5),
    (17, 'Thursday', 2),
    (18, 'Thursday', 1),
    (19, 'Thursday', 1),
    (20, 'Thursday', 1),
    (21, 'Thursday', 1),
    (07, 'Friday', 0),
    (08, 'Friday', 2),
    (09, 'Friday', 6),
    (10, 'Friday', 6),
    (11, 'Friday', 6),
    (12, 'Friday', 6),
    (13, 'Friday', 6),
    (14, 'Friday', 6),
    (15, 'Friday', 6),
    (16, 'Friday', 8),
    (17, 'Friday', 7),
    (18, 'Friday', 5),
    (19, 'Friday', 1),
    (20, 'Friday', 1),
    (21, 'Friday', 1);

