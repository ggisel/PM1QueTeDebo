package extension;

import ar.com.quetedebo.pm.PaymentMethod;

public class MercadoPagoImpl implements PaymentMethod {

	@Override
	public String processPayment(String address, Float ammount) {
		// TODO Metodo que realiza la conexion con Mercado Pago para procesarlo
		return "Mercado Pago";
	}

}
