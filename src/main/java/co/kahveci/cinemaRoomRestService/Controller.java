package co.kahveci.cinemaRoomRestService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class Controller {
    Cinema cinema = new Cinema(9,9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public Seat purchaseSeat(@RequestBody Seat seat) {
        if ((seat.getColumn() < 1 || seat.getColumn() > cinema.getTotalColumns()) || seat.getRow() < 1 || seat.getRow() > cinema.getTotalRows()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The number of a row or a column is out of bounds!");
        } else if (cinema.getPurchasedSeats().contains(seat.getSeatId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The ticket has been already purchased!");
        } else {
            cinema.setPurchasedSeats(seat.getSeatId());
            cinema.setAvailableSeats(seat);
            return seat;
        }
    }
}
