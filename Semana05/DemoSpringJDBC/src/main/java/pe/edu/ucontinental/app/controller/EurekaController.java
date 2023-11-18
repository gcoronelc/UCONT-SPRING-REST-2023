package pe.edu.ucontinental.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.ucontinental.app.bean.Cliente;
import pe.edu.ucontinental.app.service.EurekaService;

@RestController
@RequestMapping("/eureka")
public class EurekaController {
	
	@Autowired
	private EurekaService eurekaService;
	

	@GetMapping("/cantcuentas")
	public String getCantCuentas() {
		String texto = "Cantidad de Cuentas: " + eurekaService.getCantCuentas();
		return texto;
	}
	
	@GetMapping("/movimientos/{cuenta}")
	public List<Map<String,Object>> getMovimientos(@PathVariable String cuenta){
		return eurekaService.getMovimientos(cuenta);
	}
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return eurekaService.getClientes();
	}
	
	@PostMapping("/crearcliente")
	public Cliente crearCliente( @RequestBody Cliente bean) {
		return eurekaService.crearCliente(bean);
	}
	
}
