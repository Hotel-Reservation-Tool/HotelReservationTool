package res.tool.hotel.controller;

import org.springframework.web.bind.annotation.*;
import res.tool.hotel.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import res.tool.hotel.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> selectAllClients(){
        return service.selectAll();
    }

    @GetMapping("/getByEmail")
    public Client getByEmail(String email){
        return service.getClientByEmail(email);
    }

    @GetMapping("/getLoggedInClients")
    public List<Client> getLoggedInClients(){
        return service.getLoggedInClients();
    };

    @PutMapping("/updateClientLoginState")
    public int updateClientLoginState(Boolean state, String cId){
        return service.updateClientLoginState(state, cId);
    }

    @PostMapping("/createClient")
    public void createClient(@RequestBody Client client){
        service.createClient(client);
    }
}
