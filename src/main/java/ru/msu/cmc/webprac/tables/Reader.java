package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reader")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "reader_id")
    private long reader_id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "surname")
    @NonNull
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(nullable = false, name = "card_number")
    private long card_number;

    @Column(nullable = false, name = "card_date")
    @NonNull
    private Date card_date;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private long phone_number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader other = (Reader) o;
        return Objects.equals(reader_id, other.reader_id)
                && name.equals(other.name)
                && surname.equals(other.surname)
                && patronymic.equals(other.patronymic)
                && Objects.equals(card_number, other.card_number);
    }
}
