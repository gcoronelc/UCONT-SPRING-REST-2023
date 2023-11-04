package pe.edu.ucontinental.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.ucontinental.app.dto.ProductoDto;

@Service
public class ProductoService {
	
	private static List<ProductoDto> productos;
	private static Integer contador;
	
	static {
		productos = new ArrayList<>();
		productos.add(new ProductoDto(1, "Televisor", 3567.89, 20));
		productos.add(new ProductoDto(2, "Laptop", 6800.00, 50));
		productos.add(new ProductoDto(3, "Impresora", 490.00, 30));
		productos.add(new ProductoDto(4, "Monitor", 390.00, 45));
		productos.add(new ProductoDto(5, "Disco Duro", 326.50, 78));
		productos.add(new ProductoDto(6, "USB", 46.80, 60));
		contador = productos.size();
	}
	
	public List<ProductoDto> getAll(){
		return productos;
	}

	public ProductoDto getById(Integer id) {
		ProductoDto dto = null;
		for(ProductoDto bean: productos) {
			if(bean.getId() == id) {
				dto = bean;
				break;
			}
		}
		return dto;
	}

}
