package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	private List<ClientDTO> clients = new ArrayList<>();

	@PostMapping("/add-default")
	public void addDefault() {

		ClientDTO cl1 = new ClientDTO("macalister@senac.com", "Macalister", "21/10/2003");
		clients.add(0, cl1);

		ClientDTO cl2 = new ClientDTO("carlos@senac.com", "Carlos", "14/11/2001");
		clients.add(1, cl2);

		ClientDTO cl3 = new ClientDTO("joão@senac.com", "João", "02/09/2003");
		clients.add(2, cl3);

	}

	@GetMapping("/list")

	public List<ClientDTO> list() {
		return this.clients;

	}

	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> clientDeteils(@PathVariable final int id) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ClientDTO client = clients.get(id);
		if (client.equals(ClientDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> removeClient(@PathVariable final Long id) {
		if (id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO client = clients.remove(index);
		return new ResponseEntity<>(client, HttpStatus.OK);

	}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(list().size() - 1);
		return id;

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO updateClient){
		if(id >= clients.size() || id < 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO oldClient = clients.remove(index);
		clients.add(index, updateClient);
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
	}
	
}
