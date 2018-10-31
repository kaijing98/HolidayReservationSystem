package ejb.session.stateless;

import entity.Customer;
import entity.ItineraryItem;
import entity.Transaction;
import java.math.BigDecimal;
import java.util.List;
import util.enumeration.PaymentModeEnum;
import util.exception.CheckoutException;



public interface CheckoutSessionBeanLocal
{   
    public Transaction checkout(Long customerId, List<ItineraryItem> itineraryItems, PaymentModeEnum paymentMode, String creditCardNumber, BigDecimal totalAmount) throws CheckoutException;
}