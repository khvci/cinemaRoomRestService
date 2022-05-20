package co.kahveci.cinemaRoomRestService;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private int row;
    private int column;
    private final int price;
    @JsonIgnore
    private final int seatId;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.seatId = seatIdGenerator(row, column);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public int getSeatId() {
        return seatId;
    }
    int seatIdGenerator(int row, int column) {
        return row * 10 + column;
    }
}


