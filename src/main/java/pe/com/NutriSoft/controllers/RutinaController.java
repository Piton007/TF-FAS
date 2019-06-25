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

import pe.com.NutriSoft.entities.Rutina;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.IRutinaService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/rutina")
@Api(tags = "Rutina", value = "Servicio Web RESTFul de Rutinas")
public class RutinaController {
	@Autowired
	private IRutinaService rutinaService;
	
	@PostMapping
	@ApiOperation(value = "Crear Rutina", notes = "Servicio para crear una Rutina")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Rutina creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Rutina> registrar(@Valid @RequestBody Rutina rutina){
		
		Rutina rutinaNew=new Rutina();
		rutinaNew=rutinaService.registrar(rutina);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_rutina}").buildAndExpand(rutinaNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar rutina ", notes = "Servicio para actualizar un Rutina")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Rutina actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Rutina no encontrado")})
	public ResponseEntity<Rutina> actualizar(@Valid @RequestBody Rutina rutina){
		
		rutinaService.modificar(rutina);
		return new ResponseEntity<Rutina>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar Rutina", notes = "Servicio para eliminar un Rutina")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Rutina eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Rutina no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		Rutina plan= rutinaService.getOne(id);
		if(plan!=null) 
			rutinaService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Rutinas", notes = "Servicio para listar a todos los Rutinas")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Rutinas  encontrados"),
						  @ApiResponse(code = 404, message = "Rutinas no encontrados")})
	public ResponseEntity<List<Rutina>> listar(){
		List<Rutina> planes=new ArrayList<Rutina>();
		planes=rutinaService.listar();
		
		return new ResponseEntity<List<Rutina>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar Rutina por Id", notes = "Servicio para obtner Rutina por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Rutina encontrado"),
						  @ApiResponse(code = 404, message = "Rutina no encontrado")})
	public ResponseEntity<Rutina> listarPorId(@PathVariable("cod_plan") Integer id){
		Rutina plan=rutinaService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Rutina>(plan,HttpStatus.OK);
	}

}
