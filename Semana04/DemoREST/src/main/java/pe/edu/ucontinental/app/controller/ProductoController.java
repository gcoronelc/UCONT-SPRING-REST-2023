package pe.edu.ucontinental.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<ProductoDto> getById(@PathVariable Integer id) {
		ProductoDto bean = productoService.getById(id);
		if (bean == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<>(bean, HttpStatus.OK);
	}

	@GetMapping("/{minPrecio}/{maxPrecio}")
	public List<ProductoDto> getByMinPrecioMaxPRecio(@PathVariable Double minPrecio, @PathVariable Double maxPrecio) {
		return productoService.get(minPrecio, maxPrecio);
	}

	@PostMapping
	public ResponseEntity<ProductoDto> create(@RequestBody ProductoDto dto) {
		ProductoDto bean = productoService.create(dto);
		return new ResponseEntity<>(bean, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductoDto> update(@PathVariable Integer id, @RequestBody ProductoDto dto) {
		// Validacion
		ProductoDto bean = productoService.getById(id);
		if (bean == null) {
			return ResponseEntity.notFound().build();
		}
		// Proceso
		dto.setId(id);
		bean = productoService.update(dto);
		return new ResponseEntity<>(bean, HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ProductoDto> updatePartial(@PathVariable Integer id, @RequestBody ProductoDto dto) {
		// Validacion
		ProductoDto bean = productoService.getById(id);
		if (bean == null) {
			return ResponseEntity.notFound().build();
		}
		// Proceso
		dto.setId(id);
		bean = productoService.updatePartial(dto);
		return new ResponseEntity<>(bean, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		// Validacion
		ProductoDto bean = productoService.getById(id);
		if (bean == null) {
			return ResponseEntity.notFound().build();
		}
		// Proceso
		productoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
