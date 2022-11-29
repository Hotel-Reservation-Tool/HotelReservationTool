package res.tool.hotel.repository;

import res.tool.hotel.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepo implements IClientRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Client> selectAllClients(){
        String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public Client getClientByEmail(String email) {
        String sql = "SELECT * FROM client WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Client.class), email);
    }

    public Client getClientById(String id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Client.class), id);
    }

    public List<Client> getLoggedInClients() {
        String sql = "SELECT * FROM client WHERE isLoggedIn = 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    public int updateClientLoginState(Boolean loginState, String cId){
        String insertClient = "UPDATE hotel.client SET isLoggedIn = ? WHERE id = ?";
        return jdbcTemplate.update(insertClient, loginState, cId);
    }

    public int createClient(Client client){
        String insertClient = "insert into client(id, name, mobile, email, password, isloggedin) values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(insertClient, client.getId(), client.getName(), client.getMobile(), client.getEmail(), client.getPassword(), client.getIsLoggedIn());
    }

    public int editClient(Client client, String id){
        String sql = "update client set name=?, mobile=?, email=?, password=?, isLoggedIn=? where id=?";
        return jdbcTemplate.update(sql, client.getName(), client.getMobile(), client.getEmail(),
                client.getPassword(), client.getIsLoggedIn(), id);
    }
}
