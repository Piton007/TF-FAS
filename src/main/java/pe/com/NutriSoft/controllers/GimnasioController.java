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

import pe.com.NutriSoft.entities.Gimnasio;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.IGimnasioService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/api/gimnasio")
@Api(tags = "Gimnasio", value = "Servicio Web RESTFul de Gimnasio")
public class GimnasioController {
	@Autowired
	private IGimnasioService gimnasioService;
	
	@PostMapping
	@ApiOperation(value = "Crear Gimnasio", notes = "Servicio para crear una Gimnasio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Gimnasio creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Gimnasio> registrar(@Valid @RequestBody Gimnasio Gimnasio){
		
		Gimnasio GimnasioNew=new Gimnasio();
		GimnasioNew=gimnasioService.registrar(Gimnasio);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_Gimnasio}").buildAndExpand(GimnasioNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Gimnasio ", notes = "Servicio para actualizar un Gimnasio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Gimnasio actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Gimnasio no encontrado")})
	public ResponseEntity<Gimnasio> actualizar(@Valid @RequestBody Gimnasio Gimnasio){
		
		gimnasioService.modificar(Gimnasio);
		return new ResponseEntity<Gimnasio>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar Gimnasio", notes = "Servicio para eliminar un Gimnasio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Gimnasio eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Gimnasio no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		Gimnasio plan= gimnasioService.getOne(id);
		if(plan!=null) 
			gimnasioService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Gimnasios", notes = "Servicio para listar a todos los Gimnasios")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Gimnasios  encontrados"),
						  @ApiResponse(code = 404, message = "Gimnasios no encontrados")})
	public ResponseEntity<List<Gimnasio>> listar(){
		List<Gimnasio> planes=new ArrayList<Gimnasio>();
		planes=gimnasioService.listar();
		
		return new ResponseEntity<List<Gimnasio>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar Gimnasio por Id", notes = "Servicio para obtner Gimnasio por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Gimnasio encontrado"),
						  @ApiResponse(code = 404, message = "Gimnasio no encontrado")})
	public ResponseEntity<Gimnasio> listarPorId(@PathVariable("cod_plan") Integer id){
		Gimnasio plan=gimnasioService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Gimnasio>(plan,HttpStatus.OK);
	}

}
