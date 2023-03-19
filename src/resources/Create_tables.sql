DROP TABLE "Books", "Book&Copy", "Records", "Reader";

CREATE TABLE "Books" (
                         "Book_ID" int,
                         "Name" text,
                         "Author" text,
                         "Publishing_house" text,
                         "Amount" int,
                         "About" text,
                         "Genre" text,
                         "Date_of_receiving" date,
                         PRIMARY KEY ("Book_ID")
);

CREATE TABLE "Book&Copy" (
                             "Book_ID" int,
                             "Copy_ID" int,
                             PRIMARY KEY ("Copy_ID")
);

CREATE TABLE "Records" (
                           "Record_ID" int,
                           "Reader_ID" int,
                           "Copy_ID" int,
                           "Taking_date" date,
                           "Returning_date" date,
                           PRIMARY KEY ("Record_ID")
);

CREATE TABLE "Reader" (
                          "Reader_ID" int,
                          "Name" text,
                          "Surname" text,
                          "Patronymic" text,
                          "Card_number" int,
                          "Card_date" date,
                          "Date_of_birth" date,
                          "Address" text,
                          "Phone_number" varchar,
                          PRIMARY KEY ("Reader_ID")
);
