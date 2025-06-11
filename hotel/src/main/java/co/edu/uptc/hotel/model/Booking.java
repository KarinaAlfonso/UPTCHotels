package co.edu.uptc.hotel.model;

import java.time.LocalDate;

public class Booking {
    private String hotelName;
    private String hotelCity;
    private String clientName;
    private String clientId;
    private String clientEmail;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status; // Registered, Cancelled, Check-in, Check-out, Finalized

    public Booking() {}

    public Booking(String hotelName, String hotelCity, String clientName,
                   String clientId, String clientEmail, LocalDate checkInDate,
                   LocalDate checkOutDate) {
        this.hotelName = hotelName;
        this.hotelCity = hotelCity;
        this.clientName = clientName;
        this.clientId = clientId;
        this.clientEmail = clientEmail;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = "Registered";
    }

    // Getters and setters
    public String getHotelName() { return hotelName; }
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public String getHotelCity() { return hotelCity; }
    public void setHotelCity(String hotelCity) { this.hotelCity = hotelCity; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
