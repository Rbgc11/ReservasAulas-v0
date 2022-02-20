package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;


public class Aulas{
	private int capacidad;
	private int tamano;
	 Aula[] coleccionAulas;

		// Constructor
		public Aulas(int capacidadAulas) {
			if (capacidadAulas < 1) {
				throw new IllegalArgumentException(" La capacidad tiene que ser mayor que cero.");
			}  
					coleccionAulas = new Aula[capacidadAulas];
					this.capacidad = capacidadAulas;
					this.tamano = 0;
			
		}
	    
	    
	    public Aula[] get() {
	    	return copiaProfundaAulas();
	    }
	    
		// Método copiaProfundaAulas
		private Aula[] copiaProfundaAulas()  {
			Aula[] copiaProAulas = new Aula [capacidad];
			for(int i = 0; i < tamano; i++) {
				copiaProAulas[i] = new Aula(coleccionAulas[i]);
			}
			return copiaProAulas;
		}
	    
	    
		public int getTamano() {
			return tamano;
		}
		  
	    public int getCapacidad() {
	    	return capacidad;
	    }


	    //Método insertar 
		public void insertar(Aula aula) throws OperationNotSupportedException{
	     
			if (aula == null) {
				throw new IllegalArgumentException("No se puede insertar un aula nula.");
			}
			int indice = buscarIndice(aula);
		
			if (tamanoSuperado(indice)) {
	            coleccionAulas[indice] = new Aula(aula);
	            tamano++;
			} else {
	            if (capacidadSuperada(indice)) {
	            throw new OperationNotSupportedException("El aula ya existe.");
	            } else {
	            	throw new OperationNotSupportedException("No se aceptan más aulas.");
		}		}
	        
	    }
	    
	    //Método buscarIndice
	    private int buscarIndice(Aula aula) {
	    	int indice = 0;
	    	boolean aulaEncontrada = false;
	    	while (!tamanoSuperado(indice) && !aulaEncontrada) {
	            if (coleccionAulas[indice].equals(aula)) {
	            	aulaEncontrada = true;
	            } else {
	            	indice++;
	            }
		}
	            	return indice;
		}
	    
	    private boolean tamanoSuperado (int indice) {
			return indice >= tamano;
		}
	    private boolean capacidadSuperada(int indice) {
			return indice >= capacidad;
		}
		
	    //Método buscar 
	    public Aula buscar(Aula aula) {
	    	if (aula == null) {
	    		throw new NullPointerException(" No se puede buscar un aula nula.");
	    	}
	    	int indice = 0;
	    	indice = buscarIndice(aula);
	    	if (tamanoSuperado(indice)) {
	    		return null;
	    	} else {
	            return coleccionAulas[indice];
	    	}
		}
	    
	    //Método borrar 
	    public void borrar(Aula aula) throws OperationNotSupportedException {
	    	if (aula == null) {
	            throw new IllegalArgumentException("No se puede borrar un aula nula.");
	            }
	            int indice = buscarIndice(aula);
	            if (!tamanoSuperado(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
			}
	            else {
			throw new OperationNotSupportedException("El aula a borrar no existe.");
	            }
		}
	     
	    //Método desplazarunaposicionhaciaizquierda
	    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
	    	for (int i = indice; i < tamano - 1; i++) {
	            coleccionAulas[i] = coleccionAulas[i+1];
	            }
	            coleccionAulas[tamano] = null;
	            tamano--;
		}
		
	    //Método representar
		public String[] representar() {
			String[] representacion = new String[tamano];
			for (int i = 0; tamanoSuperado(i); i++) {
				representacion[i] = coleccionAulas[i].toString();
			}
			return representacion;
		}
	   
	    
	}