package res.tool.hotel.controller;

import res.tool.hotel.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
