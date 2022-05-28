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
        if (cinema.isSeatOutOfRange(seat)) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }

        if (cinema.getPurchasedSeats().contains(seat.getSeatId())) {
            return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = new Ticket(seat);
        cinema.buyTicket(seat, ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestParam String token) {
        if (!cinema.getPurchasedTickets().containsKey(token)) {
            return new ResponseEntity<>(Map.of("error", "Wrong Token!"), HttpStatus.BAD_REQUEST);
        }

        Seat seat = cinema.getPurchasedTickets().get(token);
        cinema.returnTicket(seat, token);
        return new ResponseEntity<>(Map.of("returned_ticket", seat), HttpStatus.OK);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestBody String password) {
        password = password
                .split("password\": \"")[1]
                .split("\"")[0];

        if (!password.equals("super_secret")) {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }

        StatsChecker stats = new StatsChecker(
                cinema.getCurrentIncome(),
                cinema.getAvailableSeats().size(),
                cinema.getPurchasedSeats().size());

        return new ResponseEntity<>(stats, HttpStatus.OK);

    }
}
