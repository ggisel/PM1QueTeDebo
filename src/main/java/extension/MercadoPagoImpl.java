package extension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ar.com.quetedebo.pm.PaymentMethod;
import ar.com.quetedebo.pm.PaymentObserver;

public class MercadoPagoImpl implements PaymentMethod {
	List<PaymentObserver> observers = new ArrayList<>();
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public String processPayment(String address, Float amount) {
        String paymentId = UUID.randomUUID().toString();
        
        System.out.println("Pago iniciado con ID: " + paymentId);

        scheduler.schedule(() -> {
            notifyObservers(paymentId);
        }, 5, TimeUnit.SECONDS);

        return paymentId;
    }

	public void subscribe(PaymentObserver observer) {
		observers.add(observer);
	}

	public void notifyObservers(String paymentId) {
        for (PaymentObserver observer : observers) {
            observer.onPaymentProcessed(paymentId);
        }
    }
}
