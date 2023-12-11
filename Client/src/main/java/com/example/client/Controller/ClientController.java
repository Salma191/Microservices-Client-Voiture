package com.example.client.Controller;

import com.example.client.Model.Client;
import com.example.client.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository ;
    @GetMapping("/clients")
    public List chercherClients(){
        return clientRepository.findAll();
    }
    @GetMapping("/client/{id}")
    public Client chercherUnClients (@PathVariable Long id) throws Exception{

        return this.clientRepository.findById(id).orElseThrow(()-> new Exception("Client inexistnt"));}

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "JALAOUI Salma", Float.parseFloat("21")));
            clientRepository.save(new Client(Long.parseLong("2"), "MERJANE Wiam", Float.parseFloat("21")));
            clientRepository.save(new Client(Long.parseLong("3"), "JALAOUI Marwa", Float.parseFloat("18")));

        };
    }

}
