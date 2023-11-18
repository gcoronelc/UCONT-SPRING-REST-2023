package pe.edu.ucontinental.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.ucontinental.app.model.Empleado;
import pe.edu.ucontinental.app.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	public Empleado grabar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	public Empleado buscarPorId(Long id) {
		return empleadoRepository.findById(id).get();
	}

}
