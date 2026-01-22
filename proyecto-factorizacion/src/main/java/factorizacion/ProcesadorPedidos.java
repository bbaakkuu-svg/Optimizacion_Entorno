package factorizacion;


	import java.util.ArrayList;
	 
	 
	/**
	 * Código inicial para la práctica de refactorización.
	 * Criterios: Nombres genéricos, números mágicos y métodos con demasiadas responsabilidades.
	 */
	public class ProcesadorPedidos {
	 
	 
	    public double procesar(ArrayList<String> a, ArrayList<Double> b) {
	        double t = 0;
	        
	        // Sumar precios de la lista
	        for (int i = 0; i < b.size(); i++) {
	            System.out.println("Añadiendo producto: " + a.get(i));
	            t = t + b.get(i);
	        }
	        
	        // Lógica de descuento (Magic Number 100 y 0.10)
	        final int IMPORTE_MINIMO_DESCUENTO = 100;
			if (t > IMPORTE_MINIMO_DESCUENTO) {
	            System.out.println("Descuento aplicado.");
	            final double DESCUENTO = 0.10;
				
				t = t - (t * DESCUENTO); 
	        }
	        
	        // Cálculo de impuestos (Magic Number 0.21)
	        double res = calcularIva(t);
	        
	        // Gastos de envío (Magic Number 500 y 15.95)
	        res = aplicarGastosEnvio(res);
	        
	        return res;
	    }

		private double aplicarGastosEnvio(double res) {
			final int IMPORTE_ENVIO_GRATIS = 500;
			if (res < IMPORTE_ENVIO_GRATIS) {
	            final double GASTOS_ENVIO = 15.95;
				res = res + GASTOS_ENVIO;
	        }
			return res;
		}

		private double calcularIva(double t) {
			final double IVA = 0.21;
			double res = t + (t * IVA);
			return res;
		}
	}

