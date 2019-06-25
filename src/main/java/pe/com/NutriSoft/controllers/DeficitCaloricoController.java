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
import pe.com.NutriSoft.exception.ModelNotFoundException;
import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import pe.com.NutriSoft.entities.DeficitCalorico;
import pe.com.NutriSoft.service.IDeficitCaloricoService;

@RestController
@RequestMapping("/api/defcalorico")
@Api(tags = "DefCalorico", value = "Servicio Web RESTFul de DeficitCalorico")
public class DeficitCaloricoController {
	
	@Autowired
	private IDeficitCaloricoService deficitCaloricoService;

	@PostMapping
	@ApiOperation(value = "Crear Deficit Calorico", notes = "Servicio para crear un DeficitCalorico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "DeficitCalorico creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<DeficitCalorico> registrar(@Valid @RequestBody DeficitCalorico deficit){
		
		DeficitCalorico deficitNew=new DeficitCalorico();
		deficitNew=deficitCaloricoService.registrar(deficit);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_deficit}").buildAndExpand(deficitNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar DeficitCalorico", notes = "Servicio para actualizar un DeficitCalorico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Deficit Calorico actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Deficit Calorico no encontrado")})
	public ResponseEntity<DeficitCalorico> actualizar(@Valid @RequestBody DeficitCalorico deficit){
		
		deficitCaloricoService.modificar(deficit);
		return new ResponseEntity<DeficitCalorico>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_deficit}")
	@ApiOperation(value = "Eliminar Almacen", notes = "Servicio para eliminar un almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacen eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Almacen no encontrado")})
	public void eliminar(@PathVariable("cod_deficit") Integer id) {
		
		DeficitCalorico deficit= deficitCaloricoService.getOne(id);
		if(deficit!=null) 
			deficitCaloricoService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Deficits Caloricos", notes = "Servicio para listar a todos los deficits caloricos")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Deficits  encontrados"),
						  @ApiResponse(code = 404, message = "Deficits no encontrados")})
	public ResponseEntity<List<DeficitCalorico>> listar(){
		List<DeficitCalorico> deficits=new ArrayList<DeficitCalorico>();
		deficits=deficitCaloricoService.listar();
		
		return new ResponseEntity<List<DeficitCalorico>>(deficits,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_deficit}")
	@ApiOperation(value = "Listar DeficitCalorico por Id", notes = "Servicio para obtner DeficitCalorico por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacen encontrado"),
						  @ApiResponse(code = 404, message = "Almacen no encontrado")})
	public ResponseEntity<DeficitCalorico> listarPorId(@PathVariable("cod_almacen") Integer id){
		DeficitCalorico deficit=deficitCaloricoService.getOne(id);
		
		if(deficit==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<DeficitCalorico>(deficit,HttpStatus.OK);
	}
}
