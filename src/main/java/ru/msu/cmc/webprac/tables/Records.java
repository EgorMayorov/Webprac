package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;
import ru.msu.cmc.webprac.utils.DAOFactory;

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

    @ManyToOne
    @JoinColumn(nullable = false, name = "reader_id")
    private Reader reader_id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "copy_id")
    private Book_Copy copy_id;

    @Column(nullable = false, name = "taking_date")
    @NonNull
    private Date taking_date;

    @Column(name = "returning_date")
    private Date returning_date;

    public Records(String reader_surname, String book_name){
        setReader_id(DAOFactory.getInstance().getReaderDAO().getReaderBySurname(reader_surname).get(0));
        Book_Copy copy = DAOFactory.getInstance().getCopyDAO().GetBookCopyByBookName(book_name);
        setCopy_id(copy);
        copy.setIs_taken_now("Yes");
        DAOFactory.getInstance().getCopyDAO().updateCopy(copy);
        Date current_date = new Date(System.currentTimeMillis());
        setTaking_date(current_date);
    }
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
