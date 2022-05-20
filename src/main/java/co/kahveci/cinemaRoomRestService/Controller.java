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
            cinema.addToPurchasedSeats(seat.getSeatId());
            cinema.removeFromAvailableSeats(seat);
            Ticket ticket = new Ticket(seat);
            cinema.addToPurchasedTickets(ticket);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody String token) {
        if (cinema.getPurchasedTickets().containsKey(token)) {
            Seat seat = cinema.getPurchasedTickets().get(token);
            cinema.returnSeat(seat);
            cinema.addToAvailableSeats(seat);
            cinema.removeFromPurchasedTickets(token);
            return new ResponseEntity<>(Map.of("returned_ticket", seat), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "Wrong Token!"), HttpStatus.BAD_REQUEST);
        }
    }

}
