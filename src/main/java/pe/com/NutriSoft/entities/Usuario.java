package pe.com.NutriSoft.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
@NamedQueries({
	@NamedQuery(name="Usuario.buscarPorCorreo", 
					query="select a from Usuario a where a.correo = ?1 and a.contrasena = ?2"),	
})
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	
	@ManyToOne
	private TipoUsuario Tipousuario;
	
	/*@OneToMany(mappedBy="usuario")
	private List<PlanCalorico> plancalorico;
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public TipoUsuario getTipousuario() {
		return Tipousuario;
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		Tipousuario = tipousuario;
	}

	/*public List<PlanCalorico> getPlancalorico() {
		return plancalorico;
	}

	public void setPlancalorico(List<PlanCalorico> plancalorico) {
		this.plancalorico = plancalorico;
	}
	*/
	
	

}
