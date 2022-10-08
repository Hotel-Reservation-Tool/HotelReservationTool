package res.tool.hotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Client {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String mobile;

    public Client(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }
}
