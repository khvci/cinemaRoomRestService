package co.kahveci.cinemaRoomRestService;

import java.util.UUID;

public class Ticket {
    private String token;
    private Seat seat;


    public Ticket(Seat seat) {
        this.token = (UUID.randomUUID().toString());
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }


    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }



}