package co.kahveci.cinemaRoomRestService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Ticket {
    private UUID token;
    private Seat ticket;
    @JsonIgnore
    private static Map<UUID, Seat> purchasedTickets = new HashMap<>();

    public Ticket(Seat seat) {
        this.token = UUID.randomUUID();
        this.ticket = seat;
    }

    public UUID getToken() {
        return token;
    }

    public void addToPurchasedTickets(Seat seat) {
        purchasedTickets.put(this.token, seat);
    }

    public static void removeFromPurchasedTickets(UUID token) {
        Ticket.purchasedTickets.remove(token);
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public static Map<UUID, Seat> getPurchasedTickets() {
        return purchasedTickets;
    }

    public static void setPurchasedTickets(Map<UUID, Seat> purchasedTickets) {
        Ticket.purchasedTickets = purchasedTickets;
    }
}
