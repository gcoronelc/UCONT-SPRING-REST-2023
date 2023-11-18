package pe.edu.ucontinental.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.ucontinental.app.model.Empleado;
import pe.edu.ucontinental.app.service.EmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping
	public Empleado crear(@RequestBody Empleado bean) {
		return empleadoService.grabar(bean);
	}
	
	@PatchMapping("/{id}")
	public Empleado modificar(@PathVariable Long id, @RequestBody Empleado bean) {
		Empleado obj = empleadoService.buscarPorId(id);
		if(bean.getApellido() != null) {
			obj.setApellido(bean.getApellido());
		}
		if(bean.getNombre() != null) {
			obj.setNombre(bean.getNombre());
		}
		if(bean.getEmail() != null) {
			obj.setEmail(bean.getEmail());
		}
		if(bean.getTelefono() != null) {
			obj.setTelefono(bean.getTelefono());
		}
		return empleadoService.grabar(obj);
	}
	
}
