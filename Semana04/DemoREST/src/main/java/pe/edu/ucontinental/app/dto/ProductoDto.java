package pe.edu.ucontinental.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductoDto {
	
	private Integer id;
	private String nombre;
	private Double precio;
	private Integer stock;
	
	public void updateData(ProductoDto source) {
		this.nombre = source.getNombre();
		this.precio = source.getPrecio();
		this.stock = source.getStock();
	}
}
