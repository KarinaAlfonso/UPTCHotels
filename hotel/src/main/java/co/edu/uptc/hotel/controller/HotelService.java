package co.edu.uptc.hotel.controller;
import co.edu.uptc.hotel.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private List<Hotel> hotels = new ArrayList<>();

    public boolean addHotel(Hotel hotel) {
        if (exists(hotel.getName(), hotel.getCity())) {
            return false; 
        }
        hotels.add(hotel);
        return true;
    }

    public boolean exists(String name, String city) {
        return hotels.stream()
                .anyMatch(h -> h.getName().equalsIgnoreCase(name) &&
                               h.getCity().equalsIgnoreCase(city));
    }

    public Hotel findHotel(String name, String city) {
        return hotels.stream()
                .filter(h -> h.getName().equalsIgnoreCase(name) &&
                             h.getCity().equalsIgnoreCase(city))
                .findFirst()
                .orElse(null);
    }

    public boolean editHotel(Hotel updatedHotel) {
        Hotel hotel = findHotel(updatedHotel.getName(), updatedHotel.getCity());
        if (hotel != null) {
            hotel.setAddress(updatedHotel.getAddress());
            hotel.setPhone(updatedHotel.getPhone());
            hotel.setEmail(updatedHotel.getEmail());
            hotel.setRoomCapacity(updatedHotel.getRoomCapacity());
            hotel.setActive(updatedHotel.isActive());
            return true;
        }
        return false;
    }

    public boolean toggleStatus(String name, String city) {
        Hotel hotel = findHotel(name, city);
        if (hotel != null) {
            hotel.setActive(!hotel.isActive());
            return true;
        }
        return false;
    }

    public List<Hotel> search(String name, String city) {
        return hotels.stream()
                .filter(h -> h.getName().equalsIgnoreCase(name) &&
                             h.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Hotel> searchFlexible(String name, String city) {
        return hotels.stream()
                .filter(h -> (name == null || h.getName().equalsIgnoreCase(name)) &&
                             (city == null || h.getCity().equalsIgnoreCase(city)))
                .collect(Collectors.toList());
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
}
