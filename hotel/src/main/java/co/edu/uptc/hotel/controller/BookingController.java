package co.edu.uptc.hotel.controller;

import co.edu.uptc.hotel.model.Booking;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final HotelService hotelService;
    private final BookingService bookingService;

    public BookingController(HotelService hotelService, BookingService bookingService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
    }

    @PostMapping("/register")
    public String registerBooking(@RequestBody Booking booking) {
        var hotel = hotelService.findHotel(booking.getHotelName(), booking.getHotelCity());

        if (hotel == null) return "Hotel not found.";
        if (!hotel.isActive()) return "Hotel is not active.";

        boolean success = bookingService.registerBooking(booking, hotel.getRoomCapacity());
        return success ? "Booking registered successfully." : "No available rooms in this hotel.";
    }

    @PutMapping("/change-status")
    public String changeBookingStatus(@RequestParam String clientId, @RequestParam String newStatus) {
        boolean updated = bookingService.changeBookingStatus(clientId, newStatus);
        return updated ? "Booking status updated." : "Booking not found.";
    }

    @GetMapping("/report")
    public List<Booking> reportBookings(@RequestParam String city,
                                        @RequestParam String from,
                                        @RequestParam String to) {
        return bookingService.report(city, LocalDate.parse(from), LocalDate.parse(to));
    }
}
