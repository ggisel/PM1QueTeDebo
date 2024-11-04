package extension;

import ar.com.quetedebo.pm.PaymentMethodPlugin;

public class MercadoPagoImpl implements PaymentMethodPlugin {

	@Override
	public String processPayment(String address, Float ammount) {
		// TODO Metodo que realiza la conexion con Mercado Pago para procesarlo
		return "Mercado Pago";
	}

	@Override
	public String getName() {
		return "Mercado Pago";
	}

}
