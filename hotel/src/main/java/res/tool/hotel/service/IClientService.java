package res.tool.hotel.service;

import res.tool.hotel.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    List<Client> selectAll();

    Client getClientByEmail(String email);

    Client getClientById(String id);

    List<Client> getLoggedInClients();

    int updateClientLoginState(Boolean state, String cId);

    int createClient(Client client);

    int updateClient(Client client, String id);
}