package ejb.session.stateless;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidLoginCredentialException;



@Stateless
@Local(CustomerSessionBeanLocal.class)
@Remote(CustomerSessionBeanRemote.class)

public class CustomerSessionBean implements CustomerSessionBeanLocal, CustomerSessionBeanRemote 
{
    private List<Customer> customers;

    
    
    public CustomerSessionBean() 
    {
        customers = new ArrayList<>();
    }
    
    
    
    @PostConstruct
    public void postConstruct()
    {
        
    }
    
    
    
    @PreDestroy
    public void preDestroy()
    {
        if(customers != null)
        {
            customers.clear();
            customers = null;
        }
    }
    
    
    
    @Override
    public Customer retrieveCustomerById(Long customerId) throws CustomerNotFoundException
    {
        for(Customer customer:customers)
        {
            if(customer.getCustomerId().equals(customerId))
            {
                return customer;
            }
        }
        
        throw new CustomerNotFoundException("Customer does not exist: " + customerId);
    }
    
    
    
    public Customer login(String email, String password) throws InvalidLoginCredentialException
    {
        for(Customer customer:customers)
        {
            if(customer.getEmail().equals(email) && customer.getPassword().equals(password))
            {
                return customer;
            }
        }
        
        throw new InvalidLoginCredentialException("Invalid login credential");
    }
}