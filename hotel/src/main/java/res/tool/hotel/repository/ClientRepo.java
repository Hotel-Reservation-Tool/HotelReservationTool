package res.tool.hotel.repository;

import res.tool.hotel.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Client> selectAllClients(){
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }
}
