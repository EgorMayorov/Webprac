package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Records")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Record_ID")
    private long record_id;

    @Column(nullable = false, name = "Reader_ID")
    private long reader_id;

    @Column(nullable = false, name = "Copy_ID")
    private long copy_id;

    @Column(nullable = false, name = "Taking_date")
    @NonNull
    private Date taking_date;

    @Column(nullable = false, name = "Returning_date")
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
