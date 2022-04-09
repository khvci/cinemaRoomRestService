package co.kahveci.cinemaRoomRestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Cinema cinema = new Cinema(9,9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }
}
