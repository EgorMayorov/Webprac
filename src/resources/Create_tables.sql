DROP TABLE IF EXISTS books, book_copy, records, reader;

CREATE TABLE books (
                         "book_id" int,
                         "name" text not null ,
                         "author" text not null ,
                         "publishing_house" text not null ,
                         "amount" int not null ,
                         "about" text,
                         "genre" text not null ,
                         "date_of_receiving" date not null ,
                         PRIMARY KEY ("book_id")
);

CREATE TABLE book_copy (
                             "book_id" int not null ,
                             "copy_id" int,
                             PRIMARY KEY ("copy_id")
);

CREATE TABLE records (
                           "record_id" int,
                           "reader_id" int not null ,
                           "copy_id" int not null ,
                           "taking_date" date not null ,
                           "returning_date" date not null ,
                           PRIMARY KEY ("record_id")
);

CREATE TABLE reader (
                          "reader_id" int,
                          "name" text not null ,
                          "surname" text not null ,
                          "patronymic" text,
                          "card_number" int not null unique ,
                          "card_date" date not null ,
                          "date_of_birth" date,
                          "address" text,
                          "phone_number" varchar,
                          PRIMARY KEY ("reader_id")
);
