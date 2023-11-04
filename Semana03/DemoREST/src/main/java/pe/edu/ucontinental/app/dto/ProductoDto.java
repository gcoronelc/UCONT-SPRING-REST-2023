package pe.edu.ucontinental.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductoDto {
	
	private Integer id;
	private String nombre;
	private double precio;
	private Integer stock;
	
	
}
