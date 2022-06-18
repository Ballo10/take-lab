package lab.bookings.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Apartment {

    @OneToMany(mappedBy = "apartment")
    private List<Booking> bookings;

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int capacity;
    // getters & setters
}
