package co.edu.uptc.hotel.controller_jstl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.edu.uptc.hotel.model.Booking;
import co.edu.uptc.hotel.model.Hotel;

@Controller
public class MenuController {
   
    @GetMapping("/")
    public String showMenu() {
        System.out.println("Entró al menú");
        return "index"; 
    }

    @GetMapping("/hotels/form")
    public String showHotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "registerhotel";
    }

    @GetMapping("/bookings/form")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "registerreservation"; 
    }
}
