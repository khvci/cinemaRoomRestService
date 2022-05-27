package co.kahveci.cinemaRoomRestService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;

public class Cinema {
    private final int totalRows;
    private final int totalColumns;
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

    public void buyTicket(Seat seat, Ticket ticket) {
        purchasedSeats.add(seat.getSeatId());
        availableSeats.removeIf(s -> seat.getSeatId() == s.getSeatId());
        purchasedTickets.put(ticket.getToken(), ticket.getSeat());
    }

    public void returnTicket(Seat seat, String token) {
        purchasedTickets.remove(token);
        availableSeats.add(seat);
        purchasedSeats.removeIf(s -> s == seat.getSeatId());
        Collections.sort(availableSeats);
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

    public ArrayList<Integer> getPurchasedSeats() {
        return purchasedSeats;
    }

    public Map<String, Seat> getPurchasedTickets() {
        return purchasedTickets;
    }

    public boolean isSeatOutOfRange(Seat seat) {
        if (seat.getColumn() < 1 || seat.getColumn() > totalColumns) {
            return true;
        }
        return seat.getRow() < 1 || seat.getRow() > totalRows;
    }
}
