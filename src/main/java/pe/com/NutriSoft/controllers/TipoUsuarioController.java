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

import pe.com.NutriSoft.entities.TipoUsuario;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.ITipoUsuarioService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/api/tipouser")
@Api(tags = "Tipo Usuario", value = "Servicio Web RESTFul de TipoUsuario")
public class TipoUsuarioController {
	@Autowired
	private ITipoUsuarioService tipoUsuarioService;
	
	@PostMapping
	@ApiOperation(value = "Crear TipoUsuario", notes = "Servicio para crear una TipoUsuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "TipoUsuario creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<TipoUsuario> registrar(@Valid @RequestBody TipoUsuario TipoUsuario){
		
		TipoUsuario TipoUsuarioNew=new TipoUsuario();
		TipoUsuarioNew=tipoUsuarioService.registrar(TipoUsuario);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_TipoUsuario}").buildAndExpand(TipoUsuarioNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar TipoUsuario ", notes = "Servicio para actualizar un TipoUsuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "TipoUsuario actualizado correctamente"),
						  @ApiResponse(code = 404, message = "TipoUsuario no encontrado")})
	public ResponseEntity<TipoUsuario> actualizar(@Valid @RequestBody TipoUsuario TipoUsuario){
		
		tipoUsuarioService.modificar(TipoUsuario);
		return new ResponseEntity<TipoUsuario>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar TipoUsuario", notes = "Servicio para eliminar un TipoUsuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "TipoUsuario eliminado correctamente"),
						  @ApiResponse(code = 404, message = "TipoUsuario no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		TipoUsuario plan= tipoUsuarioService.getOne(id);
		if(plan!=null) 
			tipoUsuarioService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar TipoUsuarios", notes = "Servicio para listar a todos los TipoUsuarios")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "TipoUsuarios  encontrados"),
						  @ApiResponse(code = 404, message = "TipoUsuarios no encontrados")})
	public ResponseEntity<List<TipoUsuario>> listar(){
		List<TipoUsuario> planes=new ArrayList<TipoUsuario>();
		planes=tipoUsuarioService.listar();
		
		return new ResponseEntity<List<TipoUsuario>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar TipoUsuario por Id", notes = "Servicio para obtner TipoUsuario por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "TipoUsuario encontrado"),
						  @ApiResponse(code = 404, message = "TipoUsuario no encontrado")})
	public ResponseEntity<TipoUsuario> listarPorId(@PathVariable("cod_plan") Integer id){
		TipoUsuario plan=tipoUsuarioService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<TipoUsuario>(plan,HttpStatus.OK);
	}
	
}
