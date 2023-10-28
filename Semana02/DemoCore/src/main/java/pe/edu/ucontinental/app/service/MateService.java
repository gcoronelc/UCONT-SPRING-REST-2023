package pe.edu.ucontinental.app.service;

import org.springframework.stereotype.Service;

import pe.edu.ucontinental.app.dto.SueldoDto;

@Service
public class MateService {

	public int sumar(int n1, int n2) {
		return (n1 + n2);
	}
	
	public SueldoDto calcSueldo( SueldoDto dto) {
		// Proceso
		double ingresos = dto.getHoras() * dto.getPagoHora();
		double renta = 0.0;
		if(ingresos>1500.0) {
			renta = ingresos * 0.08;
		}
		double neto = ingresos - renta;
		// Reporte
		dto.setIngresos(ingresos);
		dto.setRenta(renta);
		dto.setNeto(neto);
		return dto;
	}
	
	public long factorial(int n) {
		if(n==0 || n==1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}

}
