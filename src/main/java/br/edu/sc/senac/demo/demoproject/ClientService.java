package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ClientService {

	@GetMapping("/list")
	public List<ClientDTO> list() {
		ArrayList<ClientDTO> list = new ArrayList<ClientDTO>();

		ClientDTO cl1 = new ClientDTO(Long.valueOf(0), "Ricardo", "28/05/2007");
		list.add(0, cl1);
		ClientDTO cl2 = new ClientDTO(Long.valueOf(1), "Luiz", "15/08/2001");
		list.add(1, cl2);
		ClientDTO cl3 = new ClientDTO(Long.valueOf(2), "Paulo", "14/04/1979");
		list.add(2, cl3);

		return list;
	}

	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> clientDeteils(@PathVariable final int id) {
		ClientDTO client = list().get(id);
		if (client.equals(ProductDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
}