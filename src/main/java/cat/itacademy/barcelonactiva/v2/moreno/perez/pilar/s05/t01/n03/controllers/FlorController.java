package cat.itacademy.barcelonactiva.v2.moreno.perez.pilar.s05.t01.n03.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.v2.moreno.perez.pilar.s05.t01.n03.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.v2.moreno.perez.pilar.s05.t01.n03.model.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/flor")
public class FlorController {

	@Autowired
	private FlorService florService;
	
	@Operation(summary = "Retorna totes les flors de Flors API")
	@GetMapping("/clientFlorsAll")
	public ResponseEntity<List<FlorDTO>> getAllFlors(){
		try {
			List<FlorDTO> flors = florService.llistaFlors();
			if(flors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<FlorDTO>>(flors, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Retorna una flor segons el seu id")
	@GetMapping("/clientFlorsGetOne/{id}")
	public ResponseEntity<FlorDTO> getOneFlor(@PathVariable("id") Integer idFlor){
		try {
			FlorDTO florDTO = florService.getFlorDTOById(idFlor);
			return new ResponseEntity<>(florDTO, HttpStatus.OK);
		}catch (Exception e){
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Guarda una flor a la BD")
	@PostMapping("/clientFlorsAdd")
	public ResponseEntity<String> saveFlor(@RequestBody FlorDTO florDTO) {
		try {
			florService.saveFlorDTO(florDTO);
			return new ResponseEntity<>("Flor emmagatzemada exitosament", HttpStatus.CREATED);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Operation(summary = "Actualitza una flor segons el seu id")
	@PutMapping("/clientFlorsUpdate/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> updateFlor(@RequestBody FlorDTO florDTO, @PathVariable("id") Integer idFlor) {		
		try {
			florService.updateFlorDTO(florDTO, idFlor);
			return new ResponseEntity<>("Flor actualitzada", HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(summary = "Elimina una flor segons el seu id")
	@DeleteMapping("/clientFlorsDelete/{id}")
	public ResponseEntity<String> deleteFlor(@PathVariable("id") Integer idFlor) {
    	try {
    		florService.deleteFlorById(idFlor);
    		return new ResponseEntity<>("Flor eliminada", HttpStatus.OK);
    	}catch (Exception e) {
    		return new ResponseEntity<>("No existeix l'id",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
