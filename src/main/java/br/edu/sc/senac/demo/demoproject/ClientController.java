package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	List<ClientDTO> clients = new ArrayList<>();

	List<ClientDTO> getAllClients() {
		return clients;
	}

	Long insertClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}

	ResponseEntity <ClientDTO> getClient(Long id) {
		if (id >= clients.size()|| id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO client = clients.remove(index);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	
}
