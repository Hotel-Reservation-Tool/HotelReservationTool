package res.tool.hotel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@NoArgsConstructor
@Table("client")
public class Client {
    @Id
    private @Column("id") String id = UUID.randomUUID().toString();
    @Column("name")
    private String name;
    @Column("mobile")
    private String mobile;
    @Column("email")
    private String email;

    public Client(String name, String mobile, String email){
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
}
