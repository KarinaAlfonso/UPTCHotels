package co.edu.uptc.hotel.controller;

import co.edu.uptc.hotel.model.Booking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private List<Booking> bookings = new ArrayList<>();

    public boolean registerBooking(Booking booking, long hotelCapacity) {
        long activeBookings = bookings.stream()
                .filter(b -> b.getHotelName().equalsIgnoreCase(booking.getHotelName()) &&
                             b.getHotelCity().equalsIgnoreCase(booking.getHotelCity()) &&
                             b.getStatus().equalsIgnoreCase("Registered"))
                .count();

        if (activeBookings >= hotelCapacity) {
            return false; // No hay espacio
        }

        bookings.add(booking);
        return true;
    }

    public boolean changeBookingStatus(String clientId, String newStatus) {
        for (Booking b : bookings) {
            if (b.getClientId().equals(clientId)) {
                b.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    public List<Booking> report(String city, LocalDate from, LocalDate to) {
        return bookings.stream()
                .filter(b -> b.getHotelCity().equalsIgnoreCase(city))
                .filter(b -> !b.getCheckInDate().isBefore(from) &&
                             !b.getCheckInDate().isAfter(to))
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}
