package pe.edu.ucontinental.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.ucontinental.app.dto.SueldoDto;
import pe.edu.ucontinental.app.service.MateService;

@RestController
public class AppController {
	
	private MateService mateService;
	
	@Autowired
	public void setMateService(MateService mateService) {
		this.mateService = mateService;
	}
	
	@GetMapping("/hola")
	public String hello() {
		return "Hola Continental";
	}
	
	@GetMapping("/sumar")
	public String sumar(int n1, int n2) {
		String suma = "Suma = " + mateService.sumar(n1, n2);
		return suma;
	}
	
	@GetMapping("/sueldo")
	public SueldoDto calcSueldo(int horas, double pagoHora) {
		SueldoDto dto = new SueldoDto(horas, pagoHora);
		dto = mateService.calcSueldo(dto);
		return dto;
	}
	
	@GetMapping("/factorial/{num}")
	public String factorial(@PathVariable("num") int n) {
		String repo = "Factorial = " + mateService.factorial(n);
		return repo;
	}

}
