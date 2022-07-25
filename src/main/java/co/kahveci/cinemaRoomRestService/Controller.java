package co.kahveci.cinemaRoomRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    CinemaService cinemaService;
    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinemaService.cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody Seat seat) {
        return cinemaService.purchase(seat);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestParam String token) {
        return cinemaService.returnTicket(token);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestBody Map requestBody) {
        return cinemaService.getStats(requestBody);
    }
}
