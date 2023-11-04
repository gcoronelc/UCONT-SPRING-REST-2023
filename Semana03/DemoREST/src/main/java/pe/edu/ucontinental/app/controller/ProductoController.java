package pe.edu.ucontinental.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.ucontinental.app.dto.ProductoDto;
import pe.edu.ucontinental.app.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;

	@GetMapping
	public List<ProductoDto> getAll() {
		return productoService.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductoDto getById(@PathVariable Integer id) {
		return productoService.getById(id);
	}
		
}
	
