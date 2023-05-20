package ru.msu.cmc.webprac.tables;

import jakarta.persistence.*;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "book_id")
    private long book_id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @Column(nullable = false, name = "author")
    @NonNull
    private String author;

    @Column(nullable = false, name = "publishing_house")
    @NonNull
    private String publishing_house;

    @Column(nullable = false, name = "amount")
    private int amount;

    @Column(name = "about")
    private String about;

    @Column(nullable = false, name = "genre")
    @NonNull
    private String genre;

    @Column(nullable = false, name = "date_of_receiving")
    @NonNull
    private Date date_of_receiving;

    public Books(String name, String author, String publishing_house, int amount,
                 String about, String genre, String date_of_receiving){
        setName(name);
        setAuthor(author);
        setPublishing_house(publishing_house);
        setAmount(amount);
        setAbout(about);
        setGenre(genre);
        try {
            setDate_of_receiving(new SimpleDateFormat("yyyy-MM-dd").parse(date_of_receiving));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Books(String name, String author, String publishing_house, int amount,
                 String genre, String date_of_receiving){
        setName(name);
        setAuthor(author);
        setPublishing_house(publishing_house);
        setAmount(amount);
        setGenre(genre);
        try {
            setDate_of_receiving(new SimpleDateFormat("dd-MM-yyyy").parse(date_of_receiving));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
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

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
