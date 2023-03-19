package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Books")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Book_ID")
    private long book_id;

    @Column(nullable = false, name = "Name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "Author")
    @NonNull
    private String author;

    @Column(nullable = false, name = "Publishing_house")
    @NonNull
    private String publishing_house;

    @Column(nullable = false, name = "Amount")
    private int amount;

    @Column(name = "About")
    private String about;

    @Column(nullable = false, name = "Genre")
    @NonNull
    private String genre;

    @Column(nullable = false, name = "Date_of_receiving")
    @NonNull
    private Date date_of_receiving;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books other = (Books) o;
        return Objects.equals(book_id, other.book_id)
                && name.equals(other.name)
                && author.equals(other.author)
                && publishing_house.equals(other.publishing_house)
                && Objects.equals(amount, other.amount)
                && genre.equals(other.genre)
                && date_of_receiving.equals(other.date_of_receiving);
    }
}
