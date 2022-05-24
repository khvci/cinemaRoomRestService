package co.kahveci.cinemaRoomRestService;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

public class Cinema {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;
    @JsonIgnore
    private Map<String, Seat> purchasedTickets;

    @JsonIgnore
    private ArrayList<Integer> purchasedSeats;

    public Cinema(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        this.availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                Seat seat = new Seat(i, j);
                availableSeats.add(seat);
            }
        }
        this.purchasedTickets = new TreeMap<>();
        this.purchasedSeats = new ArrayList<>();
    }

    public int getTotalRows() {
        return totalRows;
    }


    public int getTotalColumns() {
        return totalColumns;
    }


    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void removeFromAvailableSeats(Seat seat) {
        availableSeats.removeIf(s -> seat.getSeatId() == s.getSeatId());

    }
    public void addToAvailableSeats(Seat seat) {
        availableSeats.add(seat);
    }

    public void returnSeat(Seat seat) {
        availableSeats.add(seat);
    }

    public ArrayList<Integer> getPurchasedSeats() {
        return purchasedSeats;
    }

    public void addToPurchasedSeats(int seatId) {
        this.purchasedSeats.add(seatId);
    }

    public void addToPurchasedTickets(Ticket ticket) {
        purchasedTickets.put(ticket.getToken(), ticket.getSeat());
    }

    public Map<String, Seat> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void removeFromPurchasedTickets(String token) {
        purchasedTickets.remove(token);
    }

    public void sortAvailableSeats() {
        Collections.sort(availableSeats);
    }


}
