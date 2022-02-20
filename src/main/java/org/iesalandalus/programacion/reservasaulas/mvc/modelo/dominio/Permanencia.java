package org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Permanencia {
	private LocalDate dia;
	private static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/mm/yyyy");
	private Tramo tramo;


	public Permanencia(LocalDate dia, Tramo tramo) {
		setDia(dia);
		setTramo(tramo);
	}

    public Permanencia(Permanencia permanencia){        
        if(permanencia==null){       
            throw new IllegalArgumentException("No se puede copiar una permanencia nula.");                
        }else{          
        	setDia(permanencia.getDia());
    		setTramo(permanencia.getTramo());
        }
    }

	public LocalDate getDia() {
		return dia;

	}

	private void setDia(LocalDate dia) throws IllegalArgumentException {
		if(dia==null)
			throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
		this.dia = LocalDate.of(dia.getYear(), dia.getMonth(), dia.getDayOfMonth());
	}

	public Tramo getTramo() {
		return tramo;
	}

	private void setTramo(Tramo tramo) throws IllegalArgumentException { 
		if (tramo == null) 
			throw new IllegalArgumentException("El tramo no puede ser nulo");
		this.tramo = tramo;
		
		
	}



	@Override 
	public int hashCode() {
		return Objects.hash(dia, tramo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permanencia other = (Permanencia) obj;
		return Objects.equals(dia, other.dia) && tramo == other.tramo;
	}

	@Override
	public String toString() {
		return "Permanencia [dia=" + dia.format(FORMATO_DIA) + ", tramo=" + tramo + "]";
	}



}