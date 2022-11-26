package res.tool.hotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table("reservation")
public class Reservation {
    @Id
    private @Column("reservationid")
    String reservationId = UUID.randomUUID().toString();
    private @Column("clientid")
    String clientId;
    private @Column("start_date")
    Date start_date;
    private @Column("end_date")
    Date end_date;

    @OneToMany(mappedBy = "reservation")
    List<Room> rooms;

    public Reservation(String reservationId, String clientId, Date start_date, Date end_date){
        this.reservationId = reservationId;
        this.clientId = clientId;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Reservation(String clientId, Date start_date, Date end_date) {
        this.clientId = clientId;
        this.start_date = start_date;
        this.end_date = end_date;
    }
}
