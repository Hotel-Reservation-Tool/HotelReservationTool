package res.tool.hotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("reservation_helper")
public class ReservationHelper {

    private @Column("reservationid")
    String reservationId;
    private @Column("roomdId")
    String roomId;

    public ReservationHelper(String reservationId, String roomId){
        this.reservationId = reservationId;
        this.roomId = roomId;
    }
}
