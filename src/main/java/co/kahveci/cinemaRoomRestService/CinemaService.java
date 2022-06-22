package co.kahveci.cinemaRoomRestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.Objects;

public class CinemaService {
    static Cinema cinema = new Cinema(9,9);

    static ResponseEntity<?> purchase(Seat seat) {
        if (cinema.isSeatOutOfRange(seat)) {
            return new ResponseEntity<>(
                    Map.of("error", "The number of a row or a column is out of bounds!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (cinema.getPurchasedSeats().contains(seat.getSeatId())) {
            return new ResponseEntity<>(
                    Map.of("error", "The ticket has been already purchased!"),
                    HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = new Ticket(seat);
        cinema.buyTicket(seat, ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    static ResponseEntity<?> returnTicket(String token) {
        if (!cinema.getPurchasedTickets().containsKey(token)) {
            return new ResponseEntity<>(
                    Map.of("error", "Wrong Token!"),
                    HttpStatus.BAD_REQUEST);
        }

        Seat seat = cinema.getPurchasedTickets().get(token);
        cinema.returnTicket(seat, token);
        return new ResponseEntity<>(
                Map.of("returned_ticket", seat),
                HttpStatus.OK);
    }

    static ResponseEntity<?> getStats(Map requestBody) {
        String password = (String) requestBody.get("password");

        if (!Objects.equals(password, "super_secret")) {
            return new ResponseEntity<>(
                    Map.of("error", "The password is wrong!"),
                    HttpStatus.UNAUTHORIZED);
        }

        StatsChecker stats = new StatsChecker(
                cinema.getCurrentIncome(),
                cinema.getAvailableSeats().size(),
                cinema.getPurchasedSeats().size());

        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}
