package co.edu.uptc.hotel.controller;

import co.edu.uptc.hotel.controller.BookingService;
import co.edu.uptc.hotel.controller.HotelService;
import co.edu.uptc.hotel.model.Booking;
import co.edu.uptc.hotel.model.Hotel;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class HotelWebReserve {

    private final HotelService hotelService;
    private final BookingService bookingService;

    public HotelWebReserve(HotelService hotelService, BookingService bookingService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
    }

    @PostMapping("/registrarReserva")
    public String registrarReserva(
        @RequestParam String nombreHotel,
        @RequestParam String ciudad,
        @RequestParam String nombrePersona,
        @RequestParam String documento,
        @RequestParam String email,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate llegada,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate salida,
        @RequestParam String estadoReserva,
        Model model
    ) {
        Hotel hotel = hotelService.findHotel(nombreHotel, ciudad);

        if (hotel == null) {
            model.addAttribute("mensaje", "Hotel no encontrado.");
            return "registerreservation";
        }

        if (!hotel.isActive()) {
            model.addAttribute("mensaje", "El hotel está inactivo.");
            return "registerreservation";
        }

        Booking reserva = new Booking();
        reserva.setHotelName(nombreHotel);
        reserva.setHotelCity(ciudad);
        reserva.setClientName(nombrePersona);
        reserva.setClientId(documento);
        reserva.setClientEmail(email);
        reserva.setCheckInDate(llegada);
        reserva.setCheckOutDate(salida);
        reserva.setStatus(estadoReserva);

        boolean registrada = bookingService.registerBooking(reserva, hotel.getRoomCapacity());

        if (registrada) {
            model.addAttribute("mensaje", "Reserva registrada correctamente.");
        } else {
            model.addAttribute("mensaje", "No hay habitaciones disponibles.");
        }

        return "registerreservation";
    }
}
