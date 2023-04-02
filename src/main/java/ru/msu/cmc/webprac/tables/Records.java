package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "records")
@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "record_id")
    private long record_id;

    @Column(nullable = false, name = "reader_id")
    private long reader_id;

    @Column(nullable = false, name = "copy_id")
    private long copy_id;

    @Column(nullable = false, name = "taking_date")
    @NonNull
    private Date taking_date;

    @Column(nullable = false, name = "returning_date")
    @NonNull
    private Date returning_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Records other = (Records) o;
        return Objects.equals(record_id, other.record_id)
                && Objects.equals(reader_id, other.reader_id)
                && Objects.equals(copy_id, other.copy_id)
                && taking_date.equals(other.taking_date)
                && returning_date.equals(other.returning_date);
    }
}
