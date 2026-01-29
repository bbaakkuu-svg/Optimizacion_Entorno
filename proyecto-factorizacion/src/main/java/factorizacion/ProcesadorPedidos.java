package factorizacion;


	import java.util.ArrayList;
	 
	 
	/**
	 * Código inicial para la práctica de refactorización.
	 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
	 */
	public class ProcesadorPedidos {
	 
	 
	    public double procesar(ArrayList<String> listaNombres, ArrayList<Double> precios) {
	        double totalSimImpuestos = 0;
	        
	        // Sumar precios de la lista
	        for (int i = 0; i < precios.size(); i++) {
	            System.out.println("Añadiendo producto: " + listaNombres.get(i));
	            totalSimImpuestos = totalSimImpuestos + precios.get(i);
	        }
	        
	        // Lógica de descuento (Magic Number 100 y 0.10)
	        final int IMPORTE_MINIMO_DESCUENTO = 100;
			if (totalSimImpuestos > IMPORTE_MINIMO_DESCUENTO) {
	            System.out.println("Descuento aplicado.");
	            final double DESCUENTO = 0.10;
				
				totalSimImpuestos = totalSimImpuestos - (totalSimImpuestos * DESCUENTO); 
	        }
	        
	        // Cálculo de impuestos (Magic Number 0.21)
	        double res = calculoIVA(totalSimImpuestos);
	        
	        // Gastos de envío (Magic Number 500 y 15.95)
	        res = aplicarGastosEnvio(res);
	        
	        return res;
	    }

		private double aplicarGastosEnvio(double res) {
			final int IMPORTE_MINIMO_ENVIO_GRATIS = 500;
			if (res < IMPORTE_MINIMO_ENVIO_GRATIS) {
	            final double COSTE_ENVIO = 15.95;
				res = res + COSTE_ENVIO;
	        }
			return res;
		}

		private double calculoIVA(double t) {
			final double PORCENTAJE_IVA = 0.21;
			double res = t + (t * PORCENTAJE_IVA);
			return res;
		}
	}

