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

import pe.com.NutriSoft.entities.Dieta;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.IDietaService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/dietaCalorica")
@Api(tags = "DietaCalorica", value = "Servicio Web RESTFul de DietaCalorica")
public class DietaController {
	@Autowired
	private IDietaService dietaService;
	
	@PostMapping
	@ApiOperation(value = "Crear Dieta", notes = "Servicio para crear una Dieta")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Dieta creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Dieta> registrar(@Valid @RequestBody Dieta Dieta){
		
		Dieta DietaNew=new Dieta();
		DietaNew=dietaService.registrar(Dieta);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_Dieta}").buildAndExpand(DietaNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Dieta ", notes = "Servicio para actualizar un Dieta")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Dieta actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Dieta no encontrado")})
	public ResponseEntity<Dieta> actualizar(@Valid @RequestBody Dieta Dieta){
		
		dietaService.modificar(Dieta);
		return new ResponseEntity<Dieta>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar Dieta", notes = "Servicio para eliminar un Dieta")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Dieta eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Dieta no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		Dieta plan= dietaService.getOne(id);
		if(plan!=null) 
			dietaService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Dietas", notes = "Servicio para listar a todos los Dietas")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Dietas  encontrados"),
						  @ApiResponse(code = 404, message = "Dietas no encontrados")})
	public ResponseEntity<List<Dieta>> listar(){
		List<Dieta> planes=new ArrayList<Dieta>();
		planes=dietaService.listar();
		
		return new ResponseEntity<List<Dieta>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar Dieta por Id", notes = "Servicio para obtner Dieta por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Dieta encontrado"),
						  @ApiResponse(code = 404, message = "Dieta no encontrado")})
	public ResponseEntity<Dieta> listarPorId(@PathVariable("cod_plan") Integer id){
		Dieta plan=dietaService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Dieta>(plan,HttpStatus.OK);
	}
	
	
	
}
