package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "book_copy")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book_Copy {

    @ManyToOne
    @JoinColumn(name = "book_id")
//    @Column(nullable = false, name = "book_id")
    private Books book_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "copy_id")
    private long copy_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book_Copy other = (Book_Copy) o;
        return Objects.equals(book_id, other.book_id)
                && Objects.equals(copy_id, other.copy_id);
    }
}
