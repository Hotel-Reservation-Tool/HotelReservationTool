package res.tool.hotel.service;

import res.tool.hotel.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import res.tool.hotel.repository.ClientRepo;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public List<Client> selectAll() {
        return clientRepo.selectAllClients();
    }

    public Client getClientByEmail(String email) { return clientRepo.getClientByEmail(email); }

    public Client getClientById(String id) { return clientRepo.getClientById(id); }

    public List<Client> getLoggedInClients() { return clientRepo.getLoggedInClients();}

    public int updateClientLoginState(Boolean state, String cId) { return clientRepo.updateClientLoginState(state, cId); }

    public int createClient(Client client){ return clientRepo.createClient(client); }

    public int updateClient(Client client, String id) {
        return clientRepo.editClient(client, id);
    }
}
