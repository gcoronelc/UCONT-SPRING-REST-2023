package pe.edu.ucontinental.app.dto;

public class SueldoDto {

	private int horas;
	private double pagoHora;
	private double ingresos;
	private double renta;
	private double neto;

	public SueldoDto() {
	}

	public SueldoDto(int horas, double pagoHora) {
		super();
		this.horas = horas;
		this.pagoHora = pagoHora;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public double getPagoHora() {
		return pagoHora;
	}

	public void setPagoHora(double pagoHora) {
		this.pagoHora = pagoHora;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public double getRenta() {
		return renta;
	}

	public void setRenta(double renta) {
		this.renta = renta;
	}

	public double getNeto() {
		return neto;
	}

	public void setNeto(double neto) {
		this.neto = neto;
	}

}
