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

import pe.com.NutriSoft.entities.PlanCalorico;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.IPlanCaloricoService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/plancalorico")
@Api(tags = "PlanCalorico", value = "Servicio Web RESTFul de PlanCalorico")
public class PlanCaloricoController {
	
	@Autowired
	private IPlanCaloricoService planCaloricoService;
	
	@PostMapping
	@ApiOperation(value = "Crear Plan Calorico", notes = "Servicio para crear un PlanCalorico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Plan Calorico creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<PlanCalorico> registrar(@Valid @RequestBody PlanCalorico plan){
		
		PlanCalorico planNew=new PlanCalorico();
		planNew=planCaloricoService.registrar(plan);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_plan}").buildAndExpand(planNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Plan Calorico", notes = "Servicio para actualizar un Plan Calorico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Plan Calorico actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Plan Calorico no encontrado")})
	public ResponseEntity<PlanCalorico> actualizar(@Valid @RequestBody PlanCalorico plan){
		
		planCaloricoService.modificar(plan);
		return new ResponseEntity<PlanCalorico>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar Plan Calorico", notes = "Servicio para eliminar un plan calorico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Plan calorico eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Plan calorico no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		PlanCalorico plan= planCaloricoService.getOne(id);
		if(plan!=null) 
			planCaloricoService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Planes Caloricos", notes = "Servicio para listar a todos los planes caloricos")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Planes Caloricos  encontrados"),
						  @ApiResponse(code = 404, message = "Planes Caloricos no encontrados")})
	public ResponseEntity<List<PlanCalorico>> listar(){
		List<PlanCalorico> planes=new ArrayList<PlanCalorico>();
		planes=planCaloricoService.listar();
		
		return new ResponseEntity<List<PlanCalorico>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar PlanCalorico por Id", notes = "Servicio para obtner PlanCalorico por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "PlanCalorico encontrado"),
						  @ApiResponse(code = 404, message = "PlanCalorico no encontrado")})
	public ResponseEntity<PlanCalorico> listarPorId(@PathVariable("cod_plan") Integer id){
		PlanCalorico plan=planCaloricoService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<PlanCalorico>(plan,HttpStatus.OK);
	}

}
