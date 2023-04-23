INSERT INTO reader ("name", "surname", "patronymic", "card_number", "card_date",
                      "date_of_birth", "address", "phone_number") VALUES
    ('Андрей', 'Скороходов','Дмитриевич', 100001, '2020-01-01'::date,
     '1978-05-12'::date, 'улица Фокина, д54, кв37', 89107349856),
    ('Матвей', 'Яковлев','Романович', 100002, '2020-01-01'::date,
     '1988-06-14'::date, 'улица Лебедева, д41, кв7', 89109450714),
    ('Николай', 'Пивоваров','Алексеевич', 100003, '2020-01-01'::date,
     '1979-03-16'::date, 'улица Строителей, д4к3, кв51', 89100747936),
    ('Владислав', 'Петров','Иванович', 100004, '2020-01-01'::date,
     '1981-02-02'::date, 'улица Светланова, д3, кв65', 89107539754),
    ('Иван', 'Лаптев','Петрович', 100005, '2020-01-01'::date,
     '1997-08-22'::date, 'улица Новаторов, д76, кв23', 89101237669);

INSERT INTO books ("name", "author", "publishing_house", "amount",
                     "about", "genre", "date_of_receiving") VALUES
    ('Приключения Эраста Фандорина. Азазель', 'Борис Акунин', 'Новый детектив', 10,
     'Книга рассказывает о приключениях детектива Эраста Фандорина. Захватывающий сюжет!',
     'исторический детектив', '2020-01-01'::date),
    ('Приключения Эраста Фандорина. Турецкий гамбит', 'Борис Акунин', 'Новый детектив', 10,
     'Книга рассказывает о приключениях детектива Эраста Фандорина. Захватывающий сюжет!',
     'исторический детектив', '2020-01-01'::date),
    ('Приключения Эраста Фандорина. Левиафан', 'Борис Акунин', 'Новый детектив', 10,
     'Книга рассказывает о приключениях детектива Эраста Фандорина. Захватывающий сюжет!',
     'исторический детектив', '2020-01-01'::date),
    ('Приключения Эраста Фандорина. Смерть Ахиллеса', 'Борис Акунин', 'Новый детектив', 10,
     'Книга рассказывает о приключениях детектива Эраста Фандорина. Захватывающий сюжет!',
     'исторический детектив', '2020-01-01'::date),
    ('Приключения Эраста Фандорина. Особые поручения: Пиковый вален', 'Борис Акунин', 'Новый детектив', 10,
     'Книга рассказывает о приключениях детектива Эраста Фандорина. Захватывающий сюжет!',
     'исторический детектив', '2020-01-01'::date);

INSERT INTO book_copy ("book_id", "is_taken_now") VALUES
    (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'), (1,  'No'),
    (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'), (2,  'No'),
    (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'), (3,  'No'),
    (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'), (4,  'No'),
    (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No'), (5,  'No');

INSERT INTO records ("reader_id", "copy_id", "taking_date", "returning_date") VALUES
    (1, 1, '2021-01-01'::date, '2021-02-01'::date),
    (2, 2, '2021-01-01'::date, '2021-02-01'::date),
    (3, 3, '2021-01-01'::date, '2021-02-01'::date),
    (4, 4, '2021-01-01'::date, '2021-02-01'::date),
    (5, 5, '2021-01-01'::date, '2021-02-01'::date),
    (1, 11, '2021-01-01'::date, '2021-02-01'::date),
    (2, 12, '2021-01-01'::date, '2021-02-01'::date),
    (3, 13, '2021-01-01'::date, '2021-02-01'::date),
    (4, 14, '2021-01-01'::date, '2021-02-01'::date),
    (5, 15, '2021-01-01'::date, '2021-02-01'::date),
    (1, 21, '2021-01-01'::date, '2021-02-01'::date),
    (2, 22, '2021-01-01'::date, '2021-02-01'::date),
    (3, 23, '2021-01-01'::date, '2021-02-01'::date),
    (4, 24, '2021-01-01'::date, '2021-02-01'::date),
    (5, 25, '2021-01-01'::date, '2021-02-01'::date),
    (1, 31, '2021-01-01'::date, '2021-02-01'::date),
    (2, 32, '2021-01-01'::date, '2021-02-01'::date),
    (3, 33, '2021-01-01'::date, '2021-02-01'::date),
    (4, 34, '2021-01-01'::date, '2021-02-01'::date),
    (5, 35, '2021-01-01'::date, '2021-02-01'::date);
