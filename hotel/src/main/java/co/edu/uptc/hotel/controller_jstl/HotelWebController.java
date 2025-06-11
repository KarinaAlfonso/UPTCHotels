package co.edu.uptc.hotel.controller_jstl;

import co.edu.uptc.hotel.model.Hotel;
import co.edu.uptc.hotel.controller.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HotelWebController {

    private final HotelService hotelService;

    public HotelWebController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/registrarHotel")
    public String registrarHotel(@ModelAttribute Hotel hotel, Model model) {
        if (hotelService.exists(hotel.getName(), hotel.getCity())) {
            model.addAttribute("mensaje", "Ya existe un hotel con ese nombre en esa ciudad.");
        } else {
            hotelService.addHotel(hotel);
            model.addAttribute("mensaje", "Hotel registrado exitosamente.");
        }
        return "registerhotel";
    }

    @GetMapping("/editarHotel")
    public String mostrarFormularioEditar(@RequestParam String name,
                                          @RequestParam String city,
                                          Model model) {
        Hotel hotel = hotelService.findHotel(name, city);
        if (hotel != null) {
            model.addAttribute("hotel", hotel);
            return "editHotel";         } else {
            model.addAttribute("mensaje", "Hotel no encontrado.");
            return "index"; 
        }
    }

    @PostMapping("/editarHotel")
    public String editarHotel(@ModelAttribute Hotel updatedHotel, Model model) {
        boolean updated = hotelService.editHotel(updatedHotel);
        if (updated) {
            model.addAttribute("mensaje", "✏️ Hotel actualizado correctamente.");
        } else {
            model.addAttribute("mensaje", "⚠️ No se encontró el hotel a editar.");
        }
        return "editHotel"; 
    }

    @GetMapping("/buscarHotel")
    public String buscarHotel(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String city,
                              Model model) {
        List<Hotel> resultados = hotelService.searchFlexible(name, city);
        model.addAttribute("hoteles", resultados);
        return "buscarHotel";
    }

    @GetMapping("/cambiarEstado")
    public String cambiarEstado(@RequestParam String name,
                                 @RequestParam String city,
                                 Model model) {
        boolean cambiado = hotelService.toggleStatus(name, city);
        model.addAttribute("mensaje", cambiado ?
                "✅ Estado del hotel actualizado." :
                "⚠️ Hotel no encontrado para cambiar estado.");
        return "index"; 
    }
}
