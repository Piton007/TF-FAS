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

import pe.com.NutriSoft.entities.Usuario;
import pe.com.NutriSoft.exception.ModelNotFoundException;
import pe.com.NutriSoft.service.IUsuarioService;

import java.util.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/api/usuario")
@Api(tags = "Usuario", value = "Servicio Web RESTFul de Usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping
	@ApiOperation(value = "Crear Usuario", notes = "Servicio para crear una Usuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Usuario creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario Usuario){
		
		Usuario UsuarioNew=new Usuario();
		UsuarioNew=usuarioService.registrar(Usuario);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_Usuario}").buildAndExpand(UsuarioNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Usuario ", notes = "Servicio para actualizar un Usuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Usuario actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Usuario no encontrado")})
	public ResponseEntity<Usuario> actualizar(@Valid @RequestBody Usuario Usuario){
		
		usuarioService.modificar(Usuario);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Eliminar Usuario", notes = "Servicio para eliminar un Usuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Usuario eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Usuario no encontrado")})
	public void eliminar(@PathVariable("cod_plan") Integer id) {
		
		Usuario plan= usuarioService.getOne(id);
		if(plan!=null) 
			usuarioService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Usuarios", notes = "Servicio para listar a todos los Usuarios")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Usuarios  encontrados"),
						  @ApiResponse(code = 404, message = "Usuarios no encontrados")})
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> planes=new ArrayList<Usuario>();
		planes=usuarioService.listar();
		
		return new ResponseEntity<List<Usuario>>(planes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/login/{user}/{password}")
	@ApiOperation(value = "Validacion Usuario", notes = "Servicio para validar Usuario")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Usuarios  encontrados"),
						  @ApiResponse(code = 404, message = "Usuarios no encontrados")})
	public ResponseEntity<Usuario> getone(@PathVariable("user") String user,@PathVariable("password") String password){
		Usuario planes=null;
		planes=usuarioService.buscarPorCorreo(user, password);
		if(planes!=null) 
			return new ResponseEntity<Usuario>(planes,HttpStatus.OK);
		else 
			throw new ModelNotFoundException("User"+user);
		
		
	}
	
	@GetMapping(value = "/{cod_plan}")
	@ApiOperation(value = "Listar Usuario por Id", notes = "Servicio para obtner Usuario por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Usuario encontrado"),
						  @ApiResponse(code = 404, message = "Usuario no encontrado")})
	public ResponseEntity<Usuario> listarPorId(@PathVariable("cod_plan") Integer id){
		Usuario plan=usuarioService.getOne(id);
		
		if(plan==null)
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Usuario>(plan,HttpStatus.OK);
	}
	

}
