package co.kahveci.cinemaRoomRestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controller {
    Cinema cinema = new Cinema(9,9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody Seat seat) {
        if ((seat.getColumn() < 1 || seat.getColumn() > cinema.getTotalColumns()) || seat.getRow() < 1 || seat.getRow() > cinema.getTotalRows()) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        } else if (cinema.getPurchasedSeats().contains(seat.getSeatId())) {
            return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        } else {
            cinema.setPurchasedSeats(seat.getSeatId());
            cinema.setAvailableSeats(seat);
            return new ResponseEntity<>(seat, HttpStatus.OK);
        }
    }
}
