package pe.com.NutriSoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.swagger.annotations.Api;
import java.net.URI;
import java.util.ArrayList;

import pe.com.NutriSoft.entities.Nutricionista;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.INutricionistaService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/api/nutricionista")
@Api(tags = "Nutricionista", value = "Servicio Web RESTFul de Nutricionista")
public class NutricionistaController {
	@Autowired
    private INutricionistaService nutricionistaService;
	
	@PostMapping
	@ApiOperation(value = "Crear Nutricionista", notes = "Servicio para crear una Nutricionista")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Nutricionista creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Nutricionista> registrar(@Valid @RequestBody Nutricionista nutricionista){
		
		Nutricionista nutricionistaNew=new Nutricionista();
		nutricionistaNew=nutricionistaService.registrar(nutricionista);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_Nutricionista}").buildAndExpand(nutricionistaNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Nutricionista ", notes = "Servicio para actualizar un Nutricionista")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Nutricionista actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Nutricionista no encontrado")})
	public ResponseEntity<Nutricionista> actualizar(@Valid @RequestBody Nutricionista nutricionista){
		
		nutricionistaService.modificar(nutricionista);
		return new ResponseEntity<Nutricionista>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar Nutricionista", notes = "Servicio para eliminar un Nutricionista")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Nutricionista eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Nutricionista no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		Nutricionista plan= nutricionistaService.getOne(id);
		if(plan!=null) 
			nutricionistaService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Nutricionistas", notes = "Servicio para listar a todos los Nutricionistas")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Nutricionistas  encontrados"),
						  @ApiResponse(code = 404, message = "Nutricionistas no encontrados")})
	public ResponseEntity<List<Nutricionista>> listar(){
		List<Nutricionista> planes=new ArrayList<Nutricionista>();
		planes=nutricionistaService.listar();
		
		return new ResponseEntity<List<Nutricionista>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar Nutricionista por Id", notes = "Servicio para obtner Nutricionista por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Nutricionista encontrado"),
						  @ApiResponse(code = 404, message = "Nutricionista no encontrado")})
	public ResponseEntity<Nutricionista> listarPorId(@PathVariable("cod_plan") Integer id){
		Nutricionista plan=nutricionistaService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Nutricionista>(plan,HttpStatus.OK);
	}
}
