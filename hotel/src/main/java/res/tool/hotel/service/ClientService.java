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
}
