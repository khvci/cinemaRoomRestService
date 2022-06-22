package co.kahveci.cinemaRoomRestService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/seats")
    public Cinema getSeats() {
        return CinemaService.cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody Seat seat) {
        return CinemaService.purchase(seat);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestParam String token) {
        return CinemaService.returnTicket(token);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> getStats(@RequestBody Map requestBody) {
        return CinemaService.getStats(requestBody);
    }
}
