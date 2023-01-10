package cat.itacademy.barcelonactiva.v2.moreno.perez.pilar.s05.t01.n03.model.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cat.itacademy.barcelonactiva.v2.moreno.perez.pilar.s05.t01.n03.model.dto.FlorDTO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class FlorService {
	
	private final RestTemplate restTemplate;
	
	public List<FlorDTO> llistaFlors() {
		FlorDTO[] response = restTemplate.getForObject("http://localhost:9001/flor/getAll", FlorDTO[].class);
		
		return Arrays.asList(response);
	}
	
	public FlorDTO getFlorDTOById(int id) {
		FlorDTO florDTO = restTemplate.getForObject("http://localhost:9001/flor/getOne/" + id, FlorDTO.class);
		
		return florDTO;
		
	}
	
	public void saveFlorDTO(FlorDTO florDTO) {
		restTemplate.postForObject("http://localhost:9001/flor/add", florDTO, FlorDTO.class);
	}
	
	public void updateFlorDTO(FlorDTO florDTO, int idFlor) {
		restTemplate.put("http://localhost:9001/flor/update/"+idFlor, florDTO);
		
	}
	
	public void deleteFlorById(int id) {
		restTemplate.delete("http://localhost:9001/flor/delete/"+id);
	}
}
