package ejb.session.stateless;

import entity.Customer;
import entity.ItineraryItem;
import entity.Transaction;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import util.enumeration.PaymentModeEnum;
import util.exception.CheckoutException;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidPaymentModeException;
import util.helper.SequenceNumberGenerator;



@Stateless
@Local(CheckoutSessionBeanLocal.class)

public class CheckoutSessionBean implements CheckoutSessionBeanLocal
{
    @EJB
    private CustomerSessionBeanLocal customerSessionBeanLocal;
    @EJB
    private CreditCardProcessingSessionBeanLocal creditCardProcessingSessionBeanLocal;
 
    
    
    public Transaction checkout(Long customerId, List<ItineraryItem> itineraryItems, PaymentModeEnum paymentMode, String creditCardNumber, BigDecimal totalAmount) throws CheckoutException
    {
        if(customerId != null && itineraryItems != null && !itineraryItems.isEmpty())
        {
            try 
            {
                Customer customer = customerSessionBeanLocal.retrieveCustomerById(customerId);
                String paymentReferenceNumber = creditCardProcessingSessionBeanLocal.chargeCreditCard(paymentMode, creditCardNumber, totalAmount);
                
                for(ItineraryItem itineraryItem:itineraryItems)
                {
                    itineraryItem.setItineraryItemId(SequenceNumberGenerator.getNextSequenceNumber());
                }
                
                Transaction transaction = new Transaction(SequenceNumberGenerator.getNextSequenceNumber(), totalAmount, new Date(), customer);
                transaction.setItineraryItems(itineraryItems);                
                
                return transaction;
            } 
            catch (CustomerNotFoundException | InvalidPaymentModeException ex) 
            {
                throw new CheckoutException(ex.getMessage());
            }
        }
        else
        {
            throw new CheckoutException("Missing customer data or no holiday to checkout");
        }
    }
}