package res.tool.hotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@Table("room")
public class Room {
    private String roomId = UUID.randomUUID().toString();
    private int size;
    private int max_ppl;
    private int price;

    public Room(String roomId, int size, int max_ppl, int price) {
        this.roomId = roomId;
        this.size = size;
        this.max_ppl = max_ppl;
        this.price = price;
    }
}
