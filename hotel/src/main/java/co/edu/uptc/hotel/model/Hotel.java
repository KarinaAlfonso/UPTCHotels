package co.edu.uptc.hotel.model;

public class Hotel {
    private String name;
    private String city;
    private String address;
    private String phone;
    private String email;
    private int roomCapacity;
    private boolean active = true;

    public Hotel() {
    }

    public Hotel(String name, String city, String address, String phone, String email, int roomCapacity) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.roomCapacity = roomCapacity;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setStatus(String status) {
    this.active = status.equalsIgnoreCase("activo");
}

public String getStatus() {
    return active ? "activo" : "inactivo";
}

}
