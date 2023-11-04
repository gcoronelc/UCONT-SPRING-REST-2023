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
	
	public ProductoDto create(ProductoDto dto) {
		dto.setId(++contador);
		productos.add(dto);
		return dto;
	}

	public ProductoDto update(ProductoDto dto) {
		ProductoDto obj = null;
		for(ProductoDto bean: productos) {
			if(bean.getId() == dto.getId()) {
				bean.updateData(dto);
				obj = bean;
				break;
			}
		}
		return obj;
	}

	public ProductoDto updatePartial(ProductoDto dto) {
		ProductoDto obj = null;
		for(ProductoDto bean: productos) {
			if(bean.getId() == dto.getId()) {
				if(!dto.getNombre().isBlank()) bean.setNombre(dto.getNombre());
				if(dto.getPrecio()!=null) bean.setPrecio(dto.getPrecio());
				if(dto.getStock()!=null) bean.setStock(dto.getStock());
				obj = bean;
				break;
			}
		}
		return obj;
	}

	public void delete(Integer id) {
		for(ProductoDto bean: productos) {
			if(bean.getId() == id) {
				productos.remove(bean);
				break;
			}
		}
	}

	public List<ProductoDto> get(Double minPrecio, Double maxPrecio) {
		List<ProductoDto> lista2 = new ArrayList<>();
		for(ProductoDto bean: productos) {
			if(bean.getPrecio() >= minPrecio && bean.getPrecio() <= maxPrecio) {
				lista2.add(bean);
			}
		}
		return lista2;
	}

}
