package ejb.session.stateless;

import entity.Customer;
import util.exception.CustomerNotFoundException;



public interface CustomerSessionBeanLocal
{    
    public Customer retrieveCustomerById(Long customerId) throws CustomerNotFoundException;
}