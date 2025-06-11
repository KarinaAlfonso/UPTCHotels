package co.edu.uptc.hotel.controller;
import co.edu.uptc.hotel.model.Hotel;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/register")
    public String registerHotel(@RequestBody Hotel hotel) {
        if (hotelService.exists(hotel.getName(), hotel.getCity())) {
            return "A hotel with that name already exists in that city.";
        }
        hotelService.addHotel(hotel);
        return "Hotel registered successfully.";
    }

    @GetMapping("/search")
    public List<Hotel> searchHotel(@RequestParam String name, @RequestParam String city) {
        return hotelService.getHotels().stream()
                .filter(hotel -> hotel.getName().equalsIgnoreCase(name) &&
                        hotel.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @PutMapping("/edit")
    public String editHotel(@RequestBody Hotel updatedHotel) {
        Hotel hotel = hotelService.findHotel(updatedHotel.getName(), updatedHotel.getCity());
        if (hotel != null) {
            hotel.setAddress(updatedHotel.getAddress());
            hotel.setPhone(updatedHotel.getPhone());
            hotel.setEmail(updatedHotel.getEmail());
            hotel.setRoomCapacity(updatedHotel.getRoomCapacity());
            return "Hotel edited successfully.";
        }
        return "Hotel not found.";
    }

    @PutMapping("/toggle-status")
    public String toggleHotelStatus(@RequestParam String name, @RequestParam String city) {
        Hotel hotel = hotelService.findHotel(name, city);
        if (hotel != null) {
            hotel.setActive(!hotel.isActive());
            return "Hotel status updated.";
        }
        return "Hotel not found.";
    }
}
