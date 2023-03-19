DROP TABLE "Books", "Book&Copy", "Records", "Reader";

CREATE TABLE "Books" (
                         "Book_ID" int,
                         "Name" text not null ,
                         "Author" text not null ,
                         "Publishing_house" text not null ,
                         "Amount" int not null ,
                         "About" text,
                         "Genre" text not null ,
                         "Date_of_receiving" date not null ,
                         PRIMARY KEY ("Book_ID")
);

CREATE TABLE "Book&Copy" (
                             "Book_ID" int not null ,
                             "Copy_ID" int,
                             PRIMARY KEY ("Copy_ID")
);

CREATE TABLE "Records" (
                           "Record_ID" int,
                           "Reader_ID" int not null ,
                           "Copy_ID" int not null ,
                           "Taking_date" date not null ,
                           "Returning_date" date not null ,
                           PRIMARY KEY ("Record_ID")
);

CREATE TABLE "Reader" (
                          "Reader_ID" int,
                          "Name" text not null ,
                          "Surname" text not null ,
                          "Patronymic" text,
                          "Card_number" int not null unique ,
                          "Card_date" date not null ,
                          "Date_of_birth" date,
                          "Address" text,
                          "Phone_number" varchar,
                          PRIMARY KEY ("Reader_ID")
);
