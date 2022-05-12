package co.kahveci.cinemaRoomRestService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;

    @JsonIgnore
    private ArrayList<Integer> purchasedSeats = new ArrayList<>();

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
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
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
}
