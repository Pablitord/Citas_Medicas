package ec.webmarket.restful.api.v1;

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
import org.springframework.web.bind.annotation.RestController;

import ec.webmarket.restful.dto.v1.OdontologoDTO;
import ec.webmarket.restful.dto.v1.PacienteDTO;
import ec.webmarket.restful.security.ApiResponseDTO;
import ec.webmarket.restful.service.crud.OdontologoService;
import ec.webmarket.restful.service.crud.PacienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1.1/pacientes")

public class PacienteController {
	
	@Autowired
	private PacienteService entityService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findAll(new PacienteDTO())), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PacienteDTO dto){
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.create(dto)), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody PacienteDTO dto){
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.update(dto)), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/archivo/id")
	public ResponseEntity<?> getById(@Valid @PathVariable Long id){
		PacienteDTO dto = new PacienteDTO();
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.find(dto)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
	    PacienteDTO dto = new PacienteDTO();
	    dto.setId(id);
	    entityService.delete(dto);
	    return new ResponseEntity<>(new ApiResponseDTO<>(true, "Paciente eliminado correctamente"), HttpStatus.OK);
	}

}
