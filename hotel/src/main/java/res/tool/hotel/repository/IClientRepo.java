package res.tool.hotel.repository;

import res.tool.hotel.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepo {

    public List<Client> selectAllClients();

    public Client getClientByEmail(String email);

    public Client getClientById(String id);

    public List<Client> getLoggedInClients();

    public int updateClientLoginState(Boolean loginState, String cId);

    public int createClient(Client client);

    public int editClient(Client client, String id);
}
