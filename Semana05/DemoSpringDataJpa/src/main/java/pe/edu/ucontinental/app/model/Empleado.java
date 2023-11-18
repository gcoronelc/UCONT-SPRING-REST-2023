package pe.edu.ucontinental.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_EMPLEADO")
@SequenceGenerator(name = "sq_empleado", sequenceName = "sq_empleado", initialValue = 500, allocationSize = 1)
@Data @AllArgsConstructor @NoArgsConstructor
public class Empleado {
	
	@Id
	@Column(name = "idemp")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_empleado")
	private Long id;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "telefono", length = 20, nullable = false)
	private String telefono;

}
